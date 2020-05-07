package et.covid19.rest.util.logging;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import ch.qos.logback.classic.spi.CallerData;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.classic.spi.ThrowableProxyUtil;
import ch.qos.logback.core.db.DBAppenderBase;
import ch.qos.logback.core.db.DBHelper;

public class CustomDBAppender extends DBAppenderBase<ILoggingEvent> {

    protected String insertSQL;

    // Indices of the fields of the table in which the logging information is
    // stored
    private static final int EVENTTIME_INDEX = 1;
    private static final int MESSAGE_INDEX = 2;
    private static final int LOGGER_INDEX = 3;
    private static final int LEVEL_INDEX = 4;
    private static final int CALLER_CLASS_INDEX = 5;
    private static final int CALLER_METHOD_INDEX = 6;
    private static final int CALLER_LINE_INDEX = 7;
    private static final int TRACE_INDEX = 8;
    private static final int TRANSACTION_KEY_INDEX = 9;

    private static final String TRANSACTION_MAPPED_KEY = "UUID"; // should be appended with LogFilters or with an other  mechanism
    private static final String LOGGING_EVENTS_TABLE = "logging_events";
    
    static final StackTraceElement EMPTY_CALLER_DATA = CallerData.naInstance();

    @Override
    public void append(ILoggingEvent eventObject) {

        Connection connection = null;
        PreparedStatement insertStatement = null;
        try {
            connection = connectionSource.getConnection();
            connection.setAutoCommit(false);

            insertStatement = connection.prepareStatement(getInsertSQL());

            // Inserting the event in database
            synchronized (this) {
                subAppend(eventObject, connection, insertStatement);
            }
            secondarySubAppend(eventObject, connection, 1);

            connection.commit();

        } catch (Throwable sqle) {
            addError("problem appending event", sqle);
        } finally {
            DBHelper.closeStatement(insertStatement);
            DBHelper.closeConnection(connection);
        }
    }

    @Override
    protected Method getGeneratedKeysMethod() {
        return null;
    }

    @Override
    protected String getInsertSQL() {
        return insertSQL;
    }

    @Override
    protected void secondarySubAppend(ILoggingEvent eventObject, Connection connection, long eventId) throws Throwable {
    }

    @Override
    public void start() {
        insertSQL = CustomDBAppender.buildInsertSQL();
        super.start();
    }

    @Override
    protected void subAppend(ILoggingEvent event, Connection connection, PreparedStatement insertStatement)
            throws Throwable {

        bindLoggingEventWithInsertStatement(insertStatement, event);
        bindCallerDataWithPreparedStatement(insertStatement, event.getCallerData());

        int updateCount = insertStatement.executeUpdate();
        if (updateCount != 1) {
            addWarn("Failed to insert loggingEvent");
        }
    }

    void bindCallerDataWithPreparedStatement(PreparedStatement stmt, StackTraceElement[] callerDataArray)
            throws SQLException {

        StackTraceElement caller = extractFirstCaller(callerDataArray);

        stmt.setString(CALLER_CLASS_INDEX, caller.getClassName());
        stmt.setString(CALLER_METHOD_INDEX, caller.getMethodName());
        stmt.setString(CALLER_LINE_INDEX, Integer.toString(caller.getLineNumber()));
    }

    void bindLoggingEventWithInsertStatement(PreparedStatement stmt, ILoggingEvent event) throws SQLException {

        stmt.setTimestamp(EVENTTIME_INDEX, new Timestamp(event.getTimeStamp()));
        stmt.setString(MESSAGE_INDEX, event.getFormattedMessage());
        stmt.setString(LOGGER_INDEX, event.getLoggerName());
        stmt.setString(LEVEL_INDEX, event.getLevel().toString());
        stmt.setString(TRANSACTION_KEY_INDEX, mergePropertyMaps(event).getOrDefault(TRANSACTION_MAPPED_KEY, ""));

        if (event.getThrowableProxy() != null && event.getThrowableProxy().getStackTraceElementProxyArray() != null)
            stmt.setString(TRACE_INDEX, ThrowableProxyUtil.asString(event.getThrowableProxy()));
        else
            stmt.setString(TRACE_INDEX, null);
    }

    private static String buildInsertSQL() {

        return "INSERT INTO " 
                + LOGGING_EVENTS_TABLE
                + " (eventtime, message, logger, level, callerclass, callermethod, callerline, trace, txkey) "
                + "VALUES " + "(?, ?, ?, ?, ?, ?, ?, ?, ?)";
    }

    private StackTraceElement extractFirstCaller(StackTraceElement[] callerDataArray) {

        StackTraceElement caller = EMPTY_CALLER_DATA;
        if (hasAtLeastOneNonNullElement(callerDataArray))
            caller = callerDataArray[0];

        return caller;
    }

    private boolean hasAtLeastOneNonNullElement(StackTraceElement[] callerDataArray) {
        return callerDataArray != null && callerDataArray.length > 0 && callerDataArray[0] != null;
    }
    
    private Map<String, String> mergePropertyMaps(ILoggingEvent event) {
        Map<String, String> mergedMap = new HashMap<>();
        // we add the context properties first, then the event properties, since
        // we consider that event-specific properties should have priority over
        // context-wide properties.
        Map<String, String> loggerContextMap = event.getLoggerContextVO().getPropertyMap();
        Map<String, String> mdcMap = event.getMDCPropertyMap();
        if (loggerContextMap != null) {
            mergedMap.putAll(loggerContextMap);
        }
        if (mdcMap != null) {
            mergedMap.putAll(mdcMap);
        }

        return mergedMap;
    }
}
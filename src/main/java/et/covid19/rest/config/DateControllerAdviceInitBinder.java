package et.covid19.rest.config;

import java.beans.PropertyEditorSupport;
import java.text.Format;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.function.Function;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

@ControllerAdvice
public class DateControllerAdviceInitBinder {

    private static class Editor<T> extends PropertyEditorSupport {

        private final Function<String, T> parser;
        private final Format format;

        public Editor(Function<String, T> parser, Format format) {

            this.parser = parser;
            this.format = format;
        }

        public void setAsText(String text) {

            setValue(this.parser.apply(text));
        }

        public String getAsText() {

            return format.format((T) getValue());
        }
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {

        webDataBinder.registerCustomEditor(
                Instant.class,
                new Editor<>(
                        Instant::parse,
                        DateTimeFormatter.ISO_INSTANT.toFormat()));

        webDataBinder.registerCustomEditor(
                LocalDate.class,
                new Editor<>(
                        text -> LocalDate.parse(text, DateTimeFormatter.ISO_LOCAL_DATE),
                        DateTimeFormatter.ISO_LOCAL_DATE.toFormat()));

        webDataBinder.registerCustomEditor(
                LocalDateTime.class,
                new Editor<>(
                        text -> LocalDateTime.parse(text, DateTimeFormatter.ISO_LOCAL_DATE_TIME),
                        DateTimeFormatter.ISO_LOCAL_DATE_TIME.toFormat()));

        webDataBinder.registerCustomEditor(
                LocalTime.class,
                new Editor<>(
                        text -> LocalTime.parse(text, DateTimeFormatter.ISO_LOCAL_TIME),
                        DateTimeFormatter.ISO_LOCAL_TIME.toFormat()));

        webDataBinder.registerCustomEditor(
                OffsetDateTime.class,
                new Editor<>(
                        text -> OffsetDateTime.parse(text, DateTimeFormatter.ISO_OFFSET_DATE_TIME),
                        DateTimeFormatter.ISO_OFFSET_DATE_TIME.toFormat()));

        webDataBinder.registerCustomEditor(
                OffsetTime.class,
                new Editor<>(
                        text -> OffsetTime.parse(text, DateTimeFormatter.ISO_OFFSET_TIME),
                        DateTimeFormatter.ISO_OFFSET_TIME.toFormat()));

        webDataBinder.registerCustomEditor(
                ZonedDateTime.class,
                new Editor<>(
                        text -> ZonedDateTime.parse(text, DateTimeFormatter.ISO_ZONED_DATE_TIME),
                        DateTimeFormatter.ISO_ZONED_DATE_TIME.toFormat()));
    }
}
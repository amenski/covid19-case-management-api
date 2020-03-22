package et.commcare.covid19.task.dto;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class MetadataClass {
	private String xmlns;
	private String appVersion;
	private Long appBuildVersion;
	private String commcareVersion;
	private DeviceID deviceID;
	private String drift;
	private Object geoPoint;
	private String instanceID;
	private String timeEnd;
	private String timeStart;
	private ErID userID;
	private Username username;
	private Object location;

	@JsonProperty("@xmlns")
	public String getXmlns() {
		return xmlns;
	}

	@JsonProperty("@xmlns")
	public void setXmlns(String value) {
		this.xmlns = value;
	}

	@JsonProperty("appVersion")
	public String getAppVersion() {
		return appVersion;
	}

	@JsonProperty("appVersion")
	public void setAppVersion(String value) {
		this.appVersion = value;
	}

	@JsonProperty("app_build_version")
	public Long getAppBuildVersion() {
		return appBuildVersion;
	}

	@JsonProperty("app_build_version")
	public void setAppBuildVersion(Long value) {
		this.appBuildVersion = value;
	}

	@JsonProperty("commcare_version")
	public String getCommcareVersion() {
		return commcareVersion;
	}

	@JsonProperty("commcare_version")
	public void setCommcareVersion(String value) {
		this.commcareVersion = value;
	}

	@JsonProperty("deviceID")
	public DeviceID getDeviceID() {
		return deviceID;
	}

	@JsonProperty("deviceID")
	public void setDeviceID(DeviceID value) {
		this.deviceID = value;
	}

	@JsonProperty("drift")
	public String getDrift() {
		return drift;
	}

	@JsonProperty("drift")
	public void setDrift(String value) {
		this.drift = value;
	}

	@JsonProperty("geo_point")
	public Object getGeoPoint() {
		return geoPoint;
	}

	@JsonProperty("geo_point")
	public void setGeoPoint(Object value) {
		this.geoPoint = value;
	}

	@JsonProperty("instanceID")
	public String getInstanceID() {
		return instanceID;
	}

	@JsonProperty("instanceID")
	public void setInstanceID(String value) {
		this.instanceID = value;
	}

	@JsonProperty("timeEnd")
	public String getTimeEnd() {
		return timeEnd;
	}

	@JsonProperty("timeEnd")
	public void setTimeEnd(String value) {
		this.timeEnd = value;
	}

	@JsonProperty("timeStart")
	public String getTimeStart() {
		return timeStart;
	}

	@JsonProperty("timeStart")
	public void setTimeStart(String value) {
		this.timeStart = value;
	}

	@JsonProperty("userID")
	public ErID getUserID() {
		return userID;
	}

	@JsonProperty("userID")
	public void setUserID(ErID value) {
		this.userID = value;
	}

	@JsonProperty("username")
	public Username getUsername() {
		return username;
	}

	@JsonProperty("username")
	public void setUsername(Username value) {
		this.username = value;
	}

	@JsonProperty("location")
	public Object getLocation() {
		return location;
	}

	@JsonProperty("location")
	public void setLocation(Object value) {
		this.location = value;
	}
}

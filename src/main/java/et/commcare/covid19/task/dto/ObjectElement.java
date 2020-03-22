package et.commcare.covid19.task.dto;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class ObjectElement {
	private AppID appID;
	private boolean archived;
	private Attachments attachments;
	private String buildID;
	private Domain domain;
	private Object editedByUserID;
	private Object editedOn;
	private Form form;
	private String id;
	private String indexedOn;
	private boolean initialProcessingComplete;
	private boolean isPhoneSubmission;
	private MetadataClass metadata;
	private Object problem;
	private String receivedOn;
	private String resourceURI;
	private String serverModifiedOn;
	private Type type;
	private String uiversion;
	private String version;

	@JsonProperty("app_id")
	public AppID getAppID() {
		return appID;
	}

	@JsonProperty("app_id")
	public void setAppID(AppID value) {
		this.appID = value;
	}

	@JsonProperty("archived")
	public boolean getArchived() {
		return archived;
	}

	@JsonProperty("archived")
	public void setArchived(boolean value) {
		this.archived = value;
	}

	@JsonProperty("attachments")
	public Attachments getAttachments() {
		return attachments;
	}

	@JsonProperty("attachments")
	public void setAttachments(Attachments value) {
		this.attachments = value;
	}

	@JsonProperty("build_id")
	public String getBuildID() {
		return buildID;
	}

	@JsonProperty("build_id")
	public void setBuildID(String value) {
		this.buildID = value;
	}

	@JsonProperty("domain")
	public Domain getDomain() {
		return domain;
	}

	@JsonProperty("domain")
	public void setDomain(Domain value) {
		this.domain = value;
	}

	@JsonProperty("edited_by_user_id")
	public Object getEditedByUserID() {
		return editedByUserID;
	}

	@JsonProperty("edited_by_user_id")
	public void setEditedByUserID(Object value) {
		this.editedByUserID = value;
	}

	@JsonProperty("edited_on")
	public Object getEditedOn() {
		return editedOn;
	}

	@JsonProperty("edited_on")
	public void setEditedOn(Object value) {
		this.editedOn = value;
	}

	@JsonProperty("form")
	public Form getForm() {
		return form;
	}

	@JsonProperty("form")
	public void setForm(Form value) {
		this.form = value;
	}

	@JsonProperty("id")
	public String getID() {
		return id;
	}

	@JsonProperty("id")
	public void setID(String value) {
		this.id = value;
	}

	@JsonProperty("indexed_on")
	public String getIndexedOn() {
		return indexedOn;
	}

	@JsonProperty("indexed_on")
	public void setIndexedOn(String value) {
		this.indexedOn = value;
	}

	@JsonProperty("initial_processing_complete")
	public boolean getInitialProcessingComplete() {
		return initialProcessingComplete;
	}

	@JsonProperty("initial_processing_complete")
	public void setInitialProcessingComplete(boolean value) {
		this.initialProcessingComplete = value;
	}

	@JsonProperty("is_phone_submission")
	public boolean getIsPhoneSubmission() {
		return isPhoneSubmission;
	}

	@JsonProperty("is_phone_submission")
	public void setIsPhoneSubmission(boolean value) {
		this.isPhoneSubmission = value;
	}

	@JsonProperty("metadata")
	public MetadataClass getMetadata() {
		return metadata;
	}

	@JsonProperty("metadata")
	public void setMetadata(MetadataClass value) {
		this.metadata = value;
	}

	@JsonProperty("problem")
	public Object getProblem() {
		return problem;
	}

	@JsonProperty("problem")
	public void setProblem(Object value) {
		this.problem = value;
	}

	@JsonProperty("received_on")
	public String getReceivedOn() {
		return receivedOn;
	}

	@JsonProperty("received_on")
	public void setReceivedOn(String value) {
		this.receivedOn = value;
	}

	@JsonProperty("resource_uri")
	public String getResourceURI() {
		return resourceURI;
	}

	@JsonProperty("resource_uri")
	public void setResourceURI(String value) {
		this.resourceURI = value;
	}

	@JsonProperty("server_modified_on")
	public String getServerModifiedOn() {
		return serverModifiedOn;
	}

	@JsonProperty("server_modified_on")
	public void setServerModifiedOn(String value) {
		this.serverModifiedOn = value;
	}

	@JsonProperty("type")
	public Type getType() {
		return type;
	}

	@JsonProperty("type")
	public void setType(Type value) {
		this.type = value;
	}

	@JsonProperty("uiversion")
	public String getUiversion() {
		return uiversion;
	}

	@JsonProperty("uiversion")
	public void setUiversion(String value) {
		this.uiversion = value;
	}

	@JsonProperty("version")
	public String getVersion() {
		return version;
	}

	@JsonProperty("version")
	public void setVersion(String value) {
		this.version = value;
	}
}

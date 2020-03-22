package et.commcare.covid19.task.dto;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class FormXML {
	private ContentType contentType;
	private long length;
	private String url;

	@JsonProperty("content_type")
	public ContentType getContentType() {
		return contentType;
	}

	@JsonProperty("content_type")
	public void setContentType(ContentType value) {
		this.contentType = value;
	}

	@JsonProperty("length")
	public long getLength() {
		return length;
	}

	@JsonProperty("length")
	public void setLength(long value) {
		this.length = value;
	}

	@JsonProperty("url")
	public String getURL() {
		return url;
	}

	@JsonProperty("url")
	public void setURL(String value) {
		this.url = value;
	}
}

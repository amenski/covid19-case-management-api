package et.commcare.covid19.task.dto;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class EtCovid19CaseMeta {
	private long limit;
	private Object next;
	private long offset;
	private Object previous;
	private long totalCount;

	@JsonProperty("limit")
	public long getLimit() {
		return limit;
	}

	@JsonProperty("limit")
	public void setLimit(long value) {
		this.limit = value;
	}

	@JsonProperty("next")
	public Object getNext() {
		return next;
	}

	@JsonProperty("next")
	public void setNext(Object value) {
		this.next = value;
	}

	@JsonProperty("offset")
	public long getOffset() {
		return offset;
	}

	@JsonProperty("offset")
	public void setOffset(long value) {
		this.offset = value;
	}

	@JsonProperty("previous")
	public Object getPrevious() {
		return previous;
	}

	@JsonProperty("previous")
	public void setPrevious(Object value) {
		this.previous = value;
	}

	@JsonProperty("total_count")
	public long getTotalCount() {
		return totalCount;
	}

	@JsonProperty("total_count")
	public void setTotalCount(long value) {
		this.totalCount = value;
	}
}

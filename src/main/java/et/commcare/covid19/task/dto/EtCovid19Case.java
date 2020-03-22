package et.commcare.covid19.task.dto;

import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class EtCovid19Case {
	private EtCovid19CaseMeta meta;
	private ObjectElement[] objects;

	@JsonProperty("meta")
	public EtCovid19CaseMeta getMeta() {
		return meta;
	}

	@JsonProperty("meta")
	public void setMeta(EtCovid19CaseMeta value) {
		this.meta = value;
	}

	@JsonProperty("objects")
	public ObjectElement[] getObjects() {
		return objects;
	}

	@JsonProperty("objects")
	public void setObjects(ObjectElement[] value) {
		this.objects = value;
	}
}

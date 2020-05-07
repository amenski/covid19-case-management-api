package et.covid19.rest.dal.util;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class ContactTracingProjection {

    private String code;
    private String patientName;
    private String resultStatus;
    

    @JsonInclude(Include.NON_EMPTY) 
    private List<ContactTracingProjection> children = new ArrayList<>();
    
    public ContactTracingProjection(String code, String patientName, String confirmedResult) {
        super();
        this.code = code;
        this.patientName = patientName;
        this.resultStatus = confirmedResult;
    }

    public ContactTracingProjection() {
        // 
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }
    
    public String getResultStatus() {
        return resultStatus;
    }

    public void setResultStatus(String resultStatus) {
        this.resultStatus = resultStatus;
    }

    public List<ContactTracingProjection> getChildren() {
        return children;
    }

    public void setChildren(List<ContactTracingProjection> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return code;
    }
}

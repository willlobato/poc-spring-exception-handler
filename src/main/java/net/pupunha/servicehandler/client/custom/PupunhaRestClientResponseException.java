package net.pupunha.servicehandler.client.custom;

import lombok.Getter;
import org.springframework.web.client.RestClientException;

import java.util.Map;

public abstract class PupunhaRestClientResponseException extends RestClientException {

    @Getter
    private String moduleId;

    @Getter
    private String code;

    @Getter
    private Map<String, String> details;

    public PupunhaRestClientResponseException(String moduleId, String code, String message) {
        super(message);
        this.moduleId = moduleId;
        this.code = code;
    }

    public PupunhaRestClientResponseException(String moduleId, String code, String message, Map<String, String> details) {
        super(message);
        this.moduleId = moduleId;
        this.code = code;
        this.details = details;
    }

    public PupunhaRestClientResponseException(String moduleId, String code, String message, Map<String, String> details, Throwable ex) {
        super(message, ex);
        this.moduleId = moduleId;
        this.code = code;
        this.details = details;
    }

}

package net.pupunha.servicehandler.client.exception;

import net.pupunha.servicehandler.client.custom.PupunhaRestClientResponseException;

import java.util.Map;

public class PupunhaModuleServerException extends PupunhaRestClientResponseException {

    public PupunhaModuleServerException(String moduleId, String code, String message) {
        super(moduleId, code, message);
    }

    public PupunhaModuleServerException(String moduleId, String code, String message, Map<String, String> details) {
        super(moduleId, code, message, details);
    }

}

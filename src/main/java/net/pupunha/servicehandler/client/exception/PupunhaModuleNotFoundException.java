package net.pupunha.servicehandler.client.exception;

import net.pupunha.servicehandler.client.custom.PupunhaRestClientResponseException;

public class PupunhaModuleNotFoundException extends PupunhaRestClientResponseException {

    private static final String CODE_RESOURCE_NOT_FOUND = "ResourceNotFound";

    public PupunhaModuleNotFoundException(String moduleId) {
        super(moduleId, CODE_RESOURCE_NOT_FOUND, "");
    }
}

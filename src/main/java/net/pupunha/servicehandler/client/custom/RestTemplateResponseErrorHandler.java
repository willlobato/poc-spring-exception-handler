package net.pupunha.servicehandler.client.custom;

import com.fasterxml.jackson.core.type.TypeReference;
import net.pupunha.servicehandler.client.exception.PupunhaModuleClientException;
import net.pupunha.servicehandler.client.exception.PupunhaModuleNotFoundException;
import net.pupunha.servicehandler.client.exception.PupunhaModuleServerException;
import net.pupunha.servicehandler.server.CustomObjectMapper;
import net.pupunha.servicehandler.server.ServiceErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.util.StreamUtils;
import org.springframework.web.client.DefaultResponseErrorHandler;

import java.io.IOException;
import java.util.Objects;

import static org.springframework.http.HttpStatus.Series.CLIENT_ERROR;
import static org.springframework.http.HttpStatus.Series.SERVER_ERROR;

public class RestTemplateResponseErrorHandler extends DefaultResponseErrorHandler {

    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        return (response.getStatusCode().series() == CLIENT_ERROR
                || response.getStatusCode().series() == SERVER_ERROR);
    }

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        if (response.getStatusCode().series() == SERVER_ERROR) {
            ServiceErrorMessage body = getBody(response);
            throw new PupunhaModuleServerException(body.getModuleId(), body.getErrorCode(), body.getMessage());
        } else if (response.getStatusCode().series() == CLIENT_ERROR) {
            ServiceErrorMessage body = getBody(response);
            if (response.getStatusCode() == HttpStatus.NOT_FOUND) {
                throw new PupunhaModuleNotFoundException(body.getModuleId());
            }
            throw new PupunhaModuleClientException(body.getModuleId(), body.getErrorCode(), body.getMessage());
        }
    }

    private ServiceErrorMessage getBody(ClientHttpResponse response) throws IOException {
        String body = StreamUtils.copyToString(response.getBody(), Objects.requireNonNull(getCharset(response)));
        CustomObjectMapper objectMapper = new CustomObjectMapper();
        return objectMapper.readValue(body, new TypeReference<ServiceErrorMessage>() {});
    }

}

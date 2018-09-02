package net.pupunha.servicehandler.server;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ServiceErrorMessage extends ErrorMessage {

    private String moduleId;
    private HttpStatus status;
    private String errorCode;
    private final Date timestamp = new Date();
    private String message;
    private String path;

    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
    @JsonSubTypes({
            @JsonSubTypes.Type(value = ServiceErrorMessage.class),
            @JsonSubTypes.Type(value = ValidationErrorMessage.class)
    })
    private List<ErrorMessage> cause;

    public void addErrorMessage(ErrorMessage errorMessage) {
        if (cause == null) {
            cause = new ArrayList<>();
        }
        cause.add(errorMessage);
    }

}
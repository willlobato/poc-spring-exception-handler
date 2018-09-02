package net.pupunha.servicehandler.server;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ValidationErrorMessage extends ErrorMessage {

    private String object;
    private List<FieldValidation> fields;
    private String message;

    @JsonIgnore
    public FieldValidation getSingleField() {
        return fields.stream().findFirst().orElse(null);
    }

}

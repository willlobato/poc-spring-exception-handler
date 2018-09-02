package net.pupunha.servicehandler.server;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FieldValidation {

    private String field;

//    @JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
    private Object rejectedValue;

}

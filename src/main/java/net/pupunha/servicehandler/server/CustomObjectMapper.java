package net.pupunha.servicehandler.server;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.StdDateFormat;

public class CustomObjectMapper extends ObjectMapper {
    {
        this.configure(SerializationFeature.INDENT_OUTPUT, true);
        this.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        this.setDateFormat(new StdDateFormat());
    }
}

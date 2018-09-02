package net.pupunha.servicehandler.client;

import net.pupunha.servicehandler.client.custom.RequestResponseLoggingInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

public class PupunhaFacade {

    @Autowired
    private RestTemplate restTemplate;

    public void get() {
        restTemplate.setInterceptors(Collections.singletonList(new RequestResponseLoggingInterceptor()));
    }

}

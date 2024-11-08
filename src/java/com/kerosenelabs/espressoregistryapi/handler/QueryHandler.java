package com.kerosenelabs.espressoregistryapi.handler;

import com.kerosenelabs.kindling.handler.RequestHandler;

import com.kerosenelabs.kindling.exception.KindlingException;
import com.kerosenelabs.espressoregistryapi.service.RegistryService;
import com.kerosenelabs.kindling.HttpRequest;
import com.kerosenelabs.kindling.HttpResponse;
import com.kerosenelabs.kindling.constant.HttpStatus;
import java.util.HashMap;

public class QueryHandler extends RequestHandler {

    // dependencies
    private RegistryService registryService = RegistryService.getInstance();

    @Override
    public HttpResponse handle(HttpRequest httpRequest) throws KindlingException {
        return new HttpResponse.Builder()
                .status(HttpStatus.OK)
                .headers(new HashMap<>() {
                    {
                        put("Content-Type", "application/json");
                    }
                })
                .content("{\"key\": \"value\"}")
                .build();
    }

    @Override
    public boolean accepts(HttpRequest httpRequest) throws KindlingException {
        return httpRequest.getResource().equals("/registry/query");
    }
}

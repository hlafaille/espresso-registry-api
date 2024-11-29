package com.kerosenelabs.espressoregistryapi.handler;

import com.kerosenelabs.kindling.HttpResponse;
import com.kerosenelabs.kindling.constant.HttpStatus;
import com.kerosenelabs.kindling.constant.MimeType;
import com.kerosenelabs.kindling.exception.KindlingException;
import com.kerosenelabs.kindling.handler.RequestHandler;

public abstract class BaseHandler extends RequestHandler {
    @Override
    public HttpResponse handleError(Throwable throwable) throws KindlingException {
        throwable.printStackTrace();
        return new HttpResponse.Builder()
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .contentType(MimeType.APPLICATION_JSON)
                .content("{\"message\": \"" + throwable.getMessage() + "\"}")
                .build();
    }
}

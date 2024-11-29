package com.kerosenelabs.espressoregistryapi;

import com.kerosenelabs.kindling.KindlingServer;
import java.nio.file.Path;
import java.util.logging.Logger;

import com.kerosenelabs.kindling.exception.KindlingException;
import com.kerosenelabs.espressoregistryapi.handler.QueryHandler;

public class Main {
    private static final Logger log = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws KindlingException {
        log.info("Starting server");
        KindlingServer server = KindlingServer.getInstance();
        server.installRequestHandler(new QueryHandler());
        log.info("Now serving, listening for requests");
        server.serve(8443, Path.of("keystore.p12"), "password");
    }
}
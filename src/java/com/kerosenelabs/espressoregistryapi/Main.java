package com.kerosenelabs.espressoregistryapi;

import com.kerosenelabs.kindling.KindlingServer;
import java.nio.file.Path;
import com.kerosenelabs.kindling.exception.KindlingException;
import com.kerosenelabs.espressoregistryapi.handler.QueryHandler;

public class Main {
    public static void main(String[] args) throws KindlingException {
        KindlingServer server = KindlingServer.getInstance();
        server.installRequestHandler(new QueryHandler());
        server.serve(8443, Path.of("keystore.p12"), "password");
    }
}
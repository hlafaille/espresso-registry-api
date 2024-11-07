package com.kerosenelabs.espressoregistryapi.service;

public class QueryService {
    private static QueryService instance = null;

    public static QueryService getInstance() {
        if (instance == null) {
            instance = new QueryService();
        }
        return instance;
    }
}

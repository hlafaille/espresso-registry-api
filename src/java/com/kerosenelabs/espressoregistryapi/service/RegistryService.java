package com.kerosenelabs.espressoregistryapi.service;

public class RegistryService {
    private static RegistryService instance = null;

    public static RegistryService getInstance() {
        if (instance == null) {
            instance = new RegistryService();
        }
        return instance;
    }
}
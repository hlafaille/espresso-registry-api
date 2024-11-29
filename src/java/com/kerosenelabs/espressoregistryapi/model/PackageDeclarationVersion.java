package com.kerosenelabs.espressoregistryapi.model;

import java.util.List;

public class PackageDeclarationVersion {
    private String number;
    private boolean isAnnotationProcessor;
    private String artifactUrl;
    private List<String> transientDependencies;

    public PackageDeclarationVersion() {
    }

    public PackageDeclarationVersion(String number, boolean isAnnotationProcessor, String artifactUrl,
            List<String> transientDependencies) {
        this.number = number;
        this.isAnnotationProcessor = isAnnotationProcessor;
        this.artifactUrl = artifactUrl;
        this.transientDependencies = transientDependencies;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public boolean getIsAnnotationProcessor() {
        return isAnnotationProcessor;
    }

    public void setIsAnnotationProcessor(boolean isAnnotationProcessor) {
        this.isAnnotationProcessor = isAnnotationProcessor;

    }

    public String getArtifactUrl() {
        return artifactUrl;
    }

    public void setArtifactUrl(String artifactUrl) {
        this.artifactUrl = artifactUrl;
    }

    public List<String> getTransientDependencies() {
        return transientDependencies;
    }

    public void setTransientDependencies(List<String> transientDependencies) {
        this.transientDependencies = transientDependencies;
    }
}

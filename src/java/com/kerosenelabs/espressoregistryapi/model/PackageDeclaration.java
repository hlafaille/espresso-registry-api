package com.kerosenelabs.espressoregistryapi.model;

import java.util.List;

public class PackageDeclaration {
    private String description;
    private List<PackageDeclarationVersion> versions;

    public PackageDeclaration() {
    }

    public PackageDeclaration(String description, List<PackageDeclarationVersion> versions) {
        this.description = description;
        this.versions = versions;

    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<PackageDeclarationVersion> getVersions() {
        return versions;
    }

    public void setVersions(List<PackageDeclarationVersion> versions) {
        this.versions = versions;
    }
}

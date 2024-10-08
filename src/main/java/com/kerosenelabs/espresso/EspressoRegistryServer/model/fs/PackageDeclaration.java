package com.kerosenelabs.espresso.EspressoRegistryServer.model.fs;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PackageDeclaration {
    private String description;
    private List<PackageDeclarationVersion> versions;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class PackageDeclarationVersion {
        private String number;
        private Boolean isAnnotationProcessor;
        private String artifactUrl;
        private List<String> transientDependencies;
    }
}

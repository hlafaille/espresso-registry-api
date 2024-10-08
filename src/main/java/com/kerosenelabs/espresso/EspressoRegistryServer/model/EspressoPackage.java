package com.kerosenelabs.espresso.EspressoRegistryServer.model;

import com.kerosenelabs.espresso.EspressoRegistryServer.model.fs.PackageDeclaration;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EspressoPackage {
    private String name;
    private PackageDeclaration packageDeclaration;
}

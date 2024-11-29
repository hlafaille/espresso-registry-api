package com.kerosenelabs.espressoregistryapi.model;

public class EspressoPackage {
    private String name;
    private PackageDeclaration packageDeclaration;

    public EspressoPackage() {
    }

    public EspressoPackage(String name, PackageDeclaration packageDeclaration) {
        this.name = name;
        this.packageDeclaration = packageDeclaration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PackageDeclaration getPackageDeclaration() {
        return packageDeclaration;
    }

    public void setPackageDeclarations(PackageDeclaration packageDeclaration) {
        this.packageDeclaration = packageDeclaration;
    }
}
package com.kerosenelabs.espressoregistryapi.model;

import java.util.List;

public class Group {
    private String name;
    private List<EspressoPackage> espressoPackages;

    public Group() {

    }

    public Group(String name, List<EspressoPackage> espressoPackages) {
        this.name = name;
        this.espressoPackages = espressoPackages;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<EspressoPackage> getEspressoPackages() {
        return espressoPackages;
    }

    public void setEspressoPackages(List<EspressoPackage> espressoPackages) {
        this.espressoPackages = espressoPackages;
    }
}

package com.kerosenelabs.espresso.EspressoRegistryServer.model.fs;

import java.util.List;

import com.kerosenelabs.espresso.EspressoRegistryServer.model.EspressoPackage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Group {
    private String name;
    private List<EspressoPackage> espressoPackages;
}

package com.kerosenelabs.espresso.EspressoRegistryServer.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kerosenelabs.espresso.EspressoRegistryServer.model.fs.Group;
import com.kerosenelabs.espresso.EspressoRegistryServer.service.RegistryService;

@RestController
@CrossOrigin
public class RegistryQueryController {

    private RegistryService registryService;

    public RegistryQueryController(RegistryService registryService) {
        this.registryService = registryService;
    }

    @GetMapping("/registry")
    public ResponseEntity<List<Group>> queryRegistry(@RequestParam(required = false) String q) {
        return ResponseEntity.ok(registryService.queryGroupsForPackages(Optional.ofNullable(q)));
    }
}

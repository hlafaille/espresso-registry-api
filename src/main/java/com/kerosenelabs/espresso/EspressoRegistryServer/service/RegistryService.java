package com.kerosenelabs.espresso.EspressoRegistryServer.service;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;
import org.yaml.snakeyaml.Yaml;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.kerosenelabs.espresso.EspressoRegistryServer.model.EspressoPackage;
import com.kerosenelabs.espresso.EspressoRegistryServer.model.fs.Group;
import com.kerosenelabs.espresso.EspressoRegistryServer.model.fs.PackageDeclaration;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@CrossOrigin
public class RegistryService {
    private List<Group> groups;

    public RegistryService() {
        log.info("Parsing local filesystem registry");
        groups = walkGroupsForPackages();
    }

    private EspressoPackage parsePackageDeclarationYaml(Path packageDeclarationPath) {
        Yaml yaml = new Yaml();
        PackageDeclaration packageDeclaration = null;
        try (InputStream inputStream = Files.newInputStream(packageDeclarationPath)) {
            packageDeclaration = yaml.loadAs(inputStream, PackageDeclaration.class);
        } catch (IOException e) {
            log.error("An error occurred while reading a package declaration", e);
        }

        if (packageDeclaration == null) {
            throw new RuntimeException("Package Declaration was not read");
        }

        return new EspressoPackage(
                packageDeclarationPath.toFile().getName().replaceAll("\\.yml$", ""),
                packageDeclaration);
    }

    /**
     * Walk the packages within a particular group.
     * 
     * @param groupPath
     * @return
     */
    private List<EspressoPackage> parsePackagesDeclarationsInGroup(Path groupPath) {
        List<EspressoPackage> packages = new ArrayList<>();
        try (Stream<Path> stream = Files.walk(groupPath)) {
            stream.forEach((path) -> {
                if (path.toFile().isFile()) {
                    packages.add(parsePackageDeclarationYaml(path));
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return packages;
    }

    /**
     * Walk the groups
     */
    private List<Group> walkGroupsForPackages() {
        Path startDir = Paths.get("espresso-registry-main/packages");

        List<Group> groups = new ArrayList<>();
        try (Stream<Path> stream = Files.walk(startDir)) {
            stream.forEach((path) -> {
                System.out.println(path.toString());
                if (path.toFile().isDirectory() && !path.toString().endsWith("packages")) {
                    groups.add(new Group(
                            path.toFile().getName(),
                            parsePackagesDeclarationsInGroup(path)));
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return groups;
    }

    public List<Group> queryGroupsForPackages(Optional<String> q) {
        List<Group> filtered = new ArrayList<>();

        if (q.isPresent()) {
            for (Group group : groups) {
                // if the user is searching with a '.', we look for groups
                if (q.get().contains(".") && group.getName().toLowerCase().contains(q.get())) {
                    filtered.add(group);
                    continue;
                }

                // if the user is searching for strings, we look for packages
                for (EspressoPackage pkg : group.getEspressoPackages()) {
                    if (pkg.getPackageDeclaration().getDescription().toLowerCase().contains(q.get())
                            || pkg.getName().toLowerCase().contains(q.get())) {
                        filtered.add(group);
                    }
                }
            }
        }
        return filtered;
    }
}

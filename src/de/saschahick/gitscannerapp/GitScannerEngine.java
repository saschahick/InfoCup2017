package de.saschahick.gitscannerapp;

import de.saschahick.gitscannerapp.strategy.ClassificationStrategy;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

class GitScannerEngine {

    private ClassificationStrategy classificationStrategy;

    GitScannerEngine(ClassificationStrategy classificationStrategy){

        this.classificationStrategy = classificationStrategy;

    }

    void startScan(String inputFile, String outputFile){

        List<String> gitRepositories = parseFile(inputFile);
        List<String> gitRepositoriesClassified = new ArrayList<>();

        for (String repo : gitRepositories){

            gitRepositoriesClassified.add(repo + " " + classificationStrategy.getClassification(repo));

        }

        try {

            FileWriter fw = new FileWriter(outputFile);

            for (String repo : gitRepositoriesClassified)
                fw.write(repo + System.lineSeparator());

            fw.close();

        }catch (IOException exception){
            System.out.println("Error while writing output file");
        }

    }

    private List<String> parseFile(String ginFile){

        List<String> entries = new ArrayList<>();

        try {

            Path filePath = Paths.get(ginFile);

            Stream<String> lines = Files.lines(filePath);

            lines.forEach(entries::add);

        }catch (IOException exception){
            System.out.println("Error while parsing input file");
        }

        return entries;

    }

}

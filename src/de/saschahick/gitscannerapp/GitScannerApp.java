package de.saschahick.gitscannerapp;

import de.saschahick.gitscannerapp.strategy.RandomStrategy;

public class GitScannerApp {

    public static void main(String[] args) {

        GitScannerEngine gitScannerEngine = new GitScannerEngine(new RandomStrategy());
        String inputFile = null;
        String outputFile = "output.gin";

        String option = null;

        for(String argument : args) {

            if(option == null)
                option = argument;
            else {

                switch (option) {
                    case "-f":
                        inputFile = argument;
                        break;
                    case "-o":
                        outputFile = argument;
                        break;
                }

                option = null;

            }

        }

        if(inputFile == null)
            System.out.println("No file specified. Please use -f FILENAME to load the git input file");
        else
            gitScannerEngine.startScan(inputFile, outputFile);

    }

}

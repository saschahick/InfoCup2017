package de.saschahick.gitscannerapp.strategy;

import de.saschahick.gitscannerapp.Classifications;

import java.util.concurrent.ThreadLocalRandom;

public class RandomStrategy implements ClassificationStrategy {

    public Classifications getClassification(String gitRepo) {

        int rndIndex = ThreadLocalRandom.current().nextInt(Classifications.values().length);

        return Classifications.values()[rndIndex];

    }

}

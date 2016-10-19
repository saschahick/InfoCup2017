package de.saschahick.gitscannerapp.strategy;

import de.saschahick.gitscannerapp.Classifications;

public interface ClassificationStrategy {

    public Classifications getClassification(String gitRepo);

}

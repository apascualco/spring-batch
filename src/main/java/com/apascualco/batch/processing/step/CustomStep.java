package com.apascualco.batch.processing.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;

public interface CustomStep {

    Step step(StepBuilderFactory stepBuilderFactory);

}

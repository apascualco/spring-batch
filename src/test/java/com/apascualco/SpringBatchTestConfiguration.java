package com.apascualco;

import com.apascualco.batch.processing.SpringBatchApplication;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
@ComponentScan(basePackageClasses = SpringBatchApplication.class)
public class SpringBatchTestConfiguration {

    @Bean
    public static JobLauncherTestUtils jobLauncherTestUtils() {
        return new JobLauncherTestUtils();
    }

}

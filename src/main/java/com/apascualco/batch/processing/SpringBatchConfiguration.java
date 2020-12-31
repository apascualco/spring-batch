package com.apascualco.batch.processing;

import com.apascualco.batch.processing.config.ReaderConfig;
import com.apascualco.persistence.model.BaseEntities;
import com.apascualco.persistence.repository.BaseRepository;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@Import({ReaderConfig.class})
@EntityScan(basePackageClasses = BaseEntities.class)
@EnableJpaRepositories(basePackageClasses = BaseRepository.class)
public class SpringBatchConfiguration {
}

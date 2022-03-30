package br.com.spring.batch.exemple.job;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class FileReaderJob {

    private final JobBuilderFactory jobBuilderFactory;

    @Bean
    public Job simpleFleReaderJob(Step stepReaderFile){
         return jobBuilderFactory
                 .get("fileReaderJob")
                 .start(stepReaderFile)
                 .incrementer(new RunIdIncrementer())
                 .build();
    }
}
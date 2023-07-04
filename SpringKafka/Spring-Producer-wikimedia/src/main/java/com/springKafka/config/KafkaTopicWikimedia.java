package com.springKafka.config;

import com.springKafka.Kafka.WikimediaChangesProducer;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicWikimedia implements CommandLineRunner {
    @Bean
    public NewTopic createTopic(){
        return TopicBuilder.name("wikimedia")
                .build();
    }

    @Autowired
    private WikimediaChangesProducer wikimediaChangesProducer;
    @Override
    public void run(String... args) throws Exception {
        wikimediaChangesProducer.sendMessage();
    }
}

/*
 * Created: 16.02.2022
 * Copyright (c) Saxess AG. All rights reserved.
 */

package de.goldmann.realestate.jms.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.Queue;

@Configuration
@EnableJms
public class JMSConfig {
    @Value("${active-mq-url}")
    private String activeMqUrl;

    @Bean
    public Queue queue(){
        return new ActiveMQQueue("data-collection-activation-queue");
    }

    @Bean
    public ActiveMQConnectionFactory connectionFatory(){
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory();
        factory.setBrokerURL(activeMqUrl);
        return factory;
    }

    @Bean
    public JmsTemplate jmsTemplate(){
        return new JmsTemplate(connectionFatory());
    }
}

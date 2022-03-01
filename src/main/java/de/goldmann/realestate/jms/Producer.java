/*
 * Created: 16.02.2022
 * Copyright (c) Saxess AG. All rights reserved.
 */

package de.goldmann.realestate.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Queue;

@Service
public class Producer {

    @Autowired
    private Queue queue;

    @Autowired
    private JmsTemplate jmsTemplate;

    public String publish(final String msg){
        jmsTemplate.convertAndSend(queue,msg);
        return "Your message <b>"+msg+"</b> published successfully";
    }
}


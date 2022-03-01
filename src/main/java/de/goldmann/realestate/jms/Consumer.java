/*
 * Created: 16.02.2022
 * Copyright (c) Saxess AG. All rights reserved.
 */

package de.goldmann.realestate.jms;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.goldmann.realestate.data.domain.AirBnbResult;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @JmsListener(destination = "data-collection-result-queue")
    public void listener(String msg){

        final AirBnbResult result = new ObjectMapper().convertValue(msg, AirBnbResult.class);
        System.out.println("Received Result : "+ result);
    }
}

package com.test.integration;

import com.test.schemas.Event;
import org.springframework.web.client.RestTemplate;

/**
 * Created by syerrami on 10/15/15.
 */
public class Consumersvc {

    public  void pushEvent(Event event)
    {
        final String uri = "http://localhost:8080/springrestexample/employees.json";

        RestTemplate restTemplate = new RestTemplate();
        Event result = restTemplate.postForObject( uri, event, Event.class);
        System.out.println(result);
    }
}

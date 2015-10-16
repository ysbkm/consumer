package com.test.processor;


import com.test.integration.Mongosvc;
import com.test.schemas.Event;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by syerrami.
 * Entry point to Process
 * Process method would call required processor
 */
@Component
public class EventProcessor {


    static Logger log = Logger.getLogger(EventProcessor.class.getName());


    @Resource(name = "mongosvc")
    private Mongosvc mongosvc;

    public void process(Event event) throws Exception {

        log.info("Mongo Create Event called");
        try {
            mongosvc.createEvent(event);
        } catch (Exception e) {
            log.error("Exception caught in Processor", e);
            e.printStackTrace();
            throw e;
        }

    }
}

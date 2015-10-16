package com.test.controller;

import com.test.processor.EventProcessor;
import com.test.schemas.Event;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Created by syerrami.
 * Entry point to event processing
 * Process the received event from the body call Process method
 */

@RestController
public class ConsumerEventController {

    @Resource(name = "eventProcessor")
    private EventProcessor eventProcessor;


    static Logger log = Logger.getLogger(ConsumerEventController.class.getName());

    //@RequestMapping("consumer/createevent")
    @RequestMapping(value = "consumer/createevent", method = RequestMethod.POST , consumes="application/json" , produces="application/json")
    public @ResponseBody Event createEvent(@RequestBody Event event) {

        log.info("Create Event request received ");
        if (event !=null) {

            log.info("Event Processor Called");
            try {
                eventProcessor.process(event);
            } catch (Exception e) {
                e.printStackTrace();
                log.error("Exception Caught in Controller",e);
                throw new RuntimeException(e);
            }
        }

        return event;
    }

}

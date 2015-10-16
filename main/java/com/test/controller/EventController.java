package com.test.controller;

import com.test.processor.EventProcessor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by syerrami.
 */

@RestController
public class EventController {

    @RequestMapping("/events")
    public String loadEvents(@RequestParam(value="filePath", defaultValue="/Users/syerrami/code/consumer/src/main/resources/source.txt")  String filePath){
     EventProcessor eventProcessor = new EventProcessor();
        eventProcessor.process(filePath);
        return null;
    }

}

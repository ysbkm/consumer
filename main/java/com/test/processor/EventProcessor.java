package com.test.processor;


import com.test.integration.Consumersvc;
import com.test.schemas.Event;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;

import org.apache.commons.io.FileUtils;
import java.io.File;
import java.util.List;

/**
 * Created by syerrami on 10/14/15.
 */
public class EventProcessor {

    public void process(String filePath){

        ObjectMapper mapper = new ObjectMapper();
        File file = new File(filePath);
        Consumersvc consumersvc = new Consumersvc();
        Event event = null;

        try {
            List<String> lines = FileUtils.readLines(file);
            for(String element:lines)
            {
                JsonNode node = mapper.readTree(element);
                event = mapper.treeToValue(node, Event.class);
                consumersvc.pushEvent(event);
                System.out.println("node = " + node);
                System.out.println("element = " + element);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

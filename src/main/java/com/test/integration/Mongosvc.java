package com.test.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.mongodb.*;
import com.test.schemas.Event;
import com.mongodb.util.JSON;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;


/**
 * Created by syerrami.
 * Entry point to Mongo interactions
 * Insert data received into Mongo db
 */
@Component
public class Mongosvc {


    static Logger log = Logger.getLogger(Mongosvc.class.getName());


    static Mongo mongo = new Mongo("localhost", 27017);
    static DB db = mongo.getDB("customer_event_repository");
    static DBCollection collection = db.getCollection("customer_events");

    public void createEvent(Event event) throws Exception {

        log.info("Mongo service Create Event called");

        try {

            if (event != null) {

                log.info("Event JSON Received");

                ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
                String json = ow.writeValueAsString(event);

                DBObject dbObject = (DBObject) JSON.parse(json);

                collection.insert(dbObject);
                log.info("Event created into DB");

                DBCursor cursorDocJSON = collection.find();
                log.info("Total Number of records from DB >> " + cursorDocJSON.count());
                while (cursorDocJSON.hasNext()) {
                    log.info("Values from DB >> " +cursorDocJSON.next());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Exception during DB Insert",e);
            throw e;
        }
    }

}

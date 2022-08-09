package com.example.vehicle.restserver;

import java.util.UUID;
import java.util.List;
import java.util.Map;


import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import com.example.vehicle.datamodel.Car;
import com.example.vehicle.datamodel.Truck;
import com.example.vehicle.datamodel.Vehicle;


@Path("/api")
public class SimpleRESTService {
    Logger log = LoggerFactory.getLogger(SimpleRESTService.class);
    @GET
    @Path("/text")
    public String getHello () 
    {
        log.info("here");
        return "hello world!";
    } 
   
    @POST
    @Path("/decorate")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Map<String, List<Vehicle>> updateVehicle(Map<String, List<Vehicle>> wrappers) {
        log.info("update");
        for (Map.Entry<String,List<Vehicle>> wrapper : wrappers.entrySet()) {
            log.info("wrapper key is {}", wrapper.getKey());
            for (Vehicle sp : wrapper.getValue()) {
                log.info("Vehicle is {}", sp);
            }
        }


        // Vehicle sp =  new Vehicle();
        // sp.setKey("jeffkey");
        // sp.setValue("jefvalue");
        return wrappers;
    }

}

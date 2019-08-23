package com.johnny.simulationexperimentservice.controller;

import com.johnny.simulationexperimentservice.dto.ExperimentAssignDTO;
import com.johnny.simulationexperimentservice.service.impl.ExperimentAssignServiceImpl;
import com.johnny.simulationexperimentservice.vo.UnifiedResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/experiment/assign")
public class ExperimentAssignController {
    @Autowired
    private ExperimentAssignServiceImpl myService;

    @RequestMapping(value = "/{pageNumber}/{pageSize}/{systemID}/{courseID}/{experimentTypeID}", method = RequestMethod.GET)
    public UnifiedResponse findSystemData(@PathVariable("pageNumber") int pageNumber,
                                          @PathVariable("pageSize") int pageSize,
                                          @PathVariable("systemID") int systemID,
                                          @PathVariable("courseID") int courseID,
                                          @PathVariable("experimentTypeID") int experimentTypeID){
        return myService.findListByContent(pageNumber, pageSize, systemID, courseID, experimentTypeID);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public UnifiedResponse find(@PathVariable("id") int id){
        return myService.find(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public UnifiedResponse add(@RequestBody ExperimentAssignDTO dto){
        return myService.add(dto);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public UnifiedResponse change(@RequestBody ExperimentAssignDTO dto){
        return myService.change(dto);
    }

    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public UnifiedResponse delete(@PathVariable("id") int id){
        return myService.delete(id);
    }
}

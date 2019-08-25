package com.johnny.simulationexperimentservice.controller;

import com.johnny.simulationexperimentservice.dto.TeachingResourceDTO;
import com.johnny.simulationexperimentservice.service.impl.TeachingResourceServiceImpl;
import com.johnny.simulationexperimentservice.vo.UnifiedResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/teachingResource")
public class TeachingResourceController {
    @Autowired
    private TeachingResourceServiceImpl myService;

    @RequestMapping(value = "/{pageNumber}/{pageSize}/{systemID}/{courseID}/{resourceTypeID}/{resourceStatus}/{auditorID}", method = RequestMethod.GET)
    public UnifiedResponse findListByContent(@PathVariable("pageNumber") int pageNumber,
                                          @PathVariable("pageSize") int pageSize,
                                          @PathVariable("systemID") int systemID,
                                          @PathVariable("courseID") int courseID,
                                          @PathVariable("resourceTypeID") int resourceTypeID,
                                          @PathVariable("resourceStatus") String resourceStatus,
                                          @PathVariable("auditorID") int auditorID){
        return myService.findListByContent(pageNumber, pageSize, systemID, courseID, resourceTypeID, resourceStatus, auditorID);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public UnifiedResponse find(@PathVariable("id") int id){
        return myService.find(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public UnifiedResponse add(@RequestBody TeachingResourceDTO dto){
        return myService.add(dto);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public UnifiedResponse change(@RequestBody TeachingResourceDTO dto){
        return myService.change(dto);
    }

    @RequestMapping(value="/changeStatus", method = RequestMethod.PUT)
    public UnifiedResponse changeStatus(@RequestBody TeachingResourceDTO dto){
        return myService.changeStatus(dto);
    }

    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public UnifiedResponse delete(@PathVariable("id") int id){
        return myService.delete(id);
    }
}

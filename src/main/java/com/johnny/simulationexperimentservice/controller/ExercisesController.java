package com.johnny.simulationexperimentservice.controller;

import com.johnny.simulationexperimentservice.dto.ExercisesDTO;
import com.johnny.simulationexperimentservice.service.impl.ExercisesServiceImpl;
import com.johnny.simulationexperimentservice.vo.UnifiedResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/exercises")
public class ExercisesController {
    @Autowired
    private ExercisesServiceImpl myService;

    @RequestMapping(value = "/{pageNumber}/{pageSize}/{systemID}/{knowledgeID}/{userID}", method = RequestMethod.GET)
    public UnifiedResponse findSystemData(@PathVariable("pageNumber") int pageNumber,
                                          @PathVariable("pageSize") int pageSize,
                                          @PathVariable("systemID") int systemID,
                                          @PathVariable("knowledgeID") int knowledgeID,
                                          @PathVariable("userID") int userID){
        return myService.findListByContent(pageNumber, pageSize, systemID, knowledgeID, userID);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public UnifiedResponse find(@PathVariable("id") int id){
        return myService.find(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public UnifiedResponse add(@RequestBody ExercisesDTO dto){
        return myService.add(dto);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public UnifiedResponse change(@RequestBody ExercisesDTO dto){
        return myService.change(dto);
    }

    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public UnifiedResponse delete(@PathVariable("id") int id){
        return myService.delete(id);
    }
}

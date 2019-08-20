package com.johnny.simulationexperimentservice.controller;

import com.johnny.simulationexperimentservice.dto.KnowledgeDTO;
import com.johnny.simulationexperimentservice.service.impl.*;
import com.johnny.simulationexperimentservice.vo.UnifiedResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/knowledge")
public class KnowledgeController {
    @Autowired
    private KnowledgeServiceImpl myService;

    @RequestMapping(value = "/{pageNumber}/{pageSize}/{systemID}/{userID}", method = RequestMethod.GET)
    public UnifiedResponse findSystemData(@PathVariable("pageNumber") int pageNumber,
                                          @PathVariable("pageSize") int pageSize,
                                          @PathVariable("systemID") int systemID,
                                          @PathVariable("userID") int userID){
        return myService.findListByContent(pageNumber, pageSize, systemID, userID);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public UnifiedResponse find(@PathVariable("id") int id){
        return myService.find(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public UnifiedResponse add(@RequestBody KnowledgeDTO dto){
        return myService.add(dto);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public UnifiedResponse change(@RequestBody KnowledgeDTO dto){
        return myService.change(dto);
    }

    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public UnifiedResponse delete(@PathVariable("id") int id){
        return myService.delete(id);
    }

}

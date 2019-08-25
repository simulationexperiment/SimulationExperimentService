package com.johnny.simulationexperimentservice.controller;

import com.johnny.simulationexperimentservice.dto.ExperimentReportDTO;
import com.johnny.simulationexperimentservice.service.impl.ExperimentReportServiceImpl;
import com.johnny.simulationexperimentservice.vo.UnifiedResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/experiment/report")
public class ExperimentReportController {
    @Autowired
    private ExperimentReportServiceImpl myService;

    @RequestMapping(value = "/{pageNumber}/{pageSize}/{systemID}/{courseID}/{experimentTypeID}/{reportStatus}/{createUser}/{auditorID}", method = RequestMethod.GET)
    public UnifiedResponse findSystemData(@PathVariable("pageNumber") int pageNumber,
                                          @PathVariable("pageSize") int pageSize,
                                          @PathVariable("systemID") int systemID,
                                          @PathVariable("courseID") int courseID,
                                          @PathVariable("experimentTypeID") int experimentTypeID,
                                          @PathVariable("reportStatus") String reportStatus,
                                          @PathVariable("createUser") int createUser,
                                          @PathVariable("auditorID") int auditorID){
        return myService.findListByContent(pageNumber, pageSize, systemID, courseID, experimentTypeID, reportStatus, createUser, auditorID);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public UnifiedResponse find(@PathVariable("id") int id){
        return myService.find(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public UnifiedResponse add(@RequestBody ExperimentReportDTO dto){
        return myService.add(dto);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public UnifiedResponse change(@RequestBody ExperimentReportDTO dto){
        return myService.change(dto);
    }

    @RequestMapping(value="/changeScore", method = RequestMethod.PUT)
    public UnifiedResponse changeScore(@RequestBody ExperimentReportDTO dto){
        return myService.changeScore(dto);
    }

    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public UnifiedResponse delete(@PathVariable("id") int id){
        return myService.delete(id);
    }
}

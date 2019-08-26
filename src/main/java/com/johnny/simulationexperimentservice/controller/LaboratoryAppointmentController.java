package com.johnny.simulationexperimentservice.controller;

import com.johnny.simulationexperimentservice.dto.LaboratoryAppointmentDTO;
import com.johnny.simulationexperimentservice.service.impl.LaboratoryAppointmentServiceImpl;
import com.johnny.simulationexperimentservice.vo.UnifiedResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/laboratory/appointment")
public class LaboratoryAppointmentController {
    @Autowired
    private LaboratoryAppointmentServiceImpl myService;

    @RequestMapping(value = "/{pageNumber}/{pageSize}/{fromDate}/{toDate}", method = RequestMethod.GET)
    public UnifiedResponse findList(@PathVariable("pageNumber") int pageNumber,
                                          @PathVariable("pageSize") int pageSize,
                                          @PathVariable("fromDate") String fromDate,
                                          @PathVariable("toDate") String toDate){
        return myService.findListByContent(pageNumber, pageSize, fromDate, toDate);
    }

    @RequestMapping(value = "/scheduled/{laboratoryDate}/{courseOrder}/{laboratoryID}", method = RequestMethod.GET)
    public UnifiedResponse findScheduledCountByContent(@PathVariable("laboratoryDate") String laboratoryDate,
                                                       @PathVariable("courseOrder") int courseOrder,
                                                       @PathVariable("laboratoryID") int laboratoryID){
        return myService.findScheduledCountByContent(laboratoryDate, courseOrder, laboratoryID);
    }


    @RequestMapping(method = RequestMethod.POST)
    public UnifiedResponse add(@RequestBody LaboratoryAppointmentDTO dto){
        return myService.add(dto);
    }

    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public UnifiedResponse delete(@PathVariable("id") int id){
        return myService.delete(id);
    }
}

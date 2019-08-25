package com.johnny.simulationexperimentservice.controller;

import com.johnny.simulationexperimentservice.dto.ClassSchedule4TeacherDTO;
import com.johnny.simulationexperimentservice.service.impl.ClassSchedule4TeacherServiceImpl;
import com.johnny.simulationexperimentservice.vo.UnifiedResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/classSchedule/teacher")
public class ClassSchedule4TeacherController {
    @Autowired
    private ClassSchedule4TeacherServiceImpl myService;

    @RequestMapping(value = "/{systemID}/{teacherID}", method = RequestMethod.GET)
    public UnifiedResponse findSystemData(@PathVariable("systemID") int systemID, @PathVariable("teacherID") int teacherID){
        return myService.findListByContent(systemID, teacherID);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public UnifiedResponse find(@PathVariable("id") int id){
        return myService.find(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public UnifiedResponse add(@RequestBody ClassSchedule4TeacherDTO dto){
        return myService.add(dto);
    }

//    @RequestMapping(method = RequestMethod.PUT)
//    public UnifiedResponse change(@RequestBody ClassSchedule4TeacherDTO dto){
//        return myService.change(dto);
//    }
//
//    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
//    public UnifiedResponse delete(@PathVariable("id") int id){
//        return myService.delete(id);
//    }

}

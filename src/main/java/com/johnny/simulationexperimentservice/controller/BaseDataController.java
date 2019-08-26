package com.johnny.simulationexperimentservice.controller;

import com.johnny.simulationexperimentservice.service.impl.*;
import com.johnny.simulationexperimentservice.vo.UnifiedResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/baseData")
public class BaseDataController {
    @Autowired
    private SystemServiceImpl systemService;

    @Autowired
    private CourseServiceImpl courseService;

    @Autowired
    private ResourceTypeServiceImpl resourceTypeService;

    @Autowired
    private ExperimentTypeServiceImpl experimentTypeService;

    @Autowired
    private ExercisesTypeServiceImpl exercisesTypeService;

    @Autowired
    private LaboratoryServiceImpl laboratoryService;

    @RequestMapping(value = "/system/{pageNumber}/{pageSize}", method = RequestMethod.GET)
    public UnifiedResponse findSystemData(@PathVariable("pageNumber") int pageNumber, @PathVariable("pageSize") int pageSize){
        return systemService.findList(pageNumber, pageSize);
    }

    @RequestMapping(value = "/course/{pageNumber}/{pageSize}", method = RequestMethod.GET)
    public UnifiedResponse findCourseData(@PathVariable("pageNumber") int pageNumber, @PathVariable("pageSize") int pageSize){
        return courseService.findList(pageNumber, pageSize);
    }

    @RequestMapping(value = "/resourceType/{pageNumber}/{pageSize}", method = RequestMethod.GET)
    public UnifiedResponse findResourceTypeData(@PathVariable("pageNumber") int pageNumber, @PathVariable("pageSize") int pageSize){
        return resourceTypeService.findList(pageNumber, pageSize);
    }

    @RequestMapping(value = "/experimentType/{pageNumber}/{pageSize}", method = RequestMethod.GET)
    public UnifiedResponse findExperimentTypeData(@PathVariable("pageNumber") int pageNumber, @PathVariable("pageSize") int pageSize){
        return experimentTypeService.findList(pageNumber, pageSize);
    }

    @RequestMapping(value = "/exercisesType/{pageNumber}/{pageSize}", method = RequestMethod.GET)
    public UnifiedResponse findExercisesTypeData(@PathVariable("pageNumber") int pageNumber, @PathVariable("pageSize") int pageSize){
        return exercisesTypeService.findList(pageNumber, pageSize);
    }

    @RequestMapping(value = "/laboratory/{pageNumber}/{pageSize}", method = RequestMethod.GET)
    public UnifiedResponse findLaboratoryData(@PathVariable("pageNumber") int pageNumber, @PathVariable("pageSize") int pageSize){
        return laboratoryService.findList(pageNumber, pageSize);
    }
}

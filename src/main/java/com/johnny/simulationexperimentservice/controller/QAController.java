package com.johnny.simulationexperimentservice.controller;

import com.johnny.simulationexperimentservice.dto.AnswerDTO;
import com.johnny.simulationexperimentservice.dto.QuestionDTO;
import com.johnny.simulationexperimentservice.service.impl.AnswerServiceImpl;
import com.johnny.simulationexperimentservice.service.impl.QAServiceImpl;
import com.johnny.simulationexperimentservice.service.impl.QuestionServiceImpl;
import com.johnny.simulationexperimentservice.vo.UnifiedResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/qa")
public class QAController {

    @Autowired
    private QAServiceImpl qaService;

    @Autowired
    private QuestionServiceImpl questionService;

    @Autowired
    private AnswerServiceImpl answerService;

    @RequestMapping(value = "/{pageNumber}/{pageSize}", method = RequestMethod.GET)
    public UnifiedResponse findList(@PathVariable("pageNumber") int pageNumber,
                                          @PathVariable("pageSize") int pageSize){
        return qaService.findList(pageNumber, pageSize);
    }

    @RequestMapping(value="/question", method = RequestMethod.POST)
    public UnifiedResponse add(@RequestBody QuestionDTO dto){
        return questionService.add(dto);
    }

    @RequestMapping(value="/answer", method = RequestMethod.POST)
    public UnifiedResponse add(@RequestBody AnswerDTO dto){
        return answerService.add(dto);
    }

    @RequestMapping(value="/question/{id}", method = RequestMethod.DELETE)
    public UnifiedResponse deleteQuestion(@PathVariable("id") int id){
        return questionService.delete(id);
    }

    @RequestMapping(value="/answer/{id}", method = RequestMethod.DELETE)
    public UnifiedResponse deleteAnswer(@PathVariable("id") int id){
        return answerService.delete(id);
    }
}

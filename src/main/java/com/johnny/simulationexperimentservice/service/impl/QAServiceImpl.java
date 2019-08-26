package com.johnny.simulationexperimentservice.service.impl;

import com.johnny.simulationexperimentservice.common.ObjectConvertUtils;
import com.johnny.simulationexperimentservice.constant.ResponseDataConstant;
import com.johnny.simulationexperimentservice.entity.AnswerEntity;
import com.johnny.simulationexperimentservice.entity.QuestionEntity;
import com.johnny.simulationexperimentservice.manager.UnifiedResponseManager;
import com.johnny.simulationexperimentservice.mapper.AnswerMapper;
import com.johnny.simulationexperimentservice.mapper.QuestionMapper;
import com.johnny.simulationexperimentservice.vo.AnswerVO;
import com.johnny.simulationexperimentservice.vo.QAVO;
import com.johnny.simulationexperimentservice.vo.QuestionVO;
import com.johnny.simulationexperimentservice.vo.UnifiedResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QAServiceImpl {
    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private AnswerMapper answerMapper;

    private Logger logger = LogManager.getLogger(QAServiceImpl.class);

    public UnifiedResponse findList(int pageNumber, int pageSize) {
        try {
            int startIndex = (pageNumber - 1) * pageSize;
            List<QAVO> modelList = new ArrayList<>();

            int totalCount = questionMapper.searchTotalCount();
            if(totalCount == 0){
                return UnifiedResponseManager.buildSearchSuccessResponse(ResponseDataConstant.NO_SEARCH_COUNT, ResponseDataConstant.NO_DATA);
            }

            List<QuestionEntity> questionEntityList =  questionMapper.searchList(startIndex, pageSize);
            for (QuestionEntity questionEntity : questionEntityList) {
                QAVO model = new QAVO();
                QuestionVO questionVO = new QuestionVO();

                ObjectConvertUtils.toBean(questionEntity, questionVO);
                model.setQuestion(questionVO);

                List<AnswerEntity> answerEntityList = answerMapper.searchListByContent(0, 999, questionEntity.getQuestionID());
                if(answerEntityList != null){
                    List<AnswerVO> answerVOList = new ArrayList<>();
                    for (AnswerEntity answerEntity : answerEntityList) {
                        AnswerVO answerVO = new AnswerVO();
                        ObjectConvertUtils.toBean(answerEntity, answerVO);
                        answerVOList.add(answerVO);
                    }
                    model.setAnswerList(answerVOList);
                }
                modelList.add(model);
            }

            return UnifiedResponseManager.buildSearchSuccessResponse(modelList.size(), modelList);
        } catch (Exception ex) {
            logger.error(ex.toString());
            return UnifiedResponseManager.buildExceptionResponse();
        }
    }
}

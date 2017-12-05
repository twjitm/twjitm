package com.twjitm.answer.service;



import com.twjitm.answer.entity.AnswerVo;
import com.twjitm.answer.entity.Choices;
import com.twjitm.answer.entity.Explain;
import com.twjitm.answer.entity.Papers;

import java.util.List;

/**
 * Created by 文江 on 2017/11/30.
 */
public interface AnswerService {

    public void addExplain(Explain exception);

    public void addChoices(Choices choices);

    public void deleteAnwer(int id, int type);

    public void updateAnwer(Object object, int type);

    public List<Explain> getAllExceptionBytype(int type);
    public List<Explain> getAllExplain();
    public Explain getExceptionById(int id);

    public Explain getExceptionById(int id, int type);

    public List<Choices> getAllChoices();

    public Choices getChoicesById(int id);
    public List<Papers> getAllPapers();
    public void addPapers(Papers papers);

    public  boolean combination(String title, List<AnswerVo> answerVos);

        //papers
    public List<Papers>getallPapers();
    public Papers getPapersById(int id);
    public void deletePaper(int id);

}

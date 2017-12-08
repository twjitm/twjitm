package com.twjitm.answer.service;



import com.twjitm.answer.entity.*;

import javax.servlet.http.HttpServletRequest;
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

    public  boolean combination(HttpServletRequest request,String title, List<PapersVo> answerVos);

        //papers
    public List<Papers>getallPapers();
    public Papers getPapersById(int id);
    public void deletePaper(int id);
    //统计图表用
    public ChartVo analyseDegree();

}

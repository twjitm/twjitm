package com.twjitm.answer.service.Impl;


import com.twjitm.answer.dao.ChoicesMapper;
import com.twjitm.answer.dao.ExplainMapper;
import com.twjitm.answer.dao.PapersMapper;
import com.twjitm.answer.entity.AnswerVo;
import com.twjitm.answer.entity.Choices;
import com.twjitm.answer.entity.Explain;
import com.twjitm.answer.entity.Papers;
import com.twjitm.answer.enums.Qtypes;
import com.twjitm.answer.service.AnswerService;
import com.twjitm.answer.service.QtypesService;
import com.twjitm.utils.HtmlUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by 文江 on 2017/11/30.
 */
@Service
public class AnswerServiceImpl implements AnswerService {
    public QtypesService qtypesService;
    @Resource
    public ExplainMapper explainMapper;
    @Resource
    public ChoicesMapper choicesMapper;
    @Resource
    public PapersMapper papersMapper;

    public void addExplain(Explain exception) {
        explainMapper.insert(exception);
    }

    public void addChoices(Choices choices) {
        choicesMapper.insert(choices);
    }

    public void deleteAnwer(int id, int type) {
        if (type == Qtypes.TYPE_CHOICES.getValue()) {
            choicesMapper.deleteByPrimaryKey(id);
        } else {
            explainMapper.deleteByPrimaryKey(id);
        }
    }

    public void updateAnwer(Object object, int type) {
        if (type == Qtypes.TYPE_CHOICES.getValue()) {
            Choices choices = (Choices) object;
            choicesMapper.updateByPrimaryKey(choices);
        } else {
            explainMapper.updateByPrimaryKey((Explain) object);
        }
    }

    public List<Explain> getAllExceptionBytype(int type) {
        return explainMapper.getAllExceptionBytype(type);
    }


    public List<Explain> getAllExplain() {
        return null;
    }

    public Explain getExceptionById(int id) {
        Explain result = explainMapper.selectByPrimaryKey(id);
        return result;
    }

    public Explain getExceptionById(int id, int type) {
        return explainMapper.getExceptionById(id, type);
    }

    public List<Choices> getAllChoices() {
        return choicesMapper.getAllChose();
    }

    public Choices getChoicesById(int id) {
        return choicesMapper.selectByPrimaryKey(id);
    }


    public List<Papers> getAllPapers() {
        return null;
    }

    public boolean combination(String title, List<AnswerVo> answerVos) {
      //不满足组卷条件
        boolean satisfy = canCombination();
        if(!satisfy){
           // return false;
        }
        String setverPath = "//";
        String fileType = ".html";
        if (answerVos == null || answerVos.size() == 0) return false;
        //排序标号
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("<!doctype html>");
        stringBuffer.append(HtmlUtils.getHead(title));
        stringBuffer.append("<body>");
        stringBuffer.append("<div>");
        stringBuffer.append(HtmlUtils.getStyle());
        stringBuffer.append("<header class=\"wrap-header\">\n" +
                "      <article>\n" +
                "        <div class=\"wrap-title\" >\n" +
                "          <h1>" +
                "<span>" +
                "河北大学 2018 " +
                title +
                " 期末考试" +
                "</span></h1>\n" +
                "          <p>考试时间:2018年12月1日</p>\n" +
                "        </div>\n" +
                "      </article>\n" +
                "    </header>");
        stringBuffer.append(" <div class=\"row row-info\">");
        for (int i = 0; i < answerVos.size(); i++) {
            int answerType = answerVos.get(i).getType();
            stringBuffer.append("<article class=\"markup\">" +
                    "  <h2 class=\"section-title\">" +
                    "" +
                    i +
                    Qtypes.getTitle(answerType) + (answerVos.get(i).getScore()) +
                    "</h2>"
            );
            //处理选择题
            if (answerType == Qtypes.TYPE_CHOICES.getValue()) {
                List<Choices> choicesList = this.getAllChoices();
                List<Integer> idList = new ArrayList<Integer>();
                for (int j = 0; j < choicesList.size(); j++) {
                    idList.add(choicesList.get(j).getId());
                }
                int[] finalIdarray = getRandomArray(answerVos.get(i).getNumber(), idList);
                for (int j = 0; j < finalIdarray.length; j++) {
                    stringBuffer.append("<p>");
                    Choices choices = choicesMapper.selectByPrimaryKey(finalIdarray[i]);
                    stringBuffer.append("第" + j + "题:" + choices.getTitle());
                    stringBuffer.append("</p>");
                    stringBuffer.append("<blockquote>");
                    String answers = choices.getAnswer();
                    String[] anser = answers.split("#");
                    for (int m = 0; m < anser.length; m++) {
                        stringBuffer.append(anser[m]);
                    }
                    stringBuffer.append(" </blockquote>");
                }
                stringBuffer.append("</article>");
            }else{
                //非选着题
                String BagTitle = Qtypes.getTitle(answerType);
                List<Explain> allexceptionType = this.getAllExceptionBytype(answerType);
                List<Integer> idList = new ArrayList<Integer>();
                for (int j = 0; j < allexceptionType.size(); j++) {
                    idList.add(allexceptionType.get(j).getId());
                }
                int[] lastAnsuwerIdlist = this.getRandomArray(answerVos.get(i).getNumber(), idList);
                for (int j = 0; j < lastAnsuwerIdlist.length; j++) {
                    Explain explain = this.getExceptionById(lastAnsuwerIdlist[j]);
                    //拼接格式了
                    stringBuffer.append("<p>");
                    stringBuffer.append("第" + j + "题:"+explain.getTitle());
                    stringBuffer.append("</p>");
                    stringBuffer.append("<blockquote>");
                    stringBuffer.append("</br>");
                    stringBuffer.append("</blockquote>");
                }
                stringBuffer.append("</article>");
            }
        }
        stringBuffer.append("\n" +
                "  </div>\n" +
                "</body>\n" +
                "</html>");
        boolean success = false;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-hh-mm");
        String dateStr = dateFormat.format(new Date());
        File file = new File(setverPath + title + dateStr + fileType);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(stringBuffer.toString());
            bufferedWriter.close();
            Papers papers = new Papers();
            papers.setTitle(title);
            papers.setUrl(file.getPath());
            papersMapper.insert(papers);
            success = true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error-------------------------");
        }
        return success;
    }


    private int[] getRandomArray(int length, List<Integer> region) {

        int[] array = new int[length];
        List<Integer> list = new ArrayList<Integer>();
        Random random = new Random();
        while (list.size() < length) {
            int randomInt = random.nextInt(region.size());
            if (!list.contains(randomInt)) {
                list.add(randomInt);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            array[i] = region.get(list.get(i));
        }
        return array;
    }


    public List<Papers> getallPapers() {

        return papersMapper.getAllPapers();
    }

    public Papers getPapersById(int id) {
        return papersMapper.selectByPrimaryKey(id);
    }


    public void deletePaper(int id) {
        papersMapper.deleteByPrimaryKey(id);
    }

    /**
     * can combaination
     *
     * @return
     */
    public boolean canCombination() {
        List<Choices> allxhoicse = getAllChoices();
        if (allxhoicse == null) {
            return false;
        }
        if (allxhoicse.size() < 20) {
            return false;
        }
        List<Explain> gapList = getAllExceptionBytype(Qtypes.TYPE_GAP.getValue());
        if (gapList == null) {
            return false;
        }
        if (gapList.size() < 20) {
            return false;
        }
        List<Explain> umom = getAllExceptionBytype(Qtypes.TYPE_NUOM.getValue());
        if (umom == null) {
            return false;
        }
        if (umom.size() < 20) {
            return false;
        }
        List<Explain> ashort = getAllExceptionBytype(Qtypes.TYPW_SHORT.getValue());
        if (ashort == null) {
            return false;
        }
        if (ashort.size() < 20) {
            return false;
        }
        List<Explain> judgp = getAllExceptionBytype(Qtypes.TYPE_JUDGE.getValue());
        if (judgp == null) {
            return false;
        }
        if (judgp.size() < 20) {
            return false;
        }
        List<Explain> sub = getAllExceptionBytype(Qtypes.TYPE_SUBJECTATIVITY.getValue());
        if (sub == null) {
            return false;
        }
        if (sub.size() < 20) {
            return false;
        }
        return true;
    }

}

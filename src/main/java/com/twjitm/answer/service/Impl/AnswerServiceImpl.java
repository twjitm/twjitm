package com.twjitm.answer.service.Impl;


import com.twjitm.answer.dao.ChoicesMapper;
import com.twjitm.answer.dao.ExplainMapper;
import com.twjitm.answer.dao.PapersMapper;
import com.twjitm.answer.entity.*;
import com.twjitm.answer.enums.Degrees;
import com.twjitm.answer.enums.Qtypes;
import com.twjitm.answer.service.AnswerService;
import com.twjitm.utils.HtmlUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by 文江 on 2017/11/30.
 */
@Service
public class AnswerServiceImpl implements AnswerService {
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
        return explainMapper.getAllExplain();
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
     //抽样算法
    public boolean combination(int degre, String title, List<PapersVo> answerVos) {
        //不满足组卷条件
        boolean satisfy = canCombination();
        if (!satisfy) {
            // return false;
        }
       /* String realPath = request.getServletContext().getRealPath(
                "WEB-INF/File/");*/
        String realPath = "/WEB-INF/File/";
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
                //难度系数类key，对应难度系数的目id
                Map<Integer, List<Integer>> idMap = new HashMap<Integer, List<Integer>>();
                List<Integer> idList = new ArrayList<Integer>();
                for (int j = 0; j < choicesList.size(); j++) {
                    choicesList.get(j).getDegree();
                    if (idMap.containsKey(choicesList.get(j).getDegree())) {
                        idMap.get(choicesList.get(j).getDegree()).add(choicesList.get(j).getId());
                    } else {
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(choicesList.get(j).getId());
                        idMap.put(choicesList.get(j).getDegree(), list);
                    }
                    //idList.add(choicesList.get(j).getId());
                }
                int[] finalIdarray = getRandomArray(degre, answerVos.get(i).getNumber(), idMap);

                for (int j = 0; j < finalIdarray.length; j++) {
                    stringBuffer.append("<p>");
                    Choices choices = choicesMapper.selectByPrimaryKey(finalIdarray[i]);
                    stringBuffer.append("(" + j + "):" + choices.getTitle());
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
            } else {
                //非选着题
                String BagTitle = Qtypes.getTitle(answerType);
                List<Explain> allexceptionType = this.getAllExceptionBytype(answerType);
                Map<Integer, List<Integer>> idMap = new HashMap<Integer, List<Integer>>();
                for (int j = 0; j < allexceptionType.size(); j++) {
                    if (idMap.containsKey(allexceptionType.get(j).getDegree())) {
                        idMap.get(allexceptionType.get(j).getDegree());
                    } else {
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(allexceptionType.get(j).getId());
                    }
                }
                int[] lastAnsuwerIdlist = this.getRandomArray(degre, answerVos.get(i).getNumber(), idMap);
                for (int j = 0; j < lastAnsuwerIdlist.length; j++) {
                    Explain explain = this.getExceptionById(lastAnsuwerIdlist[j]);
                    //拼接格式了
                    stringBuffer.append("<p>");
                    stringBuffer.append("(" + j + "):" + explain.getTitle());
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
        String fileUrlDb = title + dateStr + fileType;
        File file = new File(realPath + fileUrlDb);
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
            papers.setUrl(fileUrlDb);
            papersMapper.insert(papers);
            success = true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error-------------------------");
        }
        return success;
    }

     //实现正态分布抽取抽样样本算法
    private int[] getRandomArray(int degre, int length, Map<Integer, List<Integer>> region) {
        //************难度系数******************
        double[] arrays = getDegres(degre);
        double easy = arrays[0];
        double general = arrays[1];
        double difficulty = arrays[2];
        //***********************************
        int[] array = new int[length];
        List<Integer> list = new ArrayList<Integer>();
        for (Map.Entry<Integer, List<Integer>> entry : region.entrySet()) {
            List<Integer> idList = entry.getValue();
            int wight = 0;
            if (entry.getKey() == Degrees.EASY_TYPE) {
                wight = (int) (Math.round(easy * length));
            } else if (entry.getKey() == Degrees.GENERAL_TYPE) {
                wight = (int) (Math.round(general * length));
            }
            if (entry.getKey() == Degrees.DIFFICULTY_TYPE) {
                wight = (int) (Math.round(difficulty * length));
            }
            getData(list, wight, idList);
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = list.get(i);
        }
        return array;
    }
    //核心抽样算法获取数据
    public void getData(List<Integer> list, int wight, List<Integer> idList) {
        Random random = new Random();
        if (wight > 0) {
            int addtag = 0;
            while (addtag < wight) {
                int top = random.nextInt(idList.size() - 1);
                if (!list.contains(idList.get(top))) {
                    list.add(idList.get(top));
                    addtag++;
                }
            }
        }
    }
      //正态分布算法难度系数基数
    public double[] getDegres(int degreType) {
        String dataStr;
        switch (degreType) {
            case Degrees.EASY_TYPE:
                dataStr = Degrees.EASY_RATIO_DEFAUT;
                break;
            case Degrees.GENERAL_TYPE:
                dataStr = Degrees.GENERAL_RATIO_DEFAUT;
                break;
            case Degrees.DIFFICULTY_TYPE:
                dataStr = Degrees.DIFFICULTY_RATIO_DEFAUT;
                break;
            default:
                dataStr = Degrees.EASY_RATIO_DEFAUT;
                break;
        }
        String[] values = dataStr.split(",");
        double[] array = {Double.parseDouble(values[0]), Double.parseDouble(values[1]), Double.parseDouble(values[2])};
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
     * 组卷条件检测
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


    //统计
    public ChartVo analyseDegree() {
        Map<String, List<Choices>> mapChoices = new HashMap<String, List<Choices>>();
        for (int i = 1; i < 4; i++) {
            List<Choices> list = getChoicesByDegres(i);
            mapChoices.put(Qtypes.TYPE_CHOICES.getValue() + "#" + i, list);
        }
        Map<String, List<Explain>> mapExplain = new HashMap<String, List<Explain>>();
        int[] valuesType = Qtypes.getAllExplainTypeValue();
        for (int i = 0; i < valuesType.length; i++) {//type
            for (int degres = 1; degres < 4; degres++) {
                mapExplain.put(i + "#" + degres, this.getExplainByTypeAndDegers(i, degres));
            }
        }
        ChartVo chartVo = new ChartVo();
        chartVo.setMapCho(mapChoices);
        chartVo.setMapExp(mapExplain);
        return chartVo;
    }

    private List<Choices> getChoicesByDegres(int degres) {
        List<Choices> choices = choicesMapper.getChoicesByDegres(degres);
        return choices;
    }

    private List<Explain> getExplainByTypeAndDegers(int type, int degres) {
        List<Explain> lsit = explainMapper.getExplainByTypeAndDegres(type, degres);
        return lsit;
    }


    public static void main(String[] args) {
       /* Map<Integer, List<Integer>> idMap = new HashMap<Integer, List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 1; i < 31; i++) {
            list.add(i);
        }
        idMap.put(1, list);
        List<Integer> list1 = new ArrayList<Integer>();
        for (int i = 31; i < 60; i++) {
            list1.add(i);
        }
        idMap.put(2, list1);
        List<Integer> list2 = new ArrayList<Integer>();
        for (int i = 61; i < 90; i++) {
            list2.add(i);
        }
        idMap.put(3, list2);

        AnswerServiceImpl answerService = new AnswerServiceImpl();
        int[] random = answerService.getRandomArray(1, 20, idMap);
        for (int i = 0; i < random.length; i++) {
            System.out.println(random[i]);
        }*/
       String b="abc";
       String a=new String("abc");
        String c=a;
        System.out.println(c==a);
    }
}

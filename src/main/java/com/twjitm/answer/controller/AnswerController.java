package com.twjitm.answer.controller;

import com.alibaba.fastjson.JSON;

import com.twjitm.answer.entity.*;
import com.twjitm.answer.enums.FileTypes;
import com.twjitm.answer.enums.Qtypes;
import com.twjitm.answer.service.AnswerService;
import com.twjitm.base.BaseController;
import com.twjitm.utils.HtmlUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 文江 on 2017/12/3.
 */
@RequestMapping("/answer")
@Controller
public class AnswerController extends BaseController {

    @Resource
    public AnswerService answerService;

    @RequestMapping("/elist")
    public String explainList(HttpServletRequest request) {
        List<Choices> choices = answerService.getAllChoices();
        List<Explain> explains = answerService.getAllExplain();
        request.setAttribute("choices", choices);
        request.setAttribute("explains", explains);
        return "/answer/elist";
    }

    //题目---------------------
    @RequestMapping("/addsubjectUI")
    public String addSubjectUI(HttpServletRequest request) {
        return "/answer/addsubject";
    }

    @RequestMapping("addsubject")
    public String addSubject(HttpServletRequest request, SubjectVo subjectVo) {
        int type = subjectVo.getQtype();
        String json = JSON.toJSONString(subjectVo);
        if (type == Qtypes.TYPE_CHOICES.getValue()) {
            Choices choices = JSON.parseObject(json, Choices.class);
            choices.setItems(subjectVo.getItemA() + "#" + subjectVo.getItemB() + "#" + subjectVo.getItemC() + "#" + subjectVo.getItemD());
            answerService.addChoices(choices);
        } else {
            Explain explain = JSON.parseObject(json, Explain.class);
            explain.setId(0);
            answerService.addExplain(explain);
        }
        return "redirect:/answer/elist.do";
    }

    @RequestMapping("/updateSubjectUI")
    public String updateSubjectUI(HttpServletRequest request, Integer id, Integer type) {
        if (type == Qtypes.TYPE_CHOICES.getValue()) {
            request.setAttribute("choices", answerService.getChoicesById(id));
            return "/upchoices";
        }
        answerService.getExceptionById(id, type);
        return "/upexplain";
    }

    @RequestMapping("/updateSubject")
    public String updateSubject(HttpServletRequest request, SubjectVo subjectVo) {
        int type = subjectVo.getQtype();
        answerService.updateAnwer(subjectVo, type);
        return "redirect:/answer/elist.do";
    }

    @RequestMapping("deleteSubject")
    public String deletteSubject(HttpServletRequest request, Integer id, Integer type) {
        answerService.deleteAnwer(id, type);
        return "redirect:/answer/elist.do";
    }

    //-----------统计
    @RequestMapping("/answerNum")
    @ResponseBody
    public String answerNUm(HttpServletRequest request) {
        String nums;
        List<Choices> choices = answerService.getAllChoices();
        nums = choices.size() + ",";
        for (int i = 1; i < 6; i++) {
            List<Explain> list = answerService.getAllExceptionBytype(i);
            nums = nums + list.size() + ",";
        }
        nums = nums.substring(0, nums.length() - 1);
        return nums;
    }

    @RequestMapping("/answerdesNum")
    @ResponseBody
    public String answerdesNum(HttpServletRequest request, int type) {
        String nums;
        int one = 0;
        int two = 0;
        int three = 0;
        if (type == 0) {
            List<Choices> allchose = answerService.getAllChoices();
            for (Choices choices : allchose) {
                switch (choices.getDegree()) {
                    case 1:
                        one++;
                        break;
                    case 2:
                        two++;
                        break;
                    case 3:
                        three++;
                        break;
                }
            }
            nums = one + "," + two + "," + three;
            return nums;
        } else {
            List<Explain> allexplain = answerService.getAllExceptionBytype(type);
            for (Explain explain : allexplain) {
                switch (explain.getDegree()) {
                    case 1:
                        one++;
                        break;
                    case 2:
                        two++;
                        break;
                    case 3:
                        three++;
                        break;
                }
            }
            nums = one + "," + two + "," + three;
        }
        return nums;
    }

//----------统计end

    //------------------------试卷
    @RequestMapping("/plist")
    public String paperList(HttpServletRequest request) {
        request.setAttribute("plist", answerService.getallPapers());
        return "/answer/plist";
    }

    @RequestMapping("/addpaperUI")
    public String addPaperUI(HttpServletRequest request) {
        return "/answer/papers";
    }

    @RequestMapping("/combination")
    @ResponseBody
    public String combination(HttpServletRequest request, String title, String data) {
        System.out.println(data);
        //Qtypes
        String[] splitdata = data.split(";");
        List<PapersVo> list = new ArrayList<PapersVo>();
        for (int i = 0; i < splitdata.length; i++) {
            String value = splitdata[i];
            if (!value.equals("")) {
                String numStr = value.split(":")[1].split(",")[0];
                String typeStr = value.split(":")[0];
                String scoreStr = value.split(":")[1].split(",")[1];
                PapersVo papersVo = new PapersVo();
                papersVo.setNumber(Integer.parseInt(numStr));
                papersVo.setType(Integer.parseInt(typeStr));
                papersVo.setScore(Integer.parseInt(scoreStr));
                list.add(papersVo);
            }
        }
        boolean success = answerService.combination( 1,title, list);
        if (success) {
            return "success";
        } else
            return "error";
    }

    @RequestMapping("/deletePaper")
    public String deletePaper(HttpServletRequest request, Integer id) {
        answerService.deletePaper(id);
        return "redirect:/answer/plist.do";
    }

    @RequestMapping("/download")
    public String downloadAnswer(HttpServletRequest request, Integer pId, String fileType, HttpServletResponse response) {
        Papers papers = answerService.getPapersById(pId);
        String fileName = papers.getUrl();
        if (fileName != null) {
            String realPath = request.getServletContext().getRealPath(
                    "WEB-INF/File/");
            File file = new File(realPath, fileName);
            if (file.exists()) {
                response.setContentType("application/force-download");// 设置强制下载不打开
                if (fileType.equals(FileTypes.FILE_DOC)) {
                    File docFile = new File(realPath + "." + fileType);
                    HtmlUtils.htmlToWord(file, docFile);
                    response.addHeader("Content-Disposition",
                            "attachment;fileName=" + docFile.getName());// 设置文件名
                    wirte(response, docFile);
                } else {
                    //下载html格式
                    response.addHeader("Content-Disposition",
                            "attachment;fileName=" + fileName);// 设置文件名
                    wirte(response, file);
                }
            }
        }
        return null;
    }

    /**
     * 将文件写到前台
     *
     * @param response
     * @param file
     */
    private void wirte(HttpServletResponse response, File file) {
        byte[] buffer = new byte[1024];
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        try {
            fis = new FileInputStream(file);
            bis = new BufferedInputStream(fis);
            OutputStream os = response.getOutputStream();
            int i = bis.read(buffer);
            while (i != -1) {
                os.write(buffer, 0, i);
                i = bis.read(buffer);
            }
            os.close();
            bis.close();
            fis.close();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    @RequestMapping("/charts")
    public String chartUI(HttpServletRequest request) {
        return "/answer/charts";
    }

}

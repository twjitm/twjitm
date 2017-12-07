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

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

/**
 * Created by 文江 on 2017/12/3.
 */
@RequestMapping("/answer")
@Controller
public class AnswerContorller extends BaseController {

    @Resource
    public AnswerService answerService;

    @RequestMapping("/plist")
    public String paperList(HttpServletRequest request) {
        request.setAttribute("plist", answerService.getallPapers());
        return "/answer/plist";
    }

    @RequestMapping("/addpaperUI")
    public String addPaperUI(HttpServletRequest request) {

        return "/answer/addpaper";
    }

    @RequestMapping("/elist")
    public String explainList(HttpServletRequest request) {
        List<Choices> choices = answerService.getAllChoices();
        List<Explain> explains = answerService.getAllExplain();
        request.setAttribute("choices", choices);
        request.setAttribute("explains", explains);
        return "/answer/elist";
    }

    public String deletePaper(HttpServletRequest request, Integer id) {
        answerService.deletePaper(id);
        return "redirect:/answer/plist.do";
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

    @RequestMapping("/combination")
    public String combination(HttpServletRequest request, String title, List<AnswerVo> list) {
        answerService.combination(title, list);
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

}

package com.twjitm.logs.controller;

import com.alibaba.fastjson.JSON;
import com.sun.xml.internal.ws.resources.HttpserverMessages;
import com.twjitm.logs.entity.Logs;
import com.twjitm.logs.service.LogsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 文江 on 2017/9/11.
 */
@Controller
@RequestMapping("logs")
public class LogsController {
    @Resource
    public LogsService logsService;

    @RequestMapping("init")
    @ResponseBody
    public List<Logs> init() {
        return logsService.getAllLoga();
    }

    private  String logFile = "G:\\apache-tomcat-8.5.15\\bin\\catalina.bat";

    @RequestMapping("logs")
    @ResponseBody
    public LogsView getLogs(HttpServletRequest request,Integer line) {
        List<String> list=new ArrayList<String>();
        getlogs(list,  line);
        LogsView logsView=new LogsView();
        logsView.setLine(line);
        logsView.setLineList(list);
        return logsView;
    }
    class LogsView{
        private  List<String>lineList;
        private Integer line;

        public List<String> getLineList() {
            return lineList;
        }

        public void setLineList(List<String> lineList) {
            this.lineList = lineList;
        }

        public Integer getLine() {
            return line;
        }

        public void setLine(Integer line) {
            this.line = line;
        }
    }

    private  int  getlogs(List<String> lines, int line) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(logFile))));
            String l = null;
            int startline = 0;
            while ((l = reader.readLine()) != null) {
                if (++startline >= line) {
                    line++;
                    lines.add(l);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return line;
    }

    public static void main(String[] args) {
    }
}

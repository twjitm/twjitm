package com.twjitm.logs.controller;

import com.twjitm.logs.entity.Logs;
import com.twjitm.logs.service.LogsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
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
}

package com.twjitm.logs.service.Impl;

import com.twjitm.logs.dao.ILogsDao;
import com.twjitm.logs.entity.Logs;
import com.twjitm.logs.service.LogsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 文江 on 2017/9/11.
 */
@Service
public class LogsServiceImpl implements LogsService {
    @Resource
    private ILogsDao logsDao;

    public Integer insertLogs(Logs logs) {
        return logsDao.insertLogs(logs);
    }

    public List<Logs> getAllLoga() {
        return logsDao.getAllLogs();
    }

    public void delete(Integer id) {
        logsDao.delete(id);
    }

    public void delete(List<Integer> ids) {
        for (int id : ids) {
            logsDao.delete(id);
        }
    }
}

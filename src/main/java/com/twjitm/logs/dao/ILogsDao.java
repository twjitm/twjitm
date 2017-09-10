package com.twjitm.logs.dao;

import com.twjitm.logs.entity.Logs;

import java.util.List;

/**
 * Created by 文江 on 2017/9/10.
 */
public interface ILogsDao {
    public List<Logs> getAllLogs();

    public void insertLogs(Logs logs);
}

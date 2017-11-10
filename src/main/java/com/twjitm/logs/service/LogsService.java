package com.twjitm.logs.service;

import com.twjitm.logs.entity.Logs;

import java.util.List;

/**
 * Created by 文江 on 2017/9/11.
 */
public interface LogsService {
    public Integer insertLogs(Logs logs);

    public List<Logs> getAllLoga();

    public void delete(Integer id);

    public void delete(List<Integer> ids);
}

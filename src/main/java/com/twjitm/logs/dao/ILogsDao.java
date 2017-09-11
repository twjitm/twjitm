package com.twjitm.logs.dao;

import com.twjitm.logs.entity.Logs;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 文江 on 2017/9/10.
 */
@Repository
public interface ILogsDao {
    public List<Logs> getAllLogs();

    public int insertLogs(Logs logs);

    public void delete(int id);
}

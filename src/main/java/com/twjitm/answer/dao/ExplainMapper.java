package com.twjitm.answer.dao;

import com.twjitm.answer.entity.Explain;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExplainMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Explain record);

    int insertSelective(Explain record);

    Explain selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Explain record);

    int updateByPrimaryKey(Explain record);
    List<Explain> getAllExplain();
    List<Explain> getAllExceptionBytype(int qtype);

    Explain getExceptionById(int id, int qtype);

    List<Explain> getExplainByTypeAndDegres(int qtype, int degres);
}
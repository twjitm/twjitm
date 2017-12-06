package com.twjitm.answer.dao;


import com.twjitm.answer.entity.Judges;
import org.springframework.stereotype.Repository;

@Repository
public interface JudgesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Judges record);

    int insertSelective(Judges record);

    Judges selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Judges record);

    int updateByPrimaryKey(Judges record);
}
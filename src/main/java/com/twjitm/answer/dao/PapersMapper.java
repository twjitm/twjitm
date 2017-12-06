package com.twjitm.answer.dao;



import com.twjitm.answer.entity.Papers;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PapersMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Papers record);

    int insertSelective(Papers record);

    Papers selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Papers record);

    int updateByPrimaryKey(Papers record);

    List<Papers> getAllPapers();
}
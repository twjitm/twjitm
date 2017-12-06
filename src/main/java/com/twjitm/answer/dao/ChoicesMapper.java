package com.twjitm.answer.dao;



import com.twjitm.answer.entity.Choices;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ChoicesMapper {

    List<Choices> getAllChose();


    int deleteByPrimaryKey(Integer id);

    int insert(Choices record);

    int insertSelective(Choices record);

    Choices selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Choices record);

    int updateByPrimaryKey(Choices record);
}
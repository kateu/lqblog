package com.lqblog.lbg.mapper;

import com.lqblog.lbg.model.LbgCategory;
import com.lqblog.lbg.model.LbgCategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LbgCategoryMapper {
    int countByExample(LbgCategoryExample example);

    int deleteByExample(LbgCategoryExample example);

    int deleteByPrimaryKey(String categoryId);

    int insert(LbgCategory record);

    int insertSelective(LbgCategory record);

    List<LbgCategory> selectByExample(LbgCategoryExample example);

    LbgCategory selectByPrimaryKey(String categoryId);

    int updateByExampleSelective(@Param("record") LbgCategory record, @Param("example") LbgCategoryExample example);

    int updateByExample(@Param("record") LbgCategory record, @Param("example") LbgCategoryExample example);

    int updateByPrimaryKeySelective(LbgCategory record);

    int updateByPrimaryKey(LbgCategory record);
}
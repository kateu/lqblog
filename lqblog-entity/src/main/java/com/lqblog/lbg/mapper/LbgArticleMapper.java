package com.lqblog.lbg.mapper;

import com.lqblog.lbg.model.LbgArticle;
import com.lqblog.lbg.model.LbgArticleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LbgArticleMapper {
    int countByExample(LbgArticleExample example);

    int deleteByExample(LbgArticleExample example);

    int deleteByPrimaryKey(String articleId);

    int insert(LbgArticle record);

    int insertSelective(LbgArticle record);

    List<LbgArticle> selectByExampleWithBLOBs(LbgArticleExample example);

    List<LbgArticle> selectByExample(LbgArticleExample example);

    LbgArticle selectByPrimaryKey(String articleId);

    int updateByExampleSelective(@Param("record") LbgArticle record, @Param("example") LbgArticleExample example);

    int updateByExampleWithBLOBs(@Param("record") LbgArticle record, @Param("example") LbgArticleExample example);

    int updateByExample(@Param("record") LbgArticle record, @Param("example") LbgArticleExample example);

    int updateByPrimaryKeySelective(LbgArticle record);

    int updateByPrimaryKeyWithBLOBs(LbgArticle record);

    int updateByPrimaryKey(LbgArticle record);
}
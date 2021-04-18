package com.waverly.graduateProject.dao;

import com.waverly.graduateProject.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DiscussPostMapper {
    //查询帖子的结果是一个帖子的集合
    List<DiscussPost> selectDiscussPosts(int userId,int offset,int limit);

    //Param用于取别名
    // 动态sql且只有一个参数必须取别名
    int selectDiscussPostRows(@Param("userId") int userId);

}

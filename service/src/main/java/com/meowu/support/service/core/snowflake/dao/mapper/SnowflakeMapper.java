package com.meowu.support.service.core.snowflake.dao.mapper;

import com.meowu.plugins.mybatis.criteria.Criteria;
import com.meowu.support.client.entity.Snowflake;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface SnowflakeMapper{

    void save(Snowflake snowflake);

    void update(Snowflake snowflake);

    Snowflake get(@Param("params") Criteria criteria);

    List<Snowflake> find(@Param("params") Criteria criteria);

    Long count(@Param("params") Criteria criteria);
}

package com.meowu.support.service.core.snowflake.dao;

import com.meowu.commons.utils.AssertUtils;
import com.meowu.commons.utils.IDUtils;
import com.meowu.plugins.mybatis.criteria.Criteria;
import com.meowu.plugins.mybatis.criteria.Restrictions;
import com.meowu.support.client.entity.Snowflake;
import com.meowu.support.service.core.snowflake.dao.mapper.SnowflakeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class SnowflakeDao{

    @Autowired
    private SnowflakeMapper mapper;

    public void save(Snowflake snowflake){
        AssertUtils.notNull(snowflake, "[snowflake]: entity must not be null");
        AssertUtils.hasText(snowflake.getApplicationName(), "[snowflake]: application name must not be null");
        AssertUtils.hasText(snowflake.getIp(), "[snowflake]: ip must not be null");
        AssertUtils.notNull(snowflake.getPort(), "[snowflake]: port must not be null");
        AssertUtils.notNull(snowflake.getCenterId(), "[snowflake]: center id must not be null");
        AssertUtils.notNull(snowflake.getWorkerId(), "[snowflake]: worker id must not be null");
        AssertUtils.notNull(snowflake.getTimeGen(), "[snowflake]: time gen must not be null");

        snowflake.setId(IDUtils.random());
        snowflake.setCreateTime(new Date());

        mapper.save(snowflake);
    }

    public void update(Snowflake snowflake){
        AssertUtils.notNull(snowflake, "[snowflake]: entity must not be null");
        AssertUtils.hasText(snowflake.getId(), "[snowflake]: id must not be null");

        snowflake.setUpdateTime(new Date());

        mapper.update(snowflake);
    }

    public List<Snowflake> findByApplicationName(String applicationName){
        AssertUtils.hasText(applicationName, "[snowflake]: application name must not be null");

        Criteria criteria = new Criteria();
        criteria.add(Restrictions.eq("applicationName", applicationName));

        return mapper.find(criteria);
    }
}

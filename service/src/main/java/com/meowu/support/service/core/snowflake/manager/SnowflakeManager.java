package com.meowu.support.service.core.snowflake.manager;

import com.meowu.support.client.entity.Snowflake;
import com.meowu.support.service.commons.stereotype.annotation.Manager;
import com.meowu.support.service.core.snowflake.dao.SnowflakeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

@Manager
public class SnowflakeManager{

    @Autowired
    private SnowflakeDao snowflakeDao;

    public Snowflake get(String applicationName, String ip, Integer port){
        Assert.hasText(applicationName, "application name must not be null");
        Assert.hasText(ip, "server ip must not be null");
        Assert.notNull(port, "server port most not be null");

        // get record from database
        Snowflake snowflake = snowflakeDao.getByApplicationNameAndIpAndPort(applicationName, ip, port);

        // create if no record
        if(snowflake == null){
            long total = snowflakeDao.countByApplicationName(applicationName);

            long centerId = total / 31;
            long workerId = total % 31;
        }

        return null;
    }
}

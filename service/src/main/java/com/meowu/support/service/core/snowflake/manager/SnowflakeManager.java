package com.meowu.support.service.core.snowflake.manager;

import com.meowu.support.client.entity.Snowflake;
import com.meowu.support.service.commons.stereotype.annotation.Manager;
import com.meowu.support.service.commons.stereotype.consts.SnowflakeConsts;
import com.meowu.support.service.core.snowflake.dao.SnowflakeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

@Manager
public class SnowflakeManager{

    @Autowired
    private SnowflakeDao snowflakeDao;

    public Snowflake get(String applicationName, String ip, Integer port, Long timeGen){
        Assert.hasText(applicationName, "application name must not be null");
        Assert.hasText(ip, "server ip must not be null");
        Assert.notNull(port, "server port must not be null");
        Assert.notNull(timeGen, "server time gen must not be null");

        // get record from database
        Snowflake snowflake = snowflakeDao.getByApplicationNameAndIpAndPort(applicationName, ip, port);

        // create if no record
        if(snowflake == null){
            long total    = snowflakeDao.countByApplicationName(applicationName);
            long centerId = total / SnowflakeConsts.MAX_CENTER_ID;
            long workerId = total % SnowflakeConsts.MAX_WORKER_ID;

            snowflake = new Snowflake();
            snowflake.setApplicationName(applicationName);
            snowflake.setIp(ip);
            snowflake.setPort(port);
            snowflake.setCenterId(centerId);
            snowflake.setWorkerId(workerId);
            snowflake.setTimeGen(timeGen);
            snowflakeDao.save(snowflake);

        }else{
            if(timeGen < snowflake.getTimeGen()){
                // TODO throw the time flash back exception
            }

            snowflake.setTimeGen(timeGen);
            snowflakeDao.update(snowflake);
        }

        return snowflake;
    }
}

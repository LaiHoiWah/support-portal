package com.meowu.support.service.core.snowflake.service;

import com.meowu.support.client.entity.Snowflake;
import com.meowu.support.service.core.snowflake.manager.SnowflakeManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@Service
public class SnowflakeServiceImpl implements SnowflakeService{

    @Autowired
    private SnowflakeManager snowflakeManager;

    @Transactional
    @Override
    public Snowflake get(String applicationName, String ip, Integer port, Long timeGen){

    }
}

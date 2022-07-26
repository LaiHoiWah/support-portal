package com.meowu.support.service.core.snowflake.service;

import com.meowu.support.client.entity.Snowflake;

public interface SnowflakeService{

    Snowflake get(String applicationName, String ip, Integer port, Long timeGen);
}

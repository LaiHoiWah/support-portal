package com.meowu.support.service.commons.stereotype.consts;

public interface SnowflakeConsts{

    long MAX_CENTER_ID = -1L ^ (-1L << 5L);
    long MAX_WORKER_ID = -1L ^ (-1L << 5L);
}

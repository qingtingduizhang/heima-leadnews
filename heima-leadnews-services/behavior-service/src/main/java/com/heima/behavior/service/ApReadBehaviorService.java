package com.heima.behavior.service;

import com.heima.model.behavior.dtos.ReadBehaviorDto;
import com.heima.model.common.dtos.ResponseResult;


public interface ApReadBehaviorService {
    public ResponseResult apReadBehavior(ReadBehaviorDto readBehaviorDto);
}

package com.heima.user.controller.v1;

import com.heima.common.constants.admin.AdminConstants;
import com.heima.model.common.dtos.ResponseResult;
import com.heima.model.user.dtos.AuthDto;
import com.heima.user.service.ApUserRealnameService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "app用户实名认证API",tags = "app用户实名认证API")
@RestController
@RequestMapping("/api/v1/auth")
public class ApUserRealnameController {
    @Autowired
    private ApUserRealnameService userRealnameService;

    @ApiOperation("根据状态查询实名认证列表")
    @PostMapping("/list")
    public ResponseResult loadListByStatus(@RequestBody AuthDto dto){
        return userRealnameService.loadListByStatus(dto);
    }

    @ApiOperation("根据id审核通过接口")
    @PostMapping("/authPass")
    public ResponseResult authPass(@RequestBody AuthDto dto){
        return userRealnameService.updateStatusById(dto, AdminConstants.PASS_AUTH);
    }

    @ApiOperation("根据id审核驳回接口")
    @PostMapping("/authFail")
    public ResponseResult authFail(@RequestBody AuthDto dto){
        return userRealnameService.updateStatusById(dto, AdminConstants.FAIL_AUTH);
    }
}

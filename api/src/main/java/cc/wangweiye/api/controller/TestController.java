package cc.wangweiye.api.controller;

import cc.wangweiye.service.common.JsonResult;
import cc.wangweiye.utils.date.DateUtils;
import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
    @ApiOperation(value = "测试", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", name = "Authorization", value = "token", required = true, dataType = "string"),
    })
    @GetMapping("/date")
    public JSONObject getDate() {
        return JsonResult.success(DateUtils.getDate(), null);
    }
}

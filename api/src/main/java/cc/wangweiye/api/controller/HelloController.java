package cc.wangweiye.api.controller;

import cc.wangweiye.service.common.JsonResult;
import cc.wangweiye.service.hello.entity.Hello;
import cc.wangweiye.service.hello.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
public class HelloController {
    @Autowired
    private HelloService helloService;

    @ApiOperation(value = "测试swagger2", notes = "接口具体描述，记录defaultValue的使用")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", name = "Authorization", value = "token", required = true, dataType = "string"),
            @ApiImplicitParam(name = "page", value = "第几页", dataType = "int", required = false, paramType = "query"),
            @ApiImplicitParam(name = "size", value = "每页多少个", dataType = "int", required = false, paramType = "query")
    })

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public JSONObject index(@RequestParam(required = false, defaultValue = "1") Integer page, @RequestParam(required = false, defaultValue = "10") Integer size) {
        PageInfo<Hello> pageInfo = helloService.test(page, size);
        return JsonResult.success(pageInfo.getList(), pageInfo);
    }
}
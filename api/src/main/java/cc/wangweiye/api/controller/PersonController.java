package cc.wangweiye.api.controller;


import cc.wangweiye.api.security.model.Person;
import cc.wangweiye.service.common.JsonResult;
import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PersonController {
    private static final List<Person> persons;

    static {
        persons = new ArrayList<>();
        persons.add(new Person("Hello", "World"));
        persons.add(new Person("Foo", "Bar"));
    }

    @ApiOperation(value = "获得所有用户信息", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", name = "Authorization", value = "token", required = true, dataType = "string"),
    })
    @RequestMapping(path = "/persons", method = RequestMethod.GET)
    public static JSONObject getPersons() {
        return JsonResult.success(persons, null);
    }

    @ApiOperation(value = "用户详情", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", name = "Authorization", value = "token", required = true, dataType = "string"),
            @ApiImplicitParam(name = "name", value = "用户姓名", dataType = "string", required = true, paramType = "path")
    })
    @RequestMapping(path = "/persons/{name}", method = RequestMethod.GET)
    public static JSONObject getPerson(@PathVariable("name") String name) {
        return JsonResult.success(persons.stream()
                .filter(person -> name.equalsIgnoreCase(person.getName()))
                .findAny().orElse(null), null);
    }
}

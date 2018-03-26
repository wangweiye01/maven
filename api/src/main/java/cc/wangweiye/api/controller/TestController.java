package cc.wangweiye.api.controller;

import cc.wangweiye.utils.date.DateUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
    @GetMapping("/date")
    public String getDate() {
        return DateUtils.getDate().toString();
    }
}

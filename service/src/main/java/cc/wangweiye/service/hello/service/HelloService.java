package cc.wangweiye.service.hello.service;


import cc.wangweiye.service.hello.entity.Hello;
import cc.wangweiye.service.hello.repository.HelloDao;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HelloService {
    @Autowired
    private HelloDao helloDao;

    public PageInfo<Hello> test(Integer page, Integer size) {
        PageHelper.startPage(page, size);

        List<Hello> hellos = helloDao.findList(new Hello());
        return new PageInfo<Hello>(hellos);
    }
}

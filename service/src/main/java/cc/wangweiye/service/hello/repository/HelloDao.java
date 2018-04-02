package cc.wangweiye.service.hello.repository;

import cc.wangweiye.service.common.CrudDao;
import cc.wangweiye.service.hello.entity.Hello;
import org.springframework.stereotype.Repository;

@Repository
public interface HelloDao extends CrudDao<Hello> {

}

package cc.wangweiye.service.hello.entity;

import cc.wangweiye.service.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class Hello extends BaseEntity {
    Integer id;
    String email;
}

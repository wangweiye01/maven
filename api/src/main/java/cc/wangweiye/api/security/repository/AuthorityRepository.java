package cc.wangweiye.api.security.repository;

import cc.wangweiye.api.security.model.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
}

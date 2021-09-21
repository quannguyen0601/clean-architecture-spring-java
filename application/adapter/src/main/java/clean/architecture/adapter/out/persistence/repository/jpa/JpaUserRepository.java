package clean.architecture.adapter.out.persistence.repository.jpa;

import clean.architecture.adapter.out.persistence.entity.UserTbl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaUserRepository extends JpaRepository<UserTbl, Long> {

}

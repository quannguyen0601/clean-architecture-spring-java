package clean.architecture.adapter.out.persistence.repository.jpa;

import clean.architecture.adapter.out.persistence.entity.NoteTbl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaNoteRepository extends JpaRepository<NoteTbl, Long> {

}

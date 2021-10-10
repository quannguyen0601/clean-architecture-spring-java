package clean.architecture.presenter.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages = {"clean.architecture.adapter.out.persistence.entity"})
@EnableJpaRepositories(basePackages = {"clean.architecture.adapter.out.persistence.repository.jpa"})
public class JpaConfiguration {

}

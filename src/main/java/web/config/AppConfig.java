package web.config;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import web.dao.UserDao;
import web.dao.UserDaoIml;

@Configuration
@EnableTransactionManagement
public class AppConfig {

  @PersistenceContext
  private EntityManager em;

  @Bean
  public UserDao userDao() {
    return new UserDaoIml(em);
  }

  @Bean
  public PlatformTransactionManager transactionManager() {
    JpaTransactionManager transactionManager = new JpaTransactionManager();
    transactionManager.setEntityManagerFactory(em.getEntityManagerFactory());
    return transactionManager;
  }
}

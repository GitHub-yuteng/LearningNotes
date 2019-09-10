package JPA.SpringDataJpa.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * TODO Application Code -> JPA -> Hibernate -> JDBC -> DataBase
 */
public class JpaUtils {

    private static EntityManagerFactory entityManagerFactory;

    static {
        //TODO 加载配置文件创建工厂(实体管理器工厂)对象
        entityManagerFactory = Persistence.createEntityManagerFactory("MyJpa");
    }

    //TODO 通过实体管理器工厂获取实体管理器
    public static EntityManager getEntityManager() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager;
    }
}

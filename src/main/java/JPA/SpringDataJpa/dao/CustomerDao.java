package JPA.SpringDataJpa.dao;

import JPA.SpringDataJpa.pojo.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

/**
 * TODO Dao层接口规范
 * 1.需要继承两个接口(JpaRepository, JpaSpecificationExecutor )
 * 2.需要提供响应的泛型
 * JpaRepository<操作的实体类类型，实体类中主键属性的类型>
 * JpaSpecificationExecutor<操作的实体类类型>
 * <p>
 * => 通过 JDK 动态代理，JDKDynamicAopProxy 创建动态代理对象
 * => 动态代理对象 SimpleJpaRepository extends JpaRepository<Customer, Long>, JpaSpecificationExecutor<Customer>
 * => 内部实现了各个方法。通过 EntityManager 完成操作。
 * TODO SpringData Jpa -> Jpa规范 -> Hibernate -> JDBC -> DataBase
 */
public interface CustomerDao extends JpaRepository<Customer, Long>, JpaSpecificationExecutor<Customer> {

    /**
     * 案例:根据客户名称查询客户 使用jpql的形式查询
     *      jpql: FROM Customer WHERE custName = ?
     *      配置jpql语句，使用的@Query注解
     *          value 代表 JPQL|SQL
     *          nativeValue：false(默认：使用JPQL查询)|true(使用SQL查询)
     *
     *   多个参数，要保证参数与占位符顺序一致
     *   或者 在 JPQL 占位符?后标注位置   ?2  -> 表示匹配第二个参数
     *
     * @Modifying：代表把 Query 变为 Update （需要加事务，但是SpringData Jpa默认回滚事务。Rollback=false）
     *
     * 也可以按照方法名命名规则查询
     * TODO eg：FindBy + 对象属性名(首字母大写) + 查询条件(默认=|Like|IsNull) + 多条件(AND|OR)
     */
    @Query(value = "FROM Customer WHERE custName = ?")
    public Customer findJpq1(String custName);

}

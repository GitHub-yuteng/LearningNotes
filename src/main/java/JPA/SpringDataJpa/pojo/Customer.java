package JPA.SpringDataJpa.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

/**
 * @Entity；声明实体类；
 * @Table：配置实体类和表的映射关系； name:配置数据表的名称
 */
@Entity
@Table(name = "cst_customer")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Customer {

    /**
     * @Id:声明主键的配置；
     * @GeneratedValue:配置主键的生成策略
     *      GenerationType.IDENTITY：自增；（底层数据库要支持自增）mysql
     *      GenerationType.SEQUENCE：序列：（底层数据库要支持序列）Oracle
     *      GenerationType.TABLE：JPA提供的一种机制，通过一张数据库表的形式帮助我们完成主键自增
     *              hibernate.hbm2ddl.auto : create  此时数据库会多一张表，记录下一次主键的值
     *      GenerationType.AUTO：程序自动的帮助我们选择主键生成策略
     *
     * @Column：配置属性和字段的映射关系
     *      name:数据库表中字段的名称；
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cust_id")
    private Long custId;//客户编号(主键)
    @Column(name = "cust_name")
    private String custName;//客户名称(公司名称)
    @Column(name = "cust_source")
    private String custSource;//客户信息来源
    @Column(name = "cust_industry")
    private String custIndustry;//客户所属行业
    @Column(name = "cust_level")
    private String custLevel;//客户级别
    @Column(name = "cust_address")
    private String custAddress;//客户联系地址
    @Column(name = "cust_phone")
    private String custPhone;//客户联系电话
}

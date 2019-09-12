package JPA.SpringDataJpa.pojo;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @Entity；声明实体类；
 * @Table：配置实体类和表的映射关系； name:配置数据表的名称
 */
@Entity
@Table(name = "cst_customer")
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

    //TODO 配置一对多关系  客户与联系人的关系
    /**
     * 使用注解的形式配置多表关系
     * 1、声明关系：@OneToMany(targetEntity = LinkMan.class) 需要关联对方的实体类字节码
     * 2、配置外键（中间表）
     *      @JoinColumn(name = "lkm_cust_id",referencedColumnName = "cust_id")
     *      name：外键名 在主表实体类加注解，外键体现在从表一列
     *      referencedColumnName：参照主表主键字段名称
     *
     * 在客户实体类上（一的一方）添加了外键的配置，所以对于客户而言，也具备了维护外键的作用
     */
//    @OneToMany(targetEntity = LinkMan.class)
//    @JoinColumn(name = "lkm_cust_id",referencedColumnName = "cust_id")
    /**
     * 放弃外键维护权
     * mappedBy：对方配置关系的属性名称。
     * cascade：配置级联（可以配置到设置多表的映射关系的主街上）
     *  CascadeType.ALL ：所有
     *  CascadeType.MERGE ：更新
     *  CascadeType.REMOVE ：删除
     *  CascadeType.PERSIST ：保存
     *
     */
    @OneToMany(mappedBy = "customer",cascade = CascadeType.PERSIST)
    private Set<LinkMan> linkMans = new HashSet<>();

    public Customer() {
    }

    public Customer(String custName, String custSource, String custIndustry, String custLevel, String custAddress, String custPhone, Set<LinkMan> linkMans) {
        this.custName = custName;
        this.custSource = custSource;
        this.custIndustry = custIndustry;
        this.custLevel = custLevel;
        this.custAddress = custAddress;
        this.custPhone = custPhone;
        this.linkMans = linkMans;
    }

    public Long getCustId() {
        return custId;
    }

    public void setCustId(Long custId) {
        this.custId = custId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustSource() {
        return custSource;
    }

    public void setCustSource(String custSource) {
        this.custSource = custSource;
    }

    public String getCustIndustry() {
        return custIndustry;
    }

    public void setCustIndustry(String custIndustry) {
        this.custIndustry = custIndustry;
    }

    public String getCustLevel() {
        return custLevel;
    }

    public void setCustLevel(String custLevel) {
        this.custLevel = custLevel;
    }

    public String getCustAddress() {
        return custAddress;
    }

    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress;
    }

    public String getCustPhone() {
        return custPhone;
    }

    public void setCustPhone(String custPhone) {
        this.custPhone = custPhone;
    }

    public Set<LinkMan> getLinkMans() {
        return linkMans;
    }

    public void setLinkMans(Set<LinkMan> linkMans) {
        this.linkMans = linkMans;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "custId=" + custId +
                ", custName='" + custName + '\'' +
                ", custSource='" + custSource + '\'' +
                ", custIndustry='" + custIndustry + '\'' +
                ", custLevel='" + custLevel + '\'' +
                ", custAddress='" + custAddress + '\'' +
                ", custPhone='" + custPhone + '\'' +
                ", linkMans=" + linkMans +
                '}';
    }
}

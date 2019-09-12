package JPA.SpringDataJpa.pojo;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Yu
 */
@Entity
@Table(name = "sys_role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Long roleId;
    @Column(name = "role_name")
    private String roleName;

//    @ManyToMany(targetEntity = User.class)
//    @JoinTable(name = "sys_user_role",
//            //TODO joinColumns，当前对象在中间表中的外键
//            joinColumns = {@JoinColumn(name = "sys_role_id",referencedColumnName = "role_id")},
//            //TODO inverseJoinColumns，对方对象在中间表中的外键
//            inverseJoinColumns = {@JoinColumn(name = "sys_user_id",referencedColumnName = "user_id")}
//    )
    /**
     * 放弃维护权
     */
    @ManyToMany(mappedBy = "roles")
    private Set<User> users = new HashSet<>();

    public Role() {
    }

    public Role(String roleName) {
        this.roleName = roleName;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}

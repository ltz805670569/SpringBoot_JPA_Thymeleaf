package cn.itxdl.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_role")
public class Role implements Serializable {

    private static final long serialVersionUID = 7366143948802265338L;
    @Id
    @Column(name = "roleid")
    private int roleid;
    @Column(name = "rolename")
    private String rolename;
    @Column(name = "roleinfo")
    private String roleinfo;

    public Role() {
    }

    public Role(String rolename, String roleinfo) {
        this.rolename = rolename;
        this.roleinfo = roleinfo;
    }

    public Role(int roleid, String rolename, String roleinfo) {
        this.roleid = roleid;
        this.rolename = rolename;
        this.roleinfo = roleinfo;
    }

    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public String getRoleinfo() {
        return roleinfo;
    }

    public void setRoleinfo(String roleinfo) {
        this.roleinfo = roleinfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return roleid == role.roleid &&
                Objects.equals(rolename, role.rolename) &&
                Objects.equals(roleinfo, role.roleinfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleid, rolename, roleinfo);
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleid=" + roleid +
                ", rolename='" + rolename + '\'' +
                ", roleinfo='" + roleinfo + '\'' +
                '}';
    }
}

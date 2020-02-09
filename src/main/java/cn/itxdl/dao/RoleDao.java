package cn.itxdl.dao;

import cn.itxdl.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RoleDao extends JpaRepository<Role,Integer> {

    @Modifying
    @Query(nativeQuery = true,value = "update tb_role set rolename=:rolename,roleinfo=:roleinfo where roleid = :roleid")
    int updateUser(@Param("rolename") String rolename, @Param("roleinfo") String roleinfo, @Param("roleid") int roleid);

    @Modifying
    @Query(nativeQuery = true,value = "delete from tb_role where roleid = :roleid")
    int deleteUser(@Param("roleid") int roleid);

    @Query(nativeQuery = true,value = "select * from tb_role where roleid=:roleid")
    Role findRoleByRoleid(@Param("roleid") int roleid);
}

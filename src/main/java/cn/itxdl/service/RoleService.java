package cn.itxdl.service;

import cn.itxdl.entity.Role;
import org.springframework.data.domain.Page;

import java.util.List;

public interface RoleService {

    List<Role> findAllRole();

    Page<Role> findRoleByPage(int pageNum, int pageSize);

    Role findRoleById(int Roleid);

    boolean updateRole(int roleid,String rolename,String roleinfo);

    boolean addRole(String rolename,String roleinfo);

    boolean deteteRole(int roleid);


}

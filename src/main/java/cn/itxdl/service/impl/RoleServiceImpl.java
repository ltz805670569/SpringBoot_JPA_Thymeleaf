package cn.itxdl.service.impl;

import cn.itxdl.dao.RoleDao;
import cn.itxdl.entity.Role;
import cn.itxdl.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("roleService")
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public List<Role> findAllRole() {
        return roleDao.findAll();
    }

    public Page<Role> findRoleByPage(int pageNum, int pageSize){
        Sort sort = new Sort(Sort.Direction.DESC,"roleid");
        Pageable pageable = PageRequest.of(pageNum,pageSize,sort);
        return roleDao.findAll(pageable);
    }

    @Override
    public Role findRoleById(int roleid) {
        return roleDao.findRoleByRoleid(roleid);
    }

    @Override
    @Transactional
    public boolean updateRole(int roleid, String rolename, String roleinfo) {
        int i = roleDao.updateUser(rolename, roleinfo, roleid);
        return i > 0;
    }

    @Override
    @Transactional
    public boolean addRole(String rolename, String roleinfo) {
        Role role = new Role(rolename,roleinfo);
        Role role1 = roleDao.save(role);
        return true;
    }

    @Override
    @Transactional
    public boolean deteteRole(int roleid) {
        int i = roleDao.deleteUser(roleid);
        return i > 0;
    }
}

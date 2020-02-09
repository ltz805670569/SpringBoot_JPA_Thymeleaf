package cn.itxdl.controller;

import cn.itxdl.entity.Role;
import cn.itxdl.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "/role/list")
    public ModelAndView roleList(@RequestParam(name = "pageNum",required = false,defaultValue = "0") int pageNum, @RequestParam(name = "pageSize",required = false,defaultValue = "3") int pageSize){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("role_list");
        Page<Role> rolePage = roleService.findRoleByPage(pageNum, pageSize);
        int totalPages = rolePage.getTotalPages();
        int currentPage = rolePage.getNumber();
        List<Role> roles = rolePage.getContent();
        mav.getModel().put("roles",roles);
        mav.getModel().put("totalPages",totalPages);
        mav.getModel().put("currentPage",currentPage);
        return mav;
    }

    @RequestMapping(value = "/role/selRole")
    public ModelAndView selRole(int roleid){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("role_selone");
        Role role = roleService.findRoleById(roleid);
        mav.getModel().put("role",role);
        return mav;
    }

    @RequestMapping(value = "/role/updateTransfer")
    public ModelAndView updateTransfer(int roleid){
        ModelAndView mav = new ModelAndView();
        Role role = roleService.findRoleById(roleid);
        mav.setViewName("role_update");
        mav.getModel().put("role",role);
        return mav;
    }

    @RequestMapping(value = "/role/updateUser",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,String> updateUser(int roleid,String rolename,String roleinfo){
        Map<String,String> map = new HashMap<>();
        boolean b = roleService.updateRole(roleid, rolename, roleinfo);
        if(b){
            map.put("msg","success");
        }else {
            map.put("msg","fail");
        }
        return map;
    }

    @RequestMapping(value = "/role/deleteRole")
    @ResponseBody
    public Map<String,String> deleteUser(int roleid){
        Map<String,String> map = new HashMap<>();
        boolean b = roleService.deteteRole(roleid);
        if(b){
            map.put("msg","success");
        }else {
            map.put("msg","fail");
        }
        return map;
    }

    @RequestMapping(value = "/role/toAdd")
    public ModelAndView toAdd(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("role_add");
        return mav;
    }

    @RequestMapping(value = "/role/addUser",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,String> addUser(String rolename,String roleinfo){
        Map<String,String> map = new HashMap<>();
        boolean b = roleService.addRole(rolename, roleinfo);
        if(b){
            map.put("msg","success");
        }else {
            map.put("msg","fail");
        }
        return map;
    }
}

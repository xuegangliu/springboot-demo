package com.lxg.jpa.web;

import com.lxg.jpa.domain.primary.UserPrimary;
import com.lxg.jpa.dao.primary.UserPrimaryRepository;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 刘雪岗 on 2017/1/4.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserPrimaryRepository userRepository;

    /**
     * 列表查询
     * @param map
     * @return
     */
    @ApiOperation(value = "用户列表查询",notes = "显示所有用户")
    @RequestMapping(value = "/list.action",method = RequestMethod.GET)
    public String list(ModelMap map){
        map.addAttribute("des","用户列表显示");
        map.addAttribute("users",userRepository.findAll());
        return "user/list";
    }

//    @ApiIgnore
//    // 跳转添加页面
//    @RequestMapping(value = "/goAdd.action")
//    public String goAdd(){
//        return "user/add";
//    }

    @ApiOperation(value = "添加用户",notes = "单个用户添加")
    @ApiImplicitParam(name = "user",value = "用户实体类",required = true,dataType = "UserPrimary")
    @RequestMapping(value = "/add.action",method = RequestMethod.POST)
    @ResponseBody
    public void add(@RequestBody UserPrimary user){
        userRepository.save(user);
    }

    /**
     * del
     * @param id
     * @param response
     */
    @ApiOperation(value = "删除用户",notes = "根据id删除用户")
    @ApiImplicitParam(name = "id",value = "用户主键",required = true,dataType = "Integer")
    @RequestMapping(value = "/del.action/{id}",method = RequestMethod.GET)
    public void del(@PathVariable Integer id, HttpServletResponse response){
        userRepository.delete(userRepository.findById(id).get());
        try {
            response.sendRedirect("/user/list.action");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    // 修改
//    @ApiOperation(value = "更新用户",notes = "单个用户修改")
//    @ApiImplicitParam(name = "user",value = "用户实体类",required = true,dataType = "UserPrimary")
//    @RequestMapping(value = "/update.action",method = RequestMethod.POST)
//    public void update(UserPrimary user,HttpServletResponse response){
//        userRepository.updateUser(user.getName(),user.getAge(),user.getId());
//        try {
//            response.sendRedirect("/user/list.action");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}

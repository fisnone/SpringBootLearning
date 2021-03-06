package com.example.swaggerdoc.controller;

import com.example.swaggerdoc.model.User;
import io.swagger.annotations.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(tags = "UserApi", description = "用户基本信息操作API", consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    @GetMapping("/getAllUser")
    @ApiOperation(value = "获取所有用户", notes = "", httpMethod = "GET", tags = "查询接口")
    public List<User> getAll() {
        return new ArrayList<>();
    }

    @GetMapping("/getUserById")
    @ApiOperation(value = "根据id获取用户", notes = "id必传", httpMethod = "GET", tags = "查询接口")
    @ApiImplicitParam(name = "id", value = "用户id",example = "1", required = true, dataType = "long", paramType = "query")
    public User getOne(Long id) {
        return new User();
    }

    @PostMapping("/getUserByNameAndSex")
    @ApiOperation(value = "根据name和sex获取用户", notes = "", httpMethod = "POST", tags = "查询接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName", value = "用户名", example = "关羽", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "userSex", value = "用户性别", example = "男", required = true, dataType = "string", paramType = "query") })
    public User getUserByNameAndSex(String userName, String userSex) {
        return new User();
    }

    @PostMapping("/insertUser")
    @ApiOperation(value = "新增用户", notes = "传json，数据放body", httpMethod = "POST", tags = "新增接口")
    @ApiImplicitParam(name = "body", value = "用户对象json", example = "{userName:'倾尽天下',userSex:'男'}", required = true, dataType = "string")
    public String insertUser(@RequestBody String body) {
        return "{code:0,msg:'success'}";
    }

    @PostMapping("/updateUser")
    @ApiOperation(value = "修改用户", notes = "传json，数据放body", httpMethod = "POST", tags = "修改接口")
    @ApiImplicitParam(name = "body", value = "用户对象json", example = "{id:23,userName:'倾尽天下',userSex:'女'}", required = true)
    public String updateUser(@RequestBody String body) {
        return "{code:0,msg:'success'}";
    }

    @PostMapping("/deleteUser")
    @ApiOperation(value = "删除用户", notes = "id必传", httpMethod = "POST", tags = "删除接口")
    public String deleteUser(@ApiParam(name = "id", value = "用户id", required = true) Long id) {
        return "{code:0,msg:'success'}";
    }
}

package com.lhyzp.api.sys.controller;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.lhyzp.annotation.OpLog;
import com.lhyzp.base.BaseController;
import com.lhyzp.biz.system.model.SysUser;
import com.lhyzp.biz.system.service.SysUserService;
import com.lhyzp.excel.*;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.beans.IntrospectionException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 系统用户控制器
 */
@RestController
@RequestMapping("api/user")
public class SysUserController extends BaseController{

    @Autowired
    private SysUserService sysUserService;


    @RequestMapping("/export")
    public void export(HttpServletResponse response) throws IOException, IllegalAccessException, IntrospectionException, InvocationTargetException {
        //创建标题
        String[] titles={"ID","姓名","邮箱","手机","身份证号","创建日期","启用"};
        String[] keys={"id","userName","email","phone","idCard","createDate","active"};

        TableParam tableParam=new TableParam();
        List<ColumnParam> columnParams= Lists.newArrayList(
                new ColumnParam("ID","id",5),
                new ColumnParam("姓名","userName",15),
                new ColumnParam("邮箱","email",15),
                new ColumnParam("手机","phone",15),
                new ColumnParam("身份证号","idCard",25),
                new ColumnParam("创建日期","createDate",25,"yyyy-MM-dd HH:mm:ss"),
                new ColumnParam("启用","active",new ConvertValueBoolean())
        );
        tableParam.setColumnParams(columnParams);




        String excelName="excel名称.xls";

        List<SysUser> list = sysUserService.list(null);
        HSSFWorkbook workbook = ExcelUtil.exportExcel(tableParam,list);


        response.setHeader("content-Type", "application/vnd.ms-excel;charset=UTF-8");
        excelName=new String(excelName.getBytes("gbk"),"iso8859-1");
        response.setHeader("Content-Disposition", "attachment;filename="+excelName);
        workbook.write(response.getOutputStream());

    }
    @GetMapping("import")
    public void importExcel() throws IOException, InstantiationException, IllegalAccessException, IntrospectionException, InvocationTargetException, ParseException {
        String[] keys={"id","userName","email","phone","idCard","createDate","active"};

        TableParam tableParam=new TableParam();
        List<ColumnParam> columnParams= Lists.newArrayList(
                new ColumnParam("ID","id",5),
                new ColumnParam("姓名","userName",15),
                new ColumnParam("邮箱","email",15),
                new ColumnParam("手机","phone",15),
                new ColumnParam("身份证号","idCard",25),
                new ColumnParam("创建日期","createDate",25,"yyyy-MM-dd"),
                new ColumnParam("启用","active",new ConvertValueBoolean())
        );
        tableParam.setColumnParams(columnParams);

        List<SysUser> list = (List<SysUser>) ExcelUtil.importExcel("C:\\Users\\Administrator\\Downloads\\excel名称 (20).xls", tableParam,SysUser.class);

        list.forEach(user-> System.out.println(user.toString()));


    }

    @GetMapping
    public String list(@RequestParam(value="page",required = false,defaultValue = "0")Integer page,
                       @RequestParam(value="size",required = false,defaultValue = "10")Integer size,
                       @RequestParam(value="sort",required = false,defaultValue = "id")String sort,
                       @RequestParam(value="order",required = false,defaultValue = "id")String order,
                       @RequestParam(value="userName",required = false)String userName,
                       @RequestParam(value="email",required = false)String email,
                       @RequestParam(value="phone",required = false)String phone,
                       @RequestParam(value="q",required = false)String q,
                       @RequestParam(value="dept",required = false)String dept){

        Map<String,Object> map= Maps.newHashMap();
        map.put("userName",q);
        map.put("email",email);
        map.put("phone",phone);
        map.put("dept",dept);
        List<SysUser> list = sysUserService.list(map);
        return json(list);
    }

    @OpLog("新增用户")
    @PostMapping
    public String save(@RequestBody SysUser model){
        sysUserService.save(model);
        return success();
    }

    @PutMapping
    public String update(SysUser model){
        sysUserService.save(model);
        return success();
    }

    @GetMapping("{id}")
    public String get(@PathVariable("id")Integer id){
        SysUser record = sysUserService.getObject(id);
        return json(record);
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable("id")Integer id){
        return success();
    }

}

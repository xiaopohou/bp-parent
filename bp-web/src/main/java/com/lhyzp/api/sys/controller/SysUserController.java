package com.lhyzp.api.sys.controller;

import com.google.common.collect.Maps;
import com.lhyzp.annotation.OpLog;
import com.lhyzp.base.BaseController;
import com.lhyzp.biz.system.model.SysUser;
import com.lhyzp.biz.system.service.SysUserService;
import com.lhyzp.excel.ExcelUtil;
import org.apache.poi.hpsf.DocumentSummaryInformation;
import org.apache.poi.hpsf.SummaryInformation;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletResponse;
import java.beans.IntrospectionException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.Date;
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

        String excelName="excel名称.xls";

        List<SysUser> list = sysUserService.list(null);
        HSSFWorkbook workbook = ExcelUtil.exportExcel(titles,keys,SysUser.class,list);


        response.setHeader("content-Type", "application/vnd.ms-excel;charset=UTF-8");
        excelName=new String(excelName.getBytes("gbk"),"iso8859-1");
        response.setHeader("Content-Disposition", "attachment;filename="+excelName);
        workbook.write(response.getOutputStream());

    }
    @GetMapping("import")
    public void importExcel() throws IOException, InstantiationException, IllegalAccessException, IntrospectionException, InvocationTargetException, ParseException {
        String[] keys={"id","userName","email","phone","idCard","createDate","active"};
        List<Object> sheet0 = ExcelUtil.importExcel("C:\\Users\\zhoupeng\\Downloads\\excel名称 (16).xls", "Sheet0", keys, SysUser.class);


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

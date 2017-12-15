package com.lhyzp.api.sys.controller;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.lhyzp.annotation.OpLog;
import com.lhyzp.base.BaseController;
import com.lhyzp.biz.system.model.SysUser;
import com.lhyzp.biz.system.service.SysUserService;
import com.lhyzp.poi.ExcelUtil;
import com.lhyzp.poi.entity.ColumnParam;
import com.lhyzp.poi.entity.ExcelType;
import com.lhyzp.poi.entity.TableParam;
import com.lhyzp.poi.func.impl.ConvertValueBoolean;
import com.lhyzp.utils.QRCodeUtil;
import net.coobird.thumbnailator.Thumbnails;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.beans.IntrospectionException;
import java.io.IOException;
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
    public void export(HttpServletResponse response) throws IOException, IllegalAccessException, IntrospectionException, InvocationTargetException, WriterException {
//        TableParam tableParam=new TableParam(ExcelType.XLS);
//        List<ColumnParam> columnParams= Lists.newArrayList(
//                new ColumnParam("ID","id",5),
//                new ColumnParam("姓名","userName",15),
//                new ColumnParam("邮箱","email",15),
//                new ColumnParam("手机","phone",15),
//                new ColumnParam("身份证号","idCard",25),
//                new ColumnParam("创建日期","createDate",25,"yyyy-MM-dd HH:mm:ss"),
//                new ColumnParam("启用","active",new ConvertValueBoolean())
//        );
//        tableParam.setColumnParams(columnParams);
//
//
//
//
//        String excelName="excel名称.xls";
//
//        List<SysUser> list = sysUserService.list(null);
//        Workbook workbook = ExcelUtil.exportExcel(tableParam,list);
//
//
//        response.setHeader("content-Type", "application/vnd.ms-excel;charset=UTF-8");
//        excelName=new String(excelName.getBytes("gbk"),"iso8859-1");
//        response.setHeader("Content-Disposition", "attachment;filename="+excelName);
//        workbook.write(response.getOutputStream());

        //Thumbnails.of("E:\\15.jpg")
        //        .size(200, 200)
        //        .outputFormat("png")
        //        .toOutputStream(response.getOutputStream());

        JSONObject json = new JSONObject();
        json.put(
                "zxing",
                "https://github.com/zxing/zxing/tree/zxing-3.0.0/javase/src/main/java/com/google/zxing");
        json.put("author", "shihy");
        String content = json.toJSONString();// 内容
        QRCodeUtil.encodeQRCode(response.getOutputStream(),content,300,300);

        //QRCodeUtil.encodeBarCode(response.getOutputStream(),"1234567890",60,40);
        //QRCodeWriter qrCodeWriter = new QRCodeWriter();
        //BitMatrix bitMatrix = qrCodeWriter.encode(content, BarcodeFormat.QR_CODE, 300, 300);
        //MatrixToImageWriter.writeToStream(bitMatrix,"png",response.getOutputStream());

    }
    @RequestMapping("/export2")
    public void export2(HttpServletResponse response) throws IOException, IllegalAccessException, IntrospectionException, InvocationTargetException {
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

        List<SysUser> list = sysUserService.list(null);

        List<Map<String,Object>> mapList=Lists.newArrayList();
        Map<String,Object> map=Maps.newHashMap();
        map.put("id",100);
        map.put("userName","赵丽颖");
        map.put("email","zhaoliyin@lhyzp.com");
        map.put("phone","15196785021");
        map.put("createDate",new Date());
        map.put("active",true);
        mapList.add(map);
        Workbook workbook = ExcelUtil.exportExcelMap(tableParam,mapList);

        String excelName="excel名称.xlsx";
        response.setHeader("content-Type", "application/vnd.ms-excel;charset=UTF-8");
        excelName=new String(excelName.getBytes("gbk"),"iso8859-1");
        response.setHeader("Content-Disposition", "attachment;filename="+excelName);
        workbook.write(response.getOutputStream());

    }
    @GetMapping("import")
    public void importExcel() throws IOException, InstantiationException, IllegalAccessException, IntrospectionException, InvocationTargetException, ParseException, InvalidFormatException {
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

        List<SysUser> list = (List<SysUser>) ExcelUtil.importExcel("C:\\Users\\Administrator\\Downloads\\excel名称.xls", tableParam,SysUser.class);

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

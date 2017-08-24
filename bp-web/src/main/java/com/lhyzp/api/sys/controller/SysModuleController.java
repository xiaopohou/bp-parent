package com.lhyzp.api.sys.controller;

import com.google.common.collect.Maps;
import com.lhyzp.sys.model.Product;
import freemarker.core.ParseException;
import freemarker.template.*;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hpsf.DocumentSummaryInformation;
import org.apache.poi.hpsf.SummaryInformation;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.context.IContext;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * 模块
 * Created by Administrator on 2017-7-27.
 */
@RestController
@RequestMapping("api/module")
public class SysModuleController {

    @GetMapping
    public String list(){
        return "[]";
    }

    @GetMapping("excel")
    public void excelDemo() throws IOException {
        //String filePath="C:\\Users\\Administrator\\Desktop\\sample.xls";//文件路径


        /*创建Workbook和Sheet*/
        HSSFWorkbook workbook = new HSSFWorkbook();//创建Excel文件(Workbook)
        HSSFSheet sheet = workbook.createSheet("Test");//创建工作表(Sheet)



        /*创建文档摘要信息*/
        workbook.createInformationProperties();//创建文档信息
        DocumentSummaryInformation dsi= workbook.getDocumentSummaryInformation();//摘要信息
        dsi.setCategory("类别:Excel文件");//类别
        dsi.setManager("周鹏");//管理者
        dsi.setCompany("公司:--");//公司
        SummaryInformation si = workbook.getSummaryInformation();//摘要信息
        si.setSubject("主题:--");//主题
        si.setTitle("标题:测试文档");//标题
        si.setAuthor("周鹏");//作者
        si.setComments("POI测试文档");//备注


        /*创建单元格*/
        HSSFRow row = sheet.createRow(0);// 创建行,从0开始
        HSSFCell cell = row.createCell(0);// 创建行的单元格,也是从0开始
        cell.setCellValue("李志伟");// 设置单元格内容
        row.createCell(1).setCellValue(false);// 设置单元格内容,重载
        row.createCell(2).setCellValue(new Date());// 设置单元格内容,重载
        row.createCell(3).setCellValue(12.345);// 设置单元格内容,重载

        //设置为居中加粗
        //HSSFCellStyle style = workbook.createCellStyle();
        //HSSFFont font = workbook.createFont();
        //font.setBold(true);
        //style.setFont(font);
        //style.setAlignment(HorizontalAlignment.CENTER);
        //
        //cell = row.createCell(0);
        //cell.setCellValue("序号");
        //cell.setCellStyle(style);
        //
        //cell = row.createCell(1);
        //cell.setCellValue("金额");
        //cell.setCellStyle(style);
        //
        //cell = row.createCell(2);
        //cell.setCellValue("描述");
        //cell.setCellStyle(style);
        //
        //cell = row.createCell(3);
        //cell.setCellValue("日期");
        //cell.setCellStyle(style);

        //FileOutputStream out = new FileOutputStream(filePath);
        //workbook.write(out);//保存Excel文件
        //out.close();//关闭文件流
        //System.out.println("OK!");


        String excelName="excel名称.xls";


        HttpServletResponse response=((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
        response.setHeader("content-Type", "application/vnd.ms-excel;charset=UTF-8");
        excelName=new String(excelName.getBytes("gbk"),"iso8859-1");
        response.setHeader("Content-Disposition", "attachment;filename="+excelName);
        workbook.write(response.getOutputStream());
    }

    /**
     * 模板文件生成
     * @return
     */
    @GetMapping("template")
    public String template(Model model) throws IOException, TemplateException {

        model.addAttribute("name","jack");
        /* ------------------------------------------------------------------------ */
        /* You should do this ONLY ONCE in the whole application life-cycle:        */
        /* Create and adjust the configuration singleton */
        Configuration cfg = new Configuration();
        cfg.setDirectoryForTemplateLoading(new File("E:\\bp-parent\\bp-web\\src\\main\\resources\\templates")); //需要文件夹绝对路径
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        /* ------------------------------------------------------------------------ */
        /* You usually do these for MULTIPLE TIMES in the application life-cycle:   */
        /* Create a data-model */
        Map root = new HashMap();
        root.put("user", "Big Joe");
        Product latest = new Product();
        latest.setUrl("products/greenmouse.html");
        latest.setName("green mouse");
        root.put("latestProduct", latest);
        /* Get the template (uses cache internally) */
        Template temp = cfg.getTemplate("welcom.ftl");
        /* Merge data-model with template */
        Writer out = new OutputStreamWriter(System.out);

        String content = FreeMarkerTemplateUtils.processTemplateIntoString(temp, root);

        FileUtils.writeStringToFile(new File("d:/welcome.html"), content);

        temp.process(root, out);
        return "操作成功";
    }

    @GetMapping("th")
    public String th(HttpServletRequest request) throws IOException {


        System.out.println(request.getServletContext().getContextPath());

        //构造模板引擎
        ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();
        resolver.setPrefix("templates/");//模板所在目录，相对于当前classloader的classpath。
        resolver.setSuffix(".html");//模板文件后缀
        TemplateEngine templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(resolver);

        //构造上下文(Model)

        Context context = new Context();
        context.setVariable("name", "蔬菜列表");
        context.setVariable("array", new String[]{"土豆", "番茄", "白菜", "芹菜"});

        //渲染模板
        FileWriter write = new FileWriter("result.html");

        //templateEngine.process("temp", context, write);
        return "temp";
    }

}

package com.lhyzp.web.api.sys.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.collect.Maps;
import com.lhyzp.sys.model.SysModule;
import com.lhyzp.sys.model.SysUser;
import com.lhyzp.sys.service.SysModuleService;
import com.lhyzp.web.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.List;
import java.util.Map;

/**
 * 模块
 * Created by Administrator on 2017-7-27.
 */
@RestController
@RequestMapping("api/module")
public class SysModuleController extends BaseController{

    @Autowired
    private SysModuleService sysModuleService;

    @PostMapping
    public String addOrUpdate(SysModule module){

        return "";
    }

    @GetMapping
    public String list(@RequestParam(value = "pageNum",defaultValue = "0")Integer pageNum,
                       @RequestParam(value = "pageSize",defaultValue = "10")Integer pageSize){
        Map<String,Object> map= Maps.newHashMap();
        Page<Object> page = PageHelper.startPage(pageNum, pageSize);
        List<SysModule> list = sysModuleService.list(map);
        return json(list,page);
    }

    @GetMapping("{id}")
    public String getObject(@PathVariable("id")Integer id){
        SysModule module = sysModuleService.getObject(id);
        return json(module);
    }

    @DeleteMapping("{id}")
    public String delete(@PathVariable("id")Integer id){
        sysModuleService.delete(id);
        return success();
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

        templateEngine.process("temp/temp", context, write);

        write.close();
        return "temp/temp";
    }



    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * redis   使用
     * @return
     */
    @GetMapping("redis")
    public String redis(@RequestParam(value="c",required = false,defaultValue = "0")Short c){

        SysUser user=new SysUser();
        user.setId(1);

        //操作视图类
        ValueOperations<String,SysUser> valueOperations = redisTemplate.opsForValue();

        //判断缓存是否存在
        Boolean isKey = redisTemplate.hasKey("user_0");

        if(c==1&&isKey){
            //清除缓存
            redisTemplate.delete("user_0");
            return "缓存被清除";
        }

        if(!isKey){
            valueOperations.set("user_0",user);
            return "缓存没有";
        }else{
            SysUser userCache=valueOperations.get("user_0");
            return "缓存读取的："+userCache.toString();
        }
    }

}

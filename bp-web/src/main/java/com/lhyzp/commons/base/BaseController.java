package com.lhyzp.commons.base;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.lhyzp.base.ResponseMessage;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 基础controller
 * Created by Administrator on 2017-9-7.
 */
public abstract class BaseController {

    //public SysUser user(){
    //    return ShiroUtils.getUserEntity();
    //}
    //public Long userId(){
    //    return ShiroUtils.getUserId();
    //}

    /**
     * 获取请求对象
     * @return
     */
    public HttpServletRequest getRequest() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return request;
    }

    /**
     * json转换
     * @param object
     * @return
     */
    public String json(Object object){
        return JSON.toJSONString(object, SerializerFeature.DisableCircularReferenceDetect);
    }

    /**
     * 消息返回
     * @param code
     * @param message
     * @return
     */
    public String msg(Integer code,String message){
        ResponseMessage rm=new ResponseMessage(code,message);
        return json(rm);
    }
    /**
     * 消息返回
     * @param code
     * @param message
     * @return
     */
    public String msg(Integer code,String message,Object data){
        ResponseMessage rm=new ResponseMessage(code,message,data);
        return json(rm);
    }

    /**
     * 成功消息返回
     * @return
     */
    public String success(){
        return msg(200,"操作成功");
    }
    /**
     * 成功消息返回
     * @return
     */
    public String success(String message){
        return msg(200,message);
    }
    /**
     * 失败消息返回
     * @return
     */
    public String error(){
        return msg(400,"操作失败");
    }
    /**
     * 失败消息返回
     * @return
     */
    public String error(String message){
        return msg(400,message);
    }

}

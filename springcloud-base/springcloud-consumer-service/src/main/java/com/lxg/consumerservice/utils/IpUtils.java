package com.lxg.consumerservice.utils;

import com.lxg.consumerservice.constant.HttpConstant;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;

/**
 * IpUtils
 * <p>
 * This is description
 *
 * @author xuegangliu 2019/06/20
 * @since 1.8
 **/
public class IpUtils {

    public static String getIpByHttpServletRequest(HttpServletRequest request){
        String ip = request.getHeader(HttpConstant.HEADER_X_FORWARDED_FOR);
        if(ip == null || ip.length() == 0 || HttpConstant.IP_UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader(HttpConstant.HEADER_PROXY_CLIENT_IP);
        }
        if(ip == null || ip.length() == 0 || HttpConstant.IP_UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader(HttpConstant.HEADER_WL_PROXY_CLIENT_IP);
        }
        if(ip == null || ip.length() == 0 || HttpConstant.IP_UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
            if(HttpConstant.LOCAL_IP.equals(ip)){
                //根据网卡取本机配置的IP
                InetAddress inet=null;
                try {
                    inet = InetAddress.getLocalHost();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                ip= inet.getHostAddress();
            }
        }
        // 多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
        if(ip != null && ip.length() > HttpConstant.IP_LENGTH){
            if(ip.indexOf(HttpConstant.IP_SEPARATOR)>0){
                ip = ip.substring(0,ip.indexOf(","));
            }
        }
        return ip;
    }
}

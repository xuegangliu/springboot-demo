package com.lxg.wechat.util;

import lombok.extern.log4j.Log4j;
import net.sf.json.JSONObject;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * CommonUtils
 * <p>
 * This is description
 *
 * @author xuegangliu 2019/06/19
 * @since 1.8
 **/
@Log4j
public class CommonUtils {

    /**
     * 读取request中请求数据，转化成 json 对象
     * @param request 请求request
     * @return 返回请求数据
     */
    public static JSONObject requestToJson(HttpServletRequest request) {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        InputStream is = null;
        String result = null;
        try {
            is = request.getInputStream();
            byte[] buffer = new byte[1024];
            int length = -1;

            if ((length = is.read(buffer)) != -1) {
                os.write(buffer, 0, length);
            }
            result = new String(os.toByteArray(), "UTF-8");
            is.close();
            os.close();
        } catch (Exception e) {
            log.error("流解析出错", e);
        }
        return JSONObject.fromObject(result);
    }

    public static String sendPost(String url, String params) throws Exception {
        URLConnection conn = null;
        OutputStream os = null;
        BufferedReader in = null;
        //存储请求返回的参数
        StringBuffer result = new StringBuffer();

        try {
            URL requestUrl = new URL(url);
            //打开和URL之间的连接
            conn = requestUrl.openConnection();
            //设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "close");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 设置连接主机超时
            conn.setConnectTimeout(30000);
            // 设置从主机读取数据超时
            conn.setReadTimeout(30000);
            //发送post请求必须设置
            conn.setDoOutput(true);
            conn.setDoInput(true);
            //获取 URLConnection 对象的输出流
            os = conn.getOutputStream();
            os.write(params.getBytes("UTF-8"));
            in = new BufferedReader(new InputStreamReader(conn.getInputStream())); //获取 URLConnection 对象的输入流
            String line;
            while((line = in.readLine()) != null) {
                result.append(line);
            }

        } catch (Exception e) {
            log.info("post请求发生失败……");
            log.error(e.getMessage(), e);
            throw e;
        } finally {
            if (os != null) {
                os.close();
            }
            if (in != null) {
                in.close();
            }
        }
        log.info("post请求返回参数---" + result.toString());
        return result.toString();
    }
}

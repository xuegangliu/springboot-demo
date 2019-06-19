package com.lxg.wechat.servlet;

import com.lxg.wechat.util.CommonUtils;
import lombok.extern.log4j.Log4j;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.sword.wechat4j.token.server.AccessTokenMemServer;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * TempMsgServlet
 * <p>
 * This is description
 *
 * @author xuegangliu 2019/06/19
 * @since 1.8
 **/
@Log4j
@WebServlet(urlPatterns = "/tempMsg")
public class TempMsgServlet extends HttpServlet {

    @Value("${test_temp_send_openid}")
    private String testTempSendOpenid;
    @Value("${test_temp_id}")
    private String testTempId;
    @Value("${test_temp_url}")
    private String testTmepurl;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //编码设置
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        String result = "";
        // TODO 未完成
        JSONObject msgJsonObj = new JSONObject();
        msgJsonObj.put("touser", testTempSendOpenid);
        msgJsonObj.put("template_id", testTempId);

        // Hello,{{name.DATA}} 时间:{{date.DATA}} 交易金额:{{total.DATA}} This is test
        JSONObject v1 = new JSONObject();
        v1.put("value","Tony \n");
        v1.put("color","#000000");
        JSONObject v2 = new JSONObject();
        v2.put("value",new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒").format(new Date())+"\n");
        v2.put("color","#000000");
        JSONObject v3 = new JSONObject();
        v3.put("value","123456.12\n");
        v3.put("color","#000000");

        JSONObject data = new JSONObject();
        data.put("name",v1);
        data.put("date",v2);
        data.put("total",v3);
        msgJsonObj.put("data",data);
        String accessToken = AccessTokenMemServer.instance().token();
        String url=testTmepurl+accessToken;
        try {
            result = CommonUtils.sendPost(url, msgJsonObj.toString());
            log.info(JSONObject.fromObject(result));
        } catch (Exception e) {
            e.printStackTrace();
        }

        PrintWriter pw = resp.getWriter();
        pw.write("ok");
        pw.close();
    }
}

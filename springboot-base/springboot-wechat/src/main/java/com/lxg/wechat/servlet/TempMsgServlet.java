package com.lxg.wechat.servlet;

import com.lxg.wechat.constant.MessageConstant;
import com.lxg.wechat.util.CommonUtils;
import lombok.extern.log4j.Log4j;
import net.sf.json.JSONObject;
import org.sword.wechat4j.token.server.AccessTokenMemServer;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

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
        msgJsonObj.put("touser", MessageConstant.TEST_TEMP_SEND_OPENID);
        msgJsonObj.put("template_id", MessageConstant.TEST_TMEP_ID);
        msgJsonObj.put("data", MessageConstant.TEST_TMEP_ID);

        // Hello,{{name.DATA}} 时间:{{date.DATA}} 交易金额:{{total.DATA}} This is test
        JSONObject v1 = new JSONObject();
        v1.put("value","Tony");
        v1.put("color","#ffeeaa");
        JSONObject v2 = new JSONObject();
        v2.put("value","2019-06-19");
        v2.put("color","#ffeeaa");
        JSONObject v3 = new JSONObject();
        v2.put("value","123456.12");
        v2.put("color","#ffeeaa");

        JSONObject data = new JSONObject();
        data.put("name",v1);
        data.put("date",v2);
        data.put("total",v3);
        msgJsonObj.put("data",data);
        String accessToken = AccessTokenMemServer.instance().token();
        String url=MessageConstant.TEST_TEMP_URL+accessToken;
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

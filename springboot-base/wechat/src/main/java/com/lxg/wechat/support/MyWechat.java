package com.lxg.wechat.support;

import com.lxg.wechat.constant.MessageConstant;
import org.sword.wechat4j.WechatSupport;

import javax.servlet.http.HttpServletRequest;

/**
 * MyWechat
 * <p>
 * This is description
 *
 * @author xuegangliu 2019/06/18
 * @since 1.8
 **/
public class MyWechat extends WechatSupport {

    public MyWechat(HttpServletRequest request) {
        super(request);
    }

    @Override
    protected void onText() {
        String context = super.wechatRequest.getContent();
        if(MessageConstant.OK.equals(context)){
            responseText("This is onText return!!");
        }
        responseText("1234");
    }

    @Override
    protected void onImage() {

    }

    @Override
    protected void onVoice() {

    }

    @Override
    protected void onVideo() {

    }

    @Override
    protected void onShortVideo() {

    }

    @Override
    protected void onLocation() {

    }

    @Override
    protected void onLink() {

    }

    @Override
    protected void onUnknown() {

    }

    @Override
    protected void click() {

    }

    @Override
    protected void subscribe() {

    }

    @Override
    protected void unSubscribe() {

    }

    @Override
    protected void scan() {

    }

    @Override
    protected void location() {

    }

    @Override
    protected void view() {

    }

    @Override
    protected void templateMsgCallback() {

    }

    @Override
    protected void scanCodePush() {

    }

    @Override
    protected void scanCodeWaitMsg() {

    }

    @Override
    protected void picSysPhoto() {

    }

    @Override
    protected void picPhotoOrAlbum() {

    }

    @Override
    protected void picWeixin() {

    }

    @Override
    protected void locationSelect() {

    }

    @Override
    protected void kfCreateSession() {

    }

    @Override
    protected void kfCloseSession() {

    }

    @Override
    protected void kfSwitchSession() {

    }
}

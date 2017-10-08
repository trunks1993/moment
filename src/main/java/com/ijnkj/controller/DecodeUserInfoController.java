package com.ijnkj.controller;

import com.ijnkj.dao.domain.User;
import com.ijnkj.rservice.BaseRedisService;
import com.ijnkj.rservice.RUserService;
import com.ijnkj.service.UserService;
import com.ijnkj.util.*;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/userInfo")
public class DecodeUserInfoController {

    @Autowired
    private RUserService rUserService;


    @PostMapping("/decodeUserInfo")
    public Map decodeUserInfo(@RequestBody LoginObj lbj){

        String code = lbj.getCode();
        String encryptedData = lbj.getEncryptedData();
        String iv = lbj.getIv();

        Map map = new HashMap();

        //登录凭证不能为空
        if (code == null || code.length() == 0) {
            map.put("status", 0);
            map.put("msg", "code 不能为空");
            return map;
        }

        //小程序唯一标识   (在微信小程序管理后台获取)
        String wxspAppid = "wxea694820b43a5975";
        //小程序的 app secret (在微信小程序管理后台获取)
        String wxspSecret = "2bb141e702740064322ac0ff3a6aedcb";
        //授权（必填）
        String grant_type = "authorization_code";


        //////////////// 1、向微信服务器 使用登录凭证 code 获取 session_key 和 openId ////////////////
        //请求参数
        String params = "appid=" + wxspAppid + "&secret=" + wxspSecret + "&js_code=" + code + "&grant_type=" + grant_type;
        //发送请求
        String sr = HttpRequest.sendGet("https://api.weixin.qq.com/sns/jscode2session", params);
        //解析相应内容（转换成json对象）
        JSONObject json = JSONObject.fromObject(sr);

        //获取会话密钥（session_key）
        String session_key = json.get("session_key").toString();
        //用户的唯一标识（openId）
        String openId = (String) json.get("openid");


        map.put("status", 1);
        map.put("msg", "解密成功");
//        map.put("_3dr_session",_3dr_session);

            String userId = rUserService.hGet("openId",openId);
            //////////////// 2、对encryptedData加密数据进行AES解密 ////////////////
            try {

                String result = AesCbcUtil.decrypt(encryptedData, session_key, iv, "UTF-8");


                if (null != result && result.length() > 0) {

                    User userInfo = new User();

                    JSONObject userInfoJSON = JSONObject.fromObject(result);

                    userInfo.setOpenId((String) userInfoJSON.get("openId"));
                    userInfo.setNickName((String) userInfoJSON.get("nickName"));
                    userInfo.setGender(userInfoJSON.get("gender").toString());
                    userInfo.setCity((String) userInfoJSON.get("city"));
                    userInfo.setProvince((String) userInfoJSON.get("province"));
                    userInfo.setCountry((String) userInfoJSON.get("country"));
                    userInfo.setAvatarUrl((String) userInfoJSON.get("avatarUrl"));
                    userInfo.setUnionId((String) userInfoJSON.get("unionId"));

                    if (StringUtils.isBlank(userId)){

                        rUserService.put(userInfo.getOpenId(),userInfo,1);

                        map.put("user_id",userInfo.getId());

                    }else {
                        userInfo.setId(userId);
                        rUserService.put(userInfo.getOpenId(),userInfo,-1);

                        map.put("user_id",userId);
                    }


                    return map;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }




        map.put("status", 0);
        map.put("msg", "解密失败");
        return map;
    }
}

package com.xzr.controller;

import com.xzr.entity.Adm;
import com.xzr.service.AdmService;
import com.xzr.util.ValidateImageCodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;

/**
 * Created by F on 2017/10/25.
 */
@Controller
@RequestMapping("/adm")
public class AdmController {

    @Autowired
    private AdmService admService;

    /**
     * 生成验证码图片
     */
    @RequestMapping("/code")
    public void generateImageCode(HttpSession session, HttpServletResponse response) throws Exception{
        String s = ValidateImageCodeUtils.getSecurityCode(4, ValidateImageCodeUtils.SecurityCodeLevel.Hard, true);
        session.setAttribute("code",s);
        BufferedImage image = ValidateImageCodeUtils.createImage(s);
        response.setContentType("image/png");
        ImageIO.write(image,"png",response.getOutputStream());
    }

    /**
     * 用户登录
     */
    @RequestMapping("/login")
    public String login(String username, String password, String code, HttpSession session){
        String code1 = (String)session.getAttribute("code");
        Adm adm = admService.queryOne(username);
        if(adm.getUsername()!="" && adm.getUsername()!=null){
            if(adm.getPassword().equals(password)){
                if(code1.equalsIgnoreCase(code)){
                    session.setAttribute("adm",adm);
                    return "chimingfazhou";
                }
            }
        }
        return "login";
    }

    /**
     * 安全退出
     */
    @RequestMapping("/outs")
    public String outs(HttpSession session){
        session.setAttribute("adm",null);
        return "redirect:/login.jsp";
    }

    /**
     * 修改密码
     */
    @RequestMapping("/update")
    @ResponseBody
    public String update(Adm adm){
        admService.update(adm);
        return "y";
    }
}

package com.xzr.aop;

import java.util.Date;
import com.xzr.annotation.LogAnnotation;
import com.xzr.entity.Adm;
import com.xzr.entity.Log;
import com.xzr.service.LogService;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by F on 2017/10/30.
 */
@Component
public class MyAop implements MethodInterceptor {
    @Autowired
    private LogService logService;

    public Object invoke(MethodInvocation mi) throws Throwable {

        Log log = new Log();
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        Adm adm =(Adm) session.getAttribute("adm");
        log.setUsername(adm.getUsername());
        Date date = new Date();
        log.setDate(date);
        LogAnnotation annotation = mi.getMethod().getAnnotation(LogAnnotation.class);
        log.setDoSomething(annotation.description());
        Object result=null;
        try {
            result = mi.proceed();
            //记录操作成功
            log.setStatus("成功");
            logService.save(log);
        } catch (Exception e) {
            //记录操作失败
            log.setStatus("失败"+e.getMessage().toString());
            logService.save(log);
        }
        return result;
    }
}


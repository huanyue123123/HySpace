package com.gm.wj.filter;

import com.alibaba.fastjson.JSON;
import com.gm.wj.common.ResponseCode;
import com.gm.wj.result.Result;
import com.gm.wj.result.ResultFactory;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import springfox.documentation.service.ResponseMessage;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class ShiroCustomFilter extends FormAuthenticationFilter {

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {

        HttpServletResponse resp = (HttpServletResponse) response;
        resp.setContentType("application/json; charset=utf-8");
        PrintWriter out = resp.getWriter();
        Result res = ResultFactory.buildResult(ResponseCode.NO_LOGIN,"未登录",null);

        out.write(JSON.toJSONString(res)); // 返回自己的json
        out.flush();
        out.close();
        return false;
    }
}

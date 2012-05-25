package com.lchl.app.java.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * <pre>
 * File Descriptions.
 * User: chaohua.luo
 * Date: 12-5-23 下午5:04
 * Note:
 * </pre>
 */
public class LoginInterceptor implements Interceptor {
    private static Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
    private String user;
    private String loginResult;
    
    public void setUser(String user) {
        this.user = user;
    }
    
    public void setLoginResult(String loginResult) {
        this.loginResult = loginResult;
    }
    
    @Override
    public void destroy() {
    }

    @Override
    public void init() {
    }

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        Map<String, Object> session = invocation.getInvocationContext().getSession();
        if (session != null && session.containsKey(user)) {
            logger.info("User {} has login", session.get(user));
            return invocation.invoke();
        }

        logger.warn("Not login, please login first");

        return loginResult;
    }
}

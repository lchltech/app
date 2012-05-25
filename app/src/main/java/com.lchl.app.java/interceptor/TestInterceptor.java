package com.lchl.app.java.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by IntelliJ IDEA.
 * User: chaohua.luo
 * Date: 12-5-2
 * Time: 下午5:54
 * To change this template use File | Settings | File Templates.
 */
public class TestInterceptor implements Interceptor {
    private static Logger logger = LoggerFactory.getLogger(TestInterceptor.class);
    
    @Override
    public void destroy() {
    }

    @Override
    public void init() {
    }

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        logger.info("Intercept the action: {}", invocation.getAction().getClass().getName());
        return invocation.invoke();
    }
}

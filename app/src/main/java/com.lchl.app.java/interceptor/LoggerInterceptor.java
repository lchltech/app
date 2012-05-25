package com.lchl.app.java.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.Result;
import com.opensymphony.xwork2.interceptor.Interceptor;
import org.apache.struts2.dispatcher.ServletDispatcherResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <pre>
 * File Descriptions.
 * User: chaohua.luo
 * Date: 12-5-23 下午3:13
 * Note:
 * </pre>
 */
public class LoggerInterceptor implements Interceptor {
    private static Logger logger = LoggerFactory.getLogger(LoggerInterceptor.class);
    private String type;
    @Override
    public void destroy() {
        logger.info("The logger interceptor destroy");
    }

    @Override
    public void init() {
        logger.info("The logger interceptor init, log type: {}", type);
    }

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        logger.info("Start to intercept the action: {}, method: {}",
                invocation.getAction().getClass().getName(),
                invocation.getProxy().getMethod());

        String destination = invocation.invoke();

        Result result = invocation.getResult();
        if (result != null && result instanceof ServletDispatcherResult) {
            ServletDispatcherResult sdr = (ServletDispatcherResult) result;
            logger.info("The result page: {}", sdr.getLastFinalLocation());
        }

        return destination;
    }
    
    public void setType(String type) {
        this.type = type;
    }
}

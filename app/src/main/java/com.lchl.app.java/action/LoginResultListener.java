package com.lchl.app.java.action;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.PreResultListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <pre>
 * File Descriptions.
 * User: chaohua.luo
 * Date: 12-5-23 下午6:05
 * Note:
 * </pre>
 */
public class LoginResultListener implements PreResultListener {
    private Logger logger = LoggerFactory.getLogger(LoginResultListener.class);

    @Override
    public void beforeResult(ActionInvocation invocation, String resultCode) {
        invocation.getInvocationContext().getValueStack().setValue("user", "another");
        logger.info("The user's value has been changed");
    }
}

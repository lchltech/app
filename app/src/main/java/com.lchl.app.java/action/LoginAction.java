package com.lchl.app.java.action;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: chaohua.luo
 * Date: 12-5-2
 * Time: 下午6:06
 */
public class LoginAction implements Action, SessionAware {
    private static Logger logger = LoggerFactory.getLogger(LoginAction.class);
    private Map<String, Object> session = null;
    private String user;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
    
    @Override
    public String execute() throws Exception {
        session.put("user", "session");
        setUser("setUser");
        logger.info("The user login success.");

        LoginResultListener listener = new LoginResultListener();
        ActionContext.getContext().getActionInvocation().addPreResultListener(listener);

        return Action.SUCCESS;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}

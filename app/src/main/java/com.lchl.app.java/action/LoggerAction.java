package com.lchl.app.java.action;

import com.opensymphony.xwork2.Action;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <pre>
 * File Descriptions.
 * User: chaohua.luo
 * Date: 12-5-23 下午3:50
 * Note:
 * </pre>
 */
public class LoggerAction {
    private Logger logger = LoggerFactory.getLogger(LoggerAction.class);
    public String execute() throws Exception {
        logger.info("The action business {}.execute() executed", this.getClass().getName());
        return Action.SUCCESS;
    }
}

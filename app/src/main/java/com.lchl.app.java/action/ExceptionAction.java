package com.lchl.app.java.action;

import com.opensymphony.xwork2.Action;

/**
 * <pre>
 * Brief descriptions for the file.
 * User: chaohua.luo
 * Date: 12-5-9
 * Time: 下午4:05
 * </pre>
 */
public class ExceptionAction implements Action {
    @Override
    public String execute() throws Exception {
        try {
            int ret = 5 / 0;
        }
        catch (ArithmeticException e) {
            e.printStackTrace();
            return "exception";
        }
        catch (Exception e) {
            e.printStackTrace();
            return "exception";
        }

        return Action.SUCCESS;
    }
}

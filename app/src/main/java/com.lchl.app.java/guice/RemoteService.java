package com.lchl.app.java.guice;

/**
 * <pre>
 * Brief descriptions for the file.
 * User: chaohua.luo
 * Date: 12-5-15
 * Time: 上午11:58
 * </pre>
 */
public class RemoteService implements IService {
    @Override
    public void execute() {
        System.out.println("Remote Service Inject Success.");
    }
}

package com.lchl.app.java.guice;

/**
 * <pre>
 * Brief descriptions for the file.
 * User: chaohua.luo
 * Date: 12-5-15
 * Time: 上午11:57
 * </pre>
 */
public class LocalService implements IService {
    @Override
    public void execute() {
        System.out.println("Local Service Inject Success.");
    }
}

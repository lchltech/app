package com.lchl.app.java.guice;

/**
 * <pre>
 * Brief descriptions for the file.
 * User: chaohua.luo
 * Date: 12-5-15
 * Time: 上午11:00
 * </pre>
 */
public class ServiceImpl implements IService {
    @Override
    public void execute() {
        System.out.println("Service Inject Success.");
    }
}

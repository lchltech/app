package com.lchl.app.java.guice;

import com.google.inject.ImplementedBy;

/**
 * <pre>
 * Brief descriptions for the file.
 * User: chaohua.luo
 * Date: 12-5-15
 * Time: 上午11:00
 * </pre>
 */
@ImplementedBy(ServiceImpl.class)
public interface IService {
    public void execute();
}

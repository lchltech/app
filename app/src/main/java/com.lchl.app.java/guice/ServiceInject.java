package com.lchl.app.java.guice;

import com.google.inject.Inject;
import com.google.inject.name.Named;

/**
 * <pre>
 * Brief descriptions for the file.
 * User: chaohua.luo
 * Date: 12-5-15
 * Time: 上午11:34
 * </pre>
 */
public class ServiceInject {
    @Inject
    private IService service;
    @Inject
//    @Local
    @Named("Local")
    private IService localService;
    @Inject
//    @Remote
    @Named("Remote")
    private IService remoteService;

    public IService getService() {
        return service;
    }

    @Inject
    public void setService(IService service) {
        this.service = service;
    }

    public IService getLocalService() {
        return localService;
    }

    public IService getRemoteService() {
        return remoteService;
    }

//    @Inject
//    public ServiceInject(IService service) {
//        this.service = service;
//    }
}

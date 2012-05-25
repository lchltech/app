package com.lchl.app.java.guice;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.name.Names;

/**
 * <pre>
 * Brief descriptions for the file.
 * User: chaohua.luo
 * Date: 12-5-15
 * Time: 下午12:12
 * </pre>
 */
public class ServiceModule implements Module {
    @Override
    public void configure(Binder binder) {
//        binder.bind(IService.class).annotatedWith(Local.class).to(LocalService.class);
//        binder.bind(IService.class).annotatedWith(Remote.class).to(RemoteService.class);
        binder.bind(IService.class).annotatedWith(Names.named("Local")).to(LocalService.class);
        binder.bind(IService.class).annotatedWith(Names.named("Remote")).to(RemoteService.class);
    }
}

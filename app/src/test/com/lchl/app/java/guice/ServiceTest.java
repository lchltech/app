package com.lchl.app.java.guice;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.Before;
import org.junit.Test;

/**
 * <pre>
 * Brief descriptions for the file.
 * User: chaohua.luo
 * Date: 12-5-15
 * Time: 上午11:07
 * </pre>
 */
public class ServiceTest {
    private Injector injector;

    @Before
    public void setUp() throws Exception {
        injector = Guice.createInjector();
    }

    @Test
    public void testExecute() throws Exception {
        IService service = injector.getInstance(IService.class);
        service.execute();
        print(service);
    }

    @Test
    public void testServiceInject() throws Exception {
        ServiceInject serviceInject = injector.getInstance(ServiceInject.class);
        serviceInject.getService().execute();
        print(serviceInject);
    }

    @Test
    public void testLocalService() throws Exception {
        injector = Guice.createInjector(new ServiceModule());
        ServiceInject serviceInject = injector.getInstance(ServiceInject.class);
        serviceInject.getLocalService().execute();
        serviceInject.getRemoteService().execute();
    }
    
    public void print(Object instance) {
        System.out.println(instance.getClass().getSimpleName());
    }
}

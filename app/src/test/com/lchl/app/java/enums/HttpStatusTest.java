package com.lchl.app.java.enums;

import org.junit.Test;

/**
 * <pre>
 * Brief descriptions for the file.
 * User: chaohua.luo
 * Date: 12-5-14
 * Time: 下午4:57
 * </pre>
 */
public class HttpStatusTest {
    @Test
    public void testHSCEnums() throws Exception {
        HttpStatus[] statuses = HttpStatus.values();
        for (HttpStatus status: statuses) {
            System.out.println(status.name() + ", " + status.code());
        }
    }
}

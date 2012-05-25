package com.lchl.app.java.io;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: chaohua.luo
 * Date: 12-4-13
 * Time: 下午6:03
 * To change this template use File | Settings | File Templates.
 */
public class CssFormatter {
    public static void main(String[] args) throws IOException {
        String cssFile = "D:/list2.txt";
        File file = new File(cssFile);
        String content = FileUtils.readFileToString(file).replaceAll("}", "}\n");
        FileUtils.writeStringToFile(file, content);
    }
}

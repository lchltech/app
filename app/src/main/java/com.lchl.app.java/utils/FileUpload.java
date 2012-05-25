package com.lchl.app.java.utils;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.xwork.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.math.BigDecimal;
import java.util.concurrent.Callable;

/**
 * <pre>
 * File Descriptions.
 * User: chaohua.luo
 * Date: 12-5-24 下午3:25
 * Note:
 * </pre>
 */
public class FileUpload implements Callable {
    public static final String TEXT_EOL = "\n";
    public static final String HTML_EOL = "<br>";

    private static Logger logger = LoggerFactory.getLogger(FileUpload.class);
    private static final int FILE_MAX_SIZE = 1024 * 1024 * 10; // 上传文件最大为10M
    
    private String name;
    private File file;
    private String contentType;
    private String dir;
    private String message;

    public FileUpload() {

    }

    public FileUpload(File file, String name, String contentType) {
        this.file = file;
        this.name = name;
        this.contentType = contentType;
    }
    
    public FileUpload(File file, String name, String contentType, String dir) {
        this(file, name, contentType);
        this.dir = dir;
    }
    
    public void upload(String dir) throws Exception {
        setDir(dir);
        upload();
    }

    public void upload() throws Exception {
        if (StringUtils.isEmpty(getDir()) || file == null) {
            setMessage("The upload file's destination dir is empty or the file object is null.");
            logger.warn(getMessage());
            throw new IllegalArgumentException(getMessage());
        } else if (StringUtils.isEmpty(name) || file.length() > FILE_MAX_SIZE) {
            setMessage("Invalid upload file, file: " + (file.getAbsolutePath()) +
                    ", name: " + name + ", length: " + file.length() + " bytes");
            logger.warn(getMessage());
            throw new RuntimeException(getMessage());
        }


        long startTime = System.currentTimeMillis();
        String path = dir + (dir.endsWith("\\") || dir.endsWith("/") ? getName() : "/" + getName());
        FileUtils.copyFile(file, new File(path));
        logger.info("The file has been upload to server @ {}", path);
        long endTime = System.currentTimeMillis();

        double time = Math.abs(endTime - startTime) * 1.0 / 1000;
        setMessage(time);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setMessage(double time) {
        long size = getFile().length();
        StringBuilder message = new StringBuilder();
        message.append("文件上传成功, 上传" + size / 1024 + "字节/约");
        message.append(new BigDecimal(size * 1.0 / (1024 * 1024)).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue() + "M，");
        message.append("共用时 " + time + " 秒.").append(HTML_EOL);
        message.append("文件名：" + getName()).append(HTML_EOL);
        message.append("文件类型：" + getContentType());
        setMessage(message.toString());
    }

    @Override
    public Object call() throws Exception {
        logger.info("Start to upload file {}", getName());
        upload();
        logger.info("Upload file {} to server @ dir {}", getName(), getDir());
        return getMessage();
    }
}

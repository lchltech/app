package com.lchl.app.java.action;

import com.lchl.app.java.utils.FileUpload;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

/**
* Created by IntelliJ IDEA.
* User: chaohua.luo
* Date: 12-4-23
* Time: 上午10:31
*/
public class FileUploadAction extends ActionSupport  {
    private static final Logger logger = LoggerFactory.getLogger(FileUploadAction.class);
    private static final long MAX_UPLOAD_SIZE = 1024 * 1024 * 10; // 上传文件最大为10M
    private File fileUpload;
    private String fileUploadContentType;
    private String fileUploadFileName;
    private String message;

    public String execute() throws Exception{
        FileUpload file = new FileUpload(getFileUpload(), getFileUploadFileName(), getFileUploadContentType());
        
        try {
            file.upload("D:/temp");    
        } catch (Exception e) {
            logger.error("{}", file.getMessage(), e);
            return Action.INPUT;
        }

        setMessage(file.getMessage());
        setFileUploadFileName("文件名：" + file.getName());
        setFileUploadContentType("文件类型：" + file.getContentType());

//        if (this.getUploadFileSuffix().endsWith(".suffix")) {
//            logger.warn("The selected file format({}) isn't supportted.", this.getFileUploadFileName());
//            tips = "请重新选择xlsx格式的文件进行上传";
//            fileUploadFileName = "文件名：" + fileUploadFileName;
//            fileUploadContentType = "文件类型：" + fileUploadContentType;
//            return Action.INPUT;
//        }
//        long size = fileUpload.length();
//        if (size > MAX_UPLOAD_SIZE) {
//            logger.warn("The upload file size is {} bytes, over the limited max size {} bytes.", size, MAX_UPLOAD_SIZE);
//            tips = "请重新上传，你选择的文件大小为" + size + "字节/约";
//            tips += new BigDecimal(size * 1.0 / (1024 * 1024)).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue() + "M，";
//            tips += "已超过系统限制的大小" + MAX_UPLOAD_SIZE + "字节/10M";
//            fileUploadFileName = "文件名：" + fileUploadFileName;
//            fileUploadContentType = "文件类型：" + fileUploadContentType;
//
//            return Action.INPUT;
//        }
//
//        String path = "D:/temp/" + getFileUploadFileName();
//        File serverFile = new File(path);
//        long startTime = System.currentTimeMillis();
//        FileUtils.copyFile(fileUpload, serverFile);
//        logger.info("The file has been upload to the file: {}", path);
//        long endTime = System.currentTimeMillis();
//        double time = Math.abs(endTime - startTime) * 1.0 / 1000;
//        tips = "你的文件已上传成功, 上传" + size / 1024 + "字节/约";
//        tips += new BigDecimal(size * 1.0 / (1024 * 1024)).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue() + "M，";
//        tips += "共用时 " + time + " 秒.";
//        fileUploadFileName = "文件名：" + fileUploadFileName;
//        fileUploadContentType = "文件类型：" + fileUploadContentType;

        return Action.SUCCESS;
    }

    public File getFileUpload() {
        return fileUpload;
    }

    public void setFileUpload(File fileUpload) {
        this.fileUpload = fileUpload;
    }

    public String getFileUploadContentType() {
        return fileUploadContentType;
    }

    public void setFileUploadContentType(String fileUploadContentType) {
        this.fileUploadContentType = fileUploadContentType;
    }

    public String getFileUploadFileName() {
        return fileUploadFileName;
    }

    public void setFileUploadFileName(String fileUploadFileName) {
        this.fileUploadFileName = fileUploadFileName;
    }

    public String getUploadFileSuffix() {
        String uploadFileSuffix = this.getFileUploadFileName().substring(this.fileUploadFileName.lastIndexOf("."));
        return uploadFileSuffix;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

package com.lchl.app.java.action;

import com.lchl.app.java.utils.FileUpload;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

/**
 * <pre>
 * File Descriptions.
 * User: chaohua.luo
 * Date: 12-5-24 下午2:38
 * Note:
 * </pre>
 */
public class MultipleFileUploadAction extends ActionSupport {
    private static Logger logger = LoggerFactory.getLogger(MultipleFileUploadAction.class);
    private File[] multipleUpload;
    private String[] multipleUploadFileName;
    private String[] multipleUploadContentType;
    private String messages;

    public String execute() throws Exception {
        int index = 0;
        String dir = "D:/temp";
        StringBuilder builder = new StringBuilder();
//        ExecutorService executor = new ScheduledThreadPoolExecutor(20);
        for (File file: multipleUpload) {
            String result = null;
            FileUpload fileUpload = new FileUpload(file, multipleUploadFileName[index], multipleUploadContentType[index ++], dir);
            try {
                fileUpload.upload();
//                executor.submit(fileUpload);
            } catch (Exception e) {
                logger.error("{}", fileUpload.getMessage(), e);
                return Action.INPUT;
            } finally {
                builder.append(fileUpload.getMessage()).append("<br><br>");
                setMessages(builder.toString());
            }
        }

        return Action.SUCCESS;
    }

    public File[] getMultipleUpload() {
        return multipleUpload;
    }

    public void setMultipleUpload(File[] multipleUpload) {
        this.multipleUpload = multipleUpload;
    }

    public String[] getMultipleUploadFileName() {
        return multipleUploadFileName;
    }

    public void setMultipleUploadFileName(String[] multipleUploadFileName) {
        this.multipleUploadFileName = multipleUploadFileName;
    }

    public String[] getMultipleUploadContentType() {
        return multipleUploadContentType;
    }

    public void setMultipleUploadContentType(String[] multipleUploadContentType) {
        this.multipleUploadContentType = multipleUploadContentType;
    }

    public String getMessages() {
        return messages;
    }

    public void setMessages(String messages) {
        this.messages = messages;
    }
}

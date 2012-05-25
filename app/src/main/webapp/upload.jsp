<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<style>
    .button {
        padding: 0.2em 0.5em 0.2em;
        background-color: #7aa824;
        background: -webkit-gradient(linear, left bottom, left top, color-stop(0, #77a423), color-stop(0.6, #93c436), color-stop(0.97, #aad15d), color-stop(0.99, #d4ed99));
        background: -moz-linear-gradient(bottom, #77a423, #93c436 60%, #aad15d 96%, #d4ed99 98%);
        border-radius: 1px;
        -moz-border-radius: 1px;
        -webkit-border-radius: 1px;
        border: 1px solid #81a340;
        border-bottom: 1px solid #708444;
        color: white;
        font: 13px '微软雅黑',arial,sans-serif;
        margin: 0;
        cursor: pointer;
        display: inline-block;
    }
</style>
<script type="text/javascript">
    function validate() {
        var fileUpload = document.getElementById("fileUpload");
        var path = fileUpload.value.trim();
        if (path.length <= 0) {
            document.getElementById("message").innerHTML = "<font color=red>请选择上传的文件！</font>";
            return false;
        }
        return true;
    }

    function multipleValidate() {
        var multipleUpload = document.getElementsByName("multipleUpload");
        var size = multipleUpload.length;
        for (var i = 0; i < size; i ++) {
            var path = multipleUpload[i].value.trim();
            if (path <= 0) {
                document.getElementById("messages").innerHTML = "<font color=red>请选择上传的文件！</font>";
                return false;
            }
        }
        return true;
    }

    function singleFlush() {
        document.getElementById("message").innerHTML = "";
    }

    function multipleFlush() {
        document.getElementById("message").innerHTML = "";
    }
</script>
<body>
<div style="font-family: '微软雅黑', arial; font-size: 15px;">
    <s:form action="/fileupload/single-upload" method="post" enctype="multipart/form-data" onsubmit="return validate();">
        <table>
            <tr><td>文件：<input type="file" id="fileUpload" name="fileUpload" size="50" onclick="singleFlush()" /></td>
            <tr><td><button class="button" type="submit">点击上传</button></td></tr>
        </table>
    </s:form>
    <span id="message">
        <font color="green"><s:property value="message" escape="false"/></font>
    </span><br>

    <s:form action="/fileupload/multiple-upload" method="post" enctype="multipart/form-data" onsubmit="return multipleValidate();"></tr>
        <table>
            <tr><td>文件1：<input type="file" name="multipleUpload" size="50" onclick="multipleFlush()" /></td></tr>
            <tr><td>文件2：<input type="file" name="multipleUpload" size="50" onclick="multipleFlush()" /></td></tr>
            <tr><td>文件3：<input type="file" name="multipleUpload" size="50" onclick="multipleFlush()" /></td></tr>
            <tr><td>文件4：<input type="file" name="multipleUpload" size="50" onclick="multipleFlush()" /></td></tr>
            <tr><td><button class="button" type="submit">点击上传</button></td></tr>
        </table>
    </s:form>
    <span id="messages">
        <font color="green"><s:property value="messages" escape="false"/></font>
    </span>
</div>
</body>
</html>
<%--
  Created by IntelliJ IDEA.
  User: F
  Date: 2017/10/25
  Time: 22:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script type="text/javascript">

</script>
<form class="easyui-form" style="margin: 20px auto;width:90%;" id="forms" enctype="multipart/form-data" method="post">
    轮播图名称:<input type="file" name="name" value="上传文件"/><br/><br/>
    轮播图描述:<input class="easyui-textbox" name="describe"/><br/><br/>
    轮播图状态:<!-- <input class="easyui-textbox" name="status"/><br/><br/> -->
    <select class="easyui-combobox" name="status">
        <option value="展示">展示</option>
        <option value="不展示">不展示</option>
    </select><br/>
</form>

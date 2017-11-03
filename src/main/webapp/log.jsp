<%--
  Created by IntelliJ IDEA.
  User: F
  Date: 2017/10/29
  Time: 16:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

    <script type="text/javascript">
        $(function(){
            $("#logdatagrid").edatagrid({
                url:'${pageContext.request.contextPath}/log/findAll',
                fit:true,
                fitColumns:true,
                pagination:true,
                columns:[[
                    {field:'id',title:'日志编号',width:60,align:'center'},
                    {field:'username',title:'用户名称',width:60,align:'center'},
                    {field:'doSomething',title:'用户操作',width:60,align:'center'},
                    {field:'date',title:'操作日期',width:60,align:'center'},
                    {field:'status',title:'操作状态',width:60,align:'center'},
                ]],
            })
        })
    </script>

    <table id="logdatagrid" class="easyui-datagrid"  >
    </table>



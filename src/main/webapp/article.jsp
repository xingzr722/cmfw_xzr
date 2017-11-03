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
            $("#articledatagrid").edatagrid({
                url:'${pageContext.request.contextPath}/article/findAll',
                fit:true,
                fitColumns:true,
                pagination:true,
                columns:[[
                    {field:'id',title:'文章编号',width:60,align:'center'},
                    {field:'title',title:'文章标题',width:60,align:'center'},
                    {field:'creattime',title:'上传时间',width:60,align:'center'},
                    {field:'link',title:'路径',width:60,align:'center'},
                    {field:'ext',title:'扩展字段',width:60,align:'center'},
                    {field:'text',title:'文章内容',width:60,align:'center'},
                    {field:'illustration',title:'文章封面',width:60,align:'center'},
                    {field:'guru',title:'上师名称',width:60,align:'center',formatter:function (value,row,index) {
                        return row.guru.name;
                    }},
                ]],
                view:detailview,
                detailFormatter:fmtimgdetail1,
            })
        })
        function fmtimgdetail1(rowIndex, rowData){
            return  "<p style='padding-top:5px'>"+"文章封面:&nbsp;<img src='${pageContext.request.contextPath}/imgs/"+rowData.illustration+"' style='height:100px;width:100px;margin:5px 5px 5px 5px;'/></p>";
        }
    </script>

    <table id="articledatagrid" class="easyui-datagrid"  >
    </table>
    <div id="articleadd"></div>


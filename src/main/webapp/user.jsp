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
            $("#userdatagrid").edatagrid({
                url:'${pageContext.request.contextPath}/user/findAll',
                fit:true,
                fitColumns:true,
                pagination:true,
                autoSave:true,
                updateUrl:'${pageContext.request.contextPath}/user/update',
                columns:[[
                    {field:'id',title:'用户编号',width:60,align:'center'},
                    {field:'farmington',title:'用户法号',width:60,align:'center'},
                    {field:'nickname',title:'用户昵称',width:60,align:'center'},
                    {field:'gender',title:'用户性别',width:60,align:'center'},
                    {field:'photo',title:'用户头像',width:60,align:'center'},
                    {field:'location',title:'用户所在地',width:60,align:'center'},
                    {field:'province',title:'省市',width:60,align:'center'},
                    {field:'city',title:'地区',width:60,align:'center'},
                    {field:'description',title:'个性签名',width:60,align:'center'},
                    {field:'phone',title:'手机号',width:60,align:'center'},
                    {field:'status',title:'用户状态',width:60,align:'center',editor:{
                        type:'combobox',
                        options:{
                            valueField: 'label',
                            textField: 'value',
                            data: [{
                                label: '封号',
                                value: '封号'
                            },{
                                label: '正常',
                                value: '正常'
                            }]
                        },}
                    },
                ]],
            })
        })
    </script>

    <table id="userdatagrid" class="easyui-datagrid"  >
    </table>



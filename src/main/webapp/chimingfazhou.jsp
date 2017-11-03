<%--
  Created by IntelliJ IDEA.
  User: F
  Date: 2017/10/24
  Time: 21:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>持明法州</title>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/themes/black/easyui.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/themes/icon.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/themes/IconExtension.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/editor/themes/simple/simple.css">
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/echarts.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.easyui.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui-lang-zh_CN.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/datagrid-detailview.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.edatagrid.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/editor/kindeditor-common.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/editor/kindeditor.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/editor/lang/zh-CN.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/form.validator.rules.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/china.js"></script>

        <script type="text/javascript">
            function selectTab(name,logo,path){
                if($("#tt").tabs("exists",name)){
                    $("#tt").tabs("select",name);
                }else{
                    $("#tt").tabs('add',{
                        title:name,
                        iconCls:logo,
                        closable:true,
                        href:'${pageContext.request.contextPath}/'+path
                    })
                }
            }
            //修改密码
            function updatePassword(){
                $("#updatePassword").dialog({
                    title:'修改密码',
                    width:350,
                    height:200,
                    href:'${pageContext.request.contextPath}/updateAdm.jsp',
                    buttons:[{
                        text:'修改',
                        handler:function(){
                            $("#updatepwd").form('submit',{
                                url:'${pageContext.request.contextPath}/adm/update',
                                success:function(res){
                                    $("#updatePassword").dialog('close',true);
                                    if(res=='y'){
                                        $.messager.show({title:'我的消息',
                                            msg:'恭喜君上渡劫成功。',
                                            timeout:2000,
                                            showType:'slide'
                                        });
                                    }
                                }
                            })
                        }
                    },{
                        text:'关闭',
                        handler:function(){
                            $("#updatePassword").dialog('close',true);
                        }
                    }]
                })
            }

        </script>
    </head>
    <body class="easyui-layout">
        <%--顶部--%>
        <div data-options="region:'north',split:false" style="height:60px;background-color:  #5C160C">
            <div style="font-size: 24px;color: #FAF7F7;font-family: 楷体;font-weight: 900;width: 500px;float:left;padding-left: 20px;padding-top: 10px" >持名法州后台管理系统</div>
            <div style="font-size: 16px;color: #FAF7F7;font-family: 楷体;width: 300px;float:right;padding-top:15px">欢迎您:${sessionScope.adm.username} &nbsp;<a href="#" class="easyui-linkbutton" onclick="updatePassword();" data-options="iconCls:'icon-edit'">修改密码</a>&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/adm/outs" class="easyui-linkbutton" data-options="iconCls:'icon-01'">退出系统</a></div>
        </div>
        <%--修改密码div--%>
        <div  id="updatePassword"></div>
        <%--主页面--%>
        <div data-options="region:'center'">
            <div id="tt" class="easyui-tabs" data-options="fit:true,narrow:true,pill:true">
                <div title="主页" data-options="iconCls:'icon-neighbourhood',"  style="background-image:url(${pageContext.request.contextPath}/img/shouye.jpg);background-repeat: no-repeat;background-size:100% 100%;"></div>
            </div>
        </div>

        <%--底部--%>
        <div data-options="region:'south',split:false" style="height: 40px;background: #5C160C">
            <div style="text-align: center;font-size:15px; color: #FAF7F7;font-family: 楷体" >&copy;百知教育</div>
        </div>
        <div data-options="region:'west',title:'导航菜单',split:false,iconCls:'icon-home',href:'/cmfz/menu.jsp'" style="width:200px;"></div>

    </body>
</html>

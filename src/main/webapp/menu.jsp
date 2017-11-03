<%--
  Created by IntelliJ IDEA.
  User: F
  Date: 2017/10/24
  Time: 21:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<script type="text/javascript">
    var $aa;
    $(function(){
        $aa = $("#aa");

        //发送异步请求加载菜单数据
        $.get("${pageContext.request.contextPath}/menu/findAll",function(result){
            //遍历一级菜单
            $.each(result, function(index,menu){
                //遍历二级菜单
                var content = "<div style='text-align:center;'>";
                $.each(menu.children, function(index,child) {
                    var args = child.url+"*"+child.icon+"*"+child.name;
                    content += "<div class='easyui-linkbutton' onClick=\"addTabs('"+args+"');\" data-options=\" plain:true,iconCls:'"+ child.icon +"' \" style='margin:5px 0px 5px 0px;width:90%;border: 1px solid #95B8E7;'>"+child.name+"</div><br/>";
                });
                content += "</div>";
                $aa.accordion('add',{
                    title:menu.name,
                    iconCls:menu.icon,
                    selected:false,
                    content:content,
                },"JSON");
            });
        });
    });

    function addTabs(args){
        var arg=args.split("*");
        var href=arg[0];
        var iconCls=arg[1];
        var title=arg[2];

        if(!$("#tt").tabs('exists',title)){
            $("#tt").tabs('add',{
                title:title,
                iconCls:iconCls,
                closable:true,
                href:href,
                tools:[
                    {
                        iconCls:'icon-reload',
                        handler:refershTab,
                    }],
            });
        }else{//选中当前面板
            $("#tt").tabs('select',title);
        }
    }

    //刷新当前选项卡
    function refershTab(){
        //返回当前选项卡面板
        var tab = $("#tt").tabs('getSelected');
        //调用面板方法
        tab.panel('refresh');
    }


</script>
<div id="aa" class="easyui-accordion" data-options="fit:true,">

</div>
</div>

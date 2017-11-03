<%--
  Created by IntelliJ IDEA.
  User: F
  Date: 2017/10/25
  Time: 20:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false" %>

<script type="text/javascript">
    /* 添加图标 */
    tool=[
        {
            text:'新增轮播图',
            iconCls:'icon-picture_add',
            handler: function(){
                $("#lunboAdd").dialog("open");
            }
        },
        {
            text:'帮助',
            iconCls:'icon-help',
            handler: function(){
                alert('编辑按钮');
            }
        }

    ];
    /* 按钮 */
    function butten(value , row , index){
        return "<a class='easyui-linkbutton' data-options='onClick:hx'>修改</a>";
    }

    function load(){
        $.parser.parse($("a").parent());
    }

    /* 按钮回显 */
    function hx(){
        var tr=$("#luboTab").datagrid("getSelected");
        $("#dias").dialog("open");
        $("#forms1").form('load',{
            id:tr.id,
            name:tr.name,
            describe:tr.describe,
            status:tr.status
        });
    }

    /* 显示图片*/
    function names(value , row , index){
        return "<img src='${pageContext.request.contextPath}/imgs/"+value+"' style='height:100px;width:100px'/>";
    }


    /* 飘红 */
    function lunbo(value , row , index){
        //console.log(value);
        if(value=='展示'){
            return "<font color='green'>"+value+"</font>";
        }else{
            return "<font color='red'>"+value+"</font>";
        }
        return value;
    }

    /* 上传图片 */
    var btns1=[
        {
            text:'保存',
            iconCls:'icon-save',
            handler:function(){

                $("#forms").form('submit',{
                    url:"${pageContext.request.contextPath}/picture/save",
                    omSubmit:function(){
                        return $("#forms").form('validate');

                    },
                    success:function(res){
                        if(res=="y"){
                            $("#luboTab").datagrid({
                                url:"${pageContext.request.contextPath}/picture/fenye"
                            });
                            $.messager.show({title:'我的消息',
                                msg:'恭喜君上渡劫成功。',
                                timeout:2000,
                                showType:'slide'
                            });
                            $("#datag").datagrid("reload");
                        }else{
                            $.messager.show({title:'我的消息',
                                msg:'唉，君上渡劫失败，再接再厉啊。',
                                timeout:2000,
                                showType:'slide'
                            });
                        }
                    }
                });
                $("#lunboAdd").dialog("close");
            }
        },{
            text:'取消',
            iconCls:'icon-error',
            handler:function(){
                $("#lunboAdd").dialog("close");
            }
        }
    ];

    /* 操作按钮 */
    var buts=[
        {
            iconCls:'icon-save',
            text:'保存',
            handler:function(){
                $("#forms1").form('submit',{
                    url:"${pageContext.request.contextPath}/picture/update",
                    omSubmit:function(){
                        return $("#forms1").form('validate');
                    },
                    success:function(res){
                        if(res=='y'){
                            $.messager.show({title:'我的消息',
                                msg:'恭喜君上渡劫成功。',
                                timeout:2000,
                                showType:'slide'
                            });
                            $("#luboTab").datagrid("reload");
                        }else{
                            $.messager.show({title:'我的消息',
                                msg:'唉，君上渡劫失败，再接再厉啊。',
                                timeout:2000,
                                showType:'slide'
                            });
                        }
                    }
                });
                $("#dias").dialog("close");
            }
        },
        {
            iconCls:'icon-save',
            text:'取消',
            handler:function(){
                $("#dias").dialog("close");
            }
        }
    ];
    function fmtimgdetail(rowIndex, rowData){
        return  "<img src='${pageContext.request.contextPath}/imgs/"+rowData.name+"' style='height:100px;width:100px;float:left;margin:5px 5px 5px 5px;'/>"+
            "<p style='padding-top:5px'>"+"轮播图名称:&nbsp;"+rowData.name +"</p>"+
            "<p style='padding-top:5px'>"+"轮播图描述:&nbsp;"+rowData.describe +"</p>"+
            "<p style='padding-top:5px'>"+"轮播图状态:&nbsp;"+rowData.status +"</p>";
    }
    function  erbi(rowIndex, rowData){

    }
</script>

<table class="easyui-datagrid" style="width:100%;height:100%;" id="luboTab"
       data-options="fitColumns:true,toolbar:tool,striped:true,pagination:true,singleSelect:true,
		     		 url:'${pageContext.request.contextPath}/picture/fenye',
		     		 onLoadSuccess:load,view:detailview,detailFormatter:fmtimgdetail,onExpandRow:erbi">
    <thead>
    <tr>
        <th data-options="field:'id',width:'15%',align:'center'" >轮播图编号</th>
        <th data-options="field:'name',width:'15%',align:'center'">轮播图名称</th>
        <th data-options="field:'describe',width:'15%',align:'center'">轮播图描述</th>
        <th data-options="formatter:lunbo,field:'status',width:'15%',align:'center'">轮播图状态</th>
        <th data-options="field:'creattime',width:'15%',align:'center'">轮播图创建时间</th>
        <th data-options="formatter:butten,field:'update',width:'15%',align:'center'">操作</th>
    </tr>
    </thead>
</table>
<div class="easyui-dialog" style="width: 300px;height: 200px;padding: 10px"  id="lunboAdd"
     data-options="title:'添加',iconCls:'icon-add',closed:true,modal:true,buttons:btns1">
    <form id="forms" class="easyui-form" enctype="multipart/form-data" method="post">
        上传轮播图:<input name="name" id="fileText" type="file" style="width:200px"><br/><br/>
        轮播图描述:<input class="easyui-textbox" name="describe"><br/><br/>
        轮播图状态:<select name="status">
        <option value="展示">展示</option>
        <option value="不展示">不展示</option>
    </select><br/><br/>
    </form>
</div>
<div class="easyui-dialog" style="width: 350px;height: 350px;"
     data-options="title:'修改轮播图',closed:true,modal:true,buttons:buts" id="dias">
    <form class="easyui-form" style="margin: 20px auto;width:90%;" id="forms1">
        轮播图编号:<input class="easyui-textbox" name="id" readonly/><br/><br/>
        轮播图名称:<input class="easyui-textbox" name="name"/><br/><br/>
        轮播图描述:<input class="easyui-textbox" name="describe"/><br/><br/>
        轮播图状态:<select name="status">
        <option value="展示">展示</option>
        <option value="不展示">不展示</option>
    </select><br/><br/>
    </form>
</div>
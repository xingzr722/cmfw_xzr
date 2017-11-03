<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script>
    $(function(){
        $("#albumdatagrid").treegrid({
            url:'${pageContext.request.contextPath}/album/findAll',
            fit:true,
            fitColumns:true,
            pagination:true,
            idField:'id',
            treeField:'name',
            onDblClickCell: function (field, row) {
                $('#albumdatagrid').treegrid('beginEdit',row.id);
            },
            onAfterEdit:function (row,changes) {
                $.ajax({
                    url: '${pageContext.request.contextPath}/album/update',
                    data: JSON.stringify(row),
                    type: "POST",
                    contentType: "application/json",//请求格式 为json
                    success: function (res) {
                        //刷新datagrid
                        if(res='y'){
                            $.messager.show({title:'我的消息',
                                msg:'恭喜君上渡劫成功。',
                                timeout:2000,
                                showType:'slide'
                            });
                            $("#albumdatagrid").treegrid("reload");
                        }else{
                            $.messager.show({title:'我的消息',
                                msg:'唉，君上渡劫失败，再接再厉啊。',
                                timeout:2000,
                                showType:'slide'
                            });
                        }
                    }
                });
            },
            columns:[[
                {field:'name',title:'专辑名称',width:100,},
                {field:'imgPath',title:'路径',width:100,},
                {field:'setCount',title:'集数',width:100,},
                {field:'createTime',title:'上传时间',width:100},
                {field:'score',title:'评分',width:100},
                {field:'author',title:'作者',width:100},
                {field:'broadcast',title:'播音者',width:100},
                {field:'brief',title:'内容简介',width:100},
                {field:'status',title:'状态',width:100,editor:{
                    type:'combobox',
                    options:{
                        valueField: 'label',
                        textField: 'value',
                        data: [{
                            label: '展示',
                            value: '展示'
                        },{
                            label: '不展示',
                            value: '不展示'
                        }]
                    },}},
                {field:'cz',title:'操作',width:100,
                    formatter: function(value,row,index){
                        if(row.size==null) {
                            return "<a class='upd' onclick=\"edit('" + row.id + "');\">修改</a>"
                        }
                    }
                }
            ]],
            onLoadSuccess:function(){
                $(".upd").linkbutton({plain:true,iconCls:'icon-cdr_edit '});
            },
            toolbar: [{
                text:'添加专辑',
                iconCls: 'icon-cdr_add',
                handler: function(){
                    $("#albumadd").dialog({
                        width:600,
                        height:450,
                        href:'${pageContext.request.contextPath}/albumAdd.jsp',
                        title:'上传专辑窗口',
                        buttons:[{
                            text:'保存',
                            handler:function(){

                                $("#uploadalbum").form('submit',{
                                    url:'${pageContext.request.contextPath}/album/save',
                                    success:function (res) {
                                        if(res='y'){
                                            $.messager.show({title:'我的消息',
                                                msg:'恭喜君上渡劫成功。',
                                                timeout:2000,
                                                showType:'slide'
                                            });
                                            $("#albumdatagrid").treegrid("reload");
                                            $("#albumadd").dialog("close",true);
                                        }else{
                                            $.messager.show({title:'我的消息',
                                                msg:'唉，君上渡劫失败，再接再厉啊。',
                                                timeout:2000,
                                                showType:'slide'
                                            });
                                            $("#albumadd").dialog("close",true);
                                        }
                                    }
                                })
                            }
                        },{
                            text:'关闭',
                            handler:function(){
                                $("#albumadd").dialog("close",true);
                            }
                        }]
                    })
                }
            /*},'-',{
                text:'添加音频',
                iconCls: 'icon-add',
                handler: function(){
                    $("#chapteradd").dialog({
                        width:400,
                        height:400,
                        href:'/cmfz/chapterAdd.jsp',
                        title:'上传音频窗口',
                        buttons:[{
                            text:'保存',
                            handler:function(){
                                $("#uploadchapter").form('submit',{
                                    url:'/cmfz/chapter/save',
                                    success:function (res) {
                                        if(res='y'){
                                            $.messager.show({title:'我的消息',
                                                msg:'恭喜君上渡劫成功。',
                                                timeout:2000,
                                                showType:'slide'
                                            });
                                            $("#albumdatagrid").treegrid("reload");
                                            $("#chapteradd").dialog("close",true);
                                        }else{
                                            $.messager.show({title:'我的消息',
                                                msg:'唉，君上渡劫失败，再接再厉啊。',
                                                timeout:2000,
                                                showType:'slide'
                                            });
                                            $("#chapteradd").dialog("close",true);
                                        }
                                    }

                                })
                            }
                        },{
                            text:'关闭',
                            handler:function(){
                                $("#chapteradd").dialog("close",true);
                            }
                        }]
                    })
                }*/
            }]

        });
    });
    /*修改*/
    function edit(id) {
        $.messager.confirm('确认对话框', '您想要修改该专辑吗？', function (r) {
            if (r) {
                $('#albumdatagrid').treegrid('endEdit',id);
            } else {
                $('#albumdatagrid').treegrid('cancelEdit',id);
            }
        });
    }
</script>
<table id="albumdatagrid" class="easyui-datagrid"  >
</table>
<div id="albumadd"></div>
<%--<div id="chapteradd"></div>--%>

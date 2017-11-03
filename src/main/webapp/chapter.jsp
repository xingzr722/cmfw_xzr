<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script>
    $(function(){
        $("#chapterdatagrid").treegrid({
            url:'${pageContext.request.contextPath}/chapter/findAll',
            fit:true,
            fitColumns:true,
            pagination:true,
            idField:'id',
            treeField:'name',
            onDblClickCell: function (field, row) {
                $('#chapterdatagrid').treegrid('beginEdit',row.id);
            },
            onAfterEdit:function (row,changes) {
                $.ajax({
                    url: '${pageContext.request.contextPath}/chapter/update',
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
                            $("#chapterdatagrid").treegrid("reload");
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
                {field:'name',title:'音频名称',width:60,align:'center'},
                {field:'download',title:'路径',width:120,align:'center'},
                {field:'size',title:'音频大小',width:40,align:'center'},
                {field:'duration',title:'音频时长',width:40,align:'center'},
                {field:'status',title:'状态',width:40,align:'center',editor:{
                    type:'combobox',
                    options:{
                        valueField: 'label',
                        textField: 'value',
                        data: [{
                            label: '播放',
                            value: '播放'
                        },{
                            label: '不播放',
                            value: '不播放'
                        }]
                    },}},
                {field:'cz',title:'操作',width:100,align:'center',
                    formatter: function (value, row, index) {
                        return "<a class='upd' onclick=\"edit('" + row.id + "');\">修改</a>|<a  onclick=\"audioss('" + row + "');\" class='bf'>播放</a>|<a  onclick=\"stopaudioss('" + row + "');\" class='zt'>暂停</a>|<a class='down' onclick=\"down();\">下载</a>"
                    }
                }
            ]],
            onLoadSuccess:function(){
                $(".upd").linkbutton({plain:true,iconCls:'icon-cd_edit '});
                $(".bf").linkbutton({plain:true,iconCls:' icon-control_play_blue '});
                $(".zt").linkbutton({plain:true,iconCls:' icon-control_pause_blue'});
                $(".down").linkbutton({plain:true,iconCls:' icon-20130406125519344_easyicon_net_16'});
            },
            toolbar: [{
                text:'添加音频',
                iconCls: 'icon-cd_add',
                handler: function(){
                    $("#chapteradd").dialog({
                        width:400,
                        height:400,
                        href:'${pageContext.request.contextPath}/chapterAdd.jsp',
                        title:'上传音频窗口',
                        buttons:[{
                            text:'保存',
                            handler:function(){
                                $("#uploadchapter").form('submit',{
                                    url:'${pageContext.request.contextPath}/chapter/save',
                                    success:function (res) {
                                        if(res='y'){
                                            $.messager.show({title:'我的消息',
                                                msg:'恭喜君上渡劫成功。',
                                                timeout:2000,
                                                showType:'slide'
                                            });
                                            $("#chapterdatagrid").treegrid("reload");
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
                }
            }]

        });
    });
    /*修改*/
    function edit(id) {
        $.messager.confirm('确认对话框', '您想要修改该音频吗？', function (r) {
            if (r) {
                $('#chapterdatagrid').treegrid('endEdit',id);
            } else {
                $('#chapterdatagrid').treegrid('cancelEdit',id);
            }
        });
    }
    /*在线播放音乐*/
    function audioss() {
        var jqq = $('#chapterdatagrid').treegrid('getSelected');
        var title = jqq.download;
        $("#audio").prop('src',"${pageContext.request.contextPath}/audio/"+title)
        var audio = $("#audio")[0];
        audio.play();
    }
    /*在线暂停音乐*/
    function stopaudioss() {
        var jqq = $('#chapterdatagrid').treegrid('getSelected');
        var title = jqq.download;
        $("#audio").prop('src',"${pageContext.request.contextPath}/audio/"+title)
        var audio = $("#audio")[0];
        audio.pause();
    }
    /*下载音乐*/
    function down() {
        var jqq = $('#chapterdatagrid').treegrid('getSelected');
        var title = jqq.download;
        $(location).attr('href', '${pageContext.request.contextPath}/chapter/downMusic/?name='+title);
    }
</script>
<table id="chapterdatagrid" class="easyui-datagrid"  >
</table>
<div id="chapteradd"></div>
<%--播放音乐--%>
<audio id="audio" src="" autoplay="autoplay" loop="loop"></audio>


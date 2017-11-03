<%--
  Created by IntelliJ IDEA.
  User: F
  Date: 2017/10/29
  Time: 14:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

    <script type="text/javascript">
        $(function(){
            $("#gurudatagrid").edatagrid({
                url:'${pageContext.request.contextPath}/guru/findAll',
                fit:true,
                fitColumns:true,
                pagination:true,
                autoSave:true,
                updateUrl:'${pageContext.request.contextPath}/guru/update',
                columns:[[
                    {field:'id',title:'上师编号',width:60,align:'center'},
                    {field:'headpic',title:'上师头像',width:120,align:'center'},
                    {field:'name',title:'上师法号',width:40,align:'center'},
                    {field:'status',title:'上师状态',width:40,align:'center',editor:{
                        type:'combobox',
                        options:{
                            valueField: 'label',
                            textField: 'value',
                            data: [{
                                label: '可拜师',
                                value: '可拜师'
                            },{
                                label: '不可拜师',
                                value: '不可拜师'
                            }]
                        },}},
                    /*{field:'cz',title:'操作',width:40,align:'center',
                        /!*formatter:function(value,row,index){
                            return "<a class='upd1' onclick=\"edit('" + row.id + "');\">修改</a>";
                        }*!/
                    },*/
                ]],
                onLoadSuccess:function(){
                    $(".upd1").linkbutton({plain:true,iconCls:'icon-edit '});
                },
                toolbar: [{
                    text:'添加上师',
                    iconCls: 'icon-user_add ',
                    handler: function(){
                        $("#guruadd").dialog({
                            width:400,
                            height:400,
                            href:'${pageContext.request.contextPath}/guruAdd.jsp',
                            title:'添加上师窗口',
                            buttons:[{
                                text:'保存',
                                handler:function(){
                                    $("#uploadguru").form('submit',{
                                        url:'${pageContext.request.contextPath}/guru/save',
                                        success:function (res) {
                                            if(res='y'){
                                                $.messager.show({title:'我的消息',
                                                    msg:'恭喜君上渡劫成功。',
                                                    timeout:2000,
                                                    showType:'slide'
                                                });
                                                $("#gurudatagrid").edatagrid("reload");
                                                $("#guruadd").dialog("close",true);
                                            }else{
                                                $.messager.show({title:'我的消息',
                                                    msg:'唉，君上渡劫失败，再接再厉啊。',
                                                    timeout:2000,
                                                    showType:'slide'
                                                });
                                                $("#guruadd").dialog("close",true);
                                            }
                                        }

                                    })
                                }
                            },{
                                text:'关闭',
                                handler:function(){
                                    $("#guruadd").dialog("close",true);
                                }
                            }]
                        })
                    }
                }]
            });
        });
        /*/!*修改*!/
        function edit(id) {
            $.messager.confirm('确认对话框', '您想要修改该音频吗？', function (r) {
                if (r) {
                    $('#gurudatagrid').edatagrid('saveRow',id);
                } else {
                    $('#gurudatagrid').edatagrid('cancelRow',id);
                }
            });
        }*/
    </script>

    <table id="gurudatagrid">
    </table>
    <div id="guruadd"></div>


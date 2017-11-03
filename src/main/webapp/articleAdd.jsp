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
            $("#guruid").combobox({
                url:"${pageContext.request.contextPath}/guru/find",
                valueField:'id',
                textField:'name'
            })
            //富文本编辑
            KindEditor /* .ready(function(K) {
             editor = K  */
                .create(
                    //textarea id
                    "#editor_id",
                    {
                        //指定主题风格可设置:default”、”simple”，指定simple时需要引入simple.css。
                        themeType : "simple",//修改主题
                        height : "400px",
                        //工具插件
                        items : [ "source", "preview",
                            "fullscreen", "clearhtml", "|",
                            "undo", "redo", "|", "copy",
                            "paste", "plainpaste",
                            "wordpaste", "|",
                            "justifycenter",
                            "justifyright", "justifyfull",
                            "insertorderedlist",
                            "insertunorderedlist",
                            "indent", "outdent", "|",
                            "formatblock", "fontname",
                            "fontsize", "forecolor",
                            "hilitecolor", "bold",
                            "italic", "underline",
                            "strikethrough", "lineheight",
                            "removeformat", "|", "image",
                            "table", "hr", "emoticons",
                            "baidumap", "pagebreak",
                            "anchor", "link", "unlink" ],
                        langType : 'zh_CN',
                        //同步数据的方式，可设置""、"form"，值为form时提交form时自动同步，空时不会自动同步。
                        syncType : "form",
                        //true时根据 htmlTags 过滤HTML代码，false时允许输入任何代码。数据类型: Boolean 默认值: true
                        filterMode : false,
                        //可指定分页符HTML。
                        pagebreakHtml : '<hr class="pageBreak" \/>',

                        //true时显示浏览远程服务器按钮。
                        allowFileManager : true,
                        //相当于input file name
                        filePostName : "photo",
                        //指定浏览远程图片的服务器端程序
                        fileManagerJson : "${pageContext.request.contextPath}/imgss/browser",
                        uploadJson : "${pageContext.request.contextPath }/imgss/uploadImg",
                        //上传图片、Flash、视音频、文件时，支持添加别的参数一并传到服务器。 {item_id : 1000,category_id : 1}
                        extraFileUploadParams : {
                            token : getCookie("token")
                        },
                        /*  afterCreate : function() {
                         elocalStorage();
                         }, */
                        //编辑器内容发生变化后执行的回调函数。
                        afterChange : function(){
                            this.sync();
                        }
                    });
            /* 	}); */
        })
        function insert(){
            $("#uploadarticle").form("submit",{
                url:'${pageContext.request.contextPath}/article/save',
                onSubmit:function(ret){
                    return $("#uploadarticle").form("validate");
                },
                success:function(ret){

                    $.messager.show({
                        title:'提示',
                        msg:'发布成功,正在审核中。。。并为你跳转到文章管理页面',
                        width:200,
                        height:150,
                        timeout:5000,
                        showType:'slide',
                    });
                    setTimeout(function(){
                        selectTab('文章管理','icon-folder_page','article.jsp');
                    }, 5000);
                    $("#uploadarticle").form("clear");
                    $("#articledatagrid").edatagrid("reload");
                }
            })
        }
    </script>
    <form id="uploadarticle"  method="post" enctype="multipart/form-data">
        <br/><br/>
        文章名称：<input dataoptions="textbox" name="title"/><br/><br/>
        上师法号：<input id="guruid" name="guruid"/><br/><br/>
        <input name="image" class="easyui-filebox"  data-options="accept:'.jpg',label:'选择封面图：',buttonText:'浏览',buttonAlign:'left',width:200"/><br/><br/>
        <hr/>
        <h2 style="color: #00ee00">编写文章</h2>
        <textarea id="editor_id" name="text"></textarea>
        <a id="tj" class="easyui-linkbutton" data-options="iconCls:'icon-ok',onClick:insert">发表</a>
    </form>
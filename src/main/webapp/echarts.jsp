<%--
  Created by IntelliJ IDEA.
  User: F
  Date: 2017/10/31
  Time: 16:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div id="main1" style="width: 600px;height: 400px"></div>

<script type="text/javascript">
    var myeChart = echarts.init(document.getElementById('main1'));

    $.ajax({
        url:'${pageContext.request.contextPath}/user/usernum',
        dataType:'json',
        success:function(data){
            var option={
                title:{
                    text:'测试'
                },
                legend:{
                    data:['折线','柱状']
                },
                xAxis:{
                    data:['第一周','第二周','第三周']
                },
                yAxis:{},
                series:[{
                    name:'折线',
                    type:'line',
                    data:data
                },{
                    name:'柱状',
                    type:'bar',
                    data:data
                }]
            }
            myeChart.setOption(option);
        }
    })
</script>


<%--
  Created by IntelliJ IDEA.
  User: F
  Date: 2017/10/31
  Time: 16:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div id="main" style="width: 600px;height: 400px"></div>

<script type="text/javascript">
    var myeChart = echarts.init(document.getElementById('main'));

    $.ajax({
        url:'${pageContext.request.contextPath}/user/province',
        dataType:'json',
        success:function (data) {
            var option = {
                title : {
                    text: 'app用户地区分布',
                    subtext: '纯属虚构',
                    left: 'center'
                },
                tooltip : {
                    trigger: 'item'
                },
                legend: {
                    orient: 'vertical',
                    left: 'left',
                    data:['用户分布']
                },
                visualMap: {
                    min: 0,
                    max: 35000,
                    left: 'left',
                    top: 'bottom',
                    text:['高','低'],           // 文本，默认为数值文本
                    calculable : true
                },
                toolbox: {
                    show: true,
                    orient : 'vertical',
                    left: 'right',
                    top: 'center',
                    feature : {
                        mark : {show: true},
                        dataView : {show: true, readOnly: false},
                        restore : {show: true},
                        saveAsImage : {show: true}
                    }
                },
                series : [
                    {
                        name: '用户分布',
                        type: 'map',
                        mapType: 'china',
                        roam: false,
                        label: {
                            normal: {
                                show: false
                            },
                            emphasis: {
                                show: true
                            }
                        },
                        data:data
                    },
                ]
            };

            myeChart.setOption(option);
        }

    })
</script>

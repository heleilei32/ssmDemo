<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/base/head.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML >
<html lang="zh-CN">
<head>
<%@ include file="/base/meta.html"%>
    <title>控制台-chart图表</title>
<script type="text/javascript" src="${root}/resources/sys/js/laydate.js"></script>
<script type="text/javascript" src="${root}/resources/sys/js/dcCommon.js"></script>

<!-- ace -->
<link rel="stylesheet" href="${root}/resources/sys/css/font-awesome.min.css" />
<link rel="stylesheet" href="${root}/resources/sys/css/ace.min.css" />
<link rel="stylesheet" href="${root}/resources/sys/css/ace-rtl.min.css" />
<script src="${root}/resources/sys/js/ace-extra.min.js"></script>

<%--<link rel="stylesheet" href="${root}/static/assist/bootstrap-3.3.7-dist/css/bootstrap.css">--%>
<link rel="stylesheet" href="${root}/resources/sys/css/bootstrap.min.css">
<%--<link rel="stylesheet" href="${root}/static/assist/bootstrap_v2/bootstrap/css/bootstrap.min.css" >--%>
<link rel="stylesheet" href="${root}/resources/sys/css/jquery-confirm.css">
<link rel="stylesheet" href="${root}/resources/sys/css/common.css">

<script type="text/javascript" src="${root}/resources/sys/js/jquery-1.8.3.min.js" charset="UTF-8"></script>
<script type="text/javascript" src="${root}/resources/sys/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${root}/resources/sys/js/bootstrap-datetimepicker.js" charset="UTF-8"></script>

<!-- bootstrap-table -->
<link rel="stylesheet" href="${root}/resources/sys/css/bootstrap-table.css">
<script src="${root}/resources/sys/js/bootstrap-table.js"></script>
<script src="${root}/resources/sys/js/bootstrap-table-export.js"></script>
<script src="${root}/resources/sys/js/tableExport.js"></script>
<script src="${root}/resources/sys/js/bootstrap-table-zh-CN.js"></script>
<script type="text/javascript" src="${root}/resources/sys/js/jquery-confirm.js" charset="UTF-8"></script>
<script src="${root}/resources/sys/js/bootstrap-table-resizable.js"></script>
<script src="${root}/resources/sys/js/colResizable-1.5.source.js"></script>

<!-- chart js -->
<script type="text/javascript" src="${root}/resources/sys/js/Chart.bundle.js" charset="UTF-8"></script>
<script type="text/javascript" src="${root}/resources/sys/js/utils.js" charset="UTF-8"></script>
<script type="text/javascript" src="${root}/resources/sys/js/chartjs-plugin-zoom.js" charset="UTF-8"></script>

<script type="text/javascript" src="http://www.runoob.com/try/bootstrap/twitter-bootstrap-v2/docs/assets/js/jquery.js"></script>
<script type="text/javascript" src="http://www.runoob.com/try/bootstrap/twitter-bootstrap-v2/docs/assets/js/bootstrap-collapse.js"></script>

</head>
<body onload="IFrameResize()">
<div class="container-fluid">
<form id="formID" action="${root}/sys/consoleDataAction" method="post" class="form-horizontal">
<div class="row" style="margin-top: 20px">
	<label class="col-sm-1 control-label " for="beginTime" style="font-weight:normal">开始</label>
	<div class="col-sm-2 ">
		<input id="beginTime" name="beginTime" class="form-control" style="width: 160px" value="<fmt:formatDate value='${beginTime}' pattern='yyyy-MM-dd HH:mm:ss' />" placeholder="开始时间" onclick="laydate({istime: true, format: 'YYYY-MM-DD hh:mm:ss'})">
	</div>
	<label class="col-sm-1 control-label " for="endTime" style="font-weight:normal">截止</label>
	<div class="col-sm-2 text-left">
		<input id="endTime" name="endTime" class="form-control" style="width: 160px" value="<fmt:formatDate value='${endTime}' pattern='yyyy-MM-dd HH:mm:ss'  />" placeholder="结束时间" onclick="laydate({istime: true, format: 'YYYY-MM-DD hh:mm:ss'})">
	</div>
	<div class="col-sm-2 text-right">
	<select name="ctype" id="ctype" class="form-control" size="1" style="width: 120px;height: 30px">
		<option value="10">按时段查询</option>
		<option value="0">按日期查询</option>
		<option value="1">按月份查询</option>
		<option value="2">按年度查询</option>
	</select>
	</div>

	<div class="col-sm-2 text-left">
		<button type="submit" class="btn btn-success" title="生成图表"><span class="glyphicon glyphicon-ok">生成图表</span> </button>
	</div>
	<div class="col-sm-1 text-right">
		<a class=" btn btn-primary" id="" target="_blank" href="${root}/sys/consoleDataAction">
			<span class="glyphicon glyphicon-paperclip">新页面</span>
		</a>
	</div>
	<div class="col-sm-1 text-left">
		<a class=" btn btn-primary" id="debugInfoBtn" >
			<span class="glyphicon glyphicon-search">数据源</span>
		</a>
	</div>
</div>

<div id="debugInfo" class="collapse">
	订购成功:${orderArray_succeed}<br>
	订购失败:${orderArray_fail}<br>
	订购退订:${orderArray_unsubscribe}<br>
	订购全部:${orderArray_all}<br>
	用户pv:${getUserPV}<br>
	用户uv:${getUserUV}<br>
	老用户订购:${oldUserData}<br>
	新用户订购:${NewUserData}<br>
</div>

	<div class="row" style="margin-top: 15px">
<!-- 		<div class="space-6"></div> -->

		<div class="col-sm-12 infobox-container">
			<div class="infobox infobox-green2  col-sm-3">
				<div class="infobox-icon">
					<i class="icon-ok"></i>
				</div>

				<div class="infobox-data">
					<span class="infobox-data-number" id="orderArray_succeed">0</span>
					<div class="infobox-content">成功订购数</div>
				</div>
				<div class="badge badge-primary" id="orderArray_succeedRate" title="成功订购数/全部订购数">
					+32%
				</div>
<!-- 				<div class="stat stat-success">8%</div>  -->
			</div>

			<div class="infobox infobox-red  col-sm-3">
				<div class="infobox-icon">
					<i class="icon-remove"></i>
				</div>

				<div class="infobox-data">
					<span class="infobox-data-number" id="orderArray_fail">0</span>
					<div class="infobox-content">订购失败数</div>
				</div>
				<div class="badge badge-danger" id="orderArray_failRate" title="订购失败数/全部订购数">
					+32%
				</div>
			</div>

			<div class="infobox infobox-pink  col-sm-3">
				<div class="infobox-icon">
					<i class="icon-shopping-cart"></i>
				</div>
				<div class="infobox-data">
					<span class="infobox-data-number" id="orderArray_unsubscribe">0</span>
					<div class="infobox-content">退订数</div>
				</div>
				<div class="stat stat-important" id="orderArray_unsubscribeRate"  title="退订数/成功订购数">0.00%</div>
			</div>

			<div class="infobox infobox-blue  col-sm-3">
				<div class="infobox-icon">
					<i class="icon-shopping-cart"></i>
				</div>
				<div class="infobox-data">
					<span class="infobox-data-number" id="orderArray_all">0</span>
					<div class="infobox-content">全部订购数</div>
				</div>
			</div>

			<div class="infobox infobox-green  col-sm-3">
				<div class="infobox-icon">
					<i class="icon-eye-open"></i>
				</div>
				<div class="infobox-data">
					<span class="infobox-data-number" id="getUserUV">0</span>
					<div class="infobox-content">UV/访问量</div>
				</div>
			</div>

			<div class="infobox infobox-green  col-sm-3">
				<div class="infobox-icon">
					<i class="icon-eye-open"></i>
				</div>

				<div class="infobox-data">
					<span class="infobox-data-number" id="getUserPV">0</span>
					<div class="infobox-content">PV/访问次数</div>
				</div>
				<div class="stat stat-success" title="PV/UV的百分比" id="getUserUVRate">0.0%</div>
			</div>
			
			<div class="infobox infobox-grey  col-sm-3">
				<div class="infobox-icon">
					<i class="icon-user"></i>
				</div>
				<div class="infobox-data">
					<span class="infobox-data-number">${oldUserData}</span>
					<div class="infobox-content">老用户订购数</div>
				</div>
			</div>
			
			<div class="infobox infobox-orange  col-sm-3">
				<div class="infobox-icon">
					<i class="icon-user"></i>
				</div>
				<div class="infobox-data">
					<span class="infobox-data-number">${NewUserData}</span>
					<div class="infobox-content">新用户订购数</div>
				</div>
			</div>
		</div>

	</div><!-- /row -->
	
	<!-- 图标chart -->
	<div class="infobox-container" style="margin-top: 25px"> 
	  	<div class="col-sm-6" style="width:50%;">
	        <canvas id="orderCanvasHour"></canvas>
	    </div>
	  	<div class="col-sm-6"  style="width:50%;">
	        <canvas id="uvCanvasHour"></canvas>
	    </div>
	</div>
</form>



</div>
<script>
	var ctype = ${ctype};//查询维度：时段/日/月/年
	var orderArray_succeed = ${orderArray_succeed};//订购成功-时段
	var orderArray_fail = ${orderArray_fail};//订购失败-时段
	var orderArray_unsubscribe = ${orderArray_unsubscribe};//订购退订-时段
	var orderArray_all= ${orderArray_all};//订购全部-时段
	var getUserPV = ${getUserPV};//用户pv-时段
	var getUserUV = ${getUserUV};//用户uv-时段
	var oldUserData = ${oldUserData};//老用户订购-时段
	var newUserData = ${NewUserData};//新用户订购-时段
	var days = dateImsum($("#beginTime").val(),$("#endTime").val());//间隔天数
	//alert("间隔天数:"+days);

	//1.day format init
	var resultYearMonthDay = [];
	var now = new Date($("#beginTime").val());
	Date.prototype.getMonthDay = function(){
	    return this.getFullYear()+"."+(this.getMonth() + 1) + '.' + this.getDate();//this.getFullYear()+"."+
	}
	resultYearMonthDay.push(now.getMonthDay());
	
	//1.获取X坐标(日期)
	function getDayLables(days){
		for(var i = 0 ; i < days ; i ++){
		    now.setDate((now.getDate()) + 1);
		    resultYearMonthDay.push(now.getMonthDay());
		}
		return resultYearMonthDay;
	}

	
	//2.month format init
	var resultMonth = [];
	var dateMonth = new Date($("#beginTime").val());
	Date.prototype.getYearMonth = function(){
	    return this.getFullYear()+"."+(this.getMonth());//this.getFullYear()+"."+
	}
	
	//2.获取X坐标(月份)
	function getMonthLables(months){
		for(var i = 0 ; i < months ; i ++){
		    dateMonth.setMonth((dateMonth.getMonth()) + 1);
		    resultMonth.push(dateMonth.getYearMonth());
		}
		return resultMonth;
	}

	
	//3.year format init
	var resultYear = [];
	var dateYear = new Date($("#beginTime").val());
	Date.prototype.getYear = function(){
	    return this.getFullYear()-1;//this.getFullYear()+"."+
	}
	
	//3.获取X坐标(年份)
	function getYearLables(years){
		for(var i = 0 ; i < years ; i ++){
		    dateYear.setYear((dateYear.getFullYear()) + 1);
		    resultYear.push(dateYear.getYear());
		}
		return resultYear;
	}
	/////////////////////////////////////
	
	//日期相减
	function dateImsum(d1,d2){
		//var date1 = new Date('2013/02/28 18:00');
		//var date2 = new Date('2013/03/01 19:22:21');
		var date1 = new Date(d1);
		var date2 = new Date(d2);
		var s1 = date1.getTime(),s2 = date2.getTime();
		var total = (s2 - s1)/1000;
		var day = parseInt(total / (24*60*60));//计算整数天数
		return day;
	}
	////////////////////////////////////////////////
	var count = [ 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ];//访问记录数组
	var MONTHS = [ "1月", "2月", "3月", "4月", "5月", "6月", "7月", "8月", "9月", "10月", "11月", "12月" ];
	//订购时段
	var config = {
		type : 'line',
		data : {
			labels : [ "0时", "1时", "2时", "3时", "4时", "5时", "6时", "7时", "8时", "9时", "10时", "11时", "12时", "13时", "14时", "15时", "16时", "17时", "18时", "19时",
					"20时", "21时", "22时", "23时" ],
			datasets : [ 
			{
				label : "订购成功",
				backgroundColor : window.chartColors.green,
				borderColor : window.chartColors.green,
				data : orderArray_succeed,
				fill : false,
			},
			{
				label : "订购失败",
				backgroundColor : window.chartColors.red,
				borderColor : window.chartColors.red,
				data : orderArray_fail,
				fill : false,
			},
			{
				label : "退订数据",
				backgroundColor : window.chartColors.orange,
				borderColor : window.chartColors.orange,
				data : orderArray_unsubscribe,
				fill : false,
			},
			{
				label : "全部数据",
				backgroundColor : window.chartColors.blue,
				borderColor : window.chartColors.blue,
				data : orderArray_all,
				fill : false,
			}
			
			 ]
		},
		options : {
			responsive : true,
			title : {
				display : true,
				text : '用户订购数-时段'
			},
			tooltips : {
				mode : 'index',
				intersect : false,
			},
			hover : {
				mode : 'nearest',
				intersect : true
			},
			scales : {
				xAxes : [ {
					display : true,
					scaleLabel : {
						display : true,
						labelString : '24小时区间'
					}
				} ],
				yAxes : [ {
					display : true,
					scaleLabel : {
						display : true,
						labelString : '订购数'
					}
				} ]
			},
			pan : {
				enabled : true,
				mode : 'xy'
			},
			zoom : {
				enabled : true,
				mode : 'xy',
				limits : {
					max : 10,
					min : 0.5
				}
			}
		}
	};
		
	//UV-时段
	var configUVHours = {
		type : 'line',
		data : {
			labels : [ "0时", "1时", "2时", "3时", "4时", "5时", "6时", "7时", "8时", "9时", "10时", "11时", "12时", "13时", "14时", "15时", "16时", "17时", "18时", "19时",
					"20时", "21时", "22时", "23时" ],
			datasets : [ 
			{
				label : "用户pv",
				backgroundColor : window.chartColors.green,
				borderColor : window.chartColors.green,
				data : getUserPV,
				fill : false,
			},
			{
				label : "用户uv",
				backgroundColor : window.chartColors.red,
				borderColor : window.chartColors.red,
				data : getUserUV,
				fill : false,
			}
			 ]
		},
		options : {
			responsive : true,
			title : {
				display : true,
				text : '用户流量-时段'
			},
			tooltips : {
				mode : 'index',
				intersect : false,
			},
			hover : {
				mode : 'nearest',
				intersect : true
			},
			scales : {
				xAxes : [ {
					display : true,
					scaleLabel : {
						display : true,
						labelString : '24小时区间'
					}
				} ],
				yAxes : [ {
					display : true,
					scaleLabel : {
						display : true,
						labelString : 'uv/pv数'
					}
				} ]
			},
			pan : {
				enabled : true,
				mode : 'xy'
			},
			zoom : {
				enabled : true,
				mode : 'xy',
				limits : {
					max : 10,
					min : 0.5
				}
			}
		}
	};
	$(document).ready(function() {
		
		if(ctype == 10){//时段-默认
			
		}else if(ctype == 0){//日
			config.data.labels = getDayLables(days);
			config.options.title.text = "用户订购数-日期";
			config.options.scales.xAxes[0].scaleLabel.labelString = "日期";
			
			configUVHours.data.labels = getDayLables(days);
			configUVHours.options.title.text = "用户流量-日期";
			configUVHours.options.scales.xAxes[0].scaleLabel.labelString = "日期";
		
		}else if(ctype == 1){//月
			config.data.labels = getMonthLables(orderArray_succeed.length);
			config.options.title.text = "用户订购数-月份";
			config.options.scales.xAxes[0].scaleLabel.labelString = "月份";
			
			configUVHours.data.labels = getDayLables(days);
			configUVHours.options.title.text = "用户流量-月份";
			configUVHours.options.scales.xAxes[0].scaleLabel.labelString = "月份";
			
		}else if(ctype == 2){//年
			config.data.labels = getYearLables(orderArray_succeed.length);
			config.options.title.text = "用户订购数-年度";
			config.options.scales.xAxes[0].scaleLabel.labelString = "年度";
			
			configUVHours.data.labels = getDayLables(days);
			configUVHours.options.title.text = "用户流量-年度";
			configUVHours.options.scales.xAxes[0].scaleLabel.labelString = "年度";
		}

		//alert(config.data.labels);
		var ctx = document.getElementById("orderCanvasHour").getContext("2d");
		window.myLine = new Chart(ctx, config);
		
		//uv/pv-时段
		var ctx_uvCanvasHour = document.getElementById("uvCanvasHour").getContext("2d");
		window.myLine = new Chart(ctx_uvCanvasHour, configUVHours);	
		
		getDataTotal();
	});
	var orderArray_succeed_Total = 0;
	var orderArray_fail_Total = 0;
	var orderArray_unsubscribe_Total = 0;
	var orderArray_all_Total = 0;
	var getUserPV_Total = 0;
	var getUserUV_Total = 0;
	function getDataTotal() {
		for ( var i = 0; i < orderArray_succeed.length; i++) {
			orderArray_succeed_Total += parseInt(orderArray_succeed[i]);
		}
		for ( var i = 0; i < orderArray_fail.length; i++) {
			orderArray_fail_Total += parseInt(orderArray_fail[i]);
		}
		for ( var i = 0; i < orderArray_unsubscribe.length; i++) {
			orderArray_unsubscribe_Total += parseInt(orderArray_unsubscribe[i]);
		}
		for ( var i = 0; i < orderArray_all.length; i++) {
			orderArray_all_Total += parseInt(orderArray_all[i]);
		}
		for ( var i = 0; i < getUserPV.length; i++) {
			getUserPV_Total += parseInt(getUserPV[i]);
		}
		for ( var i = 0; i < getUserUV.length; i++) {
			getUserUV_Total += parseInt(getUserUV[i]);
		}
		
		$("#orderArray_succeed").html(orderArray_succeed_Total);
		$("#orderArray_fail").html(orderArray_fail_Total);
		$("#orderArray_unsubscribe").html(orderArray_unsubscribe_Total);
		$("#orderArray_all").html(orderArray_all_Total);
		$("#getUserPV").html(getUserPV_Total);
		$("#getUserUV").html(getUserUV_Total);
		
		$("#getUserUVRate").html(Percentage(getUserPV_Total,getUserUV_Total));
		$("#orderArray_succeedRate").html(Percentage(orderArray_succeed_Total,orderArray_all_Total));
		$("#orderArray_failRate").html(Percentage(orderArray_fail_Total,orderArray_all_Total));
		$("#orderArray_unsubscribeRate").html(Percentage(orderArray_unsubscribe_Total,orderArray_succeed_Total));
	}
	function Percentage(num, total) { 
	    return (Math.round(num / total * 10000) / 100.00 + "%");// 小数点后两位百分比
	}
	
	function IFrameResize() {
		var obj = parent.document.getElementById("homePageFrame"); //取得父页面IFrame对象 
		obj.height = this.document.body.clientHeight + 60; //调整父页面中IFrame的高度为此页面的高度 
	}
	setInterval(IFrameResize, "500");
	
	window.onload = initLoad;
	function initLoad() {
		//查询类型
		selectOptionByValue("${ctype}", "ctype");
		
		$("#debugInfoBtn").click(function(){
			//alert($('#debugInfo').attr('class'));
			if($("#debugInfo").attr("class").indexOf("in") >= 0){
				$("#debugInfo").removeClass("in collapse");
				$("#debugInfo").removeClass("collapse in");
				$("#debugInfo").addClass("collapse");
			}else{
				$("#debugInfo").removeClass("collapse");
				$("#debugInfo").addClass("collapse in");
			}
		});
	};

</script>

</body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/base/head.jsp"%>
<!DOCTYPE HTML >

<html lang="zh-CN">
<head>

<title>活动管理系统-后台首页</title>
<!-- basic styles -->
<link href="${root}/resources/sys/css/bootstrap.min.css" rel="stylesheet" />

<link rel="stylesheet" href="${root}/resources/sys/css/font-awesome.min.css" />
<link rel="stylesheet" href="${root}/resources/sys/css/ace.min.css" />
<link rel="stylesheet" href="${root}/resources/sys/css/ace-rtl.min.css" />
<script src="${root}/resources/sys/js/ace-extra.min.js"></script>
</head>

<body>
	<div class="navbar navbar-default" id="navbar">
		<script type="text/javascript">
			try {
				ace.settings.check('navbar', 'fixed')
			} catch (e) {
			}
		</script>

		<div class="navbar-container" id="navbar-container">
			<div class="navbar-header pull-left">
				<a href="#" class="navbar-brand">
					<small> <i class="icon-leaf"></i> DCGame活动管理系统 </small>
				</a>
				<!-- /.brand -->
			</div>
			<!-- /.navbar-header -->
			
			<div class="navbar-header pull-right" role="navigation">
				<ul class="nav ace-nav">
					<li class="light-blue">
						<a>
							<img class="nav-user-photo" src="${root}/resources/sys/imgs/avatar2.png" alt="Jason's Photo" />
							<!--								<i class="fa fa-user-o" aria-hidden="true"></i>-->
							<span class="user-info"> <small>欢迎光临,</small> ${curAdminName}</span>
						</a>
					</li>
					<li class="green">
					<li>
						<a href="${root}/exitAdminLogicAction">
							<i class="icon-off"></i>退出
						</a>
					</li>
					</li>
				</ul>
				<!-- /.ace-nav -->
			</div>
			<!-- /.navbar-header -->
		</div>
		<!-- /.container -->
	</div>

	<div class="main-container" id="main-container">
		<script type="text/javascript">
			try {
				ace.settings.check('main-container', 'fixed')
			} catch (e) {
			}
		</script>

		<div class="main-container-inner">
			<a class="menu-toggler" id="menu-toggler" href="#">
				<span class="menu-text"></span>
			</a>

			<div class="sidebar" id="sidebar">
				<script type="text/javascript">
					try {
						ace.settings.check('sidebar', 'fixed')
					} catch (e) {
					}
				</script>

				<div class="sidebar-shortcuts" id="sidebar-shortcuts">
					<div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
					
						<button class="btn btn-warning" onclick="setIframeSrc('${root}/hallDataShowAction','视频模块 ','首页排版','#homeManage');$('#videoModule').click();">
							<i class="icon-home"></i>
						</button>
						
						<button class="btn btn-success" onclick="setIframeSrc('${root}/userStatisticsAction','数据模块','运营数据统计(日终)','#operationData');$('#dataModule').click();">
							<i class="icon-signal"></i>
						</button>

						<button class="btn btn-info"    onclick="setIframeSrc('${root}/classifyShowAction','视频模块 ','分类管理(二级)','#typeManage');$('#videoModule').click();">
							<i class="icon-facetime-video"></i>
						</button>

						<button class="btn btn-danger" onclick="setIframeSrc('${root}/adminShowAction','系统模块 ','登录账号管理','#loginManage');$('#systemModule').click();">
							<i class="icon-user"></i>
<!-- 							cogs -->
						</button>
					</div>

					<div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
						<span class="btn btn-warning" onclick="setIframeSrc('${root}/hallDataShowAction','视频模块 ','首页排版','#homeManage');$('#videoModule').click();"></span> 
						<span class="btn btn-success" onclick="setIframeSrc('${root}/userStatisticsAction','数据模块','运营数据统计(日终)','#operationData');$('#dataModule').click();"></span> 
						<span class="btn btn-info" onclick="setIframeSrc('${root}/classifyShowAction','视频模块 ','分类管理(二级)','#typeManage');$('#videoModule').click();"></span> 
						<span class="btn btn-danger" onclick="setIframeSrc('${root}/adminShowAction','系统模块 ','登录账号管理','#loginManage');$('#systemModule').click();"></span>
					</div>
				</div>

				<ul class="nav nav-list">
					<li>
						<a href="#" class="dropdown-toggle" id="consoleModule">
							<i class="icon-dashboard"></i> <span class="menu-text"> 控制台模块 </span> <b class="arrow icon-angle-down"></b>
						</a>

						<ul class="submenu">
							<li>
								<a id="console" href="javascript:void(0)" onclick="setIframeSrc('${root}/sys/consoleDataAction','控制台 ','控制台',this)">
									<i class="icon-double-angle-right"></i> 控制台
								</a>
							</li>
						</ul>
					</li>

					<li>
						<a href="#" class="dropdown-toggle" id="videoModule">
							<i class="icon-facetime-video"></i> <span class="menu-text"> 活动模块.Ext </span> <b class="arrow icon-angle-down"></b>
						</a>

						<ul class="submenu">
													
							<li>
								<a href="javascript:void(0)" onclick="setIframeSrc('${root}/extend/userHavekeyShowAction','活动模块.Ext ','用户钥匙数查询',this)">
									<i class="icon-double-angle-right"></i> 用户钥匙数查询
								</a>
							</li>

							<li>
								<a id="typeManage" href="javascript:void(0)" onclick="setIframeSrc('${root}/extend/prizeGoodsShowAction','活动模块.Ext ','放奖量控制',this)">
									<i class="icon-double-angle-right"></i> 放奖量控制
								</a>
							</li>
							<li>
								<a id="homeManage"  href="javascript:void(0)" onclick="setIframeSrc('${root}/extend/winPrizeShowAction','活动模块.Ext ','用户中奖名单',this)">
									<i class="icon-double-angle-right"></i> 用户中奖名单
								</a>
							</li>
							<li>
								<a href="javascript:void(0)" onclick="setIframeSrc('${root}/extend/productPackage/ShowAction','活动模块.Ext ','产品包配置',this)">
									<i class="icon-double-angle-right"></i> 产品包配置
								</a>
							</li>
							<li>
								<a href="#" class="dropdown-toggle">
									<i class="icon-double-angle-right"></i>
									活动配置
									<b class="arrow icon-angle-down"></b>
								</a>

								<ul class="submenu">
									<li>
										<a href="javascript:void(0)" onclick="setIframeSrc('${root}/extend/interceptConfigShowAction','活动模块.Ext > 活动配置 ','退出拦截查询',this)">
											<i class="icon-eye-open"></i>
											退出拦截查询
										</a>
									</li>
									<li>
										<a href="javascript:void(0)" onclick="setIframeSrc('${root}/extend/interceptConfigGotoAddAction','活动模块.Ext > 活动配置 ','添加退出拦截',this)">
											<i class="icon-plus-sign"></i>
											添加退出拦截
										</a>
									</li>
									<li>
										<a href="javascript:void(0)" onclick="setIframeSrc('${root}/extend/GotoAddSpecifiedUserAction','活动模块.Ext > 活动配置 ','添加用户中奖',this)">
											<i class="icon-user"></i>
											添加用户中奖
										</a>
									</li>
									<li>
										<a href="javascript:void(0)" onclick="setIframeSrc('${root}/extend/activitySwitchShowAction','活动模块.Ext > 活动配置 ','活动开关控制',this)">
											<i class="icon-power-off"></i>
											活动开关控制
										</a>
									</li>
								</ul>
							</li>
						</ul>
					</li>

					<li>
						<a href="#" class="dropdown-toggle">
							<i class="icon-user"></i> <span class="menu-text"> 用户模块 </span> <b class="arrow icon-angle-down"></b>
						</a>

						<ul class="submenu">
							<li>
								<a href="javascript:void(0)" onclick="setIframeSrc('${root}/usersAction','用户模块','用户信息管理',this)">
									<i class="icon-double-angle-right"></i> 用户信息管理
								</a>
							</li>

							<li>
								<a href="javascript:void(0)" onclick="setIframeSrc('${root}/userLoginAction','用户模块','用户操作/登录记录',this)">
									<i class="icon-double-angle-right"></i> 用户操作/登录记录
								</a>
							</li>
							
							<li>
								<a href="javascript:void(0)" onclick="setIframeSrc('${root}/userShowStorageAction','用户模块','用户存档记录',this)">
									<i class="icon-double-angle-right"></i> 用户存档记录
								</a>
							</li>
						</ul>
					</li>

					<li>
						<a href="#" class="dropdown-toggle" id="dataModule">
							<i class="icon-bar-chart"></i> <span class="menu-text"> 数据模块 </span> <b class="arrow icon-angle-down"></b>
						</a>
						<ul class="submenu">
							<li>
								<a id="userOrderRecord" href="javascript:void(0)" onclick="setIframeSrc('${root}/userOrderAction','数据模块','用户订购记录',this)">
									<i class="icon-double-angle-right"></i> 用户订购记录
								</a>
							</li>
							<li>
								<a id="userUVRecord" href="javascript:void(0)" onclick="setIframeSrc('${root}/userAccessUVAction','数据模块','用户UV记录',this)">
									<i class="icon-double-angle-right"></i> 用户UV记录(日终)
								</a>
							</li>

							<li>
								<a id="userPVRecord" href="javascript:void(0)" onclick="setIframeSrc('${root}/userAccessPVAction','数据模块','用户PV记录',this)">
									<i class="icon-double-angle-right"></i> 用户PV记录
								</a>
							</li>
							<li>
								<a id="operationData" href="javascript:void(0)" onclick="setIframeSrc('${root}/userStatisticsAction','数据模块','运营数据统计(日终)',this)">
									<i class="icon-double-angle-right"></i> 运营数据统计(日终)
								</a>
							</li>
						</ul>
					</li>

					<li>
						<a href="#" class="dropdown-toggle" id="systemModule">
							<i class="icon-user" aria-hidden="true"></i> <span class="menu-text"> 管理员模块 </span> <b class="arrow icon-angle-down"></b>
						</a>

						<ul class="submenu">
							<li>
								<a id="loginManage" href="javascript:void(0)" onclick="setIframeSrc('${root}/adminShowAction','系统模块 ','登录账号管理',this)">
									<i class="icon-double-angle-right"></i> 登录账号管理
								</a>
							</li>
							<li>
								<a id="addLoginUser" href="javascript:void(0)" onclick="setIframeSrc('${root}/adminManageAction?type=add','系统模块 ','添加登录账号',this)">
									<i class="icon-double-angle-right"></i> 添加登录账号
								</a>
							</li>
						</ul>
					</li>

					<li>
						<a href="#" class="dropdown-toggle" id="monitorModule">
							<i class="icon-cogs"></i> <span class="menu-text"> 系统监测 </span> <b class="arrow icon-angle-down"></b>
						</a>

						<ul class="submenu">
							<li>
								<a id="systemTesting" href="javascript:void(0)" onclick="setIframeSrc('${root}/systemIsStillAliveAction','监测模块','系统测试',this)">
									<i class="icon-double-angle-right"></i> 系统测试
								</a>
							</li>
							<li>
								<a id="loadDataURLTesting3" href="#" onclick="setIframeSrc('${root}/version.jsp','监测模块','当前版本说明页面',this)">
									<i class="icon-double-angle-right"></i> 版本说明
								</a>
							</li>
							<li>
								<a id="loadDataURLTesting3" href="#" onclick="setIframeSrc('${root}/goPrompteMessageAction','提示信息','当前版本说明页面',this)">
									<i class="icon-double-angle-right"></i> 提示信息
								</a>
							</li>
						</ul>
					</li>

				</ul>
				<!-- /.nav-list -->

				<div class="sidebar-collapse" id="sidebar-collapse">
					<i class="icon-double-angle-left" data-icon1="icon-double-angle-left" data-icon2="icon-double-angle-right"></i>
				</div>

				<script type="text/javascript">
					try {
						ace.settings.check('sidebar', 'collapsed')
					} catch (e) {
					}
				</script>
			</div>

			<div class="main-content">
				<div class="breadcrumbs" id="breadcrumbs">
					<script type="text/javascript">
						try {
							ace.settings.check('breadcrumbs', 'fixed')
						} catch (e) {
						}
					</script>

					<ul class="breadcrumb">
						<li>
							<i class="icon-home home-icon"></i>
							<a href="#">首页</a>
						</li>
						<li class="active" id="curModule">控制台</li>
						<li class="active" id="curPageLocation">控制台</li>
					</ul>
					<!-- .breadcrumb -->

<!-- 					<div class="nav-search" id="nav-search1"> -->
<!-- 						<form class="form-search"> -->
<!-- 							<span class="input-icon">  -->
<!-- 								<input type="text" placeholder="Search ..." class="nav-search-input" id="nav-search-input" autocomplete="off" />  -->
<!-- 									<i class="icon-search nav-search-icon"></i>  -->
<!-- 							</span> -->
<!-- 						</form> -->
<!-- 					</div> -->
					<!-- #nav-search -->
				</div>
				<div align="center" style="z-index: 1; " id="load">
					<img src="${root}/resources/sys/imgs/ajax-loader.gif" />
					&nbsp;loading......
				</div>
				<IFRAME onreadystatechange=stateChangeIE(this) onload=stateChangeFirefox(this) border=0 marginWidth=0 marginHeight=0 frameSpacing=0 src="" frameBorder=0 style="visibility:hidden" noResize
					scrolling="no" width=100% height=100% vspale="0" id="homePageFrame" name="homePageFrame"> </IFRAME>
				<!-- style="border:medium double rgb(250,0,255);"  -->
			</div>
			<!-- /.main-content -->


			<div class="ace-settings-container" id="ace-settings-container">
				<div class="btn btn-app btn-xs btn-warning ace-settings-btn" id="ace-settings-btn">
					<i class="icon-cog bigger-150"></i>
				</div>

				<div class="ace-settings-box" id="ace-settings-box">

					<div>
						<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-navbar" />
						<label class="lbl" for="ace-settings-navbar"> 固定顶部</label>
					</div>

					<div>
						<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-sidebar" />
						<label class="lbl" for="ace-settings-sidebar"> 固定左边栏</label>
					</div>

					<div>
						<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-breadcrumbs" />
						<label class="lbl" for="ace-settings-breadcrumbs">固定面包屑</label>
					</div>

					<div>
						<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-rtl" />
						<label class="lbl" for="ace-settings-rtl">切换到左边</label>
					</div>

					<div>
						<input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-add-container" />
						<label class="lbl" for="ace-settings-add-container">
							切换窄屏 <b></b>
						</label>
					</div>
				</div>
			</div>
			<!-- /#ace-settings-container -->
		</div>
		<!-- /.main-container-inner -->

		<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
			<i class="icon-double-angle-up icon-only bigger-110"></i>
		</a>
	</div>
	<!-- /.main-container -->


	<script src="${root}/resources/sys/js/jquery-2.0.3.min.js"></script>
	<script type="text/javascript">
		window.jQuery
				|| document
						.write("<script src='${root}/static/assist/assets/js/jquery-2.0.3.min.js'>"
								+ "<"+"script>");
	</script>
	<script type="text/javascript">
		if ("ontouchend" in document)
			document
					.write("<script src='${root}/static/assist/assets/js/jquery.mobile.custom.min.js'>"
							+ "<"+"script>");
	</script>
	<script src="${root}/resources/sys/js/bootstrap.min.js"></script>
	<script src="${root}/resources/sys/js/typeahead-bs2.min.js"></script>
	<script src="${root}/resources/sys/js/ace-elements.min.js"></script>
	<script src="${root}/resources/sys/js/ace.min.js"></script>

	<script type="text/javascript">
		function setIframeSrc(src, module, location, obj) {
			document.getElementById("homePageFrame").style.visibility = "hidden";
			document.getElementById("load").style.display = "block";
			$("#homePageFrame").attr("src", src);
			//homePageFrame.location.href=src;//效果和src一样的
			//homePageFrame.location.href="http://www.hao123.com";
			//$("#homePageFrame").attr("src","http://www.baidu.com"); 
			$("#curModule").html(module);
			$("#curPageLocation").html(location);
			$('.nav-list li').removeClass('active');
			$(obj).parent().attr("class", "active");
		}

		function stateChangeIE(_frame) {

			if (_frame.readyState == "interactive")//state: loading ,interactive,   complete
			{
				var loader = document.getElementById("load");
				loader.style.display = "none";
				_frame.style.visibility = "visible";
			}
		}

		function stateChangeFirefox(_frame) {
			var loader = document.getElementById("load");
			loader.style.display = "none";
			_frame.style.visibility = "visible";
		}

		$(document).ready(function() {
			$("#consoleModule").click();//默认是控制台显示
			$("#console").click();//默认是控制台显示
			setIframeSrc('${root}/sys/consoleDataAction', '控制台模块 ', '控制台', '#console');
		});
	</script>
</body>
</html>


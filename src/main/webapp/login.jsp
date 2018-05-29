<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/base/head.jsp"%>
<!DOCTYPE HTML>

<html lang="zh-CN">
<head>
<%@ include file="/base/meta.html"%>
<title>登录页面</title>
<link rel="stylesheet"
	href="${root}/resources/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${root}/static/assist/assets/css/font-awesome.min.css" />
<link rel="stylesheet" href="${root}/static/assist/assets/css/ace.min.css" />
<link rel="stylesheet" href="${root}/static/assist/assets/css/ace-rtl.min.css" />
<script type="text/javascript" src="${root}/static/assist/bootstrap_v2/jquery/jquery-1.8.3.min.js"
	charset="UTF-8"></script>
<script type="text/javascript"
	src="${root}/static/assist/myActicity/js/jquery.cookie.js" charset="UTF-8"></script>
<script type="text/javascript" src="${root}/static/js/md5.js"></script>
</head>

<body class="login-layout">
	<div class="main-container" style="margin-top: 40px">
		<div class="main-content">
			<div class="row">
				<div class="col-sm-10 col-sm-offset-1">
					<div class="login-container">
						<div class="center">
							<h1>
								<i class="icon-leaf green"></i> <span class="red">浙江活动</span>
								<span class="white">管理系统</span>
							</h1>
							<h4 class="blue">Copy Right© 上海刀传网络</h4>
						</div>

						<div class="space-6"></div>

						<div class="position-relative">
							<div id="login-box"
								class="login-box visible widget-box no-border">
								<div class="widget-body">
									<div class="widget-main">
										<h4 class="header blue lighter bigger">
											<i class="icon-coffee green"></i> 请输入账号和密码
										</h4>

										<div class="space-6"></div>

										 <form id="dcLogin" action="${root}/loginLogicAction" method="post">
											<input type="hidden" name="op" value="userLogin">
											<fieldset>
												<label class="block clearfix"> 
												<span class="block input-icon input-icon-right">
													 <input id="cname" onblur="autoPwd();" name="cname" type="text" class="form-control" placeholder="用户名" /> 
													 <i class="icon-user"></i>
												</span>
												</label> 
												<label class="block clearfix">
												 <span class="block input-icon input-icon-right"> 
													 <input id="cpasswd" name="cpasswd" type="password" class="form-control" placeholder="密码" />
												 	 <i class="icon-lock"></i>
												</span>
												</label>

												<div id="tips" class="space1">${showMessage}</div>
												<div>
<!-- 													<p id="a3">账号格式不正确！</p> -->
												</div>
												<div class="clearfix">
													<label class="inline"> 
														<input type="checkbox" id="ck_rmbUser" class="ace" /> 
														<span class="lbl"> 记住密码</span>
													</label>

													<button type="button" onclick="Save();login();" class="width-35 pull-right btn btn-sm btn-primary">
														<i class="icon-key"> </i> 登录
													</button>
<!-- 														<input type="button" onclick="login();" value="登录"> -->
												</div>

												<div class="space-4"></div>
											</fieldset>
										</form>

									</div>
									<!-- /widget-main -->

								</div>
								<!-- /widget-body -->
							</div>
							<!-- /login-box -->
						</div>
						<!-- /position-relative -->
					</div>
				</div>
				<!-- /.col -->
			</div>
			<!-- /.row -->
		</div>
	</div>
	<!-- /.main-container -->
	<script type="text/javascript" >
		window.jQuery || document.write("<script src='${root}/assist/assets/js/jquery-2.0.3.min.js'>" + "<" + "/script>");
	</script>
	
	<script type="text/javascript">
		if ("ontouchend" in document) document.write("<script src='${root}/assist/assets/js/jquery.mobile.custom.min.js'>" + "<" + "/script>");
	</script>
	<script type="text/javascript">
		if(window !=top){  
    	top.location.href=location.href;  
		}  
	</script>
	<!-- inline scripts related to this page -->
	<script type="text/javascript"  src="${root}/static/assist/myActicity/js/login.js" charset="UTF-8" ></script>	
	<script type="text/javascript">
		function show_box(id) {
			jQuery('.widget-box.visible').removeClass('visible');
			jQuery('#' + id).addClass('visible');
		}
		
		function login() {
			var cname = getObj("cname").value;
			var cpasswd = getObj("cpasswd").value;
			if (cpasswd.length >= 2) {
				getObj("cpasswd").value = md5(cpasswd);
				cpasswd = md5(cpasswd);
			}
			//登录
			if (cname.length >= 1 && cpasswd.length == 32) {
				document.getElementById("dcLogin").submit();
			}
		}

		//得到对象
		function getObj(id) {
			return document.getElementById(id);
		}
	</script>
</body>
</html>
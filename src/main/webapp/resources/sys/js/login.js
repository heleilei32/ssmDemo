
$(document).ready(function() {
	if ($.cookie("rmbUser") == "true") {
		$("#ck_rmbUser").attr("checked", true);
		$("#cname").val($.cookie("username"));
		$("#cpasswd").val($.cookie("password"));
	}
});

//自动添加用户名密码  
function autoPwd() {
//	alert(1);
	if ($.cookie("rmbUser") == "true") {
		var username = $("#cname").val();
		if (username == $.cookie("username")) {
			$("#ck_rmbUser").attr("checked", true);
			$("#cpasswd").val($.cookie("password"));
		}
	}
}

//记住用户名密码  
function Save() {
	if ($("#ck_rmbUser").attr("checked")) {
		var str_username = $("#cname").val();
		var str_password = $("#cpasswd").val();
		$.cookie("rmbUser", "true", {
			expires : 7
		}); //存储一个带7天期限的cookie  
		$.cookie("username", str_username, {
			expires : 7
		});
		$.cookie("password", str_password, {
			expires : 7
		});
	} else {
		$.cookie("rmbUser", "false", {
			expire : -1
		});
		$.cookie("username", "", {
			expires : -1
		});
		$.cookie("password", "", {
			expires : -1
		});
	}
}

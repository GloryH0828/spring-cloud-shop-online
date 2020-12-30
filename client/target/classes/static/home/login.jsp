<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>登录</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
<meta name="format-detection" content="telephone=no">
<meta name="renderer" content="webkit">
<meta http-equiv="Cache-Control" content="no-siteapp" />

<link rel="stylesheet"
	href="<c:url value='/AmazeUI-2.4.2/assets/css/amazeui.min.css'/>" />
<link href="<c:url value='/css/dlstyle.css'/>" rel="stylesheet"
	type="text/css">

</head>

<body>

	<div class="login-boxtitle">
		<a href="home.html"><img alt="logo"
			src="<c:url value='/images/logobig.png'/>" />
		</a>
	</div>

	<div class="login-banner">
		<div class="login-main">
			<div class="login-banner-bg">
				<span></span><img src="<c:url value='/images/big.jpg'/> " />
			</div>
			<div class="login-box">

				<h3 class="title">登录商城</h3>

				<div class="clear"></div>

				<div class="login-form">
					<form action="<c:url value='/userServlet'/>" method="post" id="form1">
					<input type="hidden" name="action" value="login"/>
						<div class="user-name">
							<label for="user"><i class="am-icon-user"></i>
							</label> <input type="text" name="username" id="user" placeholder="用户名">
						</div>
						<div class="user-pass">
							<label for="password"><i class="am-icon-lock"></i>
							</label> <input type="password" name="password" id="password" placeholder="请输入密码">
						</div>
					</form>
				</div>

				<div class="login-links">
					<label for="remember-me"><input id="remember-me"
						type="checkbox">记住密码</label> <a href="#" class="am-fr">忘记密码</a>


				</div>
				<div class="am-cf">
					<input type="button" name="" value="登 录"
						class="am-btn am-btn-primary am-btn-sm" onclick="javascript:form1.submit();">
				</div>
				<div class="partner">
					<h3>
						${error}
					</h3>
					<h3>
						<a href="regist.jsp">注册</a>
					</h3>

				</div>

			</div>
		</div>
	</div>


	<div class="footer ">

		<div class="footer-bd ">
			<p>
				<a href="# ">关于我们</a> <a href="# ">合作伙伴</a> <a href="# ">联系我们</a> <a
					href="# ">网站地图</a> <em>© 2015-2025 版权所有.</em>
			</p>
		</div>
	</div>
</body>

</html>
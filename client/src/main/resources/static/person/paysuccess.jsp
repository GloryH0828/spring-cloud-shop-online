<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
<title>付款成功页面</title>
<link rel="stylesheet"  type="text/css" href="../AmazeUI-2.4.2/assets/css/amazeui.css"/>
<link href="<c:url value='/AmazeUI-2.4.2/assets/css/admin.css'/>" rel="stylesheet" type="text/css">
<link href="<c:url value='/basic/css/demo.css'/>" rel="stylesheet" type="text/css" />

<link href="<c:url value='/css/sustyle.css'/>" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<c:url value='/basic/js/jquery-1.7.min.js'/>"></script>

</head>

<body>


<!--顶部导航条 -->
<div class="am-container header">
		<ul class="message-l">
			<div class="topMessage">
				<div class="menu-hd">
					<a href="<c:url value='/home/login.jsp'/>" target="_top" class="h">亲，请登录</a>
					<a href="<c:url value='/home/regist.jsp'/>" target="_top">免费注册</a>
				</div>
			</div>
		</ul>
		<ul class="message-r">
			<div class="topMessage home">
				<div class="menu-hd">
					<a href="<c:url value='/index.html'/>" target="_top" class="h">商城首页</a>
				</div>
			</div>
			<div class="topMessage my-shangcheng">
				<div class="menu-hd MyShangcheng">
					<a href="#" target="_top"><i class="am-icon-user am-icon-fw"></i>个人中心</a>
				</div>
			</div>
			<div class="topMessage mini-cart">
				<div class="menu-hd">
					<a id="mc-menu-hd" href="<c:url value='/home/cart.jsp'/>"
						target="_top"><i class="am-icon-shopping-cart  am-icon-fw"></i><span>购物车</span><strong
						id="J_MiniCartNum" class="h">0</strong>
					</a>
				</div>
			</div>
			<div class="topMessage favorite">
				<div class="menu-hd">
					<a href="#" target="_top"><i class="am-icon-heart am-icon-fw"></i><span>收藏夹</span>
					</a>
				</div>
		</ul>
	</div>

<!--悬浮搜索框-->

<div class="nav white">
		<div class="logo">
			<img src="<c:url value='/images/logo.png'/>" />
		</div>
		<div class="logoBig">
			<img src="<c:url value='/images/logobig.png'/>" />
		</div>

		<div class="search-bar pr">
			<a name="index_none_header_sysc" href="#"></a>
			<form action="<c:url value='/productServlet'/>" method="post">
				<input type="hidden" name="action" value="findAll" /> <input
					id="searchInput" name="svalue" type="text" placeholder="搜索"
					autocomplete="off"> <input id="ai-topsearch"
					class="submit am-btn" value="搜索" index="1" type="submit">
			</form>
		</div>
	</div>

<div class="clear"></div>



<div class="take-delivery">
 <div class="status">
   <h2>您已成功付款</h2>
   <div class="successInfo">
     <ul>
       <li>付款金额<em>¥9.90</em></li>
       <div class="user-info">
         <p>收货人：艾迪</p>
         <p>联系电话：15871145629</p>
         <p>收货地址：湖北省 武汉市 武昌区 东湖路75号众环大厦</p>
       </div>
             请认真核对您的收货信息，如有错误请联系客服
                               
     </ul>
     <div class="option">
       <span class="info">您可以</span>
        <a href="../person/order.html" class="J_MakePoint">查看<span>已买到的宝贝</span></a>
        <a href="../person/orderinfo.html" class="J_MakePoint">查看<span>交易详情</span></a>
     </div>
    </div>
  </div>
</div>


<div class="footer" >

 <div class="footer-bd">
 <p>
 <a href="#">关于我们</a>
 <a href="#">合作伙伴</a>
 <a href="#">联系我们</a>
 <a href="#">网站地图</a>
 <em>© 2015-2025 版权所有. </em>
 </p>
 </div>
</div>


</body>
</html>

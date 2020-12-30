<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">

		<title>首页</title>

		<link href="<c:url value='/AmazeUI-2.4.2/assets/css/amazeui.css'/>" rel="stylesheet" type="text/css" />
		<link href="<c:url value='/AmazeUI-2.4.2/assets/css/admin.css'/>" rel="stylesheet" type="text/css" />

		<link href="<c:url value='/basic/css/demo.css'/>" rel="stylesheet" type="text/css" />

		<link href="<c:url value='/css/hmstyle.css'/>" rel="stylesheet" type="text/css" />
		<script src="<c:url value='/AmazeUI-2.4.2/assets/js/jquery.min.js'/>"></script>
		<script src="<c:url value='/AmazeUI-2.4.2/assets/js/amazeui.min.js'/>"></script>

	</head>

	<body>
		<div class="hmtop">
			
			
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
						<div class="menu-hd"><a href="#" target="_top" class="h">商城首页</a></div>
					</div>
					<div class="topMessage my-shangcheng">
						<div class="menu-hd MyShangcheng"><a href="#" target="_top"><i class="am-icon-user am-icon-fw"></i>个人中心</a></div>
					</div>
					<div class="topMessage mini-cart">
						<div class="menu-hd"><a id="mc-menu-hd" href="#" target="_top"><i class="am-icon-shopping-cart  am-icon-fw"></i><span>购物车</span><strong id="J_MiniCartNum" class="h">0</strong></a></div>
					</div>
					<div class="topMessage favorite">
						<div class="menu-hd"><a href="#" target="_top"><i class="am-icon-heart am-icon-fw"></i><span>收藏夹</span></a></div>
				</ul>
				</div>

				<!--悬浮搜索框-->

				<div class="nav white">
					<div class="logo"><img src="<c:url value='/images/logo.png'/>" /></div>
					<div class="logoBig">
						<li><img src="<c:url value='/images/logobig.png'/>" /></li>
					</div>

					<div class="search-bar pr">
						<a name="index_none_header_sysc" href="#"></a>
						<form>
							<input id="searchInput" name="index_none_header_sysc" type="text" placeholder="搜索" autocomplete="off">
							<input id="ai-topsearch" class="submit am-btn" value="搜索" index="1" type="submit">
						</form>
					</div>
				</div>
			<!--悬浮搜索框结束-->
				<div class="clear"></div>
			</div>
			<!--顶部导航条结束 -->
			
			
									
			
			<div class="listMain">"
				
			        
					  
								<div class="nav-table">
					   <div class="long-title"><span class="all-goods">全部分类</span></div>
					   <div class="nav-cont">
							<ul>
								<li class="index"><a href="#">首页</a></li>
                                <li class="qc"><a href="#">购物车</a></li>
                                <li class="qc"><a href="#">我的订单</a></li>
                                <li class="qc last"><a href="#">个人中心</a></li>
							</ul>
						    
						</div>
			</div>
				
		       					
					
				
			</div>
			
			
			<div class="shopMainbg">
			

					<!--甜点-->
					
					<div class="am-container ">
						<div class="shopTitle ">
							<h4>甜品</h4>
							<h3>每一道甜品都有一个故事</h3>
							
							<span class="more ">
                    <a class="more-link " href="# ">更多美味</a>
                        </span>
						</div>
					</div>
					     
					
					<div class="am-g am-g-fixed flood method3 ">
						<ul class="am-thumbnails ">
							<li>
								<div class="list ">
									<a href="# ">
										<img src="../images/act1.png " />
										<div class="pro-title ">饮品</div>
										<span class="e-price ">￥29.90</span>
									</a>
								</div>
							</li>
							<li>
								<div class="list ">
									<a href="# ">
										<img src="../images/act2.png" />
										<div class="pro-title ">雪之恋和风大福</div>
										<span class="e-price ">仅售：¥13.8</span>
									</a>
								</div>
							</li>
							<li>
								<div class="list ">
									<a href="# ">
										<img src="../images/act3.png " />
										<div class="pro-title ">小优布丁</div>
										<span class="e-price ">￥8.90</span>
									</a>
								</div>
							</li>
							<li>
								<div class="list ">
									<a href="# ">
										<img src="../images/5.jpg " />
										<div class="pro-title ">雪之恋和风大福</div>
										<span class="e-price ">￥29.90</span>
									</a>
								</div>
							</li>
							<li>
								<div class="list ">
									<a href="# ">
										<img src="../images/tj2.png " />
										<div class="pro-title ">巧克力</div>
										<span class="e-price ">￥8.90</span>
									</a>
								</div>
							</li>
							<li>
								<div class="list ">
									<a href="# ">
										<img src="../images/cp.jpg " />
										<div class="pro-title ">萨拉米 1+1小鸡腿</div>
										<span class="e-price ">￥29.90</span>
									</a>
								</div>
							</li>
							<li>
								<div class="list ">
									<a href="# ">
										<img src="../images/act3.png " />
										<div class="pro-title ">松子</div>
										<span class="e-price ">￥88.90</span>
									</a>
								</div>
							</li>
							<li>
								<div class="list ">
									<a href="# ">
										<img src="../images/cp.jpg " />
										<div class="pro-title ">萨拉米 1+1小鸡腿</div>
										<span class="e-price ">￥29.90</span>
									</a>
								</div>
							</li>
							<li>
								<div class="list ">
									<a href="# ">
										<img src="../images/cp2.jpg " />
										<div class="pro-title ">ZEK 原味海苔</div>
										<span class="e-price ">￥8.90</span>
									</a>
								</div>
							</li>
							<li>
								<div class="list ">
									<a href="# ">
										<img src="../images/tj.png " />
										<div class="pro-title ">香肠</div>
										<span class="e-price ">￥29.90</span>
									</a>
								</div>
							</li>
							<li>
								<div class="list ">
									<a href="# ">
										<img src="../images/cp2.jpg " />
										<div class="pro-title ">ZEK 原味海苔</div>
										<span class="e-price ">￥8.90</span>
									</a>
								</div>
							</li>
							
							
						
						</ul>
						
					</div>
					
					<div class="footer ">
						
						<div class="footer-bd ">
							<p>
								<a href="# ">关于我们</a>
								<a href="# ">合作伙伴</a>
								<a href="# ">联系我们</a>
								<a href="# ">网站地图</a>
								<em>© 2015-2025  版权所有. </em>
							</p>
						</div>
					</div>
			
			</div>
		</div>
		
		<!--引导 -->

		
		

		
		<script>
			window.jQuery || document.write('<script src="basic/js/jquery.min.js "><\/script>');
		</script>
		<script type="text/javascript " src="<c:url value='/basic/js/quick_links.js'/> "></script>
	</body>

</html>
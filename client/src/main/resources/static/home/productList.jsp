<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">

		<title>搜索页面</title>

		<link href="<c:url value='/AmazeUI-2.4.2/assets/css/amazeui.css'/>" rel="stylesheet" type="text/css" />
		<link href="<c:url value='/AmazeUI-2.4.2/assets/css/admin.css'/>" rel="stylesheet" type="text/css" />

		<link href="<c:url value='/basic/css/demo.css'/>" rel="stylesheet" type="text/css" />

		<link href="<c:url value='/css/seastyle.css'/>" rel="stylesheet" type="text/css" />

		<script type="text/javascript" src="<c:url value='/basic/js/jquery-1.7.min.js'/>"></script>
		<script type="text/javascript" src="<c:url value='/js/script.js'/>"></script>
	</head>

	<body>

		<!--顶部导航条 -->
		<div class="am-container header">
			<ul class="message-l">
				<div class="topMessage">
					<div class="menu-hd">
						<a href="#" target="_top" class="h">亲，请登录</a>
						<a href="#" target="_top">免费注册</a>
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
				<div class="logo"><img src="<c:url value='/images/logobig.png'/>" /></div>
				<div class="logoBig">
					<li><img src="../images/logobig.png" /></li>
				</div>

				<div class="search-bar pr">
					<a name="index_none_header_sysc" href="#"></a>
					<form>
						<input id="searchInput" name="index_none_header_sysc" type="text" placeholder="搜索" autocomplete="off">
						<input id="ai-topsearch" class="submit am-btn"  value="搜索" index="1" type="submit">
					</form>
				</div>
			</div>

			<div class="clear"></div>
			<b class="line"></b>
           <div class="search">
			<div class="search-list">
			<div class="nav-table">
					   <div class="long-title"><span class="all-goods">全部分类</span></div>
					   <div class="nav-cont">
							<ul>
								<li class="index"><a href="#">首页</a></li>
                                <li class="qc"><a href="#">闪购</a></li>
                                <li class="qc"><a href="#">限时抢</a></li>
                                <li class="qc"><a href="#">团购</a></li>
                                <li class="qc last"><a href="#">大包装</a></li>
							</ul>
						    
						</div>
			</div>
			
				
					<div class="am-g am-g-fixed">
						<div class="am-u-sm-12 am-u-md-12">
	                  	
							<!--<div class="search-content">-->
								<div class="sort">
									<li class="first"><a title="综合">综合排序</a></li>
									<li><a title="销量">销量排序</a></li>
									<li><a title="价格">价格优先</a></li>
									<li class="big"><a title="评价" href="#">评价为主</a></li>
								</div>
								<div class="clear"></div>

								<ul class="am-avg-sm-2 am-avg-md-3 am-avg-lg-4 boxes">
									<li>
										<div class="i-pic limit">
											<img src="../images/imgsearch1.jpg" />											
											<p class="title fl">【良品铺子旗舰店】手剥松子218g 坚果炒货零食新货巴西松子包邮</p>
											<p class="price fl">
												<b>¥</b>
												<strong>56.90</strong>
											</p>
											<p class="number fl">
												销量<span>1110</span>
											</p>
										</div>
									</li>
									<li>
										<div class="i-pic limit">
											
											<img src="../images/imgsearch1.jpg" />
											<p class="title fl">手剥松子218g 坚果炒货零食新货巴西松子包邮</p>
											<p class="price fl">
												<b>¥</b>
												<strong>56.90</strong>
											</p>
											<p class="number fl">
												销量<span>1110</span>
											</p>
										</div>
									</li>
									<li>
										<div class="i-pic limit">
											
											<img src="../images/imgsearch1.jpg" />
											<p class="title fl">【良品铺子旗舰店】手剥松子218g 坚果炒货零食新货巴西松子包邮</p>
											<p class="price fl">
												<b>¥</b>
												<strong>56.90</strong>
											</p>
											<p class="number fl">
												销量<span>1110</span>
											</p>
										</div>
									</li>
									<li>
										<div class="i-pic limit">
											
											<img src="../images/imgsearch1.jpg" />
											<p class="title fl">手剥松子218g 坚果炒货零食新货巴西松子包邮</p>
											<p class="price fl">
												<b>¥</b>
												<strong>56.90</strong>
											</p>
											<p class="number fl">
												销量<span>1110</span>
											</p>
										</div>
									</li>
									<li>
										<div class="i-pic limit">
											
											<img src="../images/imgsearch1.jpg" />
											<p class="title fl">【良品铺子旗舰店】手剥松子218g 坚果炒货零食新货巴西松子包邮</p>
											<p class="price fl">
												<b>¥</b>
												<strong>56.90</strong>
											</p>
											<p class="number fl">
												销量<span>1110</span>
											</p>
										</div>
									</li>
									<li>
										<div class="i-pic limit">
											
											<img src="../images/imgsearch1.jpg" />
											<p class="title fl">【良品铺子旗舰店】手剥松子218g 坚果炒货零食新货巴西松子包邮</p>
											<p class="price fl">
												<b>¥</b>
												<strong>56.90</strong>
											</p>
											<p class="number fl">
												销量<span>1110</span>
											</p>
										</div>
									</li>
									<li>
										<div class="i-pic limit">
											
											<img src="../images/imgsearch1.jpg" />
											<p class="title fl">【良品铺子旗舰店】手剥松子218g 坚果炒货零食新货巴西松子包邮</p>
											<p class="price fl">
												<b>¥</b>
												<strong>56.90</strong>
											</p>
											<p class="number fl">
												销量<span>1110</span>
											</p>
										</div>
									</li>
									<li>
										<div class="i-pic limit">
											
											<img src="../images/imgsearch1.jpg" />
											<p class="title fl">【良品铺子旗舰店】手剥松子218g 坚果炒货零食新货巴西松子包邮</p>
											<p class="price fl">
												<b>¥</b>
												<strong>56.90</strong>
											</p>
											<p class="number fl">
												销量<span>1110</span>
											</p>
										</div>
									</li>
									<li>
										<div class="i-pic limit">
											
											<img src="../images/imgsearch1.jpg" />
											<p class="title fl">【良品铺子旗舰店】手剥松子218g 坚果炒货零食新货巴西松子包邮</p>
											<p class="price fl">
												<b>¥</b>
												<strong>56.90</strong>
											</p>
											<p class="number fl">
												销量<span>1110</span>
											</p>
										</div>
									</li>
									<li>
										<div class="i-pic limit">
											
											<img src="../images/imgsearch1.jpg" />
											<p class="title fl">【良品铺子旗舰店】手剥松子218g 坚果炒货零食新货巴西松子包邮</p>
											<p class="price fl">
												<b>¥</b>
												<strong>56.90</strong>
											</p>
											<p class="number fl">
												销量<span>1110</span>
											</p>
										</div>
									</li>
									<li>
										<div class="i-pic limit">
											
											<img src="../images/imgsearch1.jpg" />
											<p class="title fl">【良品铺子旗舰店】手剥松子218g 坚果炒货零食新货巴西松子包邮</p>
											<p class="price fl">
												<b>¥</b>
												<strong>56.90</strong>
											</p>
											<p class="number fl">
												销量<span>1110</span>
											</p>
										</div>
									</li>
									<li>
										<div class="i-pic limit">
											
											<img src="../images/imgsearch1.jpg" />
											<p class="title fl">【良品铺子旗舰店】手剥松子218g 坚果炒货零食新货巴西松子包邮</p>
											<p class="price fl">
												<b>¥</b>
												<strong>56.90</strong>
											</p>
											<p class="number fl">
												销量<span>1110</span>
											</p>
										</div>
									</li>
								</ul>
							<!--</div>-->
							
							<div class="clear"></div>
							<!--分页 -->
							<ul class="am-pagination am-pagination-right">
								<li class="am-disabled"><a href="#">&laquo;</a></li>
								<li class="am-active"><a href="#">1</a></li>
								<li><a href="#">2</a></li>
								<li><a href="#">3</a></li>
								<li><a href="#">4</a></li>
								<li><a href="#">5</a></li>
								<li><a href="#">&raquo;</a></li>
							</ul>

						</div>
					</div>
					<div class="footer">
						
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
				</div>

			</div>

		
		<script>
			window.jQuery || document.write('<script src="basic/js/jquery-1.9.min.js"><\/script>');
		</script>
		<script type="text/javascript" src="../basic/js/quick_links.js"></script>

<div class="theme-popover-mask"></div>

	</body>

</html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<div class="header_agileits">

	<c:set var="theString" value="${pageContext.request.requestURI }" />

	<c:if test="${fn:contains(theString, 'home.jsp')}">
		<div class="logo">
			<h1>
				<a class="navbar-brand"
					href="${pageContext.request.contextPath}/home"><span>House</span></a>
				<a class="navbar-brand"
					href="${pageContext.request.contextPath}/home"> <i>
						Booking</i></a>
			</h1>
		</div>
		<div class="overlay overlay-contentpush">
			<button type="button" class="overlay-close">
				<i class="fa fa-times" aria-hidden="true"></i>
			</button>

			<nav>
				<ul>
					<li><a href="${pageContext.request.contextPath}/home"
						class="active">Home</a></li>
					<li><a href="${pageContext.request.contextPath}/about">About</a></li>
					<li><a href="${pageContext.request.contextPath}/error">Team</a></li>
					<c:if test="${usersession != null }">
						<li><a href="${pageContext.request.contextPath}/log-out">Log
								out</a></li>
					</c:if>
					<c:if test="${usersession == null }">
						<li><a href="${pageContext.request.contextPath}/login">Login</a></li>
						<li><a href="${pageContext.request.contextPath}/sign-up">Sign up</a></li>
					</c:if>

				</ul>
			</nav>
		</div>
		<div class="mobile-nav-button">
			<button id="trigger-overlay" type="button">
				<i class="fa fa-bars" aria-hidden="true"></i>
			</button>
		</div>
		
		<!-- search -->

		<!-- //search -->

		<!-- search -->
		<div class="search_w3ls_agileinfo">
			<div>
				<div class="cd-main-header">
					<ul class="cd-header-buttons">
						<li><a class="cd-search-trigger" href="#cd-search"> <span></span></a></li>
					</ul>
				</div>
				<div id="cd-search" class="cd-search">
					<form action="#" method="post">
						<input name="Search" type="search"
							placeholder="Click enter after typing...">
					</form>
				</div>
			</div>
		</div>

		<!-- //search -->
		
	</c:if>

	<c:if test="${not fn:contains(theString, 'home.jsp')}">
		<div class="logo inner_page_log">
			<h1>
				<a class="navbar-brand"
					href="${pageContext.request.contextPath}/home"><span>House</span>
					<i>Booking</i></a>
			</h1>
		</div>
		<div class="overlay overlay-contentpush">
			<button type="button" class="overlay-close">
				<i class="fa fa-times" aria-hidden="true"></i>
			</button>

			<nav>
				<ul>
					<li><a href="${pageContext.request.contextPath}/home"
						class="active">Home</a></li>
					<li><a href="${pageContext.request.contextPath}/about">About</a></li>
					<li><a href="${pageContext.request.contextPath}/error">Team</a></li>
					<c:if test="${usersession != null }">
						<li><a href="${pageContext.request.contextPath}/log-out">Log
								out</a></li>
					</c:if>
					<c:if test="${usersession == null }">
						<li><a href="${pageContext.request.contextPath}/login">Login</a></li>
						<li><a href="${pageContext.request.contextPath}/sign-up">Sign up</a></li>
					</c:if>
				</ul>
			</nav>
		</div>
		<div class="mobile-nav-button">
			<button id="trigger-overlay" type="button">
				<i class="fa fa-bars" aria-hidden="true"></i>
			</button>
		</div>
		<div class="top_nav_right">
					<div class="shoecart shoecart2 cart cart box_1">
						<form action="#" method="post" class="last">
							<input type="hidden" name="cmd" value="_cart">
							<input type="hidden" name="display" value="1">
							<button class="top_shoe_cart" type="submit" name="submit" value=""><i class="fa fa-cart-arrow-down" aria-hidden="true"></i></button>
						</form>
					</div>
				</div>
		
	</c:if>
	<div class="clearfix"></div>
</div>
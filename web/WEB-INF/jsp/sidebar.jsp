
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="tpl-left-nav tpl-left-nav-hover">
	<div class="tpl-left-nav-title">
		功能菜单
	</div>
	<div class="tpl-left-nav-list">
		<ul class="tpl-left-nav-menu">
			<li class="tpl-left-nav-item">
				<a href="${pageContext.request.contextPath}/main" class="nav-link active"> <i
					class="am-icon-home"></i> <span>首页</span> </a>
			</li>
			<li class="tpl-left-nav-item">
				<a href="javascript:;"
					class="nav-link tpl-left-nav-link-list active"> <i
					class="am-icon-folder"></i> <span>委托人管理</span> </a>
					<ul class="tpl-left-nav-sub-menu" style="display: block">
						<li>
							<a href="${pageContext.request.contextPath}/list"> <i
								class="am-icon-angle-right"></i> <span>委托人管理</span> </a>
							<a href="${pageContext.request.contextPath}/allCase"> <i
									class="am-icon-angle-right"></i> <span>事件类别管理</span> </a>
						</li>
					</ul>
			</li>
			<li class="tpl-left-nav-item">
				<a href="javascript:;"
				   class="nav-link tpl-left-nav-link-list active"> <i
						class="am-icon-folder"></i> <span>律师管理</span> </a>
				<ul class="tpl-left-nav-sub-menu" style="display: block">
					<li>
						<a href="${pageContext.request.contextPath}/listLawyer"> <i
								class="am-icon-angle-right"></i> <span>律师信息管理</span> </a>
					</li>
				</ul>
			</li>
<%--			<li class="tpl-left-nav-item">--%>
<%--				<a href="javascript:;"--%>
<%--				   class="nav-link tpl-left-nav-link-list active"> <i--%>
<%--						class="am-icon-folder"></i> <span>个人设置</span> </a>--%>
<%--				<ul class="tpl-left-nav-sub-menu" style="display: block">--%>
<%--					<li>--%>
<%--						<a href="/person/person_info.jsp"> <i--%>
<%--								class="am-icon-angle-right"></i> <span>个人信息修改</span> </a>--%>
<%--						<a href="/person/updatepwd.jsp"> <i class="am-icon-angle-right"></i>--%>
<%--							<span>密码修改</span> </a>--%>
<%--					</li>--%>
<%--				</ul>--%>
<%--			</li>--%>

		</ul>
	</div>
</div>

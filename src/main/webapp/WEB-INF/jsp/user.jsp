<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="includes/header.jsp"%>

<div class="panel panel-primary">
  <div class="panel-heading">
    <h3 class="panel-title">Profile</h3>
  </div>
  <div class="panel-body">
  	<dl class="dl-horizontal">
	  <dt>Name</dt>
	  <dd><c:out value="${user.name}" /></dd>
	  <dt>Email</dt>
	  <dd><c:out value="${user.email}" /></dd>
	  <dt>Roles</dt>
	  <dd><c:out value="${user.roles}" /></dd>
	</dl>
  </div>
</div>

<%@include file="includes/footer.jsp"%>     

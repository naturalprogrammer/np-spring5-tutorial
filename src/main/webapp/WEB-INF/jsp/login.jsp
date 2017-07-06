<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="includes/header.jsp"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<div class="panel panel-primary">
  <div class="panel-heading">
    <h3 class="panel-title">Please sign in</h3>
  </div>
  <div class="panel-body">
	<form:form>
	
	  <div class="form-group">
	    <label for="email">Email address</label>
	    <input name="username" id="email" type="email" class="form-control" placeholder="Email" />
		<p class="help-block">Enter your email address</p>
	  </div>
	  <div class="form-group">
	    <label for="password">Password</label>
	    <input name="password" id="password" type="password" class="form-control" placeholder="Password" />
	  </div>
	  <button type="submit" class="btn btn-primary">Sign In</button>
	</form:form>
  </div>
</div>

<%@include file="includes/footer.jsp"%>     

<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="includes/header.jsp"%>

<div class="panel panel-primary">
  <div class="panel-heading">
    <h3 class="panel-title">Forgot password?</h3>
  </div>
  <div class="panel-body">
	<form:form modelAttribute="forgotPasswordCommand">
	
	  <form:errors cssClass="error"/>
	  
	  <div class="form-group">
	    <form:label path="email">Email address</form:label>
	    <form:input path="email" type="email" class="form-control" id="exampleInputEmail1" placeholder="Email" />
	    <form:errors path="email" cssClass="error" />
	  </div>
	  <button type="submit" class="btn btn-primary">Reset Password</button>
	</form:form>
  </div>
</div>

<%@include file="includes/footer.jsp"%>     

<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="includes/header.jsp"%>

<div class="panel panel-primary">
  <div class="panel-heading">
    <h3 class="panel-title">Reset your password</h3>
  </div>
  <div class="panel-body">
	<form:form modelAttribute="resetPasswordCommand">
	
	  <form:errors cssClass="error"/>
	  
	  <div class="form-group">
	    <form:label path="password">Password</form:label>
	    <form:input path="password" type="password" class="form-control" id="exampleInputPassword1" placeholder="Password" />
	    <form:errors path="password" cssClass="error" />
	  </div>
	  <div class="form-group">
	    <form:label path="retypePassword">Retype Password</form:label>
	    <form:input path="retypePassword" type="password" class="form-control" id="exampleInputPassword2" placeholder="Retype Password" />
	    <form:errors path="retypePassword" cssClass="error" />
	  </div>
	  <button type="submit" class="btn btn-primary">Reset Password</button>
	</form:form>
  </div>
</div>

<%@include file="includes/footer.jsp"%>     

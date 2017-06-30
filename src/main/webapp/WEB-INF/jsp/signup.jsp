<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="includes/header.jsp"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<div class="panel panel-primary">
  <div class="panel-heading">
    <h3 class="panel-title">Please signup</h3>
  </div>
  <div class="panel-body">
	<form:form modelAttribute="user">
	
	  <form:errors cssClass="error"/>
	  
	  <div class="form-group">
	    <form:label path="email">Email address</form:label>
	    <form:input path="email" type="email" class="form-control" id="exampleInputEmail1" placeholder="Email" />
	    <form:errors path="email" cssClass="error" />
	  </div>
	  <div class="form-group">
	    <form:label path="name">Name</form:label>
	    <form:input path="name" type="text" class="form-control" id="exampleInputName1" placeholder="Name" />
	    <form:errors path="name" cssClass="error" />
	  </div>
	  <div class="form-group">
	    <form:label path="password">Password</form:label>
	    <form:input path="password" type="password" class="form-control" id="exampleInputPassword1" placeholder="Password" />
	    <form:errors path="password" cssClass="error" />
	  </div>
	  <button type="submit" class="btn btn-primary">Submit</button>
	</form:form>
  </div>
</div>

<%@include file="includes/footer.jsp"%>     

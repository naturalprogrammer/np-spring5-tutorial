<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="includes/header.jsp"%>

<div class="panel panel-primary">
  <div class="panel-heading">
    <h3 class="panel-title">Edit profile</h3>
  </div>
  <div class="panel-body">
	<form:form modelAttribute="user">
	
	  <form:errors cssClass="error"/>
	  
	  <div class="form-group">
	    <form:label path="name">Name</form:label>
	    <form:input path="name" type="text" class="form-control" id="exampleInputName1" placeholder="Name" />
	    <form:errors path="name" cssClass="error" />
	  </div>
	  
	  <sec:authorize access="hasRole('ADMIN')">
		  <div class="form-group">
		    <form:label path="roles">Roles</form:label>
		    <form:input path="roles" type="text" class="form-control" id="exampleInputRoles1" placeholder="Roles" />
		    <form:errors path="roles" cssClass="error" />
		    <p class="help-block">Enter comma separated roles</p>
		  </div>
	  </sec:authorize>
	  
	  <button type="submit" class="btn btn-primary">Update</button>
	</form:form>
  </div>
</div>

<%@include file="includes/footer.jsp"%>     

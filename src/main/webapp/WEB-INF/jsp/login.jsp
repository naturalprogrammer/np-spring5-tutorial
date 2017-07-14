<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="includes/header.jsp"%>

<div class="panel panel-primary">
  <div class="panel-heading">
    <h3 class="panel-title">Please sign in</h3>
  </div>
  <div class="panel-body">
  
  	<c:if test="${param.logout != null}">
  		<div class="alert alert-success">
  			You have been logged out
  		</div>
  	</c:if>
  	
  	<c:if test="${param.error != null}">
  		<div class="alert alert-danger">
  			Failed to login.
  			<c:if test="${SPRING_SECURITY_LAST_EXCEPTION != null}">
  				Reason: <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}" />
  			</c:if>
  		</div>
  	</c:if>

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
	  
	  <div class="checkbox">
	    <label>
	      <input type="checkbox" name="remember-me"> Remember Me
	    </label>
	  </div>
	  
	  <button type="submit" class="btn btn-primary">Sign In</button>
	</form:form>
  </div>
</div>

<%@include file="includes/footer.jsp"%>     

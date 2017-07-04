<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="includes/header.jsp"%>

<div class="alert alert-danger" role="alert">
There was an unexpected error (type=${error}, status=${status}): <strong>${message}</strong>
</div>

<%@include file="includes/footer.jsp"%>     

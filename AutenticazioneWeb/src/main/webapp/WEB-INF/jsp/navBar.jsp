<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import ="com.corso.vo.*, java.util.*" %>
<% UtenteVO utente = (UtenteVO) session.getAttribute("utente");
    if(utente!=null){%>
        <%@include  file="../../resources/html/navBarLogged.html" %>
    <%} else {%>
        <%@include  file="../../resources/html/navBarNotLogged.html" %>
    <%}
%>
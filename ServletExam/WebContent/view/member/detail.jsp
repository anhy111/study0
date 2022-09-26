<<<<<<< HEAD
<%@page import="kr.or.ddit.member.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	MemberVO mv = (MemberVO)request.getAttribute("mv");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 상세 정보</title>
</head>
<body>
	<table border="2">
		<tr>
			<td>I D :</td>
			<td><%=mv.getMemId() %></td>
		</tr>
		<tr>
			<td>이름:</td>
			<td><%=mv.getMemName() %></td>
		</tr>
		<tr>
			<td>전화번호 :</td>
			<td><%=mv.getMemTel() %></td>
		</tr>
		<tr>
			<td>주소 :</td>
			<td>
				<%=mv.getMemAddr() %>	
			</td>
		</tr>
		</tr>
=======
<%@page import="kr.or.ddit.common.vo.AtchFileVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.member.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	MemberVO mv = (MemberVO)request.getAttribute("mv");

	List<AtchFileVO> atchFileList = (List<AtchFileVO>)request.getAttribute("atchFileList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 상세 정보</title>
</head>
<body>
	<table border="2">
		<tr>
			<td>I D :</td>
			<td><%=mv.getMemId() %></td>
		</tr>
		<tr>
			<td>이름:</td>
			<td><%=mv.getMemName() %></td>
		</tr>
		<tr>
			<td>전화번호 :</td>
			<td><%=mv.getMemTel() %></td>
		</tr>
		<tr>
			<td>주소 :</td>
			<td>
				<%=mv.getMemAddr() %>	
			</td>
		</tr>
		<tr>
			<td>첨부파일:</td>
			<td>
				<%
					if(atchFileList != null){
						for(AtchFileVO fileVO : atchFileList){
				%>
						<div><a href="<%=request.getContextPath() %>/filedown.do?fileId=<%= fileVO.getAtchFileId()%>&fileSn=<%=fileVO.getFileSn()%>"><%=fileVO.getOrignlFileNm() %></a></div>		
				<%			
						}
					}
				%>
			</td>
		
		</tr>
		<tr>
>>>>>>> refs/remotes/origin/main
			<td colspan="2">
				<a href="list.do">[목록]</a>
				<a href="update.do?memId=<%=mv.getMemId() %>">[회원정보 수정]</a>
				<a href="delete.do?memId=<%=mv.getMemId() %>">[회원정보 삭제]</a>
			</td>
		<tr>
	</table>
</body>
</html>
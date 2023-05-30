<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="constants.ForwardConst" %>
<%@ page import="constants.AttributeConst" %>

<c:set var="actEmp" value="${ForwardConst.ACT_EMP.getValue()}" />
<c:set var="actRep" value="${ForwardConst.ACT_REP.getValue()}" />
<c:set var="commIdx" value="${ForwardConst.CMD_INDEX.getValue()}" />
<c:set var="commEdt" value="${ForwardConst.CMD_EDIT.getValue()}" />
<c:set var="commApr" value="${ForwardConst.CMD_APPROVE.getValue()}" />

<c:import url="/WEB-INF/views/layout/app.jsp">
    <c:param name="content">

        <h2>日報 詳細ページ</h2>

        <table>
            <tbody>
                <tr>
                    <th>氏名</th>
                    <td><c:out value="${report.employee.name}" /></td>
                </tr>
                <tr>
                    <th>日付</th>
                    <fmt:parseDate value="${report.reportDate}" pattern="yyyy-MM-dd" var="reportDay" type="date" />
                    <td><fmt:formatDate value='${reportDay}' pattern='yyyy-MM-dd' /></td>
                </tr>
                <tr>
                    <th>内容</th>
                    <td><pre><c:out value="${report.content}" /></pre></td>
                </tr>
                <tr>
                    <th>登録日時</th>
                    <fmt:parseDate value="${report.createdAt}" pattern="yyyy-MM-dd'T'HH:mm:ss" var="createDay" type="date" />
                    <td><fmt:formatDate value="${createDay}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
                </tr>
                <tr>
                    <th>更新日時</th>
                    <fmt:parseDate value="${report.updatedAt}" pattern="yyyy-MM-dd'T'HH:mm:ss" var="updateDay" type="date" />
                    <td><fmt:formatDate value="${updateDay}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
                </tr>
            </tbody>
        </table>
            <c:if test="${sessionScope.login_employee.id == report.employee.id}">
            <p>
                <a href="<c:url value='?action=${actRep}&command=${commEdt}&id=${report.id}' />">この日報を編集する</a>
            </p>
            </c:if>

        <c:if test="${sessionScope.login_employee != null}">
             <c:if test="${sessionScope.login_employee.mgrFlag == AttributeConst.ROLE_MGR.getIntegerValue()}">
             <form method="POST" action="<c:url value='?action=${actRep}&command=${commApr}' />">
                <label for="${AttributeConst.REP_APPROVED_FLAG.getValue()}"></label>
                <select name="${AttributeConst.REP_APPROVED_FLAG.getValue()}" id="${AttributeConst.REP_APPROVED_FLAG.getValue()}">
                     <option value="${AttributeConst.REP_NOT_APPROVED.getIntegerValue()}"<c:if test="${report.approvedFlag == AttributeConst.REP_NOT_APPROVED.getIntegerValue()}"> selected</c:if>>未承認</option>
                     <option value="${AttributeConst.REP_APPROVED_TRUE.getIntegerValue()}"<c:if test="${report.approvedFlag == AttributeConst.REP_APPROVED_TRUE.getIntegerValue()}"> selected</c:if>>承認</option>
                </select>
                <input type="hidden" name="${AttributeConst.REP_ID.getValue()}" value="${report.id}" />
                <input type="hidden" name="${AttributeConst.TOKEN.getValue()}" value="${_token}" />
                <button type="submit">更新</button>
                 </form>
              </c:if>
         </c:if>

        <p>
            <a href="<c:url value='?action=${actRep}&command=${commIdx}' />">一覧に戻る</a>
        </p>
    </c:param>
</c:import>
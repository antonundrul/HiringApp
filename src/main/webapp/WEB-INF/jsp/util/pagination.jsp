<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="/WEB-INF/jsp/util/baseTabLibs.jsp" %>

<%@ include file="/WEB-INF/jsp/util/baseCss.jsp" %>


<div>

    <nav aria-label="Navigation for countries">

        <ul class="pagination">

            <c:if test="${currentPage - 1 > 0}">
                <li class="page-item">
                    <a class="page-link"
                       href=${param.ref}?size=${size}&page=${currentPage-1}>
                        Назад
                    </a>
                </li>
            </c:if>

            <c:forEach begin="1" end="${pagesCount}" var="i">
                <c:choose>
                    <c:when test="${currentPage eq i}">
                        <li class="page-item active">
                            <a class="page-link">
                                    ${i}<span class="sr-only">(current)</span>
                            </a>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li class="page-item">
                            <a class="page-link"
                               href=${param.ref}?size=${size}&page=${i}>
                                    ${i}
                            </a>
                        </li>
                    </c:otherwise>
                </c:choose>
            </c:forEach>

            <c:if test="${currentPage lt pagesCount}">
                <li class="page-item">
                    <a class="page-link"
                       href=${param.ref}?size=${size}&page=${currentPage+1}>
                        Назад
                    </a>
                </li>
            </c:if>
        </ul>
    </nav>
</div>

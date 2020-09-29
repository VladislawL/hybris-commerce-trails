<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<jsp:useBean id="product" type="de.hybris.platform.commercefacades.product.data.ProductData" scope="request" />
<div class="tabbody" style="font-size: ${fontSize}">
    <div class="container">
        <div>
            Questions ${numberOfQuestionsToShow} ${product.questions.size()}
        </div>
        <c:if test="${product.questions.size() < numberOfQuestionsToShow}">
            <c:forEach var="question" items="${product.questions}">
                <div class="row">
                    <div>
                        <c:out value="${question.questionCustomer}" />
                    </div>
                    <div>
                        <c:out value="${question.question}" />
                    </div>
                    <div>
                        <c:out value="${question.answerCustomer}" />
                    </div>
                    <div>
                        <c:out value="${question.answer}" />
                    </div>
                </div>
            </c:forEach>
        </c:if>
        <c:if test="${product.questions.size() > numberOfQuestionsToShow}">
            <c:forEach var="i" begin="0" end="${numberOfQuestionsToShow}" >
                <div class="row">
                    <div>
                        <c:out value="${product.questions[i].questionCustomer}" />
                    </div>
                    <div>
                        <c:out value="${product.questions[i].question}" />
                    </div>
                    <div>
                        <c:out value="${product.questions[i].answerCustomer}" />
                    </div>
                    <div>
                        <c:out value="${product.questions[i].answer}" />
                    </div>
                </div>
            </c:forEach>
        </c:if>
    </div>
</div>
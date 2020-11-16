<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="common/header.jspf" %>
<div class="container hero">
    <style>
        a:hover {
            color: gray;
            text-decoration: none;
        }
        a:visited {
            color: green;
        }

    </style>
    <div class="container">
        <div class="row">

            <div style="width: 600px; margin-left: 230px">
                <%--starting previous post section--%>
                <c:forEach items="${userPost}" var="post">
                    <div class="panel-body">
                        <section class="post-heading">
                            <div class="row">
                                <div class="col-md-11">
                                    <div class="media">
                                        <div class="media-body">
                                            <a href="${pageContext.request.contextPath}/profile"
                                               class="anchor-username"><h4 class="media-heading"
                                                                           style="color: yellow; text-decoration: none;">${post.postBy}</h4>
                                            </a>
                                            <p class="anchor-time"
                                               style="color: #7abaff; font-size: smaller">${post.postTime}, ${post.postLocation}</p>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-1">
                                    <a href="#"><i class="glyphicon glyphicon-chevron-down"></i></a>
                                </div>
                            </div>
                        </section>
                        <section class="post-body">
                            <p style="color: white">${post.postBody}</p>
                        </section>
                        <section class="post-footer">
                            <hr>

                        </section>
                    </div>
                </c:forEach>

                <%--end previous post section--%>
            </div>

        </div>


    </div>


</div>
</div>
</div>
</div>
<%@ include file="common/footer.jspf" %>

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
                <form:form action="${pageContext.request.contextPath}/savePost" modelAttribute="post">
                    <form:textarea path="postBody" placeholder="What are you up to?" class="form-control" rows="5"
                                   id="comment"></form:textarea>

                    <form:select aria-labelledby="dropdownMenuButton" path="postLocation"
                                 cssStyle="color: gray; margin: 3px">
                        <form:option value="" label="Location"/>
                        <form:options items="${location}" itemLabel="location" itemValue="location"></form:options>
                    </form:select>

                    <form:select aria-labelledby="dropdownMenuButton" path="isPrivate"
                                 cssStyle="color: gray; margin: 3px">
                        <form:option value="false" label="Privacy"/>
                        <form:option value="false" label="Public"/>
                        <form:option value="true" label="private"/>
                    </form:select>
                    <button style="margin-top: 10px;" class="btn btn-success pull-right">Post</button>
                </form:form>
                <br><br>
                <hr style="border: 4px dotted #926e6e; border-radius: 2px">
                <%--starting previous post section--%>

                <c:forEach items="${allPost}" var="post">
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

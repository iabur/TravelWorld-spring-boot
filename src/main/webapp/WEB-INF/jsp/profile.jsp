<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="common/header.jspf" %>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lobster">
<style>
    a:hover {
        color: gray;
        text-decoration: none;
    }

    a:visited {
        color: green;
    }

</style>
<div class="container hero">

    <div class="container">

        <div class="row">

            <div style="width: 600px; margin-left: 230px">
                <h1 style="font-family: Lobster, serif; color: #9fcdff">${userName}</h1>
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
                <hr style="height:2px;border-width:0;color:gray;background-color:gray; margin-top: 30px;">
                <%--starting previous post section--%>

                <div class="container">
                    <div class="col-md-12">
                        <div class="panel panel-default">
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
                                                           style="color: #7abaff">${post.postTime}, ${post.postLocation}</p>
                                                    </div>
                                                    <div class="float-right">
                                                        <button class="btn"><a href="#"><i class="fa fa-pencil-square-o"
                                                                                           aria-hidden="true"></i></a>
                                                        </button>
                                                    </div>
                                                    <div class="float-right">
                                                        <button class="btn"><a href="#"><i
                                                                class="fas fa-map-pin"></i></a></button>
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

                        </div>
                    </div>
                </div>

                <%--end previous post section--%>
            </div>

        </div>


    </div>


</div>
</div>
</div>
</div>
<%@ include file="common/footer.jspf" %>

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
                <h1 style="color: white">Edit Your Post</h1>
                <form:form action="${pageContext.request.contextPath}/editPost" modelAttribute="post">
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
                    <form:input path="postId" value="${postId}" type="hidden"/>
                    <button style="margin-top: 10px;" class="btn btn-success pull-right">Submit</button>
                </form:form>
            </div>

        </div>


    </div>


</div>
</div>
</div>
</div>
<%@ include file="common/footer.jspf" %>

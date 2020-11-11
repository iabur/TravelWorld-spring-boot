<%@ include file="common/header.jspf" %>
<div class="container hero" >
    <div class="container">
        <div class="row">

            <div style="width: 600px; margin-left: 230px">
                <form>
                    <textarea placeholder="What are you up to?" class="form-control" rows="5" id="comment"></textarea>
                    <div class="btn-group">
                            <div class="dropdown" style="margin: 5px">
                                <button class="btn btn-secondary dropdown-toggle btn btn-link btn-icon" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <i class="fa fa-map-marker"></i>
                                </button>
                                <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                                    <a class="dropdown-item" href="#">Action</a>
                                    <a class="dropdown-item" href="#">Another action</a>
                                    <a class="dropdown-item" href="#">Something else here</a>
                                </div>
                            </div>
                            <div class="dropdown " style="margin: 5px">
                                <button class="btn btn-secondary dropdown-toggle btn btn-link btn-icon" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <i class="fa fa-lock" aria-hidden="true"></i>
                                </button>
                                <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                                    <a class="dropdown-item" href="#">public</a>
                                    <a class="dropdown-item" href="#">private</a>
                                </div>
                            </div>
                        </div>
                    <button style="margin-top: 10px;" type="button" class="btn btn-success pull-right">Post</button>
                </form>
                <hr style="height:2px;border-width:0;color:gray;background-color:gray; margin-top: 30px;">
                <%--starting previous post section--%>
                <div class="container">
                    <div class="col-md-12">
                        <div class="panel panel-default">
                            <div class="panel-body">
                                <section class="post-heading">
                                    <div class="row">
                                        <div class="col-md-11">
                                            <div class="media">
                                                <div class="media-body">
                                                    <a href="#" class="anchor-username"><h4 class="media-heading" style="color: yellow">Bayu Darmantra</h4></a>
                                                    <a href="#" class="anchor-time" style="color: #7abaff">51 mins</a>
                                                </div>
                                                <div class="float-right">
                                                  <button class="btn"><a href="#"><i class="fa fa-pencil-square-o" aria-hidden="true"></i></a></button>
                                                </div>
                                                <div class="float-right">
                                                    <button class="btn"><a href="abc"><i class="fas fa-map-pin"></i></a></button>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-md-1">
                                            <a href="#"><i class="glyphicon glyphicon-chevron-down"></i></a>
                                        </div>
                                    </div>
                                </section>
                                <section class="post-body">
                                    <p style="color: white">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras
                                        turpis sem, dictum id bibendum eget, malesuada ut massa. Ut scel
                                        erisque nulla sed luctus dapibus. Nulla sit amet mi vitae purus sol
                                        licitudin venenatis. Praesent et sem urna. Integer vitae lectus nis
                                        l. Fusce sapien ante, tristique efficitur lorem et, laoreet ornare lib
                                        ero. Nam fringilla leo orci. Vivamus semper quam nunc, sed ornare magna dignissim sed. Etiam interdum justo quis risus
                                        efficitur dictum. Nunc ut pulvinar quam. N
                                        unc mollis, est a dapibus dignissim, eros elit tempor diam, eu tempus quam felis eu velit.</p>
                                </section>
                                <section class="post-footer">
                                    <hr>

                                </section>
                            </div>
                            <div class="panel-body">
                                <section class="post-heading">
                                    <div class="row">
                                        <div class="col-md-11">
                                            <div class="media">
                                                <div class="media-body">
                                                    <a href="#" class="anchor-username"><h4 class="media-heading">Bayu Darmantra</h4></a>
                                                    <a href="#" class="anchor-time" style="color: #7abaff">51 mins</a>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-md-1">
                                            <a href="#"><i class="glyphicon glyphicon-chevron-down"></i></a>
                                        </div>
                                    </div>
                                </section>
                                <section class="post-body">
                                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras
                                        turpis sem, dictum id bibendum eget, malesuada ut massa. Ut scel
                                        erisque nulla sed luctus dapibus. Nulla sit amet mi vitae purus sol
                                        licitudin venenatis. Praesent et sem urna. Integer vitae lectus nis
                                        l. Fusce sapien ante, tristique efficitur lorem et, laoreet ornare lib
                                        ero. Nam fringilla leo orci. Vivamus semper quam nunc, sed ornare magna dignissim sed. Etiam interdum justo quis risus
                                        efficitur dictum. Nunc ut pulvinar quam. N
                                        unc mollis, est a dapibus dignissim, eros elit tempor diam, eu tempus quam felis eu velit.</p>
                                </section>
                                <section class="post-footer">
                                    <hr>

                                </section>
                            </div>

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
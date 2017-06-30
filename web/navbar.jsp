<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="${pageContext.request.contextPath}/">Filmes</a>
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav">
                <%--<li class="active"><a href="#"></a></li>--%>
                <li><a href="${pageContext.request.contextPath}/atores">Atores</a></li>
                <li><a href="${pageContext.request.contextPath}/diretores">Diretores</a></li>
                <li><a href="${pageContext.request.contextPath}/roteiristas">Roteiristas</a></li>
                <li><a href="${pageContext.request.contextPath}/generos">Generos</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <%--<a href="#" id="loginform"><span class="glyphicon glyphicon-log-in"></span> Login</a>--%>
                <li><a href="#" class="dropdown-toggle" data-toggle="dropdown">
                    <div style="padding-right: 10px">
                        <span class="glyphicon glyphicon-log-in"></span>
                        Login
                    </div>
                </a>
                <ul id="login-dp" class="dropdown-menu">
                    <li>
                        <div class="row">
                            <div class="col-md-12">
                                Login via
                                <div class="social-buttons">
                                    <a href="#" class="btn btn-fb"><i class="fa fa-facebook"></i> Facebook</a>
                                    <a href="#" class="btn btn-tw"><i class="fa fa-twitter"></i> Twitter</a>
                                </div>
                                ou
                                <form class="form" role="form" method="post" action="login" accept-charset="UTF-8" id="login-nav">
                                    <div class="form-group">
                                        <label class="sr-only" for="exampleInputEmail2">Email</label>
                                        <input type="email" class="form-control" id="exampleInputEmail2" placeholder="Email" required>
                                    </div>
                                    <div class="form-group">
                                        <label class="sr-only" for="exampleInputPassword2">Senha</label>
                                        <input type="password" class="form-control" id="exampleInputPassword2" placeholder="Senha" required>
                                        <div class="help-block text-right"><a href="">Esqueceu sua senha ?</a></div>
                                    </div>
                                    <div class="form-group">
                                        <button type="submit" class="btn btn-primary btn-block">Entrar</button>
                                    </div>
                                    <div class="checkbox">
                                        <label>
                                            <input type="checkbox"> Quero ficar logado
                                        </label>
                                    </div>
                                </form>
                            </div>
                            <div class="bottom text-center">
                                Novo aqui ? <a href="#"><b>Registre-se</b></a>
                            </div>
                        </div>
                    </li>
                    </li>
                </ul>
            </ul>
        </div>
    </div>
</nav>

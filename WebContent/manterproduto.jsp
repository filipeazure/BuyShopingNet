<%@page import="br.com.BuyShoppingNet.VO.Produto"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<title>Login | B-BSN</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/font-awesome.min.css" rel="stylesheet">
<link href="css/prettyPhoto.css" rel="stylesheet">
<link href="css/price-range.css" rel="stylesheet">
<link href="css/animate.css" rel="stylesheet">
<link href="css/main.css" rel="stylesheet">
<link href="css/responsive.css" rel="stylesheet">
<!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->
<link rel="shortcut icon" href="images/ico/favicon.ico">
<link rel="apple-touch-icon-precomposed" sizes="144x144"
	href="images/ico/apple-touch-icon-144-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="114x114"
	href="images/ico/apple-touch-icon-114-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72"
	href="images/ico/apple-touch-icon-72-precomposed.png">
<link rel="apple-touch-icon-precomposed"
	href="images/ico/apple-touch-icon-57-precomposed.png">
</head>
<!--/head-->

<body>
	<header id="header">
		<!--header-->
		<div class="header_top">
			<!--header_top-->
			<div class="container">
				<div class="row">
					<div class="col-sm-6">
						<div class="contactinfo">
							<ul class="nav nav-pills">
								<li><a href=""><i class="fa fa-phone"></i> +55 61
										91351956 </a></li>
								<li><a href=""><i class="fa fa-envelope"></i>
										buyshoppingnet@gmail.com</a></li>
							</ul>
						</div>
					</div>

				</div>
			</div>
		</div>
		<!--/header_top-->

		<div class="header-middle">
			<!--header-middle-->
			<div class="container">
				<div class="row">
					<div class="col-sm-4">
						<div class="logo pull-left">
							<a href="index.html"><img src="images/home/logo.png" alt="" /></a>
						</div>
						<div class="btn-group pull-right">
							<div class="btn-group"></div>

							<div class="btn-group"></div>
						</div>
					</div>
					<div class="col-sm-8">
						<div class="shop-menu pull-right">
							<ul class="nav navbar-nav">
								<li><a href="MinhaConta.html"><i class="fa fa-user"></i>
										Minha Conta</a></li>
								<li><a href=""><i class="fa fa-star"></i> Lista de
										desejos</a></li>
								<li><a href="checkout.html"><i class="fa fa-crosshairs"></i>
										Checkout</a></li>
								<li><a href="cart.html"><i class="fa fa-shopping-cart"></i>
										Carrinho</a></li>
								<li><a href="login.jsp" class="fa fa-user"><i
										class="fa fa-lock"></i> Login</a></li>

							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!--/header-middle-->

		<div class="header-bottom">
			<!--header-bottom-->
			<div class="container">
				<div class="row">
					<div class="col-sm-9">
						<div class="navbar-header">
							<button type="button" class="navbar-toggle"
								data-toggle="collapse" data-target=".navbar-collapse">
								<span class="sr-only">Toggle navigation</span> <span
									class="icon-bar"></span> <span class="icon-bar"></span> <span
									class="icon-bar"></span>
							</button>
						</div>
						<div class="mainmenu pull-left">
							<ul class="nav navbar-nav collapse navbar-collapse">
								<li><a href="index.html">Inicio</a></li>
								<li class="dropdown"><a href="#">Loja<i
										class="fa fa-angle-down"></i></a>
									<ul role="menu" class="sub-menu">
										<li><a href="shop.html">Produtos</a></li>
										<li><a href="product-details.html">Detalhes do
												Produto</a></li>
										<li><a href="checkout.html">Checkout</a></li>
										<li><a href="cart.html">Carrinho</a></li>
										<li><a href="login.jsp">Login</a></li>

									</ul></li>
								<li class="dropdown"><a href="#">Blog<i
										class="fa fa-angle-down"></i></a>
									<ul role="menu" class="sub-menu">
										<li><a href="blog.html">Blog List</a></li>
										<li><a href="blog-single.html">Blog Single</a></li>
									</ul></li>
								<li><a href="404.html">404</a></li>
								<li><a href="contact-us.html">Contact</a></li>
							</ul>
						</div>
					</div>
					<form action="">
						<div class="col-sm-3">
							<div class="search_box pull-right">
								<input type="text" placeholder="Search" />
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
		<!--/header-bottom-->
	</header>
	<!--/header-->

	<section id="form">
		<!--form-->
		<div class="container">
			<div class="breadcrumbs">
				<ol class="breadcrumb">
					<li><a href="index.html">Inicio </a></li>
					<li><a href="manterproduto.jsp">Manter Produto</a></li>
					<li><a href="ProdutoServlet?acao=listar">Listar</a></li>
				</ol>
			</div>
			<div class="row">
				<div class="col-sm-4 col-sm-offset-1">
					<div class="login-form">
						<!--Manter Produto form-->
						<h2>Cadastrar Produto</h2>

						<form action="ProdutoServlet" method="post">

							<input type="text" name="CodProduto"
								placeholder="Codigo do produto" required="required" /> <input
								type="date" name="DataProduto" placeholder="Data do produto" 
								required="required" /> <input type="text" name="NomeProduto"
								placeholder="Nome do produto" required="required" /> <input
								type="text" name="Medida" placeholder="Unidade de medida"
								required="required" /> <input type="text" name="Tipo"
								placeholder="Tipo/categoria do produto" required="required" />
							<input type="number" name="Quantidade"
								placeholder="Quantidade do produto" required="required" /> <input
								type="number" name="ValorInicial"
								placeholder="Valor inicial do produto" required="required"
								step="0.5" /> <input type="hidden" name="acao" value="inserir">
							<span> </span>
							<button type="submit" class="btn btn-default">Inserir</button>
						</form>
					</div>
					<!--/login form-->
				</div>
				<div class="col-sm-1">
					<h2 class="or">OU</h2>
				</div>
				<div class="col-sm-4">
					<div class="signup-form">
						<!--sign up form-->
						<h2>Alterar Produto</h2>
						<form action="ProdutoServlet" method="post">

							<input type="text" name="CodProduto"
								placeholder="Codigo do produto" required="required" /> <input
								type="text" name="DataProduto" placeholder="Data do produto"
								required="required" /> <input type="text" name="NomeProduto"
								placeholder="Nome do produto" required="required" /> <input
								type="text" name="Medida" placeholder="Unidade de medida"
								required="required" /> <input type="text" name="Tipo"
								placeholder="Tipo/categoria do produto" required="required" />
							<input type="number" name="Quantidade"
								placeholder="Quantidade do produto" required="required" />
								 <input	type="number" name="ValorInicial" placeholder="Valor inicial do produto" required="required" step="0.5" /> 
								 <input type="hidden" name="acao" value="alterar">

							<button type="submit" class="btn btn-default">Alterar</button>
						</form>
					</div>
					<!--/sign up form-->
				</div>

			</div>
			<div>
				<p>
				<p>
			</div>

			<%
				List<Produto> produtos = (List<Produto>) session
						.getAttribute("lista");
			%>
			<div class="table-responsive cart_info">
				<table class="table table-condensed">

					<%
					if (produtos != null && !produtos.isEmpty()) {
					%>
					<tr class="cart_menu">

						<th class="description">CodProduto</th>

						<th class="description">NomeProduto</th>

						<th class="description">DataProduto</th>

						<th class="description">Medida</th>

						<th class="description">Quantidade</th>
						<th class="description">ValorInicial</th>

						<th class="description">Acoes</th>
						<th></th>
					</tr>

					<%
							for (Produto produto : produtos) {
					%>
					<tr>
						<td class="description"><%=produto.getCodProduto()%></td>
						<td class="description"><%=produto.getNomeProduto()%></td>
						<td class="description"><%=produto.getDataProduto()%></td>

						<td class="description"><%=produto.getMedida()%></td>

						<td class="description"><%=produto.getQuantidade()%></td>
						<td class="description"><%=produto.getValorInicial()%></td>

						<td>
							<form action="ProdutoServlet" method="post">
								<input type="hidden" name="acao" value="excluir" /> <input
									type="hidden" name="codproduto"
									value="<%=produto.getCodProduto()%>" />
								<button type="submit" class="btn btn-default">Excluir</button>
							</form> <!--  <a href="ProdutoServlet?acao=excluir&codproduto=<%= produto.getCodProduto()%>">Excluir</a>-->
						</td>

					</tr>
					<tr></tr>
					<%
						}
						}
						else{
							%>
							<hr/>
							<center>Nenhum produto cadastrado!</center>
							<%
						}
					%>

				</table>
				<div class="breadcrumbs">
					<ol class="breadcrumb">
						<li><a href="index.html">Inicio</a></li>
						<li><a href="login.jsp">Login</a>
						<li><a href="MinhaConta.html">Alterar</a>
					</ol>

				</div>
			</div>

		</div>

	</section>
	<!--/form-->
	<footer id="footer">
		<!--Footer-->
		<div class="footer-top">
			<div class="container">
				<div class="row">
					<div class="col-sm-2">
						<div class="companyinfo">
							<h2>
								<span>BSN</span>-Shopping
							</h2>
							<p>Lorem ipsum dolor sit amet, consectetur adipisicing
								elit,sed do eiusmod tempor</p>
						</div>
					</div>
					<div class="col-sm-7">
						<div class="col-sm-3">
							<div class="video-gallery text-center">
								<a href="http://www.youtube.com">
									<div class="iframe-img">
										<img src="images/home/iframe1.png" alt="" />
									</div>
									<div class="overlay-icon">
										<i class="fa fa-play-circle-o"></i>
									</div>
								</a>
								<p>Circle of Hands</p>
								<h2>24 DEC 2014</h2>
							</div>
						</div>

						<div class="col-sm-3">
							<div class="video-gallery text-center">
								<a href="#">
									<div class="iframe-img">
										<img src="images/home/iframe2.png" alt="" />
									</div>
									<div class="overlay-icon">
										<i class="fa fa-play-circle-o"></i>
									</div>
								</a>
								<p>Circle of Hands</p>
								<h2>24 DEC 2014</h2>
							</div>
						</div>

						<div class="col-sm-3">
							<div class="video-gallery text-center">
								<a href="#">
									<div class="iframe-img">
										<img src="images/home/iframe3.png" alt="" />
									</div>
									<div class="overlay-icon">
										<i class="fa fa-play-circle-o"></i>
									</div>
								</a>
								<p>Circle of Hands</p>
								<h2>24 DEC 2014</h2>
							</div>
						</div>

						<div class="col-sm-3">
							<div class="video-gallery text-center">
								<a href="#">
									<div class="iframe-img">
										<img src="images/home/iframe4.png" alt="" />
									</div>
									<div class="overlay-icon">
										<i class="fa fa-play-circle-o"></i>
									</div>
								</a>
								<p>Circle of Hands</p>
								<h2>24 DEC 2014</h2>
							</div>
						</div>
					</div>
					<div class="col-sm-3">
						<div class="address">
							<img src="images/home/map.png" alt="" />
							<p>505 S Atlantic Ave Virginia Beach, VA(Virginia)</p>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="footer-widget">
			<div class="container">
				<div class="row">
					<div class="col-sm-2">
						<div class="single-widget">
							<h2>Service</h2>
							<ul class="nav nav-pills nav-stacked">
								<li><a href="">Ajuda On-line</a></li>
								<li><a href="">Contate-nos</a></li>
								<li><a href="">Status do pedido</a></li>
								<li><a href="">Change Location</a></li>
								<li><a href="">FAQ’s</a></li>
							</ul>
						</div>
					</div>
					<div class="col-sm-2">
						<div class="single-widget">
							<h2>Quock Shop</h2>
							<ul class="nav nav-pills nav-stacked">
								<li><a href="">T-Shirt</a></li>
								<li><a href="">Mens</a></li>
								<li><a href="">Womens</a></li>
								<li><a href="">Gift Cards</a></li>
								<li><a href="">Shoes</a></li>
							</ul>
						</div>
					</div>
					<div class="col-sm-2">
						<div class="single-widget">
							<h2>Policies</h2>
							<ul class="nav nav-pills nav-stacked">
								<li><a href="">Terms of Use</a></li>
								<li><a href="">Privecy Policy</a></li>
								<li><a href="">Refund Policy</a></li>
								<li><a href="">Billing System</a></li>
								<li><a href="">Ticket System</a></li>
							</ul>
						</div>
					</div>
					<div class="col-sm-2">
						<div class="single-widget">
							<h2>About Shopper</h2>
							<ul class="nav nav-pills nav-stacked">
								<li><a href="">Company Information</a></li>
								<li><a href="">Careers</a></li>
								<li><a href="">Store Location</a></li>
								<li><a href="">Affillate Program</a></li>
								<li><a href="">Copyright</a></li>
							</ul>
						</div>
					</div>
					<div class="col-sm-3 col-sm-offset-1">
						<div class="single-widget">
							<h2>About Shopper</h2>
							<form action="#" class="searchform">
								<input type="text" placeholder="Your email address" />
								<button type="submit" class="btn btn-default">
									<i class="fa fa-arrow-circle-o-right"></i>
								</button>
								<p>
									Get the most recent updates from <br />our site and be updated
									your self...
								</p>
							</form>
						</div>
					</div>

				</div>
			</div>
		</div>

		<div class="footer-bottom">
			<div class="container">
				<div class="row">
					<p class="pull-left">Copyright © 2013 E-SHOPPER Inc. All
						rights reserved.</p>
					<p class="pull-right">
						Designed by <span><a target="_blank"
							href="http://www.themeum.com">Marques Developper</a></span>
					</p>
				</div>
			</div>
		</div>

	</footer>
	<!--/Footer-->



	<script src="js/jquery.js"></script>
	<script src="js/price-range.js"></script>
	<script src="js/jquery.scrollUp.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.prettyPhoto.js"></script>
	<script src="js/main.js"></script>

</body>
</html>

<%@page import="com.comtrade.entity.Kategorije"%>
<%@page import="com.comtrade.entity.Artikal"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%><!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <title>Prime - Webshop</title>
  <meta name="description" content=".....">
  <meta name="keywords" content=".....">
  <meta name="author" content="Aleksandar Vilus | aleksandar.vilus.it.obuka@gmail.com">
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <meta name="robots" content="index">
  <link rel="icon" href="http://primetimewatches.net/media/favicon/default/favicon.ico" type="image/x-icon">

  <link href="${pageContext.request.contextPath}css/bootstrap.min.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}css/all.min.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}css/mojstil.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}ss/mojstil_index.css" rel="stylesheet">

  <link href="${pageContext.request.contextPath}css/mojstil_galerija.css" rel="stylesheet">


</head>

<body>
<%List<Kategorije> listaKategorija=(List<Kategorije>) request.getAttribute("listaKategorija"); %>
<%List<Artikal> listaArtikala=(List<Artikal>) request.getAttribute("listaArtikala"); %>
  <!-- POÄETAK OMOTAÄA -->
  <div class="container">


    <!-- POÄETAK HEDER-A -->
    <div class="page-header">
      <img src="images/primetime/primetime-head-inv.png">
    </div>

    <!-- KRAJ HEDER-A -->

    <!-- OVO JE POCETAK NAVIGACIJE -->
    <nav class="navbar navbar-default" data-spy="affix">
      <!--afix FIKSIRANJE NAVIGACIJE-->
      <h2>Glavna navigacija</h2>
      <div class="container-fluid">

        <!-- POÄETAK DELA KOJI KREIRA BURGER -->
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
            data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="index1">
            PRIME
          </a>
        </div>
        <!-- KRAJ DELA KOJI KREIRA BURGER -->

        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
          <ul class="nav navbar-nav navbar-right">

            <!-- POÄETAK PADAJUÄEG MENIJA -->
            <li class="dropdown">
              <a href="galerija.html" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                aria-expanded="false">BRENDOVI <span class="caret"></span></a>
              <ul class="dropdown-menu">
              
            <%
              if(listaKategorija!=null){
              for(Kategorije k: listaKategorija){ %>
              <li><a href="${pageContext.request.contextPath}/index/kategorijaArtikli/<%=k.getId()%>"><%=k.getNaziv() %></a></li>
              <%}} %>
              </ul>
            </li>
            <!-- KRAJ PADAJUÄEG MENIJA -->

            <li><a href="webshop">PRODAVNICA</a></li>
            <li><a href="onama.html">O NAMA</a></li>
            <li><a href="kontakt">KONTAKT</a></li>

        </div>
        <!-- /.navbar-collapse -->
      </div>
      <!-- /.container-fluid -->
    </nav>
    <!-- KRAJ NAVIGACIJE -->

    <!-- POÄETAK NASLOVA STRANE -->
    <div class="page-header">
      <h1><em>WEBSHOP</em></h1>
    </div>
    <!-- KRAJ NASLOVA STRANE -->
    <form class="prodavnica" id="proizvodi">
      <div class="page-header">

        <!-- POÄETAK BOKSEVA -->
        <div class="row">
          <div class="col-xs-3 col-sm-3 col-md-0">

          </div>
        <!--   <div class="col-xs-6 col-sm-6 col-md-12">
            <img id="HaGe" src="images/primetime/HAEMER-icon-large1.jpg" class="img-responsive" alt="Haemmer Germany">

          </div> -->
        </div>

        <div class="row">

          <!-- BOÄNI SEGMENT KOJI SLUÅ½I SAMO ZA ODVAJANJE -->
          <div class="col-xs-2 col-md-1">
          </div>

          <!-- GLAVNI SEGMENT -->
          <div class="col-xs-8 col-md-10">

            <!-- POÄETAK DELA SA FOTOGRAFIJAMA PROIZVODA -->
            <div class="okvir0">

              <!-- FOTOGRAFIJA 1 -->
                <%if(listaArtikala!=null){
             for(Artikal a: listaArtikala){ 
			 String  naziv=a.getKategorije().getNaziv();
%>
              <div class="okvir1">
                <div>
                  <p>
                    <h3>
                      <strong><%=a.getNaziv()%>"</strong>
                    </h3>
                  </p>
                  <a>
                    <img src="\images\<%=naziv%>\<%=a.getFileName() %>" alt="<%=a.getNaziv()%>" width=”30px” height=”30px”>
                  </a>
                </div>
                 <input type="hidden" name="idArtikla" value="<%=a.getId()%>">
                <p>
                  <strong><%=a.getCena() %> RSD</strong>
                </p>
                <p>
                  Narucujem <label for="<%=a.getId()%>"></label>
                  <input type="number" id="<%=a.getId()%>" name="<%=a.getId() %>" size="1" placeholder="0"> komada
                </p>
                <p>
                 <input type="submit" value="Dodaj u korpu" onclick="poziv(<%=a.getId()%>,<%=a.getCena()%>)">                 
                    <i class="fas fa-arrow-alt-circle-down"></i>
                  </a>
                </p>
              </div>

          	<%}} %>
              </div>

            </div>
            <!-- KRAJ SA FOTOGRAFIJAMA PROIZVODA -->

          </div>

        </div>
        <!-- KRAJ BOKSEVA -->

      </div>
      <div class="page-header">

    <!--     POÄETAK BOKSEVA
        <div class="row">
          <div class="col-xs-3 col-sm-3 col-md-0">

          </div>
          <div class="col-xs-6 col-sm-6 col-md-12">
            <img id="HaGe" src="images/primetime/WELDER-icon-large1.jpg" class="img-responsive" alt="Welder">

          </div>
        </div>

        <div class="row">

          BOÄNI SEGMENT KOJI SLUÅ½I SAMO ZA ODVAJANJE
          <div class="col-xs-2 col-md-1">
          </div>

          GLAVNI SEGMENT
          <div class="col-xs-8 col-md-10">

            POÄETAK DELA SA FOTOGRAFIJAMA PROIZVODA
            <div class="okvir0">

              FOTOGRAFIJA 7
              <div class="okvir1">
                <div>
                  <p>
                    <h3>
                      <strong>K24 3300</strong>
                    </h3>
                  </p>
                  <a>
                    <img src="images/welder/K24_3300.jpg" alt="DHC-12 Zeno">
                  </a>
                </div>
                <p>
                  <strong>71,500.00 RSD</strong>
                </p>
                <p>
                  NaruÄujem <label for="sedam"></label>
                  <input type="text" id="sedam" name="" size="1" placeholder="0"> komada
                </p>
                <p>
                  <a class="btn btn-primary btn-sm" href="#krajodabira" role="button">
                    ZavrÅ¡i kupovinu
                    <i class="fas fa-arrow-alt-circle-down"></i>
                  </a>
                </p>
              </div>

              FOTOGRAFIJA 8
              <div class="okvir1">
                <div>
                  <p>
                    <h3>
                      <strong>K24 3301</strong>
                    </h3>
                  </p>
                  <a>
                    <img src="images/welder/K24_3301.jpg" alt="DHC-13 Moon">
                  </a>
                </div>
                <p>
                  <strong>71,500.00 RSD</strong>
                </p>
                <p>
                  NaruÄujem <label for="osam"></label>
                  <input type="text" id="osam" name="" size="1" placeholder="0"> komada
                </p>
                <p>
                  <a class="btn btn-primary btn-sm" href="#krajodabira" role="button">
                    ZavrÅ¡i kupovinu
                    <i class="fas fa-arrow-alt-circle-down"></i>
                  </a>
                </p>
              </div>

              FOTOGRAFIJA 9
              <div class="okvir1">
                <div>
                  <p>
                    <h3>
                      <strong>K25B 4603</strong>
                    </h3>
                  </p>
                  <a>
                    <img src="images/welder/K25B_4603.jpg" alt="HC-07 Invader">
                  </a>
                </div>
                <p>
                  <strong>64,900.00 RSD</strong>
                </p>
                <p>
                  NaruÄujem <label for="devet"></label>
                  <input type="text" id="devet" name="" size="1" placeholder="0"> komada
                </p>
                <p>
                  <a class="btn btn-primary btn-sm" href="#krajodabira" role="button">
                    ZavrÅ¡i kupovinu
                    <i class="fas fa-arrow-alt-circle-down"></i>
                  </a>
                </p>
              </div>

              FOTOGRAFIJA 10
              <div class="okvir1">
                <div>
                  <p>
                    <h3>
                      <strong>K25B 4704</strong>
                    </h3>
                  </p>
                  <a>
                    <img src="images/welder/K25B_4704.jpg" alt="HC-16 Charon">
                  </a>
                </div>
                <p>
                  <strong>70,400.00 RSD</strong>
                </p>
                <p>
                  NaruÄujem <label for="deset"></label>
                  <input type="text" id="deset" name="" size="1" placeholder="0"> komada
                </p>
                <p>
                  <a class="btn btn-primary btn-sm" href="#krajodabira" role="button">
                    ZavrÅ¡i kupovinu
                    <i class="fas fa-arrow-alt-circle-down"></i>
                  </a>
                </p>
              </div>

              FOTOGRAFIJA 11
              <div class="okvir1">
                <div>
                  <p>
                    <h3>
                      <strong>K33 9301</strong>
                    </h3>
                  </p>
                  <a>
                    <img src="images/welder/K33_9301.jpg" alt="HQ-02 Dublin">
                  </a>
                </div>
                <p>
                  <strong>70,400.00 RSD</strong>
                </p>
                <p>
                  NaruÄujem <label for="jedanaest"></label>
                  <input type="text" id="jedanaest" name="" size="1" placeholder="0"> komada
                </p>
                <p>
                  <a class="btn btn-primary btn-sm" href="#krajodabira" role="button">
                    ZavrÅ¡i kupovinu
                    <i class="fas fa-arrow-alt-circle-down"></i>
                  </a>
                </p>
              </div>

              FOTOGRAFIJA 12
              <div class="okvir1">
                <div>
                  <p>
                    <h3>
                      <strong>K33 9302</strong>
                    </h3>
                  </p>
                  <a>
                    <img src="images/welder/K33_9302.jpg" alt="HQ-10 Brussel">
                  </a>
                </div>
                <p>
                  <strong>70,400.00 RSD</strong>
                </p>
                <p>
                  NaruÄujem <label for="dvanaest"></label>
                  <input type="text" id="dvanaest" name="" size="1" placeholder="0"> komada
                </p>
                <p>
                  <a class="btn btn-primary btn-sm" href="#krajodabira" role="button">
                    ZavrÅ¡i kupovinu
                    <i class="fas fa-arrow-alt-circle-down"></i>
                  </a>
                </p>
              </div>

            </div>
            KRAJ SA FOTOGRAFIJAMA PROIZVODA
          </div>

        </div>

        KRAJ BOKSEVA -->

      </div>

      <div class="page-header">

        <!-- POÄETAK BOKSEVA -->
        <div class="row">
          <div class="col-xs-3 col-sm-3 col-md-0">

          </div>
          <div class="col-xs-6 col-sm-6 col-md-12">

      

          </div>
        </div>

      </div>


      <div class="page-header">

        <div id="krajodabira">
          <div class="row">
            <div class="col-md-12">
              <h2>
                Detalji narudzbenice
              </h2>

              <div class="grupaizracunavanje">
                <p>
                  <label for="btn-izracunaj">

                  </label>
                  <input type="submit" value="Ukupan iznos" id="btn-izracunaj" name="">
                  <input type="text" id="txt-izracunaj" placeholder="0.00 RSD" name="">
                </p>
                <div id="rezultati">
                </div>
                <br>
                <div id="rezultati1">
                </div>
                <p>
                  <a class="btn btn-primary btn-lg" href="kontakt.html" role="button">Prijavite se</a>
                </p>
              </div>
            </div>
          </div>
        </div>
      </div>

    </form>
    <!-- POÄETAK FOOTER-A -->
    <footer>
      <div class="row">

        <div class="col-md-12">

          <ul id="SoNet" class="list-inline">
            <li><a href="http://facebook.com/"><i class="fab fa-facebook-f fa-3x"></i></a></li>
            <li><a href="http://instagram.com/"><i class="fab fa-instagram fa-3x"></i></a></li>
            <li><a href="http://twitter.com/"><i class="fab fa-twitter fa-3x"></i></a></li>
          </ul>
        </div>
      </div>
      <!-- kraj gornjeg dela footer-a -->
      <!-- donji deo footer-a -->
      <div class="panel-footer">
        <div class="row">

          <div class="col-md-12">
            <p class="text-right">Copyright &copy; 2019 Aleksandar Vilus &#64; CODE</p>
          </div>
        </div>
      </div>
      <!-- kraj donjeg dela footer-a -->
    </footer>
    <!-- KRAJ FOOTER-A -->
  </div>
  <!-- KRAJ OMOTAÄA -->


  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
  <script src="js/mojjs.js"></script>

  <script src="js/korpa.js"></script>


</body>

</html>
<img class="img-rounded" src="../images/logo.png" height="150px" width="99%" />
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <ul class="nav navbar-nav">
<!--       <li class="active"><a href="index">Home</a></li> -->
       <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="javascript:void(0)">Location
        <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="../mvc/showlocReg">Registration</a></li>
          <li><a href="../mvc/showLocs">Show all</a></li>
        </ul>
      </li>
       <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="javascript:void(0)">Vendor
        <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="../mvc/venReg">Registration</a></li>
          <li><a href="../mvc/showAllVen">Show all</a></li>
        </ul>
      </li>

      
       <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="javascript:void(0)">Customer
        <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="../mvc/showCustReg">Registration</a> 
      </li>
          <li><a href="../mvc/showCusts">Show all</a></li>
        </ul>
      </li>
      
       <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="javascript:void(0)">Reports
        <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li> <a href="../mvc/locReport">Location Report</a> 
      </li>
          <li><a href="../mvc/venReport">Vendor Report</a></li>
        </ul>
      </li>
        <li><a href="../mvc/regUpload">Document</a></li>
        <li><a href="../mvc/logout">Log Out</a></li>
    </ul>
     <p class="navbar-text" align="right">Login as: ${username}</p>
  </div>
</nav>

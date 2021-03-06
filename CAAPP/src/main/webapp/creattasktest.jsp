<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Charted Accountant</title>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" href="/css/bootstrap.min.css" />
<link rel="stylesheet" href="/css/bootstrap-responsive.min.css" />
<link rel="stylesheet" href="/css/fullcalendar.css" />
<link rel="stylesheet" href="/css/maruti-style.css" />
<link rel="stylesheet" href="/css/maruti-media.css" class="skin-color" />
<link rel="stylesheet" href="/css/uniform.css" />
</head>
<body>

<!--Header-part-->
<div id="header">
  <!--h1>Ajahsma</h1 -->
  <div style="color: #ffffff;padding: 0 0 0 20px;">
	  <h3>SANJAY K & CO.</h3>
	  <h5 style="margin-top: -15px;">CHARTERED ACCOUNTANT</h5>
  </div>
</div>
<!--close-Header-part--> 

<!--top-Header-messaages-->
<div class="btn-group rightzero"> <a class="top_message tip-left" title="Manage Files"><i class="icon-file"></i></a> <a class="top_message tip-bottom" title="Manage Users"><i class="icon-user"></i></a> <a class="top_message tip-bottom" title="Manage Comments"><i class="icon-comment"></i><span class="label label-important">5</span></a> <a class="top_message tip-bottom" title="Manage Orders"><i class="icon-shopping-cart"></i></a> </div>
<!--close-top-Header-messaages--> 

<!--top-Header-menu-->
<div id="user-nav" class="navbar navbar-inverse">
  <ul class="nav">
    <li class="" ><a title="" href="#"><i class="icon icon-user"></i> <span class="text">Profile</span></a></li>
    <li class=" dropdown" id="menu-messages"><a href="#" data-toggle="dropdown" data-target="#menu-messages" class="dropdown-toggle"><i class="icon icon-envelope"></i> <span class="text">Messages</span> <span class="label label-important">5</span> <b class="caret"></b></a>
      <ul class="dropdown-menu">
        <li><a class="sAdd" title="" href="#">new message</a></li>
        <li><a class="sInbox" title="" href="#">inbox</a></li>
        <li><a class="sOutbox" title="" href="#">outbox</a></li>
        <li><a class="sTrash" title="" href="#">trash</a></li>
      </ul>
    </li>
    <li class=""><a title="" href="#"><i class="icon icon-cog"></i> <span class="text">Settings</span></a></li>
    <li class=""><a title="" href="/logout"><i class="icon icon-share-alt"></i> <span class="text">Logout</span></a></li>
  </ul>
</div>
<div id="search">
  <input type="text" placeholder="Search here..."/>
  <button type="submit" class="tip-left" title="Search"><i class="icon-search icon-white"></i></button>
</div>
<!--close-top-Header-menu-->

<div id="sidebar">
<h4 align="center">SANJAY K & CO, CHARTERED ACCOUNTANT</h4>
</div>


<div id="content">
  <div id="content-header">
    <div id="breadcrumb"> <a href="index.html" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a></div>
  </div>
  <div class="container-fluid">
   	<div class="quick-actions_homepage">
    <ul class="quick-actions">
           <li> <a href="/caapp/client/clientRegistrationView"> <i class="icon-people"></i> Client </a> </li>
          <li> <a href="/caapp/employee/createEmployee"> <i class="icon-people"></i> Employee</a> </li>
          <li> <a href="/caapp/tasks/createTasks"> <i class="icon-people"></i> Add Tasks </a> </li>
          <li> <a href="assigned-tasks.html"> <i class="icon-people"></i> Assigned tasks </a> </li>
          <li> <a href="#"> <i class="icon-calendar"></i> Pending tasks </a> </li>
          <li> <a href="#"> <i class="icon-calendar"></i> Completed tasks </a> </li>
        </ul>
   </div>
<!--close-left-menu-stats-sidebar-->

<div>
 
  <div class="container-fluid" align="center">
    <div class="row-fluid">
 
	    <div class="span3">
	    	<div class="widget-box">
	    		<div class="widget-title" style="background-color: #848d97;"> 
					<p>Important News</p>
				</div>
				<div class="widget-content">
	    	<div align="left">
	    		<h5>1. GST</h5>
	    		<h5>2. INCOME TAX</h5>
	    		<h5>3. ESI/EPF/PT</h5>
	    		<h5>4. OFFICE</h5>
	    		<h5>5. ROC</h5>
	    	</div>
	    	</div>
	    </div>
	   </div> 
	    
	   
    
      <div class="span6">
        <div class="widget-box">
          <div class="widget-title" > 
           <p align="center">Client Registration</p>
          </div>
          <div class="widget-content nopadding">
            <form:form action="client/clientRegister" method="post" class="form-horizontal"  modelAttribute="tasks">
             
              <div class="control-group">
                <label class="control-label">Client Name :</label>
                <div class="controls">
                <form:select type="text" class="form-control"  path="clientDto.clientId">
					<form:option value="-1">-select client-</form:option>
					<form:options items="${clientsList }" itemValue="clientId"
													itemLabel="tradeName"/>
				</form:select>
                  <form:errors path="clientDto.clientId"/>
                  
                </div>
              </div>
             
            
            
            
            
              <div class="control-group">
                <label class="control-label">Nature Of Assignment :</label>
                <div class="controls" align="left">
                  <form:select type="text"
							class="form-control " 
							path="natureOfAssignmentDto.natureOfAssignmentId" >
							<form:option value="-1">--select nature of assignment--</form:option>
							<form:options items="${natureOfAssignmentDtos}" itemValue="natureOfAssignmentId"
													itemLabel="natureOfAssignmentName" />
											</form:select>
											<form:errors path="natureOfAssignmentDto.natureOfAssignmentId"/>
                </div>
              </div>
              
              
              
              
              <div class="form-actions">
                <button type="submit" class="btn btn-success">Save</button>
                <button type="submit" class="btn btn-primary">Reset</button>
                <button type="submit" class="btn btn-danger">Cancel</button>
              </div>
            </form:form>
          </div>
        </div>
      </div>
      
       <div class="span3">
	    	<div class="widget-box">
	    	<div class="widget-title" style="background-color: #848d97;"> 
					<p>Important Links</p>
				</div>
				<div class="widget-content">
	    	<div align="left">
	    	<a href="WWW.GST.GOV.IN">WWW.GST.GOV.IN</a><br/>
	    	<a href="WWW.ICAI.ORG">WWW.ICAI.ORG</a><br/>
	    	<a href="WWW.MCA.GOV.IN">WWW.MCA.GOV.IN</a><br/>
	    	<a href="WWW.PT.KAR.NIC.IN">WWW.PT.KAR.NIC.IN</a><br/>
	    	<a href="WWW.ESI">WWW.ESI</a><br/>
	    	<a href="WWW.EPF">WWW.EPF</a><br/>
	    	<a href="WWW. S & E">WWW. S & E</a><br/>
	    	<a href="WWW.RBI.ORG">WWW.GST.GOV.IN</a><br/>
	    	<a href="WWW.HDFCBANK.OCM">WWW.HDFCBANK.OCM</a><br/>
	    	</div>
	    	</div>
	    	</div>
	    </div>
      
      </div>
      
     
      <!-- <div class="span6">
        <div class="widget-box">
          <div class="widget-title"> <span class="icon"> <i class="icon-align-justify"></i> </span>
            <h5>Form Elements</h5>
          </div>
          <div class="widget-content nopadding">
            <form action="#" method="get" class="form-horizontal">
              <div class="control-group">
                <label class="control-label">Select input</label>
                <div class="controls">
                  <select >
                    <option>First option</option>
                    <option>Second option</option>
                    <option>Third option</option>
                    <option>Fourth option</option>
                    <option>Fifth option</option>
                    <option>Sixth option</option>
                    <option>Seventh option</option>
                    <option>Eighth option</option>
                  </select>
                </div>
              </div>
              <div class="control-group">
                <label class="control-label">Multiple Select input</label>
                <div class="controls">
                  <select multiple >
                    <option>First option</option>
                    <option selected>Second option</option>
                    <option>Third option</option>
                    <option>Fourth option</option>
                    <option>Fifth option</option>
                    <option>Sixth option</option>
                    <option>Seventh option</option>
                    <option>Eighth option</option>
                  </select>
                </div>
              </div>
              <div class="control-group">
                <label class="control-label">Radio inputs</label>
                <div class="controls">
                  <label>
                    <input type="radio" name="radios" />
                    First One</label>
                  <label>
                    <input type="radio" name="radios" />
                    Second One</label>
                  <label>
                    <input type="radio" name="radios" />
                    Third One</label>
                </div>
              </div>
              <div class="control-group">
                <label class="control-label">Checkboxes</label>
                <div class="controls">
                  <label>
                    <input type="checkbox" name="radios" />
                    First One</label>
                  <label>
                    <input type="checkbox" name="radios" />
                    Second One</label>
                  <label>
                    <input type="checkbox" name="radios" />
                    Third One</label>
                </div>
              </div>
              <div class="control-group">
                <label class="control-label">File upload input</label>
                <div class="controls">
                  <input type="file" />
                </div>
              </div>
              <div class="control-group">
                <label class="control-label">Disabled Input</label>
                <div class="controls">
                  <input type="text" placeholder="You can't type anything…" disabled="" class="span11">
                </div>
              </div>
              <div class="form-actions">
                <button type="submit" class="btn btn-success">Save</button>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div> --><!-- <hr>
    <div class="row-fluid">
      <div class="span6">
        <div class="widget-box">
          <div class="widget-title"> <span class="icon"> <i class="icon-align-justify"></i> </span>
            <h5>Form Elements</h5>
          </div>
          <div class="widget-content nopadding">
            <form class="form-horizontal">
              <div class="control-group">
                <label class="control-label">Color picker (hex)</label>
                <div class="controls">
                  <input type="text" data-color="#ffffff" value="#ffffff" class="colorpicker input-big span11">
                  <span class="help-block">Color picker with Formate of  (hex)</span> </div>
              </div>
              <div class="control-group">
                <label class="control-label">Color picker (rgba)</label>
                <div class="controls">
                  <input type="text" data-color="rgba(344,232,53,0.5)" value="rgba(344,232,53,0.5)" data-color-format="rgba" class="colorpicker span11">
                  <span class="help-block">Color picker with Formate of  (rgba)</span> </div>
              </div>
              <div class="control-group">
                <label class="control-label">Date picker (dd-mm)</label>
                <div class="controls">
                  <input type="text" data-date="01-02-2013" data-date-format="dd-mm-yyyy" value="01-02-2013" class="datepicker span11">
                  <span class="help-block">Date with Formate of  (dd-mm-yy)</span> </div>
              </div>
              <div class="control-group">
                <label class="control-label">Date Picker (mm-dd)</label>
                <div class="controls">
                  <div  data-date="12-02-2012" class="input-append date datepicker">
                    <input type="text" value="12-02-2012"  data-date-format="mm-dd-yyyy" class="span11" >
                    <span class="add-on"><i class="icon-th"></i></span> </div>
                </div>
              </div>
              <div class="control-group">
                <label class="control-label">Color Picker (rgb)</label>
                <div class="controls">
                  <div data-color-format="rgb" data-color="rgb(155, 142, 180)" class="input-append color colorpicker colorpicker-rgb">
                    <input type="text" value="rgb(155, 142, 180)" class="span11">
                    <span class="add-on"><i style="background-color: rgb(155, 142, 180)"></i></span> </div>
                </div>
              </div>
              <div class="control-group">
                <label class="control-label">Color Picker (hex)</label>
                <div class="controls">
                  <div data-color-format="hex" data-color="#000000"  class="input-append color colorpicker">
                    <input type="text" value="#000000" class="span11">
                    <span class="add-on"><i style="background-color: #000000"></i></span> </div>
                </div>
              </div>
              <div class="form-actions">
                <button type="submit" class="btn btn-success">Save</button>
                <button type="submit" class="btn btn-primary">Reset</button>
                <button type="submit" class="btn btn-info">Edit</button>
                <button type="submit" class="btn btn-danger">Cancel</button>
              </div>
            </form>
          </div>
        </div>
      </div>
      <div class="span6">
        <div class="widget-box">
          <div class="widget-title"> <span class="icon"> <i class="icon-align-justify"></i> </span>
            <h5>Form Elements</h5>
          </div>
          <div class="widget-content nopadding">
            <form class="form-horizontal">
              <div class="control-group">
                <label class="control-label">Tooltip Input</label>
                <div class="controls">
                  <input type="text" placeholder="Hover for tooltip…" data-title="A tooltip for the input" class="span11 tip" data-original-title="">
                </div>
              </div>
              <div class="control-group">
                <label class="control-label">Type ahead Input</label>
                <div class="controls">
                  <input type="text" placeholder="Type here for auto complete…" style="margin: 0 auto;" data-provide="typeahead" data-items="4" data-source="[&quot;Alabama&quot;,&quot;Alaska&quot;,&quot;Arizona&quot;,&quot;Arkansas&quot;,&quot;California&quot;,&quot;Colorado&quot;,&quot;Ahmedabad&quot;,&quot;India&quot;,&quot;Florida&quot;,&quot;Georgia&quot;,&quot;Hawaii&quot;,&quot;Idaho&quot;,&quot;Illinois&quot;,&quot;Indiana&quot;,&quot;Iowa&quot;,&quot;Kansas&quot;,&quot;Kentucky&quot;,&quot;Louisiana&quot;,&quot;Maine&quot;,&quot;Maryland&quot;,&quot;Massachusetts&quot;,&quot;Michigan&quot;,&quot;Minnesota&quot;,&quot;Mississippi&quot;,&quot;Missouri&quot;,&quot;Montana&quot;,&quot;Nebraska&quot;,&quot;Nevada&quot;,&quot;New Hampshire&quot;,&quot;New Jersey&quot;,&quot;New Mexico&quot;,&quot;New York&quot;,&quot;North Dakota&quot;,&quot;North Carolina&quot;,&quot;Ohio&quot;,&quot;Oklahoma&quot;,&quot;Oregon&quot;,&quot;Pennsylvania&quot;,&quot;Rhode Island&quot;,&quot;South Carolina&quot;,&quot;South Dakota&quot;,&quot;Tennessee&quot;,&quot;Texas&quot;,&quot;Utah&quot;,&quot;Vermont&quot;,&quot;Virginia&quot;,&quot;Washington&quot;,&quot;West Virginia&quot;,&quot;Wisconsin&quot;,&quot;Wyoming&quot;]" class="span11">
                </div>
              </div>
              <div class="control-group">
                <label class="control-label">Prepended Input</label>
                <div class="controls">
                  <div class="input-prepend"> <span class="add-on">#</span>
                    <input type="text" placeholder="prepend" class="span11">
                  </div>
                </div>
              </div>
              <div class="control-group">
                <label class="control-label">Appended Input</label>
                <div class="controls">
                  <div class="input-append">
                    <input type="text" placeholder="5.000" class="span11">
                    <span class="add-on">$</span> </div>
                </div>
              </div>
              <div class="control-group warning">
                <label class="control-label" for="inputWarning">Input with warning</label>
                <div class="controls">
                  <input type="text" id="inputWarning" class="span11">
                  <span class="help-inline">Something may have gone wrong</span> </div>
              </div>
              <div class="control-group error">
                <label class="control-label" for="inputError">Input with error</label>
                <div class="controls">
                  <input type="text" id="inputError" class="span11">
                  <span class="help-inline">Please correct the error</span> </div>
              </div>
              <div class="control-group info">
                <label class="control-label" for="inputInfo">Input with info</label>
                <div class="controls">
                  <input type="text" id="inputInfo" class="span11">
                  <span class="help-inline">Username is already taken</span> </div>
              </div>
              <div class="control-group success">
                <label class="control-label" for="inputSuccess">Input with success</label>
                <div class="controls">
                  <input type="text" id="inputSuccess" class="span11">
                  <span class="help-inline">Woohoo!</span> </div>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div> -->
 
</div>
</div>
<div class="row-fluid">
 <div id="footer" class="span12"> 2018 &copy; AJAHSMA. Brought to you by <a href="http://Ajahsma.in">Ajahsma.in</a> </div>
</div>
<script src="js/jquery.min.js"></script> 
<script src="js/jquery.ui.custom.js"></script> 
<script src="js/bootstrap.min.js"></script> 
<script src="js/bootstrap-colorpicker.js"></script> 
<script src="js/bootstrap-datepicker.js"></script> 
<script src="js/jquery.uniform.js"></script> 
<script src="js/select2.min.js"></script> 
<script src="js/maruti.js"></script> 
<script src="js/maruti.form_common.js"></script>
</body>
</html>

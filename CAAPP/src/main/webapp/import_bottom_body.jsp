
<div style="height: 150px; display: none;"></div>
<div class="row-fluid">
	<div id="footer" class="span12">
		2018 &copy; AJAHSMA. Brought to you by <a href="http://Ajahsma.in">Ajahsma.in</a>
	</div>
</div>

<div class="modal" id="confirmModal" style="display: none; z-index: 1050;top:40%;">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-body" id="confirmMessage"></div>
			<div class="modal-footer"  style="text-align: center;">
				<a href="" class="btn btn-primary" id="confirmOk" style="width: 65px;"> OK </a>
				<button type="button" class="btn btn-danger" id="confirmCancel" style="width: 90px;"> Cancel </button>
			</div>
		</div>
	</div>
</div>
<div class="modal" id="alertModal" style="display: none; z-index: 1050;top:40%;">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-body" id="alertMessage"></div>
			<div class="modal-footer"  style="text-align: center;">
				<p class="btn btn-primary" id="alertOk" style="width: 65px;"> OK </p>
			</div>
		</div>
	</div>
</div>

</body>

<script type="text/javascript">
$(document).ready(function(){
	var message = "${alert_msg}";
	if(message) {
		alertMessage(message)
	}
	
	
});
</script>

</html>

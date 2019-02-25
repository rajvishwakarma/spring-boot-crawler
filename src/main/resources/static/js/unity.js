/**
 * 
 */
$(function() {

	function crawl() {
		$("#internal").hide();
		$("#external").hide();
		$("#static").hide();
		$("#other").hide();
		var link = $("#link").val();

		//validation
		if (link == ""  || link == null){
			alert("Please provide the link");
			return false;
		}
		
		var pattern = new RegExp('^(https?:\\/\\/)?'+ // protocol
	            '((([a-z\\d]([a-z\\d-]*[a-z\\d])*)\\.?)+[a-z]{2,}|'+ // domain name
	            '((\\d{1,3}\\.){3}\\d{1,3}))'+ // ip (v4) address
	            '(\\:\\d+)?(\\/[-a-z\\d%_.~+]*)*'+ //port
	            '(\\?[;&a-z\\d%_.~+=-]*)?'+ // query string
	            '(\\#[-a-z\\d_]*)?$','i');
		if(!pattern.test(link)){
			alert("Invalid link");
			return false;
		}

		var query = "crawl";
		var body = "{ \"link\": \""+link+"\"}"
		$.ajaxSetup({
			headers:{
				'Content-Type': 'application/json'
			}
		});
		$.post(query, body).done(function(data){
			var internalLinks = $("#internal-links").empty();
			var externalLinks = $("#external-links").empty();
			var staticResources = $("#static-resources").empty();
			var otherResources = $("#other-resources").empty();
			if (!data)
				return;
			
			if(data.internalResources != undefined && data.internalResources.length > 0){
				data.internalResources.forEach(function(value) {
					$("<a href=\""+value+"\" target=\"_blank\">"+value+"</a><br/>").appendTo(internalLinks)
				});
				$("#internal").show();
			}
			
			if(data.externalResources != undefined && data.externalResources.length > 0){
				data.externalResources.forEach(function(value) {
					$("<a href=\""+value+"\" target=\"_blank\">"+value+"</a><br/>").appendTo(externalLinks)
				});
				$("#external").show();
			}
			
			if(data.staticResources != undefined && data.staticResources.length > 0){
				data.staticResources.forEach(function(value) {
					$("<a href=\""+value+"\" target=\"_blank\">"+value+"</a><br/>").appendTo(staticResources)
				});
				$("#static").show();
			}
			
			if(data.otherResources != undefined && data.otherResources.length > 0){
				data.otherResources.forEach(function(value) {
					$("<a href=\""+value+"\" target=\"_blank\">"+value+"</a><br/>").appendTo(otherResources)
				});
				$("#other").show();
			}
			
			showAlert(data.message, true);
		})
		.fail(function(xhr, status, error) {
			$("#results").hide();
			showAlert("something went wrong", false);
		});

		return false;
	}

	function showAlert(message, success){

		if(success)
			$('#msg').html('<div class="alert alert-success alert-dismissible ecosystem-alerts" role="alert"><button type="button" class="close" data-dismiss="alert">&times;</button><span class="glyphicon glyphicon-user" aria-hidden="true"></span> <strong>'+message+'</strong></div>').fadeIn('slow');
		else
			$('#msg').html('<div class="alert alert-danger alert-dismissible ecosystem-alerts" role="alert"><button type="button" class="close" data-dismiss="alert">&times;</button><span class="glyphicon glyphicon-lock" aria-hidden="true"></span> <strong>'+message+'</strong></div>').fadeIn('slow');
		$('#msg').delay(1000).fadeOut('slow');
	}

	$("#crawl").submit(crawl);

})
var cadena=null;
	function hacerPost(datos){
		console.log("hola2");
		let promise = new Promise( (resolve, reject) => {
				var postPromise = $.ajax({
				url: "http://localhost:4567/palabras",
				type: 'POST',
				data: datos,
				contentType: "application/json"
		});
			resolve(postPromise);
			
		});	
		console.log(promise);
		
		return promise;			
	}
	
	
	$(document).ready(function(){
		
		$("#button").click(function(){
			console.log("hola");
			cadena=$("#cadena").val();
			var pro=hacerPost(cadena);
			
			
		});

	});
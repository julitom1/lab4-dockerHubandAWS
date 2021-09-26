var cadena=null;
	function hacerGet(){
		console.log("hola3");
		$.get("http://localhost:4567/obtener"),function ( data ) {
			console.log(data);
		}
	}
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
		fetch("http://localhost:4567/obtener").then(response => response.json()).then(
			function  (data){
				console.log(data);
		});
			//hacerGet();
			console.log("hola");
			cadena=$("#cadena").val();
			var pro=hacerPost(cadena);
		});

	});

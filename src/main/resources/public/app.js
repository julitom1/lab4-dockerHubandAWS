var cadena=null;
	function hacerGet(){
		$(".clm_principal").remove();
		fetch("/obtener").then(response => response.json()).then(
			function  (data){
				console.log(data);
				var columnas="";
				for(const property in data){
					columnas=columnas+'<tr class="clm_principal">'
					columnas=columnas+"<td>"+data[property].palabra+"</td>";
					columnas=columnas+"<td>"+data[property].fecha+"</td>";
					columnas=columnas+"</tr>";
				}
				
				$("#tabla_fechas").append(columnas);
		});
		
	}
	function hacerPost(datos){

		let promise = new Promise( (resolve, reject) => {
				var postPromise = $.ajax({
				url: "/palabras",
				type: 'POST',
				data: datos,
				contentType: "application/json"
		});
			resolve(postPromise);
		});;
		return promise;
	}
	$(document).ready(function(){
		hacerGet();
		$("#button").click(function(){
		
			
			console.log("hola");
			cadena=$("#cadena").val();
			var pro=hacerPost(cadena);
			hacerGet();
			
		});

	});

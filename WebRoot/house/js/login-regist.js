$(function(){
	$('#myModal').on('shown.bs.modal', function () {
	  $('#myInput').focus()
	})

	// code
	getcode();
	
	// reg
	$(".reg").click(function(){
		$.ajax({
			url:commonurl+"user/regist.do",
			type:"POST",
			data:{
				phone:$("#phone").val(),
				password:$("#password").val(),
				userCode:$("#usercode").val(),
				codeKey:sessionStorage.getItem("codeKey")
			},
			success:function(data){
				alert(data.msg);
				if(data.success){
					$("#phone").val("");
					$("#password").val("");
					$("#usercode").val("")
				}
			}
		})
	})
	// login
	$(".login").click(function(){
		$.ajax({
			url:commonurl+"user/login.do",
			type:"POST",
			data:{
				phone:$("#userphone").val(),
				password:$("#userpassword").val(),
			},
			success:function(data){
				alert(data.msg);
				if(data.success){
					var name;
					var id=data.obj.id;
					if(data.obj.nickname){
						name = data.obj.nickname;
					}else{
						name = data.obj.phone;
					}
					if(data.obj.imageUrl){
						imageUrl = data.obj.imageUrl;
					}else{
						imageUrl = "./imgs/head.jpg";
					}
					sessionStorage.setItem("name", name);
					sessionStorage.setItem("id",id); 
					sessionStorage.setItem("imageUrl",imageUrl); 
					location.href="./index.html?name="+name;
				}				
			}
		})
	})
	

	
})

function regist(){
	$("#login").modal("hide");
}

function login(){

	$("#regist").modal("hide");

}

function getcode(){
	var key;
	$.ajax({
			url:commonurl+"user/getCodeImage.do",
			type:"POST",
			data:{
				
			},
			dataType:"json",
			success:function(data){
				sessionStorage.setItem("codeKey",data.msg)
				$(".code-img").attr("src",data.obj);

			}

		})
}
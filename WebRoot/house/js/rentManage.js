$(function(){
	$(".nickName").html(sessionStorage.getItem("name"));
	$(".left div div").click(function(){
		var id=$(this).attr("id");
		console.log(id);
		$(this).parent().parent().parent().find(".right>div").css("display","none");
		$(this).parent().parent().parent().find(".right ."+id).css("display","inline-block");
		$(this).parent().parent().find("div").removeClass('select');
		$(this).addClass("select");
		$(this).parent().parent().find("a").css("color","black");
		$(this).find("a").css("color","white");
	})


	$(".topoptions div").click(function(){
		var id=$(this).attr("id");
		console.log(id);
		$(this).parent().parent().find(".hid>div").css("display","none");
		$(this).parent().parent().find(".hid ."+id).css("display","inline-block");
		$(this).parent().parent().find(".topoptions div").removeClass('chose');
		$(this).addClass("chose");
	})

	$(".ownerName div input").blur(function(){
		if($(this).val()==""){
			$(".point").html("昵称不能为空");
			$(".point").css("color","red");
		}
	})

	$(".ownerPassword div input").blur(function(){
		if($(this).val()==""){
			$(this).parent().find(".pass").html("密码不能为空");
			$(this).parent().find(".pass").css("color","red");
		}
	})

	$(".ownerName div input").focus(function(){
		if($(this).val()==""){
			$(".point").html("");
		}
	})

	$(".ownerPassword div input").focus(function(){
		if($(this).val()==""){
			$(this).parent().find(".pass").html("");
		}
	})

	myoptions.onPageClicked = function(event, originalEvent, type, page) {
		ajaxLoadData({
			pageNo:page,
			userId:sessionStorage.getItem("id"),
		});
	};
	$("#rightContent").click(function(){
		ajaxLoadData({
				userId:sessionStorage.getItem("id"),
				pageNo:1
			});
	})
	// userimg	
	$("#file").change(function(){
		var formData = new FormData();
		var f= $('#file')[0].files[0];
		formData.append('file', f);
		formData.append('userId', sessionStorage.getItem("id"));
		$("#showImg").attr("src",window.URL.createObjectURL(this.files[0]));

		$.ajax({
			url:commonurl+"user/uploadHeadImage.do",
			type:"POST",
			data:formData,
			dataType:"json",
			processData: false,
			contentType: false,
			success:function(data){
				console.log(data);
				alert(data.msg);
				if(data.success){
					sessionStorage.setItem("userImg",commonurlimg+data.obj.imageUrl);
					$(".left img").attr("src", sessionStorage.getItem("userImg"));
				}
			}

		})
	})

	// myrent
	ajaxLoadData({
				userId:sessionStorage.getItem("id"),
				pageNo:1
			});
	$(".left img").attr("src", sessionStorage.getItem("userImg")?sessionStorage.getItem("userImg"):"/house/imgs/head.jpg");

	// nickName
	$(".savenickname").click(function(){
		$.ajax({
			url:commonurl+"user/modifyNickname.do",
			type:"POST",
			data:{
				userId:sessionStorage.getItem("id"),
				nickname:$("#nickName").val()
			},
			dataType:"json",
			success:function(data){
				alert(data.msg);
				if(data.success){
					sessionStorage.setItem("name",data.obj.nickname);
					window.location.reload();
				};
				console.log(data);
			}

		})
	})

	// password
	$(".savepassword").click(function(){
		$.ajax({
			url:commonurl+"user/modifyPassword.do",
			type:"POST",
			data:{
				userId:sessionStorage.getItem("id"),
				oldPassword:$("#oldPassword").val(),
				newPassword:$("#newPassword").val(),
				rePassword:$("#rePassword").val()

			},
			dataType:"json",
			success:function(data){
				alert(data.msg);
				console.log(data);
			}

		})
	})

	// out
	$(".log").click(function(){
    	$.ajax({
			url:commonurl+"user/loginOut.do",
			type:"POST",
			data:{
				userId:sessionStorage.getItem("id")
			},
			dataType:"json",
			success:function(data){
				console.log(data);
				sessionStorage.removeItem("name")
					sessionStorage.removeItem("id");
					sessionStorage.removeItem("imageUrl");
				location.href="../house/index.html";
			}

		})
    })

})

	function openFile(){
		$("#file").click();
	}

	function ajaxLoadData(data){
		$.ajax({
			url:commonurl+"houseInfo/findMyHouseInfos.do",
			type:"POST",
			data:data,
			dataType:"json",
			success:function(data){
				if(data.success){
				obj=data.obj;		
				obj.list.forEach(function(value,index){
						value.houseType=value.houseType.split(",");
						value.createTime=new Date(value.createTime) ;
						value.createTime=value.createTime.getFullYear() + "年" + (value.createTime.getMonth() + 1) + "月" + value.createTime.getDate() + "日 " + value.createTime.getHours() + "点" + value.createTime.getMinutes() + "分" + value.createTime.getSeconds() + "秒";
				})
				var datas={
	                	sources:obj.list,
	                	commonurlimg:commonurlimg
	            	};
				$(".rightContent").html(template("myrent",datas));
				obj.list.forEach(function(value,index){
					if(value.status==-1){
				 		$("."+value.id).html("已删除");
				 		$("#"+value.id).html("");
					}
				})
				myPaginatorFun("myPages", obj.pageNo, obj.pages);
			}else{
				alert(data.msg);
			}
			}

		})
	}

	// function myRent(){
	// 	$.ajax({
	// 		url:commonurl+"houseInfo/findMyHouseInfos.do",
	// 		type:"POST",
	// 		data:{
	// 			userId:sessionStorage.getItem("id"),
	// 			pageNo:1
	// 		},
	// 		dataType:"json",
	// 		success:function(data){
	// 			console.log(data);
	// 			if(data.success){
	// 			obj=data.obj;		
	// 			obj.list.forEach(function(value,index){
	// 					value.houseType=value.houseType.split(",");
	// 					value.createTime=new Date(value.createTime) ;
	// 					value.createTime=value.createTime.getFullYear() + "年" + (value.createTime.getMonth() + 1) + "月" + value.createTime.getDate() + "日 " + value.createTime.getHours() + "点" + value.createTime.getMinutes() + "分" + value.createTime.getSeconds() + "秒";
	// 			})
	// 			var datas={
	//                 	sources:obj.list,
	//                 	commonurlimg:commonurlimg
	//             	};
	// 			$(".rightContent").html(template("myrent",datas));
	// 			obj.list.forEach(function(value,index){
	// 				if(value.status==-1){
	// 			 		$("."+value.id).html("已删除");
	// 			 		$("#"+value.id).html("");
	// 				}
	// 			})
	// 		}else{
	// 			alert(data.msg);
	// 		}
	// 		}

	// 	})
	// }

	// delete
    function del(obj){
		$.ajax({
			url:commonurl+"houseInfo/remove.do",
			type:"POST",
			data:{
				userId:sessionStorage.getItem("id"),
				id:obj

			},
			dataType:"json",
			success:function(data){
				if(data.success){
					window.location.reload();
				}else{
					alert(data.msg);
				}
			}

		})

}

// modify	
		
	function modify(obj){
		location.href="../house/modifyRent.html?id="+obj;
	}
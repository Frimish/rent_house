$(function(){
	$(".renttype li").click(function(){
		$(this).parent().parent().find(".text").html($(this).html());
	})

	$(".paytype li").click(function(){
		$(this).parent().parent().find(".text").html($(this).html());
	})

	$(".statetype li").click(function(){
		$(this).parent().parent().find(".text").html($(this).html());
	})

	$(".dicrtype li").click(function(){
		$(this).parent().parent().find(".text").html($(this).html());
	})

	$("#file").change(function(){
		$.each(this.files,function(key,value){
			$content = $($("#template").html());
			$content.find("img").attr("src",window.URL.createObjectURL(value))
			$(".imgs").append($content);
		})
	})

    var name=sessionStorage.getItem("name");
    if(name!=="null"){
    	$(".regi").html("<a>"+name+"</a> |");
    	$(".log").html("<a>退出</a>");
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
					location.href="./index.html";
				}

			})
    	})
    }
	// area search
	$.ajax({
		url:commonurl+"area/findByParentId.do",
		type:"POST",
		data:{
			parentId:2,
		},
		dataType:"json",
		success:function(data){			
			if(data.success){
			var obj=data.obj;			
			var datas={
            	sources:obj
        	};
            $(".dis").html(template("area",datas));
            $(".dis").find("li").click(function(){
				$(".selectarea .text").html($(this).html());
				$.ajax({
					url:commonurl+"area/findByParentId.do",
					type:"POST",
					data:{
						parentId:$(this).find("a").attr("id"),
					},
					dataType:"json",
					success:function(data){
						console.log(data.obj);
						var datas={
		                	source:data.obj
		            	};
			            console.log(datas);
			            $(".hid").html(template("ar",datas));
			            $(".hid").find("li").click(function(){
			            	$(".bankuai .text").html($(this).html());
			            	$(".bankuai .text").attr("id",$(this).attr("id"));
			            })
					}
				})
			})
		}
		}
	})
	// code
	getCodeImage();
			
	// submit		
	$(".botton").click(function(){
		equips=[];
    	$(".housecontainer").find("input").parents("ul").find("input").each(function(i,el){
    		if($(el).prop("checked")){
    			equips.push($(el).attr("data-item"));
    		}	    		
    	})	
		var equip=equips.join(",");
		
		var formData = new FormData();
		var userId= sessionStorage.getItem("id");
		var codeKey= sessionStorage.getItem("codeKey");
		var userCode= $(".code input").val();
		var communityName= $("#communityName").val();
		var areaId=$(".bankuai .text a").attr("id");
		var roomNo= $(".dong").val()+","+$(".danyuan").val()+","+$(".shi").val();
		var rentType= $(".rent .text").text();
		var houseType= $(".sh").val()+","+$(".ting").val()+","+$(".wei").val();
		var acreage= $(".houseareas input").val();
		var rent= $(".houseprice input").val();
		var payType= $(".selectpaytype .text").text();
		var floorInfo= $(".currentfloor").val()+","+$(".totalfloor").val();
		var houseState= $(".selectdecration .text").text()+","+$(".selectdicr .text").text();
		var title= $(".title input").val();
		var equips= equip;
		var detail= $("#details").val();
		var linkman= $(".linkman").val();
		var phone= $("#phone").val();
		var multiFiles= $('#file')[0].files;


		for(var i=0; i<multiFiles.length;i++){
           formData.append('multiFiles',multiFiles[i]);
       	}				
		
		formData.append('userId', userId);
		formData.append('codeKey', codeKey);
		formData.append('userCode', userCode);
		formData.append('communityName', communityName);
		formData.append('areaId', areaId);
		formData.append('roomNo', roomNo);
		formData.append('rentType', rentType);
		formData.append('houseType', houseType);
		formData.append('acreage', acreage);
		formData.append('rent', rent);
		formData.append('payType', payType);
		formData.append('floorInfo', floorInfo);
		formData.append('houseState', houseState);
		formData.append('title', title);
		formData.append('equips', equip);
		formData.append('detail', detail);
		formData.append('linkman', linkman);
		formData.append('phone', phone);
		$.ajax({
			url:commonurl+"houseInfo/add.do",
			type:"POST",
			data:formData,
			dataType:"json",
			processData: false,
			contentType: false,
			success:function(data){
				console.log(data);				
				if(data.success){
					window.location.href="./index.html";
				}else{
					alert(data.msg);
				}
			}

		})
		console.log(areaId);
	})
	
})




	function openFile(){
		$("#file").click();
	}


	function removeThis(item){
		$(item).parent().remove();
	}

	function getCodeImage(){
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
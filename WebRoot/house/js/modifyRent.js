$(function(){
	//get id
	function getRequest1(){
        var str=decodeURI(location.search); 
        if(str){
            var url=str.substr(1),arr=url.split('&'),len=arr.length,i= 0,request={};
            for(;i<len;i++){
                request[arr[i].split('=')[0]]=arr[i].split('=')[1];
            }
            return request;
        }
        return "";
    }
    var Request=getRequest1();
    id=Request.id;
    console.log(id);

    var houseid;
	$.ajax({
		url:commonurl+"houseInfo/findById.do",
		type:"POST",
		data:{
			id:id,
			userId:sessionStorage.getItem("id")
		},
		dataType:"json",
		success:function(data){
			console.log(data);
			if(data.success){
			obj=data.obj;
			var areaId= obj.areaId;
			var qushu;
			$.ajax({
				url:commonurl+"area/findParentById.do",
				type:"POST",
				data:{'id': areaId},
				dataType:"json",
				success:function(data){
					console.log(data);
					qushu=data.obj.name;
					$(".selectarea .text").text(qushu);
				}
			});
			houseid=obj.id;
			obj.houseType=obj.houseType.split(",");
			obj.houseState=obj.houseState.split(",");
			obj.floorInfo=obj.floorInfo.split(",");
			obj.roomNo=obj.roomNo.split(",");
			obj.equips=obj.equips.split(",");
			$(".housecontainer").find("input").each(function(index,value){
				if(obj.equips.indexOf(value.getAttribute("data-item"))>=0){
						$(value).prop("checked","true");
				}
			})
			console.log(qushu);
			$("#communityName").val(obj.communityName);
			// $(".selectarea .text").val(qushu);
			$(".bankuai .text").text(obj.area.name);
			$(".dong").val(obj.roomNo[0]);
			$(".danyuan").val(obj.roomNo[1]);
			$(".shi").val(obj.roomNo[2]);
			$(".selecttype .text").text(obj.rentType);
			$(".sh").val(obj.houseType[0]);
			$(".ting").val(obj.houseType[1]);
			$(".wei").val(obj.houseType[2]?obj.houseType[2]:"");
			$(".houseareas input").val(obj.acreage);
			$(".houseprice input").val(obj.rent);
			$(".selectpaytype .text").text(obj.payType);
			$(".currentfloor").val(obj.floorInfo[0]);
			$(".totalfloor").val(obj.floorInfo[1]);
			$(".selectdecration .text").text(obj.houseState[0]);
			$(".housedicr .text").text(obj.houseState[1]);
			$(".title input").val(obj.title);
			$(".detailIntroduce #details").val(obj.detail);
			$(".linkman").val(obj.user.nickname);
			$("#phone").val(obj.user.phone);
			$.each(obj.images,function(key,value){
				var id = value.id;
				$content = $($("#template").html());
				$content.find("img").attr("src",commonurlimg+value.path);
				$content.find("span").click({id:id},function(event){
					removeTh(id,event.currentTarget)
				});
				
				$(".imgs").append($content);
			})

			$("#files").change(function(){
				$.each(this.files,function(key,value){
					$content = $($("#template").html());
					$content.find("img").attr("src",window.URL.createObjectURL(value));
					$(".imgs").append($content);
				})
			})
				// submit		
			$(".bott").click({removeImages:removeImages},function(){
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
				var multiFiles= $("#files")[0].files;

				for(var i=0; i<multiFiles.length;i++){
		           formData.append('multiFiles',multiFiles[i]);
		       	}								
				formData.append('userId', userId);
				formData.append('codeKey', codeKey);
				formData.append('userCode', userCode);
				formData.append('id', houseid);
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
				for (var i = 0; i < removeImages.length; i++) {
					formData.append('removeImages', removeImages[i]);
				}
				$.ajax({
					url:commonurl+"houseInfo/modify.do",
					type:"POST",
					data:formData,
					dataType:"json",
					processData: false,
					contentType: false,
					success:function(data){
						console.log(data);
						if(data.success){
							window.location.href="./houseDetails.html?id="+houseid;
						}else{
							alert(data.msg);
						}
						
					}

				})
				console.log(areaId);
			})
			}else{
				alert(data.msg);
			}
		    }
		})
	
})

	var removeImages = [];
	function openFiles(){
		$("#files").click();
	}
	function removeTh(id,item){
		removeImages.push(id);
		$(item).parent().remove();
	}
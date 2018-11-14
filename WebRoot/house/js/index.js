$(function(){
	var areaParentId;
	var rentBegin;
	var rentEnd;
	var acreageBegin;
	var acreageEnd;
	var houseType;
	var houseState;
	var floorInfo;
	var rentType;
	var sort;
	// pagesearch
	myoptions.onPageClicked = function(event, originalEvent, type, page) {
 		houseState=$(".state").attr("dir");
		floorInfo=$(".floor").attr("id");
		rentType=$(".type").attr("typ");
 		areaParentId=$(".area .active").attr("id");
		rentBegin=$(".price .active").find(".begin").text();
		rentEnd=$(".price .active").find(".end").text();
		acreageBegin=$(".areas .active").find(".begin").text();
		acreageEnd=$(".areas .active").find(".end").text();
		houseType=$(".layouthouse .active").attr("id");
		ajaxLoadData({
			pageNo:page,
			areaParentId,
			rentBegin,
			rentEnd,
			acreageBegin,
			acreageEnd,
			houseType,
			houseState,
			floorInfo,
			rentType,
			sort,
		});
	};

	
	$(".hid li").click(function(){
		$(this).parent().parent().find('span').text($(this).text());
		$(this).parent().parent().find('span').attr("id",$(this).find("a").attr("id"));
		$(this).parent().parent().find('span').attr("dir",$(this).find("a").attr("dir"));
		$(this).parent().parent().find('span').attr("typ",$(this).find("a").attr("typ"));
		houseState=$(".state").attr("dir");
		floorInfo=$(".floor").attr("id");
		rentType=$(".type").attr("typ");
		ajaxLoadData({
					pageNo:1,
					areaParentId,
					rentBegin,
					rentEnd,
					acreageBegin,
					acreageEnd,
					houseType,
					houseState,
					floorInfo,
					rentType,
					sort,
				});
	})
	$(".sort .sort-item").click(function(){
		$(this).parent().find("li").removeClass("choosed");
		$(this).addClass("choosed");
		sort=$(".sort .choosed").find("a").attr("id");
		ajaxLoadData({
					pageNo:1,
					areaParentId,
					rentBegin,
					rentEnd,
					acreageBegin,
					acreageEnd,
					houseType,
					houseState,
					floorInfo,
					rentType,
					sort,
				});
	})

	
	// area search
	$.ajax({
		url:commonurl+"area/findByParentId.do",
		type:"POST",
		data:{
			parentId:2,
		},
		dataType:"json",
		success:function({obj}){
			var datas={
                sources:obj,
            };
	        $(".area").html(template("area",datas));

	        $(".typeList li a").click(function(){
				$(this).parent().parent().find("a").removeClass('active');
				$(this).addClass('active');
				areaParentId=$(".area .active").attr("id");
				rentBegin=$(".price .active").find(".begin").text();
				rentEnd=$(".price .active").find(".end").text();
				acreageBegin=$(".areas .active").find(".begin").text();
				acreageEnd=$(".areas .active").find(".end").text();
				houseType=$(".layouthouse .active").attr("id");
				ajaxLoadData({
					pageNo:1,
					areaParentId,
					rentBegin,
					rentEnd,
					acreageBegin,
					acreageEnd,
					houseType,
					houseState,
					floorInfo,
					rentType,
					sort,
				});
			})
		}

	})
	// house search
	ajaxLoadData({
				pageNo:1,
				areaParentId,
				rentBegin,
				rentEnd,
				acreageBegin,
				acreageEnd,
				houseType,
				houseState,
				floorInfo,
				rentType,
				sort,
			});

    name=sessionStorage.getItem("name");
    // console.log(name)
    if(name!=="null"){
    	$(".regi").html("<a>"+name+"</a> |");
    	$(".log").html("<a>退出</a>");
    	// out
    	$(".log").click(function(){
    		console.log(1);
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
					window.location.reload();
				}

			})
    	})
    }
})

	function ajaxLoadData(data){
		$.ajax({
			url:commonurl+"houseInfo/find.do",
			type:"POST",
			data:data,
			dataType:"json",
			success:function({obj}){
				obj.list.forEach(function(value,index){
					value.houseType=value.houseType.split(",");
					value.houseState=value.houseState.split(",");
					value.floorInfo=value.floorInfo.split(",");
					value.updateTime=new Date(value.updateTime) ;
					value.updateTime=value.updateTime.getFullYear() + "年" + (value.updateTime.getMonth() + 1) + "月" + value.updateTime.getDate() + "日 " + value.updateTime.getHours() + "点" + value.updateTime.getMinutes() + "分" + value.updateTime.getSeconds() + "秒";
				})
				var datas={
                	sources:obj.list,
                	total:obj.total,
                	commonurlimg:commonurlimg
            	};
	            $(".houseList").html(template("detailList",datas));
				myPaginatorFun("myPages", obj.pageNo, obj.pages);
			}

		})
	}


	function showDetails(obj){
		location.href="./houseDetails.html?id="+obj;
	}


	function houserent(){
		console.log(name);
		if(name!=="null"){
			location.href="./houserent.html?name="+name;
		}else{
			alert("请登陆");
		}
	}

	function houseManage(){
		console.log(name);
		if(name!=="null"){
			location.href="./rentManage.html";
		}else{
			alert("请登陆");
		}
	}

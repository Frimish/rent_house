$(function(){
	function getRequest1(){
        var str=location.search; 
        if(str){
            var url=str.substr(1),arr=url.split('&'),len=arr.length,i= 0,request={};
            for(;i<len;i++){
                request[arr[i].split('=')[0]]=arr[i].split('=')[1];
            }
            return request;
        }else{
            alert('没有传递参数');
        }
    }
    var Request=getRequest1();
    var id=Request.id;
    userId=sessionStorage.getItem("id")?sessionStorage.getItem("id"):"";
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
   	$.ajax({
			url:commonurl+"houseInfo/lookById.do",
			type:"POST",
			data:{
				id,
				userId:userId
			},
			dataType:"json",
			success:function({obj}){
				obj.houseType=obj.houseType.split(",");
				obj.houseState=obj.houseState.split(",");
				obj.floorInfo=obj.floorInfo.split(",");
				obj.equips=obj.equips.split(",");
				obj.updateTime=new Date(obj.updateTime) ;
				obj.updateTime=obj.updateTime.getFullYear() + "年" + (obj.updateTime.getMonth() + 1) + "月" + obj.updateTime.getDate() + "日 " + obj.updateTime.getHours() + "点" + obj.updateTime.getMinutes() + "分" + obj.updateTime.getSeconds() + "秒";
				$(".communityName").html(obj.communityName);
				$(".shi").html(obj.houseType[0]);
				$(".ting").html(obj.houseType[1]);
				$(".acreage").html(obj.acreage);
				$(".price").html(obj.rent);
				$(".others").html("("+obj.rentType+","+obj.houseState[1]+","+obj.payType+")");
				$(".houseState").html(obj.houseState[0]);
				$(".currentfloor").html(obj.floorInfo[0]);
				$(".totalfloor").html(obj.floorInfo[1]);
				$(".areaname").html(obj.area.name);
				$(".ownername").html(obj.linkman);
				$(".phone").html(obj.phone);
				$(".updatetime").html(obj.updateTime);
				obj.equips.forEach(function(value,index){
					var li=$("<li></li>");
					li.append($("<i class='icon iconfont icon-right'></i>"));
					li.append($("<span>"+value+"</span>"));
					$(".equips").append(li);
				})

				for(var i=0;i<obj.images.length;i++){
					var div=$("<div class='swiper-slide'></div");
					div.append($("<img src="+commonurlimg+obj.images[i].path+">"));
					$(".houseImg #top").append(div);
				}
				for(var i=0;i<obj.images.length;i++){
					var div=$("<div class='swiper-slide'></div");
					div.append($("<img src="+commonurlimg+obj.images[i].path+">"));
					$(".houseImg #bottom").append(div);
				}

				for(var i=0;i<obj.images.length;i++){
					var div=$("<div class='col-xs-8'></div");
					div.append($("<img src="+commonurlimg+obj.images[i].path+">"));
					$(".detailpicture").append(div);
				}
				var swiperTop=new Swiper(".gallery-top",{
					spaceBetween:20,
					prevButton:".swiper-button-prev",
					nextButton:".swiper-button-next",
					loop:true,
					loopedSlides:4,

				});
				var swiperThumbs=new Swiper(".gallery-thumbs",{
					spaceBetween:20,
					slidesPerView:"auto",
					loop:true,
					loopedSlides:4,
					centeredSlides:true
				});
				swiperTop.params.control=swiperThumbs;
				swiperThumbs.params.control=swiperTop;
				$(".brief").html(obj.detail);
				var index=obj.user.imageUrl.lastIndexOf("/");
				if(obj.user.imageUrl.substring(index+1)=="null"){
					$(".ownerpicture img").attr("src","./imgs/head.jpg");
				}else{
					$(".ownerpicture img").attr("src",commonurlimg+obj.user.imageUrl);
				}
				
			}

		})

})


	function houserent(){
		console.log(name);
		if(name){
			location.href="./houserent.html?name="+name;
		}else{
			alert("请登陆");
		}
	}

	function houseManage(){
		console.log(name);
		if(name){
			location.href="./rentManage.html";
		}else{
			alert("请登陆");
		}
	}
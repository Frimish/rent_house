## rentHouse项目文档

```
项目请求路径: http://localhost:8080/rentHouse

所有ajax方法返回格式json
{"success":true,"msg":"",obj:""}
success:操作是否成功
msg:相关提示信息
obj:方法返回的数据实体

所有文件保存的位置必须使用String uploadPath = CommonUtil.getUploadPath();路径最后不含"/".
所有请求文件的路径必须使用CommonUtil.getContextPath() + "/" + 自定义文件名(可包含文件夹名)
```

## UserController

com.itany.rent.controller.UserController类中的方法

### 登录,login

```properties
#请求路径
url=http://localhost:8080/rentHouse/user/login.do
#请求类型
type=post,get
#方法参数
phone=手机号
password=密码
```

```json
//返回值json格式示例
{"success":true,"msg":"",obj:""}
```



### 退出登录,loginOut

```properties
#请求路径
url=http://localhost:8080/rentHouse/user/loginOut.do
#请求类型
type=post,get
#方法参数
userId=用户id
```



### 注册,regist

```properties
#请求路径
url=http://localhost:8080/rentHouse/user/regist.do
#请求类型
type=post
#方法参数
phone=手机号
password=密码
userCode=验证码
codeKey=生成验证码时的key

```





### 上传头像

```properties
#请求路径
url=http://localhost:8080/rentHouse/user/uploadHeadImage.do
#请求类型
type=post
#方法参数
userId=登录用户的id
file=图片
```



### 修改昵称

```properties
#请求路径
url=http://localhost:8080/rentHouse/user/modifyNickname.do
#请求类型
type=post
#方法参数
userId=登录用户的id
nickname=昵称

```



### 修改密码

```properties
#请求路径
url=http://localhost:8080/rentHouse/user/modifyPassword.do
#请求类型
type=post
#方法参数
userId=登录用户的id
oldPassword=原密码
newPassword=新密码
rePassword=重复新密码

```



### 获取验证码(图片)

```properties
#请求路径
url=http://localhost:8080/rentHouse/user/getCodeImage.do
#请求类型
type=post
#方法参数
num=验证码样式,默认值为4:使用数字和字母(4个),没有干扰线

```



### 获取验证码(图片对应的字符串)

```properties
#请求路径
url=http://localhost:8080/rentHouse/user/getCodeStr.do
#请求类型
type=post
#方法参数
codeKey=生成验证码时的key

```



## HouseInfoController

com.itany.rent.controller.HouseInfoController类中的方法

### 首页条件搜索

```properties
#请求路径
url=http://localhost:8080/rentHouse/houseInfo/find.do
#请求类型
type=post
#方法参数
pageNo=当前第几页
#以下可选参数
areaParentId=主地区id,例:秦淮区...
areaId=子地区id,例:夫子庙街道...
rentBegin=租金范围开始
rentEnd=租金范围结束
acreageBegin=面积范围开始
acreageEnd=面积范围结束
houseType=房型:几室,例:5(5室)
houseState=朝向:南,西南,东,东南,北,东北,西,西北,南北,东西
floorInfo=楼层:低楼层1(1-4层),中楼层2(5-8层),高楼层3(9层以上)
sign=品牌:全部,链家,自如
rentType=租赁方式:整租,合租,全部(不需要传参数)
sort=排序:默认(不需要传参数),最新1,租金低2,面积小3,地铁距离近4
```



### 修改使用,获取指定的房源信息

```properties
#请求路径
url=http://localhost:8080/rentHouse/houseInfo/findById.do
#请求类型
type=post
#方法参数
id=房源信息id
userId=登录用户的id
```



### 首页查询指定的房源信息

```properties
#请求路径
url=http://localhost:8080/rentHouse/houseInfo/lookById.do
#请求类型
type=post
#方法参数
id=房源信息id
userId=登录用户的id
```



### 我的发布

```properties
#请求路径
url=http://localhost:8080/rentHouse/houseInfo/findMyHouseInfos.do
#请求类型
type=post
#方法参数
userId=登录用户的id
pageNo=当前第几页

```



### 发布房源

```properties
#请求路径
url=http://localhost:8080/rentHouse/houseInfo/add.do
#请求类型
type=post
#方法参数
userId=登录用户的id
userCode=用户输入的验证码
codeKey=生成验证码时的key
communityName=小区名称
areaId=所属板块
roomNo=门牌号,几幢几单元几室等等;例:1幢,1单元,107室
rentType=租赁方式:整租,合租
houseType=户型:几室几厅;例:3,2,1,1(三室两厅一厨一卫)
acreage=面积m2
rent=租金:元/月(不含小数)
payType=付款方式:月付,半年付,一年付
floorInfo=楼层信息, 例2,12 第2层,共12层
#房屋状态:毛坯,简装,精装,豪装(豪华装);方向:南,西南,东,东南,北,东北,西,西北,南北,东西
houseState=例:简装,东南
title=标题
#房屋配套的设备等:床,冰箱,电视,空调,洗衣机,热水器,家具,宽带,可做饭,独立卫生间...全无
equips=例:床,冰箱,电视,空调,洗衣机,热水器
detail=详细介绍
linkman=联系人
phone=手机号码
multiFiles=一个或多个图片
```



### 修改房源

```properties
#请求路径
url=http://localhost:8080/rentHouse/houseInfo/modify.do
#请求类型
type=post
#方法参数
userId=登录用户的id
userCode=用户输入的验证码
codeKey=生成验证码时的key
id=房源信息id
communityName=小区名称
areaId=所属板块
roomNo=门牌号,几幢几单元几室等等;例:1幢,1单元,107室
rentType=租赁方式:整租,合租
houseType=户型:几室几厅;例:3,2,1,1(三室两厅一厨一卫)
acreage=面积m2
rent=租金:元/月(不含小数)
payType=付款方式:月付,半年付,一年付
floorInfo=楼层信息, 例2,12 第2层,共12层
#房屋状态:毛坯,简装,精装,豪装(豪华装);方向:南,西南,东,东南,北,东北,西,西北,南北,东西
houseState=例:简装,东南
title=标题
#房屋配套的设备等:床,冰箱,电视,空调,洗衣机,热水器,家具,宽带,可做饭,独立卫生间...全无
equips=例:床,冰箱,电视,空调,洗衣机,热水器
detail=详细介绍
linkman=联系人
phone=手机号码
multiFiles=一个或多个图片
removeImages=需要删除的一个或多个图片的id
```



### 删除房源信息

```properties
#请求路径
url=http://localhost:8080/rentHouse/houseInfo/remove.do
#请求类型
type=get,post
#方法参数
userId=登录用户的id
id=房源信息id
```



## AreaController

com.itany.rent.controller.AreaController类中的方法

### 获取所有区域信息

```properties
#请求路径
url=http://localhost:8080/rentHouse/area/findByParentId.do
#请求类型
type=post
#方法参数
parentId=查询某地区下的所有地区(没有值时,查询最顶层的地区)

```

### 根据地区id查询其所属地区信息

```properties
#请求路径
url=http://localhost:8080/rentHouse/area/findParentById.do
#请求类型
type=post
#方法参数
id=地区id
```


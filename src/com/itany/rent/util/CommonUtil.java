package com.itany.rent.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.UUID;

import javax.servlet.ServletContext;

import com.itany.rent.constant.Constant;
import com.itany.rent.entity.User;

/**
 * 工具类
 * @author ldl
 * @date 2018年5月9日 下午2:52:07
 * @version 1.0
 */
public class CommonUtil {
	
	/**
	 * 存储登录的用户信息<br>
	 * key=userId,value=User<br>
	 */
	private static Map<String, User> users = Collections.synchronizedMap(new HashMap<String, User>());
	
	/**
	 * 存放用户的验证码<br>
	 * key=keyId,value=UserCode(code,time)<br>
	 * 需要定时清空无效的验证码<br>
	 */
	private static Map<String, UserCode> userCodes = Collections.synchronizedMap(new HashMap<String, UserCode>());
	
	private static String uploadPath;
	/**
	 * 文件请求路径
	 */
	private static String contextPath;
	/**
	 * 项目应用application
	 */
	private static ServletContext context;

	static {
		loadProperties();
	}
	
	/**
	 * 加载文件上传的配置文件
	 */
	private static void loadProperties() {
		Properties p = new Properties();
		try {
			p.load(CommonUtil.class.getClassLoader().getResourceAsStream("file.properties"));
			String key = p.getProperty(Constant.UPLOAD_PATH_PREFIX);
			uploadPath = p.getProperty(key + Constant.UPLOAD_PATH_SUFFIX);
		} catch (IOException e) {
			throw new IllegalArgumentException("file.properties配置文件未找到", e);
		}
		if(null == uploadPath){
			throw new IllegalArgumentException("文件上传路径获取失败");
		}
	}
	
	/**
	 * 获取文件上传的路径(如果文件夹不存在,则自动创建),末尾没有"/"
	 * @return 
	 */
	public static String getUploadPath(){
		String realPath = getContext().getRealPath(uploadPath);
		File f = new File(realPath);
		if(!f.exists()){
			boolean flag = f.mkdirs();
			if(!flag){
				throw new IllegalArgumentException("文件上传路径创建失败:" + realPath);
			}
		}
		return realPath;
	}
	
	/**
	 * 获取文件请求路径,file.properties中的path有"/",就有
	 * @return
	 */
	public static String getContextPath(){
		if(null == contextPath){
			contextPath = getContext().getContextPath() + "/" + uploadPath;
		}
		return contextPath;
	}

	public static ServletContext getContext() {
		if(null == context){
			throw new RuntimeException("项目启动失败,或者项目已停止");
		}
		return context;
	}

	public static void setContext(ServletContext context) {
		CommonUtil.context = context;
	}
	
	/**
	 * @see  java.util.Random 随机类
	 */
	public static Random r = new Random();
	/**
	 * 生成随机颜色
	 * @return java.awt.Color
	 */
	public static Color randomColor(){
		Color color = new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256));
		return color;
	}
	public static final String[] FONT_NAMES = {
		"宋体", "楷书", "仿宋", "黑体", "微软雅黑"
	};
	public static final int[] FONT_STYLES = {
		Font.BOLD, Font.ITALIC, Font.PLAIN,
		Font.BOLD + Font.ITALIC
	};
	/**
	 * 生成随机字体
	 * @return java.awt.Font
	 */
	public static Font randomFont(){
		String name = FONT_NAMES[r.nextInt(FONT_NAMES.length)];
		int style = FONT_STYLES[r.nextInt(FONT_STYLES.length)];
		int size = 30;
		Font f = new Font(name, style, size);
		return f;
	}
	
	/**
	 * 随机产生几个字符
	 * @param counts
	 * @return java.lang.String
	 */
	public static String randomCode(int counts){
		String words = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		Random r = new Random();
		StringBuffer code = new StringBuffer();
		for (int i = 0; i < counts; i++) {
			int index = r.nextInt(words.length());
			code.append(words.charAt(index));
		}
		return code.toString();
	}
	/**
	 * 随机产生一个有四个中文的字符串
	 * @return java.lang.String
	 */
	public static String randomCode(){
		int len = words.length;
		if(0 == len){
			return null;
		}
		return words[r.nextInt(len)];
	}
	
	/**
	 * 生成验证码
	 * @param backColor 背景颜色
	 * @param counts 验证码中的字数(字数越多,图片宽度越大,最小4个,width最小80,height30)
	 * @param isChinese 是否选择中文验证码(使用时无法指定字符数量)
	 * @param hasLines 是否有干扰线
	 * @return com.itany.netClass.util.CommonUtil.MyImage(width:auto,height:40)
	 */
	public static MyImage getImage(Color backColor, int counts, boolean isChinese, boolean hasLines){
		MyImage m = CommonUtil.getImage(backColor, false, null, counts, isChinese, hasLines);
		return m;
	}
	/**
	 * 生成验证码
	 * @param backColor 背景颜色
	 * @param codes 验证码,其中的字数越多,图片宽度越大,width动态,height30
	 * @param hasLines 是否有干扰线
	 * @return com.itany.netClass.util.CommonUtil.MyImage(width:auto,height:40)
	 */
	public static MyImage getImage(Color backColor, String codes, boolean hasLines){
		if(null == codes || "".equals(codes.trim())){
			return null;
		}
		MyImage m = CommonUtil.getImage(backColor, true, codes, 0, true, hasLines);
		return m;
	}
	
	/**
	 * 会随机生成4条干扰线
	 * @param backColor 背景颜色,可以没有
	 * @param isUseCode 是否使用自定义code
	 * @param codeString 自定义code字符串
	 * @param counts 不使用自定义code或中文成语时,指定生成的字符数量
	 * @param isChinese 是否生成中文成语字符串
	 * @param hasLines 是否有干扰线
	 * @return com.itany.netClass.util.CommonUtil.MyImage(width:auto,height:40)
	 */
	private static MyImage getImage(Color backColor, boolean isUseCode , String codeString, int counts, boolean isChinese, boolean hasLines){
		//width 124 刚好4个字符,每多一个增加18像素
		int width = 100;
		int height = 45;
		int offWidth = 21;//width偏移量
		int lines = 4;//干扰线的数量
		String codeStr = null;//code字符串
		if(counts < 4){
			counts = 4;
		}
		if(isUseCode){//使用自定义code
			codeStr = codeString;
			counts = codeStr.length();
		}
		if(isChinese){
			counts = 4;
			width+=6;//中文字符较大
		}
		width = width + (counts - 4) * offWidth;
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics g = image.getGraphics();
		//背景色
		if(null == backColor){
			backColor = new Color(0xffeded);
		}
		g.setColor(backColor);
		g.fillRect(0, 0, width, height);
		if(!isUseCode){//不使用自定义code字符串时
			if(isChinese){
				codeStr = CommonUtil.randomCode();
			}else{
				codeStr = CommonUtil.randomCode(counts);
			}
		}
		if(null == codeStr){//如果没有codeStr,默认使用以下方式
			codeStr = CommonUtil.randomCode(counts);
		}
		StringBuffer codes = new StringBuffer();
		for (int i = 0; i < counts; i++) {
			//每个字符单独设置样式
			String code = String.valueOf(codeStr.charAt(i));
			codes.append(code);
			g.setColor(CommonUtil.randomColor());
			g.setFont(CommonUtil.randomFont());
			//x根据情况调整,y和字体大小保持一致
			g.drawString(code, 8 + (i * offWidth), 30);
		}
		//x的范围(0~10),y的范围(width-10~width)
		int xRange = 20;
		int yRange = width - xRange;
		if(!hasLines){//不需要干扰线
			lines = -1;
		}
		for (int i = 0; i < lines; i++) {
			g.setColor(Color.BLACK);//默认黑色,无其他样式
			int x1 = r.nextInt(xRange);
			int y1 = r.nextInt(height);
			int x2 = r.nextInt(xRange) + yRange;
			int y2 = r.nextInt(height);
//			System.out.println("x1="+x1+",y1="+y1+"=="+"x2="+x2+",y2="+y2);
			g.drawLine(x1, y1, x2, y2);
		}
		
		MyImage m = new MyImage(image, codes.toString());
		return m;
	}
	
	//存放从以下文件中读取的验证码字符串
	private static String[] words;
	static {
		loadCodeWords("code-words.txt");
	}
	private static void loadCodeWords(String path){
		BufferedReader br = null;
		List<String> list = new ArrayList<String>();
		try {
			InputStream is = CommonUtil.class.getClassLoader().getResourceAsStream(path);
			br = new BufferedReader(new InputStreamReader(is, "utf-8"));
			String line = null;
			while((line = br.readLine()) != null){
				list.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(null != br){
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		words = new String[list.size()];
		if(!list.isEmpty()){
			list.toArray(words);
		}
	}
	
	/**
	 * 封装image和code
	 */
	public static class MyImage {
		private BufferedImage image;
		private String code;
		public MyImage() {
		}
		public MyImage(BufferedImage image, String code) {
			this.image = image;
			this.code = code;
		}
		public BufferedImage getImage() {
			return image;
		}
		public void setImage(BufferedImage image) {
			this.image = image;
		}
		public String getCode() {
			return code;
		}
		public void setCode(String code) {
			this.code = code;
		}
	}
	
	/**
	 * md5算法+自定义处理
	 * @param str 原字符串
	 * @return 长度为32的字符串(只包含数字和大写字母)
	 */
	public static String md5(String str){
		try {
			MessageDigest md5 = MessageDigest.getInstance("md5");
			//大于等于0的byte范围(十六进制表示)00~7f
			byte[] bs = md5.digest(str.getBytes("utf-8"));
			StringBuffer buffer = new StringBuffer();
			//byte-->十六进制
			for (int i = 0; i < bs.length; i++) {
				//处理负数
				if(bs[i] < 0){
					bs[i] = (byte) (bs[i] * -1);
				}
				//转十六进制
				String hex = Integer.toHexString(bs[i]);
				if(hex.length() < 2){
					buffer.append("0");
				}
				buffer.append(hex);
			}
			//转大写
			return buffer.toString().toUpperCase();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 用户登录
	 * @param user
	 * @throws NullPointerException user或其id为null
	 */
	public static void userLogin(User user) throws NullPointerException {
		if(null == user){
			throw new NullPointerException("当前用户为null");
		}
		Integer id = user.getId();
		if(null == id){
			throw new NullPointerException("当前用户id=" + id + "不存在");
		}
		users.put(user.getId().toString(), user);
	}
	
	/**
	 * 用户退出登录
	 * @param id
	 * @throws NullPointerException id为null
	 */
	public static void userLoginOut(Integer id) throws NullPointerException {
		if(null == id){
			throw new NullPointerException("当前用户id=" + id + "不存在");
		}
		users.remove(id.toString());
	}
	/**
	 * 用户退出登录
	 * @param id
	 * @throws NullPointerException id为null
	 */
	public static void userLoginOut(String id) throws NullPointerException {
		if(null == id){
			throw new NullPointerException("当前用户id=" + id + "不存在");
		}
		users.remove(id);
	}
	
	/**
	 * 存放验证码
	 * @param key
	 * @param code
	 */
	public static void putCode(String key, String code){
		userCodes.put(key, new UserCode(code, System.currentTimeMillis()));
	}
	
	/**
	 * 忽略英文字母大小写<br>
	 * 验证用户输入的验证是否匹配<br>
	 * @param key
	 * @param userCode
	 * @return 匹配true
	 * @throws NullPointerException 验证码失效
	 */
	public static boolean checkCodeIgnoreCase(String key, String userCode) throws NullPointerException {
		UserCode uc = userCodes.get(key);
		if(null == uc){
			throw new NullPointerException("当前验证码已失效,请重新获取");
		}
		userCodes.remove(key);
		return uc.code.equalsIgnoreCase(userCode);
	}
	
	/**
	 * 不忽略英文字母大小写<br>
	 * 验证用户输入的验证是否匹配<br>
	 * @param key
	 * @param userCode
	 * @return 匹配true
	 * @throws NullPointerException 验证码失效
	 */
	public static boolean checkCode(String key, String userCode) throws NullPointerException {
		UserCode uc = userCodes.get(key);
		if(null == uc){
			throw new NullPointerException("当前验证码已失效,请重新获取");
		}
		boolean flag = false;
		if(uc.code.equals(userCode)){
			flag = true;
		}
		userCodes.remove(key);
		return flag;
	}
	
	/**
	 * 获取验证码字符串
	 * @param key
	 * @return
	 * @throws NullPointerException 验证码失效
	 */
	public static String getCodeStr(String key) throws NullPointerException {
		UserCode uc = userCodes.get(key);
		if(null == uc){
			throw new NullPointerException("当前验证码已失效,请重新获取");
		}
		return uc.code;
	}
	
	/**
	 * 判断字符是否是null或者""
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str){
		return null == str || "".equals(str.trim());
	}
	
	/**
	 * 获取登录的用户
	 * @param userId
	 * @return user
	 */
	public static User getLoginUser(String userId){
		return users.get(userId);
	}
	/**
	 * 获取登录的用户
	 * @param userId
	 * @return user
	 */
	public static User getLoginUser(Integer userId){
		if(null == userId){
			return null;
		}
		return users.get(userId.toString());
	}
	/**
	 * 当前用户是否登录
	 * @param userId
	 * @return 登录true
	 */
	public static boolean isLogin(String userId){
		return users.get(userId) != null;
	}
	/**
	 * 当前用户是否登录
	 * @param userId
	 * @return 登录true
	 */
	public static boolean isLogin(Integer userId){
		if(null == userId){
			return false;
		}
		return users.get(userId.toString()) != null;
	}
	/**
	 * 获取UUID
	 * @return
	 */
	public static String getUUID(){
		return UUID.randomUUID().toString();
	}
	
	public static class UserCode {
		String code;//验证码
		long time;//生成的时间 ,一般60s过期
		public UserCode(String code, long time) {
			super();
			this.code = code;
			this.time = time;
		}
		public UserCode() {
			super();
		}
	}
	
	public static void main(String[] args) {
		//1=3C36 4238 6047 237E 0D34 5066 6F75 7C65
		//2=381E 7273 634C 2F63 6F06 7F77 3414 7A2C
		System.out.println("md5=" + md5("2"));
		//System.out.println(Integer.toHexString(-10));
	}
	
}

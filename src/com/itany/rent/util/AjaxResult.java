package com.itany.rent.util;

/**
 * ajax返回规范类
 * @author ldl
 * @date 2018年5月9日 下午2:51:43
 * @version 1.0
 */
public class AjaxResult {
	
	private boolean success;
	private String msg;
	private Object obj;
	public AjaxResult(boolean success, String msg, Object obj) {
		this.success = success;
		this.msg = msg;
		this.obj = obj;
	}
	public AjaxResult() {
	}
	/**
	 * 执行操作的状态
	 * @return boolean
	 */
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	/**
	 * 执行操作后的提示信息
	 * @return msg(java.lang.String)
	 */
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	/**
	 * 执行操作后提供的数据对象
	 * @return obj(java.lang.Object)
	 */
	public Object getObj() {
		return obj;
	}
	public void setObj(Object obj) {
		this.obj = obj;
	}
	/**
	 * 执行结果成功
	 * @return
	 */
	public static AjaxResult isOk(){
		return new AjaxResult(true, null, null);
	}
	/**
	 * 执行结果成功
	 * @param msg 提示信息
	 * @return
	 */
	public static AjaxResult isOk(String msg){
		return new AjaxResult(true, msg, null);
	}
	/**
	 * 执行结果成功
	 * @param msg 提示信息
	 * @param obj 需要返回给页面的相关数据对象
	 * @return
	 */
	public static AjaxResult isOk(String msg, Object obj){
		return new AjaxResult(true, msg, obj);
	}
	/**
	 * 执行结果失败
	 * @return
	 */
	public static AjaxResult isFail(){
		return new AjaxResult(false, null, null);
	}
	/**
	 * 执行结果失败
	 * @param msg 提示信息
	 * @return 
	 */
	public static AjaxResult isFail(String msg){
		return new AjaxResult(false, msg, null);
	}
	/**
	 * 执行结果失败
	 * @param msg 提示信息
	 * @param obj 需要返回给页面的相关数据对象
	 * @return
	 */
	public static AjaxResult isFail(String msg, Object obj){
		return new AjaxResult(false, msg, obj);
	}
	
}

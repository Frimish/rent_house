package com.itany.rent.factory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * 对象工厂
 * @author ldl
 * @date 2018年5月9日 下午2:50:38
 * @version 1.0
 */
public class ObjectFactory {

	private static Map<String, Object> objects = new HashMap<String, Object>();

	static {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(ObjectFactory.class
					.getClassLoader()
					.getResourceAsStream("objects.txt")));
			String s = null;
			while ((s = br.readLine()) != null) {
				String[] entry = s.split("=");
				if(entry.length != 2){//空的行?,不合要求的行
					//System.out.println("空的行?" + s);
					continue;
				}
				String key = entry[0].trim();
				String value = entry[1].trim();
				Class<?> c = Class.forName(value);
				if(c.isInterface()){//接口
					objects.put(key, c);
					continue;
				}
				objects.put(key, c.newInstance());
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ExceptionInInitializerError("ObjectFactory初始化错误" + e);
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static Object getObject(String key) {
		Object obj = objects.get(key);
		return obj;
	}
}

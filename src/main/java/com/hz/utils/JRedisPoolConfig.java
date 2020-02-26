package com.hz.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class JRedisPoolConfig {

	private final static Properties prop = new Properties();
	
	private static JRedisPoolConfig jRedisPoolConfig = new JRedisPoolConfig();
	
	private JRedisPoolConfig(){
		
	}
	
	public static JRedisPoolConfig inst(){
		return jRedisPoolConfig;
	}
	static {
		InputStream in = JRedisPoolConfig.class.getClassLoader().getResourceAsStream("redis.properties");
		try {
			prop.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public  String redisHost ;

	public  int redisPort ;
	
	public String redisPass;
	
	public int redisDatabase;
	
	public int redisTimeout;
	
	public String getRedisHost() {
		return prop.getProperty("redis.host","127.0.0.1");
	}
	
	public int getRedisPort() {
		return Integer.parseInt(prop.getProperty("redis.port","6379"));
	}
	
	public String getRedisPass() {
		return prop.getProperty("redis.pass","test");
	}

	public int getRedisDatabase() {
		return Integer.parseInt(prop.getProperty("redis.database","0"));
	}
	
	public int getRedisTimeout() {
		return Integer.parseInt(prop.getProperty("redis.timeout","1000"));
	}
}

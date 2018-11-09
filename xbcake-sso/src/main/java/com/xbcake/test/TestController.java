package com.xbcake.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xbcake.cart.service.CartService;
import com.xbcake.common.po.Cart;

import redis.clients.jedis.JedisCluster;
/**
 * 导入项目后修改一下配置：
 * 1.修改jdbc.properties的数据库地址和密码
 * 2.修改redis.properties的虚拟机地址
 * 3.修改zookeeper-provider.properties或zookeeper-consumer.properties的虚拟机地址（可以整合时再修改）
 * 4.建立MavenBuild，并检查pom里的tomcat插件端口号
 * 5.打开下列网址，测试是否正常（注意端口号）
 * 6.开始dubbo控制台服务器，登录查看服务是否正常
 *
 */
@Controller
@RequestMapping("/test")
public class TestController {

	@Autowired
	private CartService cartService;
	
	@Autowired
	private JedisCluster jedisCluster;
	
	
	//localhost:8094/test/doTestRedis
	@RequestMapping("/doTestRedis")
	@ResponseBody
	public String doTestRedis(){
		jedisCluster.set("haha", "hehehehehehe");
		return jedisCluster.get("haha");
	}
	
	//localhost:8094/test/doTestDB?id=73
	@RequestMapping("/doTestDB")
	@ResponseBody
	public Cart doTestDB(Long id){
		return cartService.findCartById(id);
	}
}

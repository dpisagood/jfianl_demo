package demo;

import java.util.HashMap;
import java.util.Map;

import com.jfinal.core.Controller;
import com.jfinal.kit.HashKit;

public class UserController extends Controller {
	public  static Map<String,String> users=new HashMap<String,String>();
	static{
		users.put("dingpeng", "123456");
		users.put("zs", "456");
	}
	
	public void index(){
		render("/User.html");
		createToken();
		System.out.println("创建token成功");
	}
	
	public void login(){
		if(!validateToken()){
			System.out.println(">>>>>>>>token失效");
			redirect("/user");
			return;
		}
		System.out.println(">>>>>>>>token验证成功");
		String user=getPara("user");
		String password=getPara("password");
		String pas=users.get(user);
		if(pas==null){
			redirect("/user");
			return;
		}
		//将cookie 进行特殊的md5加密，然后通过#标示符截取用户信息
		String cookieinfo=user+"#"+HashKit.md5(user);
		if(pas.equals(password)){
			setCookie("user",cookieinfo,1000);
			redirect("/user/center");
			return;
		}else{
			redirect("/user");
		}
	}
	
	public void center(){
		String cookieinfo=getCookie("user");
		//将字符串截取成数组元素，然后取第一个
		String user=cookieinfo.split("#")[0];
		String md5=cookieinfo.split("#")[1];
		if(HashKit.md5(user).equals(md5)){
			System.out.println(">>>>>>>>>>>>>合法的用户");
		}else{
			System.out.println("?????????????非法的用户");
		}
		if(user==null){
			redirect("/user");
			return ;
		}
		renderText(user+",欢迎来到用户中心！");
	}
	
	
}

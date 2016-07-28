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
	}
	
	public void login(){
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
		String user=cookieinfo.split("#")[0];
		if(user==null){
			redirect("/user");
			return ;
		}
		renderText(user+",欢迎来到用户中心！");
	}
	
	
}

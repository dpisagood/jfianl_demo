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
		createToken();//每次访问创建一个token
		System.out.println("创建token成功");
	}
	
	public void login(){
		keepPara();//转移参数
		
		redirect("/user_center.html");
	}
		
	
	
//	public void login(){
//		//User.html中有获取验证码的请求url
//		if(!validateCaptcha("yzm")){//审核验证码
//			System.out.println("验证码错误");
//			redirect("/user");
//			return;
//		}
//		System.out.println("验证码验证通过");
//		if(!validateToken()){//验证token
//			System.out.println(">>>>>>>>token失效");
//			redirect("/user");
//			return;
//		}
//		System.out.println(">>>>>>>>token验证成功");
//		String username=getPara("username");
//		String password=getPara("password");
//		String pas=users.get(username);
//		if(pas==null){
//			redirect("/user");
//			return;
//		}
//		//将cookie 进行特殊的md5加密，然后通过#标示符截取用户信息
//		String cookieinfo=username+"#"+HashKit.md5(username);
//		if(pas.equals(password)){
//			setCookie("user",cookieinfo,1000);//颁发cookie
////			keepPara();//不行
//			redirect("/user/center");//重定向到用户中心。在用户中心中验证cookie的合法性
//			return;
//		}else{
//			redirect("/user");
//		}
//	}

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
//		keepPara();//不行
		renderText(user+"欢迎来到用户中心！");
//		render("/user_center.html");
	}
	
	public void yzm(){//创建验证码
		renderCaptcha();
	}
}

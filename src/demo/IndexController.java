package demo;

import com.jfinal.core.Controller;

/**
 * Action是url请求中的一个最小单位，每个Action都会对应一个URL地址，在JFinal体系里，
 * Action是一个生命在Controller里的，没有参数的，被public修饰的方法
 * @author wl
 *
 */
public class IndexController extends Controller {
	public void index() {//正确写法
//		renderText("this is IndexController");//render渲染
		System.out.println("========执行了index方法===========");
		render("/hello.html");//渲染一个html文件
	}
	
//	private void index() {//错误写法，action必须被public修饰的
////		renderText("this is IndexController");//render渲染
//		System.out.println("========执行了index方法===========");
//		render("/hello.html");//渲染一个html文件
//	}
	
	
//	public void index(int a) {//错误写法，action方法不能有参数
////		renderText("this is IndexController");//render渲染
//		System.out.println("========执行了index方法===========");
//		render("/hello.html");//渲染一个html文件
//	}
	
}
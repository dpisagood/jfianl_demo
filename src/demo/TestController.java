package demo;

import com.jfinal.core.Controller;

public class TestController extends Controller {
	public void  index(){
		//renderText("this is TextContorller ");
		//render("/test.html");
		System.out.println(getPara());
		render("test.html");
		System.out.println(getPara());
		//渲染某个html或者jsp模板，如果以“/”，则到相应的根目录文件路径寻找这个模板进行渲染,如果没有加“/”，则按照
		//config中路由路由配置中提供的viewPath路劲去寻找，viewPath给的是从二级路径开始
	}
}

package demo;
import com.jfinal.core.Controller;


/**
 * Action是url请求中的一个最小单位，每个Action都会对应一个URL地址，在JFinal体系里，
 * Action是一个生命在Controller里的，没有参数的，被public修饰的方法
 * @author wl
 *
 */
public class HelloController extends Controller {
	public void index() {
	//	renderText("Hello JFinal World.");
		Data data=new Data();
		data.setAge(23);
		data.setName("丁鹏");
		
		renderJson(data);//通过json串的形式将java bean对象响应出去
	}
	
	public void test(){//通过http://localhost/hello/test来访问这个方法，如果test不存在则默认访问index
		renderText("test..........");
	}
	
	public void download(){
		renderFile("jfinal_demo.war");
	}
}
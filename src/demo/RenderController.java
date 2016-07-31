package demo;

import java.util.ArrayList;
import java.util.List;

import com.jfinal.core.Controller;

public class RenderController extends Controller {
	
	public void index(){
		//如果一个action里有多个render，只有最后一个有效，其他都将被覆盖,renderError除外，它之后的内容将不会再被执行
		
		//renderError(404);
		renderText("你好！");
		//renderText("你好，丁鹏！");
	//	renderHtml("nihao");
	//	renderXml("niaho");
	//	renderJavascript("nihao");
		render("/User.html");
		
	}
	
	public void uindex(){
		List<String> articles=new ArrayList<String>();
		articles.add("文章一");
		articles.add("文章二");
		articles.add("文章三");
		articles.add("文章四");
		setAttr("articles",articles);
		render("/user_index.html");
	}
}

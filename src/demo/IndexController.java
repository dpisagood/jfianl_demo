package demo;


import com.jfinal.core.Controller;

/**
 * Action是url请求中的一个最小单位，每个Action都会对应一个URL地址，在JFinal体系里，
 * Action是一个生命在Controller里的，没有参数的，被public修饰的方法
 * @author wl
 *
 */
public class IndexController extends Controller {
//	public void index() {//正确写法
////		renderText("this is IndexController");//render渲染
//		System.out.println("========执行了index方法===========");
//		render("/hello.html");//渲染一个html文件
//	}
	
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
	public void index(){
//		String value1=getPara("key1");
//		System.out.println("value1=="+value1);
//		System.out.println("value2=="+getPara("key2"));
//		System.out.println(getPara());
//		System.out.println("value1=="+value1);
//		System.out.println("value2=="+getPara("key2"));
//		System.out.println(getPara(0));//jfinal 会把最后一个/之前的单词作为命名空间去找action 
//		//如果没有，404，如果找到，将最后一个之后的单词作为参数传到对应的action中
//		//可以设置分隔符进行url传递参数然后使用getPara(int i) 的方式来获取参数
//		System.out.println(getPara(1));
//		System.out.println(URLDecoder.decode(getPara(2)));
	//	Article article =getBean(Article.class);//会把表单提交的数据，通过Article提供的set get方法注入成一个java bean
		//Article article=getBean(Article.class,"art1");//将表单中的命名方式改为name=art1.name,原来为name=article.name
		Article article=getBean(Article.class,"");//将表单中的命名方式改为name=name,原来为name=article.name
		//Article article1=getModel(Article.class,"");//报错，用法和getbean用法一样，不同的是他要和数据库进行映射,而且bean要是Modle的子类
		System.out.println(article);
		System.out.println(article.getEmailto());
		System.out.println(article.getMessage());
		render("/index.html");
	}
}
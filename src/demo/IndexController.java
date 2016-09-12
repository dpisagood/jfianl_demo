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
//		Article article=getBean(Article.class,"");//将表单中的命名方式改为name=name,原来为name=article.name
		//Article article1=getModel(Article.class,"");//报错，用法和getbean用法一样，不同的是他要和数据库进行映射,而且bean要是Modle的子类
//		System.out.println(article);
//		System.out.println(article.getEmailto());
//		System.out.println(article.getMessage());
		
		//getFile();
		render("/index.html");
	}
	
	public void upload(){
		//调用getFile() 必须是multipart/form-data
		//文件大小的限制可能会出错，通过config的setMaxPostSize去设置
		//同时getFile必须依赖于cos-26Dec2008.jar

		getFile();//如果是文件传的这种提交机制的话，getFile先要解析这个post请求getPara()才能从请求中得到参数
		//getFile(parameterName);//根据指定的参数名获得提交的文件
		//getFile(parameterName, uploadPath)//根据指定的参数名获得提交的文件,然后放在指定的文件路径，这是在全局的文件上传路径的二级路径下
		//getFile(parameterName, uploadPath, maxPostSize);//最后一个参数设置局部文件上传大小，覆盖全局文件上传大小限制
		
		String title=getPara("emailto");
		System.out.println("emailto="+title);
		renderText("upload........");
	}
	public void cookie(){
		String uer=getPara("user");
		String password=getPara("paw");
		if("dingpeng".equals(uer) && "123456".equals(password)){
			setCookie("user","dingpeng",60*60*24);	
			renderText("颁发了一个cookie");
		}else{
			removeCookie("user");
			renderText("颁发cookie失败");
		}
	}
}









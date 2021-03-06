package demo;
import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;

import demo.handler.Handler1;
import demo.handler.Handler2;
import demo.interceptor.Interceptor1;

public class DemoConfig extends JFinalConfig {
	/**
	 * 此方法用来配置 JFinal 常量值， 如开发模式常量 devMode 的配置， 默认视图类型 ViewType的配置
	 */
	public void configConstant(Constants me) {//constants 常量；常量配置方法
			me.setDevMode(true);//是否是开发者模式。是否打印日志
			
//			me.setBaseDownloadPath("download");//设置文件下载的默认路径
			me.setBaseUploadPath("上传文件");//设置文件上传存放的默认路径
//			me.setBaseViewPath("");//设置路由视图的默认路径
			me.setEncoding("utf-8");//设置jfinal编码
//			me.setError401View("");//设置401错误的视图
			me.setError404View("404.html");//设置错误404的视图 
			me.setErrorRenderFactory(new MyErroRenderFactory());//设置错误视图生产工厂在这个工厂类中可以设置各种错误的视图
//			me.setFreeMarkerTemplateUpdateDelay(0);//设置freemarker模板引擎的更新时时间
//			me.setFreeMarkerViewExtension("");//设置freemarker的默认后缀，默认是html
//			me.setI18nDefaultBaseName("");//
//			me.setI18nDefaultLocale("");//
//			me.setMainRenderFactory(null);
			me.setMaxPostSize(1024*1024*150);//设置文j 件上传大小限制。这里最大1M
			me.setReportAfterInvocation(false);//先执行程序还是打印日志
//			me.setTokenCache(null);//设置一个token的缓存
			//me.setUrlParaSeparator("@");//设置url分隔符，默认为中划线-
//			me.setViewType(ViewType.FREE_MARKER);//视图渲染
//			me.setMainRenderFactory(new IMainRenderFactory() {
//				
//				public String getViewExtension() {
//					// TODO Auto-generated method stub
//					return null;
//				}
//				
//				public Render getRender(String view) {//可以使用这个配置自己的渲染模板而不一定是freemarker
//					return new TextRender("自定义RenderFaactory");
//				}
//			});
		}
		public void configRoute(Routes me) {//路由配置
			me.add("/hello", HelloController.class);//配置了路由
			me.add("/", IndexController.class);
			me.add("/test", TestController.class, "test");
			me.add("/user",UserController.class);
			me.add("/render",RenderController.class);
		}
		public void configPlugin(Plugins me) {}//插件配置
		public void configInterceptor(Interceptors me) {
			me.add(new Interceptor1());
		}//此方法用来配置 JFinal 的全局拦截器;interceptors拦截机
		public void configHandler(Handlers handlers) {
//			handlers.add(new FakeStaticHandler());//添加jfinal自带的伪静态处理，url后面必须有.html不然会跳转到错误页面
			handlers.add(new Handler1());
			handlers.add(new Handler2());
		}//handlers处理者，管理者，处理器配置
}
package demo.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jfinal.handler.Handler;

public class Handler1 extends Handler{

	@Override
	public void handle(String target, HttpServletRequest request, HttpServletResponse response, boolean[] isHandled) {
		System.out.println("handler1 invoke!:"+target);
		if(target.endsWith(".html")){
			target=target.substring(0,target.lastIndexOf("."));
		}
		System.out.println("substring target:"+target);
		next.handle(target, request, response, isHandled);//执行下一个handler
		
	}
}

package demo.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jfinal.handler.Handler;
import com.jfinal.kit.HandlerKit;

public class Handler2 extends Handler{
@Override
public void handle(String target, HttpServletRequest request, HttpServletResponse response, boolean[] isHandled) {
		if(target.startsWith("/download")){
			String user=(String)request.getSession().getAttribute("usercookieid");
			System.out.println(user);
			if(user==null){
				HandlerKit.redirect("/user", request, response, isHandled);
				return;
			}
		}
		next.handle(target, request, response, isHandled);
	}
}
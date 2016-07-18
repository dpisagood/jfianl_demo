package demo;

import com.jfinal.render.IErrorRenderFactory;
import com.jfinal.render.Render;
import com.jfinal.render.TextRender;

public class MyErroRenderFactory implements IErrorRenderFactory {

	public Render getRender(int errorCode, String view) {
		return new TextRender("你好，jfinal，404错误。。。");
	}

}

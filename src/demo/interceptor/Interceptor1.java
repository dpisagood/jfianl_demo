package demo.interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;

public class Interceptor1 implements Interceptor {

	public void intercept(Invocation inv) {
		System.out.println("??????interceptor");
		System.out.println("inv.getActionKey:"+inv.getActionKey());
		if("/user".equals(inv.getActionKey())){
			inv.invoke();
			return;
		}
		inv.getController().redirect("/user");
//		inv.invoke();
	}

}

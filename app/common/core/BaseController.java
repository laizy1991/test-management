package common.core;

import play.mvc.Controller;

public class BaseController extends Controller {
	
	
	protected static Long privilegeFlag = 0L;

	protected static boolean checkRouterPrivilege() {
		return true;
	}
}

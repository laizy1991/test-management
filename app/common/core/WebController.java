package common.core;

import play.Logger;
import play.Play;
import play.i18n.Messages;
import play.mvc.Before;
import play.mvc.Catch;
import play.mvc.Http.Request;
import play.mvc.Scope.Session;
import utils.StringUtil;

import common.annotation.GuestAuthorization;

import controllers.Application;
import exception.BusinessException;

public class WebController extends BaseController {
	protected static String loginTpl = "guildLogin.html";
	
	@Before
	protected static void beforeAction() throws SecurityException, NoSuchMethodException {
		
		Logger.info("Action - %s", Request.current().path);
		
		initReqSource();
		
		if(getActionAnnotation(GuestAuthorization.class) != null) {
			return;
		}
		
		String sessionId = Session.current().get("sid");
		Logger.info("sid" + sessionId);
		if(sessionId != null && sessionId.equals("15989104721")) {
            initParams();
            return;
        }
		
		Application.login();
	}
	
	/**
	 * 根据请求的域名判断是进入哪个系统
	 * 
	 * @author chenxx
	 */
	private static void initReqSource() {
		renderArgs.put("pageTitle", "测试管理平台");
		renderArgs.put("sysType", 0);
		loginTpl = "guildLogin.html";
	}
	
	private static void initParams() {
		renderArgs.put("privilegeFlag", privilegeFlag);
		renderArgs.put("ctrl", request.controller);
        renderArgs.put("nickname", "赖泽原");
        renderArgs.put("action", request.action);
	}
	
	@Catch(Exception.class)
	protected static void onException(Throwable throwable) {
		
		if (throwable instanceof BusinessException){
			BusinessException be = (BusinessException)throwable;
			Logger.warn(throwable, "@Catch Exception: " + be.getMessage());
			String msg = be.getMessage();
			renderTemplate("errors/error.html", msg);
		} else {
			Logger.error(throwable, "Unknown Exception: " + throwable.getMessage());
			error(Messages.get("server.error"));
		}
	}
	
	protected static void renderError(String msg) {
		renderTemplate("errors/error.html", msg);
	}
	
	/**
	 * 获取主机地址信息(域名+端口)
	 */
	private static String getHost(String domain, String port) {
		StringBuilder sb = new StringBuilder();
		sb.append(domain);
		if(!StringUtil.isNullOrEmpty(port) && !port.equals("80")) {
			sb.append(":").append(port);
		}
		return sb.toString();
	}
}

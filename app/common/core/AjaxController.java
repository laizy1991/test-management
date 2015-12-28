package common.core;

import org.h2.util.StringUtils;

import play.Logger;
import play.i18n.Messages;
import play.mvc.Before;
import play.mvc.Catch;
import play.mvc.Http;
import play.mvc.Http.Request;
import play.mvc.results.RenderJson;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import exception.BusinessException;

public class AjaxController extends BaseController {
	
	private static Gson gson = new Gson();
	
	@Before
	protected static void beforeAction() throws SecurityException, NoSuchMethodException {
		
		Logger.info("Action - %s", Request.current().path);
		return;
	}
	
	@Catch(Exception.class)
	protected static void onException(Throwable throwable) {
		
		if (throwable instanceof BusinessException){
			BusinessException be = (BusinessException)throwable;
			Logger.warn(throwable, "@Catch Exception: " + be.getMessage());
			renderErrorJson(be.getMessage());
		} else {
			Logger.error(throwable, "Unknown Exception: " + throwable.getMessage());
			renderErrorJson(Messages.get("server.error"));
		}
	}
	
	/**
     * 发送成功结果的消息到客户端
     */
    protected static void renderSuccessJson() {
        Http.Response.current().setContentTypeIfNotSet("text/html");
        throw new RenderJson("{\"success\":true}");
    }
    
    /**
     * 发送成功结果的消息到客户端，且将数据id一并输出
     * @param id
     */
    protected static void renderSuccessJson(Integer id){
        Http.Response.current().setContentTypeIfNotSet("text/html");
        throw new RenderJson("{\"success\":true, \"id\":" + id + "}");
    }
    
    /**
     * 发送成功结果的消息到客户端
     * @param message
     */
    protected static void renderSuccessJson(String message){
        Http.Response.current().setContentTypeIfNotSet("text/html");
        throw new RenderJson("{\"success\":true, \"message\":" + StringUtils.quoteJavaString(message) + "}");
    }
    
    /**
     * 发送成功结果的消息到客户端
     */
    protected static void renderSuccessJson(Object obj){
        Http.Response.current().setContentTypeIfNotSet("text/html");
        JsonObject jo = new JsonObject();
        jo.add("success", gson.toJsonTree(true));
        jo.add("data", gson.toJsonTree(obj));
        throw new RenderJson(jo.toString());
    }
    
    /**
     * 发送错误结果的消息到客户端
     * @param message
     */
    protected static void renderErrorJson(String message){
        if( message == null ){
            message = "null";
        }
        Http.Response.current().setContentTypeIfNotSet("text/html");
        
        throw new RenderJson("{\"error\":" + StringUtils.quoteJavaString(message) + "}");
    }

}

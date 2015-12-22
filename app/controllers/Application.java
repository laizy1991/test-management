package controllers;

import play.Logger;
import play.mvc.Scope.Session;
import utils.StringUtil;
import common.annotation.GuestAuthorization;
import common.core.WebController;


public class Application extends WebController {

    @GuestAuthorization
    public static void login() {
        renderTemplate(loginTpl);
    }

    @GuestAuthorization
    public static void logined(String mobile, String password) {
        String errorMsg = null;
        if (StringUtil.isNullOrEmpty(mobile)) {
            renderTemplate(loginTpl, errorMsg);
        }
        if (StringUtil.isNullOrEmpty(password)) {
            renderTemplate(loginTpl, errorMsg);
        }

        if(mobile.equals("15989104721") && password.equals("123456")) {
            session.put("sid", "15989104721");
        }

        redirect("Application.index");
    }

    public static void logout() {
        session.remove("sid");
        login();
    }

    public static void index() {
        render();
    }

}

package controllers.ajax;


import modules.email.ddl.EmailInfo;
import play.Logger;

import com.google.gson.Gson;
import common.core.AjaxController;

public class EmailInfos extends AjaxController {
    private static final Gson gson = new Gson();
    
    public static void add(EmailInfo email) {
        if (email != null) {
            email.setCreateTime(System.currentTimeMillis());
            email.setUpdateTime(System.currentTimeMillis());
            Logger.info(gson.toJson(email));
            email.create();
        }
        renderSuccessJson();
    }

    public static void delete(EmailInfo email) {
        if(email != null) {
            Logger.info(gson.toJson(email));
            email.delete();
        }
        renderSuccessJson();
    }

    public static void update(EmailInfo email) {
        if(email != null) {
            email.setUpdateTime(System.currentTimeMillis());
            Logger.info(gson.toJson(email));
            email.save();
        }
        renderSuccessJson();
    }
    
}

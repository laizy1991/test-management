package controllers;

import java.util.ArrayList;
import java.util.List;

import modules.email.ddl.EmailInfo;

import org.apache.commons.collections.CollectionUtils;

import play.db.jpa.GenericModel.JPAQuery;

import com.google.gson.Gson;
import common.core.WebController;

import controllers.dto.EmailInfoDto;

public class EmailInfos extends WebController{
    private static final Gson gson = new Gson();
    public static void list() {
        JPAQuery result = EmailInfo.all();
        List<EmailInfo> ddls = result.query.getResultList();
        List<EmailInfoDto> emailInfos = new ArrayList<EmailInfoDto>();
        if(CollectionUtils.isNotEmpty(ddls)) {
            for(EmailInfo info : ddls) {
                EmailInfoDto dto = new EmailInfoDto(info);
                emailInfos.add(dto);
            }
        }
        
        render("/EmailInfos/list.html", emailInfos);
    }
    
    public static void create() {
        
    }
}

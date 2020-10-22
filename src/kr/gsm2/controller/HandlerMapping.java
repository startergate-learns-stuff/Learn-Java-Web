package kr.gsm2.controller;

import javax.servlet.http.HttpServlet;
import java.util.HashMap;

public class HandlerMapping {
    private HashMap<String, HttpServlet> mappings;

    public HandlerMapping() {
        mappings = new HashMap<>();
        keyAdd();
    }

    private void keyAdd() {
        mappings.put("/list.do", new MemberListController());
        mappings.put("/insert.do", new MemberDeleteController());
        mappings.put("/delete.do", new MemberDeleteController());
        mappings.put("/update.do", new MemberUpdateController());
    }

    public HttpServlet getController(String url){
        return mappings.get(url);
    }
}

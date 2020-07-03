package kr.gsm.controller;

import org.json.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@WebServlet("/map.do")
public class MapController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String location=req.getParameter("address");
        String addr = "https://dapi.kakao.com/v2/local/search/address.json";
        String apiKey = "KakaoAK 0e46bbbf75a5ba4b01762725b70d591e";
        location = URLEncoder.encode(location, StandardCharsets.UTF_8);
        String query = "query=" + location;
        StringBuffer stringBuffer = new StringBuffer(); stringBuffer.append(addr); stringBuffer.append("?");
        stringBuffer.append(query);

        System.out.println("stringBuffer.toString() "+ stringBuffer.toString());

        URL url = new URL(stringBuffer.toString());

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setRequestProperty("Authorization", apiKey);
        conn.setRequestMethod("GET");

        BufferedReader rd = null;
        rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8));

        StringBuffer docJson = new StringBuffer();
        String line;
        while((line=rd.readLine())!=null) {
            docJson.append(line);
        }
        if(0<docJson.toString().length()) {
            System.out.println("docJson:"+docJson.toString());
        }
        rd.close();
        JSONObject jsonObject = new JSONObject(docJson.toString());
        JSONArray jsonArray= (JSONArray) jsonObject.get("documents");
        JSONObject tempObj = (JSONObject) jsonArray.get(0);
        resp.setContentType("text/json;charset=euc-kr");
        PrintWriter out=resp.getWriter();
        out.println(tempObj.toString());
//System.out.println("latitude : " + tempObj.getDouble("y")); //System.out.println("longitude : " + tempObj.getDouble("x"));
    }
}

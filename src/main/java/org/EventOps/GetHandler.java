//package org.EventOps;
//
//import com.sun.net.httpserver.HttpExchange;
//import com.sun.net.httpserver.HttpHandler;
//
//import java.io.IOException;
//import java.io.OutputStream;
//import java.util.List;
//
//public class GetHandler implements HttpHandler {
//
//    public GetHandler(){
//
//    }
//
////    public void  handle (HttpExchange exchange) throws IOException {
////
////
////
////
////
//////        Scheduler scheduler = new Scheduler(TimeArray.getTimeArray(), StudentArray.getStudentArray());
////        Scheduler.scheduleStudents();
////        System.out.println("Timearay" + TimeArray.getTimeArray());
////
//////        System.out.println(TimeArray.getTimeArray().toString());
////    }
//
//    public void handle(HttpExchange exchange) throws IOException {
//        // Your handling logic goes here
//
//        if ("GET".equals(exchange.getRequestMethod())){
//            Scheduler.scheduleStudents();
//            String dummyText = TimeArray.getTimeArray().toString();
//            exchange.sendResponseHeaders(200, dummyText.getBytes().length);
//            OutputStream output = exchange.getResponseBody();
//            output.write(dummyText.getBytes());
//            output.flush();
//            exchange.close();
//
//        }else{
//            exchange.sendResponseHeaders(405, -1);// 405 Method Not Allowed
//
//        }
//        exchange.close();
//    }
//
//
//}
package org.EventOps;

//import com.google.gson.JsonArray;

//import com.google.gson.JsonArray;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class GetHandler implements HttpHandler {

    public GetHandler() {
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        Headers responseHeaders = exchange.getResponseHeaders();
        responseHeaders.add("Access-Control-Allow-Origin", "*");
        responseHeaders.add("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
        responseHeaders.add("Access-Control-Allow-Headers", "Content-Type, Authorization");

        if ("OPTIONS".equalsIgnoreCase(exchange.getRequestMethod())) {
            exchange.sendResponseHeaders(204, -1); // No Content
        } else if ("GET".equalsIgnoreCase(exchange.getRequestMethod())) {
            handleGetRequest(exchange);
        } else {
            exchange.sendResponseHeaders(405, -1); // 405 Method Not Allowed
        }
        exchange.close();
    }

    private void handleGetRequest(HttpExchange exchange) throws IOException {
        Scheduler.scheduleStudents();
        List<TimeSlot> responseText = TimeArray.getTimeArray();

        JSONArray myArr = new JSONArray();



        for(TimeSlot item  : responseText){
            JSONObject obj = new JSONObject();
            int id = item.getId();
            String time = item.getTimeString();
            List<String> students = item.getStudentNames();
            JSONArray studentOutput = new JSONArray();
            for (String name : students){
                studentOutput.add(name);
            }

            obj.put("id", id);
            obj.put("time", time);
            obj.put("students",studentOutput);
            myArr.add(obj);
            System.out.println("myarr1" + myArr);

        }

        String result = myArr.toJSONString();

        System.out.println("myarr" + myArr);

        byte[] responseBytes = result.getBytes(StandardCharsets.UTF_8);

//        JsonArray jsonArray = responseText.

        Headers responseHeaders = exchange.getResponseHeaders();
        responseHeaders.add("Content-Type", "application/json");

        exchange.sendResponseHeaders(200, responseBytes.length);
        OutputStream output = exchange.getResponseBody();
        output.write(responseBytes);
        output.flush();
        output.close();
    }
}

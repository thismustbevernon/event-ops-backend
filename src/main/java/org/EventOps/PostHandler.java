//package org.EventOps;
//
//import com.google.gson.JsonArray;
//import com.google.gson.JsonElement;
//import com.google.gson.JsonObject;
//import com.google.gson.JsonParser;
//import com.sun.net.httpserver.Headers;
//import com.sun.net.httpserver.HttpExchange;
//import com.sun.net.httpserver.HttpHandler;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.EventOps.DatabaseConnection.createConnection;
//
//public class PostHandler implements HttpHandler {
//
//    public PostHandler(){
//
//    }
//
//    public void  handle (HttpExchange exchange) throws IOException{
//
//        if ("POST".equals(exchange.getRequestMethod())){
//
//            InputStream input = exchange.getRequestBody();
////                      the input stream returns some bytes
//
//            int currentByte;
//
////                       we want to create a string
//
//            StringBuilder stringBuilder = new StringBuilder();
//            while ((currentByte = input.read()) != -1) {
//                stringBuilder.append((char)currentByte);
//            }
//
//            // Print the content of the input stream
////            System.out.println("Received POST data: " + stringBuilder.toString());
//            processQuery (stringBuilder.toString());
//
////            you may remove this section
//
//            input.close();
//
//            exchange.close();
//
//        }else{
//            exchange.sendResponseHeaders(405, -1);// 405 Method Not Allowed
//
//        }
//        exchange.close();
//
//
//    }
//
//    public static void processQuery (String values){
////        need to print the values to know which kind of data object we are dealing with.
//
//
//
//        JsonObject studentInput = JsonParser.parseString(values).getAsJsonObject();
//
//
//        String firstName = studentInput.get("firstName").getAsString();
//        String lastName = studentInput.get("lastName").getAsString();
//        String netId = studentInput.get("netId").getAsString();
//        int hours = studentInput.get("hours").getAsInt();
//        String level = studentInput.get("level").getAsString();
//        JsonArray shiftsArray = studentInput.get("shifts").getAsJsonArray();
//
//
//// Convert the shift array into a format that is stored in our student array
//        List<Integer> shiftsList = new ArrayList<>();
//        for (JsonElement element : shiftsArray) {
//            shiftsList.add(element.getAsInt());
//        }
////        consider adding values to the database as well.
//
//// Add the new student to the student array
//        Student newStudent = new Student(firstName,lastName,netId,hours,level,shiftsList);
//        System.out.println("newStudent");
//
////        what if we need to completely delete shift info
//
//        StudentArray.setStudentArray(newStudent);
//
//        System.out.println(StudentArray.getStudentArray().get(0));
//
//
//
//
//
//
//
////
////
////        JsonArray array = JsonParser.parseString(values)
////                .getAsJsonArray();
//
//        // crete DB connection
//        // Iterate jsonArray using for loop
////        for (int i = 0; i < array.size(); i++) {
////            // get field value from JSONObject using get() method
////            JsonObject currObject = array.get(i).getAsJsonObject();
////            String name = currObject.get("name").getAsString();
////            double price = currObject.get("price").getAsDouble();
////
////            System.out.println(name);
////            System.out.println(price);
////
////            Connection conn = createConnection();
////            Statement st;
//
////
////
////            {
////                try {
////                    st = conn.createStatement();
//////                need to have a statement that inserts values into the DB
////                    String insertQuery = "INSERT INTO products (name, price) VALUES ('" + name + "', " + price + ")";
////                    System.out.println("down here");
////                    ResultSet rs = st.executeQuery(insertQuery);
////
////                    rs.close();
////                    st.close();
////
////                } catch (SQLException ex) {
////                    throw new RuntimeException(ex);
////                }
////
////            }
////
////        }
//
//
//
//
//    }
//
//
//
//}



//remove code
package org.EventOps;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class PostHandler implements HttpHandler {

    public PostHandler() {
    }

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        Headers responseHeaders = exchange.getResponseHeaders();
        responseHeaders.add("Access-Control-Allow-Origin", "*");
        responseHeaders.add("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
        responseHeaders.add("Access-Control-Allow-Headers", "Content-Type, Authorization");

        if ("OPTIONS".equalsIgnoreCase(exchange.getRequestMethod())) {
            exchange.sendResponseHeaders(204, -1); // No Content
        } else if ("POST".equalsIgnoreCase(exchange.getRequestMethod())) {
            handlePostRequest(exchange);
        } else {
            exchange.sendResponseHeaders(405, -1); // 405 Method Not Allowed
        }
        exchange.close();
    }

    private void handlePostRequest(HttpExchange exchange) throws IOException {
        InputStream input = exchange.getRequestBody();
        StringBuilder stringBuilder = new StringBuilder();
        int currentByte;
        while ((currentByte = input.read()) != -1) {
            stringBuilder.append((char) currentByte);
        }

        processQuery(stringBuilder.toString());

        Headers responseHeaders = exchange.getResponseHeaders();
        responseHeaders.add("Content-Type", "application/json");

        String response = "success"; // You can set this to an appropriate response body if needed
        byte[] responseBytes = response.getBytes("UTF-8");

        exchange.sendResponseHeaders(200, responseBytes.length);
        OutputStream output = exchange.getResponseBody();
        output.write(responseBytes);
        output.flush();
        output.close();

        input.close();
    }

    public static void processQuery(String values) {
        JsonObject studentInput = JsonParser.parseString(values).getAsJsonObject();

        String firstName = studentInput.get("firstName").getAsString();
        String lastName = studentInput.get("lastName").getAsString();
        String netId = studentInput.get("netId").getAsString();
        int hours = studentInput.get("hours").getAsInt();
        String level = studentInput.get("level").getAsString();
        JsonArray shiftsArray = studentInput.get("shifts").getAsJsonArray();

        List<Integer> shiftsList = new ArrayList<>();
        for (JsonElement element : shiftsArray) {
            shiftsList.add(element.getAsInt());
        }

        Student newStudent = new Student(firstName, lastName, netId, hours, level, shiftsList);
        System.out.println("newStudent");

        StudentArray.setStudentArray(newStudent);
        System.out.println(StudentArray.getStudentArray().get(0));
    }
}

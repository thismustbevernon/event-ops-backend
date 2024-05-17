package org.EventOps;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;

// Press ⇧ twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {


    //    STEP 1 - CONNECT TO SERVER
//returns a connection to the server
    static int serverPort = 8000;

    public static void main(String[] args) {

////        DatabaseConnection.populateDatabase();
        DatabaseConnection.createConnection();
//
//        HttpServer myServer = Server.getServer();
//
//        GetProducts getProducts = new GetProducts(myServer);
//        PostProducts postProducts = new PostProducts(myServer);
////        getProducts.processQuery();
//        getProducts.request();
//        postProducts.request();

        List<TimeSlot> array = new ArrayList<>();

        array.add(new TimeSlot(1, "8-10am"));
        array.add(new TimeSlot(2, "10-12pm"));
        array.add(new TimeSlot(3, "12-2pm" ));
        array.add(new TimeSlot(4, "2-4pm"));
        array.add(new TimeSlot(5, "4-6pm"));
        array.add(new TimeSlot(6, "6-8pm"));
        array.add(new TimeSlot(7, "8-10pm"));
        array.add(new TimeSlot(8, "10-12am"));
        array.add(new TimeSlot(9, "8-10am"));
        array.add(new TimeSlot(10, "10-12pm"));
        array.add(new TimeSlot(11, "12-2pm"));
        array.add(new TimeSlot(12, "2-4pm"));
        array.add(new TimeSlot(13, "4-6pm"));
        array.add(new TimeSlot(14, "6-8pm"));
        array.add(new TimeSlot(15, "8-10pm"));
        array.add(new TimeSlot(16, "10-12am"));
        array.add(new TimeSlot(17, "8-10am"));
        array.add(new TimeSlot(18, "10-12pm"));
        array.add(new TimeSlot(19, "12-2pm"));
        array.add(new TimeSlot(20, "2-4pm"));
        array.add(new TimeSlot(21, "4-6pm"));
        array.add(new TimeSlot(22, "6-8pm"));
        array.add(new TimeSlot(23, "8-10pm"));
        array.add(new TimeSlot(24, "10-12am"));
        array.add(new TimeSlot(25, "8-10am"));
        array.add(new TimeSlot(26, "10-12pm"));
        array.add(new TimeSlot(27, "12-2pm"));
        array.add(new TimeSlot(28, "2-4pm"));
        array.add(new TimeSlot(29, "4-6pm"));
        array.add(new TimeSlot(30, "6-8pm"));
        array.add(new TimeSlot(31, "8-10pm"));
        array.add(new TimeSlot(32, "10-12am"));
        array.add(new TimeSlot(33, "8-10am"));
        array.add(new TimeSlot(34, "10-12pm"));
        array.add(new TimeSlot(35, "12-2pm"));
        array.add(new TimeSlot(36, "2-4pm"));
        array.add(new TimeSlot(37, "4-6pm"));
        array.add(new TimeSlot(38, "6-8pm"));
        array.add(new TimeSlot(39, "8-10pm"));
        array.add(new TimeSlot(40, "10-12am"));
        array.add(new TimeSlot(41, "8-10am"));
        array.add(new TimeSlot(42, "10-12pm"));
        array.add(new TimeSlot(43, "12-2pm"));
        array.add(new TimeSlot(44, "2-4pm"));
        array.add(new TimeSlot(45, "4-6pm"));
        array.add(new TimeSlot(46, "6-8pm"));
        array.add(new TimeSlot(47, "8-10pm"));
        array.add(new TimeSlot(48, "10-12am"));
        array.add(new TimeSlot(49, "8-10am"));
        array.add(new TimeSlot(50, "10-12pm"));
        array.add(new TimeSlot(51, "12-2pm"));
        array.add(new TimeSlot(52, "2-4pm"));
        array.add(new TimeSlot(53, "4-6pm"));
        array.add(new TimeSlot(54, "6-8pm"));
        array.add(new TimeSlot(55, "8-10pm"));
        array.add(new TimeSlot(56, "10-12am"));


        TimeArray.setTimeArray(array);

        try {
            HttpServer myServer = HttpServer.create(new InetSocketAddress(serverPort), 0);
//            using two separate endpoints for products because context allows only one per
//            next step - change logic to have them on a single ProductHandler()
//            myServer.createContext("/getProducts", new GetHandler());
            myServer.createContext("/postStudent", new PostHandler());
            myServer.createContext("/getSchedule", new GetHandler());

            myServer.setExecutor(null);
            myServer.start();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }



//        NOTES -
//        It is possible that connection is being created multiple times causing errors
//        server connection - try to organize the files inoto one file where server is initially created




    }
}
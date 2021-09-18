package client.demo;

import java.io.*;
import java.net.*;
//import java.net.InetAddress;
//import java.net.Socket;
//import java.net.UnknownHostException;

import org.dom4j.*;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.json.*;

public class client {




    public static void main(String[] args) throws Exception {
        // 2017年12月29日 下午1:43:11
//        Socket socket = null;
        InetAddress addr = InetAddress.getByName("127.0.0.1");
        int serverPort = 7899;

        String readline = null;
        String inTemp = null;
        String turnLine = "\n";
        final String client = "Client:";
        final String server = "Server:";


        String fin = null;

        Socket socket = new Socket(addr, serverPort);

        //创建三个流，系统输入流BufferedReader systemIn，socket输入流BufferedReader socketIn，socket输出流PrintWriter socketOut;
        BufferedReader systemIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader socketIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter socketOut = new PrintWriter(socket.getOutputStream());
        protocols protocols = new protocols();
        String body="";
        if (addr.isReachable(5000)) {
            try {

                while(readline != "bye"){

                    System.out.println(client);
//                    readline = systemIn.readLine();
                    //System.out.println(readline);



                    socketOut.println(protocols.heartbeat());
                    socketOut.flush();    //赶快刷新使Server收到，也可以换成socketOut.println(readline, ture)

                    //outTemp = readline;
                    inTemp =  protocols.XMLtoJSON(socketIn.readLine());


                    //System.out.println(client + outTemp);
                    System.out.println(server + turnLine + inTemp);

                }



            } catch (UnknownHostException e) {
                System.out.println("Socket Error:" + e.getMessage());
            } catch (EOFException e) {
                System.out.println("EOF:" + e.getMessage());
            } catch (IOException e) {
                System.out.println("IO:" + e.getMessage());
            } finally {
                if (socket != null)
                    try {
                        socket.close();
                    } catch (IOException e) {/* close failed */
                    }
            }
        } else {
            System.out.println("FAILURE - ping " + addr
                    + " with no interface specified");
        }
    }

}
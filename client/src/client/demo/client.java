package client.demo;

import java.io.*;
import java.net.*;
//import java.net.InetAddress;
//import java.net.Socket;
//import java.net.UnknownHostException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class client {


    public static void main(String[] args) throws Exception {
        // 2017年12月29日 下午1:43:11
//        Socket socket = null;
//        InetAddress addr = InetAddress.getByName("127.0.0.1");
//        int serverPort = 7899;
//
        String readline = null;
        String inTemp = null;
//        String inTemp1="1";
//        String turnLine = "\n";
//        String jieshou=null;
        final String client = "Client:";
        final String server = "Server:";
//


        //创建三个流，系统输入流BufferedReader systemIn，socket输入流BufferedReader socketIn，socket输出流PrintWriter socketOut;
        BufferedReader systemIn = new BufferedReader(new InputStreamReader(System.in));


        CtrlInterface c = new CtrlInterface("127.0.0.1",7899);



        try {

            while(readline != "bye"){



                System.out.println(client);


                System.out.print("请输入你的选择：\n\r" +
                        "\t0 登录\n\r" +
                        "\t1 订阅消息\n\r" +
                        "\t2 连接状态\n\r" +
                        "\t3 相位状态\n\r" +
                        "\t4 单元状态\n\r" +
                        "\t5 协调状态\n\r" +
                        "\t6 通道状态\n\r" +
                        "\t7 手动控制\n\r" +
                        "\t8 相位驻留\n\r" +
                        "\t9 步进控制\n\r");


                readline = systemIn.readLine();

                System.out.println("准备写入流");


                switch (readline)
                {
                    case "0":
                        inTemp=c.loginAndKeepAlive();
                        break;
                    case "1":
                        inTemp=c.subscribe("");
                        break;
                    case "2":
                        inTemp=c.getConnectState("100019");
                        break;
                    case "3":
                        inTemp=c.getPhaseState("100019");
                        break;
                    case "4":
                        inTemp=c.getUnitStatus("100019");
                        break;
                    case "5":
                        inTemp=c.getCoordinateStatus("100019");
                        break;
                    case "6":
                        inTemp=c.getChannelState("100019");
                        break;
                    case "7":
                        inTemp=c.manualControl("100019","1");
                        break;
                    case "8":
                        inTemp=c.phaseResides("100019", Arrays.asList("1","2"));
                        break;
                    case "9":
                        inTemp=c.stepControl("1","0");
                        break;
                }



//                inTemp=c.loginAndKeepAlive();


                System.out.println("写入流OK");

                System.out.println(inTemp);

                System.out.println("准备接受");

                System.out.println("没有阻塞");

            }



        } catch (UnknownHostException e) {
            System.out.println("Socket Error:" + e.getMessage());
        } catch (EOFException e) {
            System.out.println("EOF:" + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO:" + e.getMessage());
        }

    }

}
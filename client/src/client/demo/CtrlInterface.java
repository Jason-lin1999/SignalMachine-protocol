package client.demo;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;



/**
 * Created by dell on 2021/9/27.
 */
public class CtrlInterface {

    private  int serverPort;
    private InetAddress addr;
    private String readline = null;
    private String inTemp = null;
    private String inTemp1="1";
    private String turnLine = "\n";
    private String jieshou=null;
    private final String client = "Client:";
    private final String server = "Server:";
    private List<String> lists = new ArrayList<String>();
    private SelfBufferedReader systemIn = new SelfBufferedReader(new InputStreamReader(System.in));
    private Socket socket;
    private SelfBufferedReader socketIn ;
    private DataOutputStream output;
    private protocols p=new protocols();

    public CtrlInterface(String IP, int port) throws IOException {
        this.addr = InetAddress.getByName(IP);
        this.serverPort = port;
         this.socket = new Socket(this.addr, this.serverPort);
         this.socketIn = new SelfBufferedReader(new InputStreamReader(socket.getInputStream()));
         this.output = new DataOutputStream(socket.getOutputStream());

    }



    public void send_hertbeat()
    {
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(250000);
                        output.writeUTF(p.heartbeat());
                        output.flush();
                    } catch (InterruptedException | IOException e) {
                        e.printStackTrace();
                    }
                }

            }
        }.start();
    }

    public String loginAndKeepAlive() throws IOException, InterruptedException {

        String get_t=null;

        this.output.writeUTF(p.log_in());
        this.output.flush();

//        Thread.sleep(5000);
        get_t=getxml();
        get_t=p.XMLtoJSON(get_t);



        this.socket = new Socket(this.addr, this.serverPort);
        this.socketIn = new SelfBufferedReader(new InputStreamReader(socket.getInputStream()));
        this.output = new DataOutputStream(socket.getOutputStream());
        send_hertbeat();
        return get_t;
    }

    public String subscribe(String spot) throws IOException, InterruptedException {

        String get_t=null;

        this.output.writeUTF(p.subscribe_message(spot));
        this.output.flush();

//        Thread.sleep(5000);
        get_t=getxml();
        get_t=p.XMLtoJSON(get_t);

        this.socket = new Socket(this.addr, this.serverPort);
        this.socketIn = new SelfBufferedReader(new InputStreamReader(socket.getInputStream()));
        this.output = new DataOutputStream(socket.getOutputStream());

        return get_t;
    }


    public String getConnectState(String spot) throws IOException, InterruptedException {

        String get_t=null;

        this.output.writeUTF(p.connect_status(spot));
        this.output.flush();

//        Thread.sleep(5000);
        get_t=getxml();
        get_t=p.XMLtoJSON(get_t);

        this.socket = new Socket(this.addr, this.serverPort);
        this.socketIn = new SelfBufferedReader(new InputStreamReader(socket.getInputStream()));
        this.output = new DataOutputStream(socket.getOutputStream());

        return get_t;
    }


    public String getPhaseState(String spot) throws IOException, InterruptedException {

        String get_t=null;

        this.output.writeUTF(p.phase_status(spot));
        this.output.flush();

//        Thread.sleep(5000);
        get_t=getxml();
        get_t=p.XMLtoJSON(get_t);

        this.socket = new Socket(this.addr, this.serverPort);
        this.socketIn = new SelfBufferedReader(new InputStreamReader(socket.getInputStream()));
        this.output = new DataOutputStream(socket.getOutputStream());

        return get_t;
    }

    public String getUnitStatus(String spot) throws IOException, InterruptedException {

        String get_t=null;

        this.output.writeUTF(p.cell_status(spot));
        this.output.flush();

//        Thread.sleep(5000);
        get_t=getxml();
        get_t=p.XMLtoJSON(get_t);

        this.socket = new Socket(this.addr, this.serverPort);
        this.socketIn = new SelfBufferedReader(new InputStreamReader(socket.getInputStream()));
        this.output = new DataOutputStream(socket.getOutputStream());

        return get_t;
    }


    public String getCoordinateStatus(String spot) throws IOException, InterruptedException {

        String get_t=null;

        this.output.writeUTF(p.coordinate_status(spot));
        this.output.flush();

//        Thread.sleep(5000);
        get_t=getxml();
        get_t=p.XMLtoJSON(get_t);

        this.socket = new Socket(this.addr, this.serverPort);
        this.socketIn = new SelfBufferedReader(new InputStreamReader(socket.getInputStream()));
        this.output = new DataOutputStream(socket.getOutputStream());

        return get_t;
    }


    public String getChannelState(String spot) throws IOException, InterruptedException {

        String get_t=null;

        this.output.writeUTF(p.channel_status(spot));
        this.output.flush();

//        Thread.sleep(5000);
        get_t=getxml();
        get_t=p.XMLtoJSON(get_t);

        this.socket = new Socket(this.addr, this.serverPort);
        this.socketIn = new SelfBufferedReader(new InputStreamReader(socket.getInputStream()));
        this.output = new DataOutputStream(socket.getOutputStream());

        return get_t;
    }

    public String manualControl(String spot, String pattern) throws IOException, InterruptedException {

        String get_t=null;

        this.output.writeUTF(p.self_control(spot,pattern));
        this.output.flush();

//        Thread.sleep(5000);
        get_t=getxml();
        get_t=p.XMLtoJSON(get_t);

        this.socket = new Socket(this.addr, this.serverPort);
        this.socketIn = new SelfBufferedReader(new InputStreamReader(socket.getInputStream()));
        this.output = new DataOutputStream(socket.getOutputStream());

        return get_t;
    }

    public String phaseResides(String spot, List<String> holdPhases) throws IOException, InterruptedException {

        String get_t=null;

        this.output.writeUTF(p.phase_control(spot,holdPhases));
        this.output.flush();

//        Thread.sleep(5000);
        get_t=getxml();
        get_t=p.XMLtoJSON(get_t);

        this.socket = new Socket(this.addr, this.serverPort);
        this.socketIn = new SelfBufferedReader(new InputStreamReader(socket.getInputStream()));
        this.output = new DataOutputStream(socket.getOutputStream());

        return get_t;
    }

    public String stepControl(String spot,String a) throws IOException, InterruptedException {

        String get_t=null;

        this.output.writeUTF(p.step_control(spot,a));
        this.output.flush();

//        Thread.sleep(5000);
        get_t=getxml();
        get_t=p.XMLtoJSON(get_t);

        this.socket = new Socket(this.addr, this.serverPort);
        this.socketIn = new SelfBufferedReader(new InputStreamReader(socket.getInputStream()));
        this.output = new DataOutputStream(socket.getOutputStream());

        return get_t;
    }


    public String getxml() throws IOException, InterruptedException {

        String get_t=null;

       inTemp=this.socketIn.readLine();
        lists.add(inTemp);
        socket.shutdownInput();
        while((inTemp=this.socketIn.readLine())!=null)
        {
            lists.add(inTemp);
        }


        get_t=getrestruct_list(lists);

        lists.clear();

        return get_t;
    }

    public String getrestruct_list(List lists)
    {
        String t=null;
        String t1=null;


        t= (String) lists.get(lists.size()-1);

        t1= t.substring(t.indexOf(">")+1,t.length());

//        下面三行是在最后追加 > \n 符号
        StringBuilder sb=new StringBuilder(t1);
        sb.insert(sb.length(),">"+"\\n");
        t1=sb.toString();

        return t1;
    }


}


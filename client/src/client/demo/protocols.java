package client.demo;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.json.JSONObject;
import org.json.XML;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;


/**
 * Created by dell on 2021/8/30.
 */





public class protocols {


//    public void socketinit(String addr,int port) throws Exception
//    {
//        Socket socket = new Socket(addr, port);
//
//        //创建三个流，系统输入流BufferedReader systemIn，socket输入流BufferedReader socketIn，socket输出流PrintWriter socketOut;
//        BufferedReader systemIn = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader socketIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//        PrintWriter socketOut = new PrintWriter(socket.getOutputStream());
//    }

    public Document init()
    {
        Document doc = DocumentHelper.createDocument();
        Element root = doc.addElement("systemScription").addAttribute("System", "TCIP").addAttribute("Version", "1.0");

        // 在根节点下添加第一个子节点
//        Element oneChildElement= root.addElement("subSystem").addText("Hisense");
        root.addElement("subSystem").addText("Hisense");
        root.addElement("messageType").addText("1");
        root.addElement("isRequest").addText("1");
        root.addElement("seq").addText("20190806160612000678");
        root.addElement("needResponse").addText("1");
        root.addElement("result").addText("0");
        root.addElement("flag").addText("0");

        return doc;

    }

    public Element clearMessageContent(Element root)
    {
        Element messageContent = null;
        if (root.element("messageContent") == null) {
            messageContent = root.addElement("messageContent");
        } else {
            root.element("messageContent").clearContent();
            messageContent = root.element("messageContent");
        }
        assert messageContent != null;
        return messageContent;
    }

    public String heartbeat()
    {
        Document doc=init();
        Element root = doc.getRootElement();

        //修改xml元素的值
        root.element("messageType").setText("0");
//        setText里面为空格，可以保证标签成对的出现
        root.element("isRequest").setText(" ");
        root.element("needResponse").setText(" ");
        root.element("result").setText(" ");
        root.element("flag").setText(" ");

        //移除xml元素
        Element removeElement = root.element("seq");
        if (removeElement != null) {
            root.remove(removeElement);
        }
        root.addElement("messageContent").addText(" ");

        //添加xml元素

        String body="";
        body= doc.asXML().replace("\n","");

        return body;
    }

    public String log_in()
    {
        Document doc=init();

        Element root = doc.getRootElement();


//        root.addElement("flag").addText("0");
        root.addElement("messageContent");
        Element messageContent = root.element("messageContent");
        messageContent.addElement("User").addText("system");
        messageContent.addElement("Password").addText("1");

        String body="";
        body= doc.asXML().replace("\n","");

        return body;
    }

    public String subscribe_message(String spot)
    {
        Document doc=init();

        Element root = doc.getRootElement();

        //修改xml元素的值
        root.element("messageType").setText("2");
        root.element("isRequest").setText("1");
        root.element("needResponse").setText("1");
        root.element("result").setText("0");
        root.element("flag").setText("0");


        Element messageContent = clearMessageContent(root);
        messageContent.addElement("Spot").addText(spot);
        messageContent.addElement("SubType").addText("10");
        messageContent.addElement("Flag").addText("0");

        String body="";
        body= doc.asXML().replace("\n","");

        return body;
    }


    public String connect_status(String spot)
    {
        Document doc=init();
        Element root = doc.getRootElement();

        //修改xml元素的值
        root.element("messageType").setText("3");
        root.element("isRequest").setText("1");
        root.element("needResponse").setText("1");
        root.element("result").setText("0");
        root.element("flag").setText("0");

        Element messageContent = clearMessageContent(root);
        messageContent.addElement("Spot").addText(spot);

        String body="";
        body= doc.asXML().replace("\n","");

        return body;
    }

    public String phase_status(String spot)
    {
        Document doc=init();

        Element root = doc.getRootElement();

        //修改xml元素的值
        root.element("messageType").setText("10");
        root.element("isRequest").setText("1");
        root.element("needResponse").setText("1");
        root.element("result").setText("0");
        root.element("flag").setText("0");

        Element messageContent = clearMessageContent(root);
        messageContent.addElement("Spot").addText(spot);

        String body="";
        body= doc.asXML().replace("\n","");

        return body;
    }


    public String cell_status(String spot)
    {
        Document doc=init();
        Element root = doc.getRootElement();

        //修改xml元素的值
        root.element("messageType").setText("11");
        root.element("isRequest").setText("1");
        root.element("needResponse").setText("1");
        root.element("result").setText("0");
        root.element("flag").setText("0");

        Element messageContent = clearMessageContent(root);
        messageContent.addElement("Spot").addText(spot);

        String body="";
        body= doc.asXML().replace("\n","");

        return body;



    }

    public String coordinate_status(String spot)
    {
        Document doc=init();
        Element root = doc.getRootElement();

        //修改xml元素的值
        root.element("messageType").setText("12");
        root.element("isRequest").setText("1");
        root.element("needResponse").setText("1");
        root.element("result").setText("0");
        root.element("flag").setText("0");

        Element messageContent = clearMessageContent(root);
        messageContent.addElement("Spot").addText(spot);

        String body="";
        body= doc.asXML().replace("\n","");

        return body;
    }

    public String channel_status(String spot)
    {
        Document doc=init();

        Element root = doc.getRootElement();

        //修改xml元素的值
        root.element("messageType").setText("40");
        root.element("isRequest").setText("1");
        root.element("needResponse").setText("1");
        root.element("result").setText("0");
        root.element("flag").setText("0");


        Element messageContent = clearMessageContent(root);
        messageContent.addElement("Spot").addText(spot);

        String body="";
        body= doc.asXML().replace("\n","");

        return body;
    }

    public String self_control(String spot,String pattern)
    {
        Document doc=init();

        Element root = doc.getRootElement();
        root.element("messageType").setText("16");
        root.element("isRequest").setText("1");
        root.element("needResponse").setText("1");
        root.element("result").setText("0");
        root.element("flag").setText("0");

        Element messageContent = clearMessageContent(root);
        messageContent.addElement("Spot").addText(spot);

//        a表示制定的运行方案，取值范围见图5
        messageContent.addElement("Pattern").addText(pattern);

        String body="";
        body= doc.asXML().replace("\n","");

        return body;
    }

    public String phase_control(String spot,List<String> holdPhases)
    {
        Document doc=init();

        Element root = doc.getRootElement();
        root.element("messageType").setText("18");
        root.element("isRequest").setText("1");
        root.element("needResponse").setText("1");
        root.element("result").setText("0");
        root.element("flag").setText("0");

        Element messageContent = clearMessageContent(root);
        messageContent.addElement("Spot").addText(spot);

//      a表示驻留的相位数，取值【1-16】
//      b表示驻留的相位（锁定的相位）。取值【1-16】
        messageContent.addElement("Count").addText(holdPhases.get(0));
        messageContent.addElement("HoldPhase").addText(holdPhases.get(1));


        String body="";
        body= doc.asXML().replace("\n","");

        return body;
    }

    public String step_control(String spot,String a)
    {
        Document doc=init();

        Element root = doc.getRootElement();
        root.element("messageType").setText("22");
        root.element("isRequest").setText("1");
        root.element("needResponse").setText("1");
        root.element("result").setText("0");
        root.element("flag").setText("0");

        Element messageContent = clearMessageContent(root);
        messageContent.addElement("Spot").addText(spot);

//      a表示控制命令。1：开始步进；0：取消步进
        messageContent.addElement("Command").addText(a);
        messageContent.addElement("CtrlStep").addText("0");
//        messageContent.addElement("Pattern").addText(a);

        String body="";
        body= doc.asXML().replace("\n","");

        return body;
    }





    public String XMLtoJSON(String data)
    {
        JSONObject xmlJSONObj = XML.toJSONObject(data);
        //设置缩进
        String jsonPrettyPrintString = xmlJSONObj.toString(4);

        return jsonPrettyPrintString;
    }

}


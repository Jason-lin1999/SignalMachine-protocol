package client.demo;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

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

//    public client()
//    {
//
//
//    }
//    public void log_in()
//    {
//        System.out.print("我已经登录上了");
//    }

    static void init(Document doc) {
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
    }


    static Element clearMessageContent(Element root) {

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

    //Wu add heartbeat message.
    static void heartbeat(Document doc) {
        Element root = doc.getRootElement();

        //修改xml元素的值
        root.element("messageType").setText("0");
        root.element("isRequest").setText("");
        root.element("needResponse").setText("");
        root.element("result").setText("");
        root.element("flag").setText("");

        //移除xml元素
        Element removeElement = root.element("seq");
        if (removeElement != null) {
            root.remove(removeElement);
        }
        root.addElement("messageContent").addText("");
        //添加xml元素

    }

    static void log_in(Document doc) {
//        Document doc = DocumentHelper.createDocument();
        Element root = doc.getRootElement();

        // 添加根节点
//        Element root = doc.addElement("systemScription").addAttribute("System", "TCIP").addAttribute("Version","1.0");
//
//        // 在根节点下添加第一个子节点
////        Element oneChildElement= root.addElement("subSystem").addText("Hisense");
//        root.addElement("subSystem").addText("Hisense");
//        root.addElement("messageType").addText("1");
//        root.addElement("isRequest").addText("1");
//        root.addElement("seq").addText("20190806160612000678");
//        root.addElement("needResponse").addText("1");
//        root.addElement("result").addText("0");
//        root.addElement("flag").addText("0");
        root.addElement("messageContent");
        Element messageContent = root.element("messageContent");
        messageContent.addElement("User").addText("system");
        messageContent.addElement("Password").addText("1");
//        oneChildElement.addElement("people")
//                .addAttribute("attr", "child one")
//                .addText("person one child one");
//        oneChildElement.addElement("people")
//                .addAttribute("attr", "child two")
//                .addText("person one child two");

        // 在根节点下添加第一个子节点
//        Element twoChildElement= root.addElement("person").addAttribute("attr", "root two");
//        twoChildElement.addElement("people")
//                .addAttribute("attr", "child one")
//                .addText("person two child one");
//        twoChildElement.addElement("people")
//                .addAttribute("attr", "child two")
//                .addText("person two child two");


    }

    static void subscribe(Document doc) {
        Element root = doc.getRootElement();

        //修改xml元素的值
        root.element("messageType").setText("2");
        root.element("isRequest").setText("1");
        root.element("needResponse").setText("1");
        root.element("result").setText("0");
        root.element("flag").setText("0");
//        List<Element> nodelist = root.elements("messageContent");
////        Element namenode;
//        for (Element node:nodelist)
//        {
////            if(namenode == node)
////            Element namenode = node.element("User");
////            namenode.setText("hello");
////          修改节点名字
//            node.element("User").setName("Spot");
//            node.element("Password").setName("SubType");
//
////          修改节点内容
//            node.element("Spot").setText("10");
//            node.element("SubType").setText("hhhh");
//        }
//
//            Element Flag = DocumentHelper.createElement("Flag");
//            Flag.setText("0");
//
//        Element add = (Element)root.element("messageContent");
//        List list = add.elements();
//
//        list.add(2,Flag);

        Element messageContent = clearMessageContent(root);
        messageContent.addElement("Spot").addText("102497");
        messageContent.addElement("SubType").addText("10");
        messageContent.addElement("Flag").addText("0");

    }


    static void connect(Document doc) {
        Element root = doc.getRootElement();

        //修改xml元素的值
        root.element("messageType").setText("3");
        root.element("isRequest").setText("1");
        root.element("needResponse").setText("1");
        root.element("result").setText("0");
        root.element("flag").setText("0");

//        List<Element> nodelist = root.elements("messageContent");

//        Element parent = root.element("messageContent");
//
//        Element rm1 = parent.element("SubType");
//        rm1.getParent().remove(rm1);
//
//        Element rm2 = parent.element("Flag");
//        rm2.getParent().remove(rm2);


        Element messageContent = clearMessageContent(root);
        messageContent.addElement("Spot").addText("100146");

//        for (Element node:nodelist)
//        {
//            if(node.getName()=="SubType")
//            {
//                node.getParent().remove(node);
//            }
//
//            if(node.getName()=="Flag")
//            {
//                rm.remove(node);
//            }
//        }


    }

    //Wu add message.
    static void phase(Document doc) {
        Element root = doc.getRootElement();

        //修改xml元素的值
        root.element("messageType").setText("10");
        root.element("isRequest").setText("1");
        root.element("needResponse").setText("1");
        root.element("result").setText("0");
        root.element("flag").setText("0");


        Element messageContent = clearMessageContent(root);
        messageContent.addElement("Spot").addText("100146");

    }

    static void self_control(Document doc) {
        Element root = doc.getRootElement();


        Element messageContent = clearMessageContent(root);
        messageContent.addElement("Spot").addText("100146");
        messageContent.addElement("Pattern").addText("252");
    }

    static void writeXMLFile(String data, String fileName) throws DocumentException, IOException {

        Document dom = DocumentHelper.parseText(data);
//
        OutputFormat format = new OutputFormat();
        format.setIndentSize(4);  // 行缩进
        format.setNewlines(true); // 一个结点为一行
        format.setTrimText(true); // 去重空格
        format.setPadText(true);
        format.setNewLineAfterDeclaration(false); // 放置xml文件中第二行为空白行

        Writer out = new PrintWriter(fileName, "utf-8");
        XMLWriter xwriter = new XMLWriter(out, format);

        xwriter.write(dom);

        out.close();
        xwriter.close();
    }

    public static void main(String[] args) throws Exception {
        // 2017年12月29日 下午1:43:11
        Socket socket = null;
        InetAddress addr = InetAddress.getByName("127.0.0.1");
        int serverPort = 7899;
        if (addr.isReachable(5000)) {
            try {

//                client in = new client();
//                in.log_in();

                socket = new Socket(addr, serverPort);

                DataInputStream input = new DataInputStream(socket.getInputStream());
                DataOutputStream output = new DataOutputStream(socket.getOutputStream());


//************************向客户端写xml文件******************************************
                // 创建XML初始化
                Document doc = DocumentHelper.createDocument();
                init(doc);
//
//                // 添加根节点
//                Element root = doc.addElement("root");
//
//                // 在根节点下添加第一个子节点
//                Element oneChildElement= root.addElement("person").addAttribute("attr", "root noe");
//                oneChildElement.addElement("people")
//                        .addAttribute("attr", "child one")
//                        .addText("person one child one");
//                oneChildElement.addElement("people")
//                        .addAttribute("attr", "child two")
//                        .addText("person one child two");
//
//                // 在根节点下添加第一个子节点
//                Element twoChildElement= root.addElement("person").addAttribute("attr", "root two");
//                twoChildElement.addElement("people")
//                        .addAttribute("attr", "child one")
//                        .addText("person two child one");
//                twoChildElement.addElement("people")
//                        .addAttribute("attr", "child two")
//                        .addText("person two child two");
//                log_in(doc);
//                subscribe(doc);
//                connect(doc);

                Scanner scanner = new Scanner(System.in);
                heartbeat(doc);
                String heartBeatStr = doc.asXML().replace("\n"," ");
                System.out.println(heartBeatStr);
                new Thread() {
                    @Override
                    public void run() {
                        while (true) {
                            try {
                                Thread.sleep(25000);
                                output.writeUTF(heartBeatStr);
                            } catch (InterruptedException | IOException e) {
                                e.printStackTrace();
                            }
                        }

                    }
                }.start();


                while (!socket.isClosed()) {

                    doc = DocumentHelper.createDocument();
                    init(doc);
                    System.out.print("请输入你的选择：\n\r" +
                            "\t0 heart\n\r" +
                            "\t1 login\n\r" +
                            "\t2 subscribe\n\r" +
                            "\t3 connect\n\r" +
                            "\t4 self_control\n\r" +
                            "\t5 相位状态\n\r"+
                            "\t6 手动控制\n\r");
                    int option = scanner.nextInt();
                    String xmlFile = "";

                    String body="";
                    switch (option) { //一直发的话这个代码会直接不停地向xml后面添加Element
                        case 0:
                            heartbeat(doc);
                            xmlFile = "heartbeat";
                            break;
                        case 1:
                            log_in(doc);
                            xmlFile = "log_in";
                            body = doc.asXML().replace("\n","");
                            break;
                        case 2:
                            subscribe(doc);
                            xmlFile = "subscribe";
                            break;
                        case 3:
                            connect(doc);
                            xmlFile = "connect";
                            break;
                        case 4:
                            phase(doc);
                            xmlFile = "phase";
                            break;
                        case 5:
                            self_control(doc);
                            xmlFile = "self_control";
                            break;
                        case 6:
                            body=("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                                    "<systemScription System=\"TCIP\" Version=\"1.0\">\n" +
                                    "    <subSystem>Hisense</subSystem>\n" +
                                    "    <messageType>16</messageType>\n" +
                                    "    <isRequest>1</isRequest>\n" +
                                    "    <seq>20190806160612000678</seq>\n" +
                                    "    <needResponse>1</needResponse>\n" +
                                    "    <result>0</result>\n" +
                                    "    <flag>0</flag>\n" +
                                    "    <messageContent>\n" +
                                    "        <Spot>100019</Spot>\n" +
                                    "        <Pattern>244</Pattern>\n" +
                                    "    </messageContent>\n" +
                                    "</systemScription>"
                            ).replace("\n"," ");
                            break;

                        case 7:
                            body=("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                                    "<systemScription System=\"TCIP\" Version=\"1.0\">\n" +
                                    "    <subSystem>Hisense</subSystem>\n" +
                                    "    <messageType>22</messageType>\n" +
                                    "    <isRequest>1</isRequest>\n" +
                                    "    <seq>20190806160612000678</seq>\n" +
                                    "    <needResponse>1</needResponse>\n" +
                                    "    <result>0</result>\n" +
                                    "    <flag>0</flag>\n" +
                                    "    <messageContent>\n" +
                                    "        <Spot>100019</Spot>\n" +
                                    "        <Count>1</Count>\n" +
                                    "        <HoldPhase>128</HoldPhase>\n" +
                                    "    </messageContent>\n" +
                                    "</systemScription>"
                            ).replace("\n"," ");
                            break;
                        case 8:
                            body=("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                                    "<systemScription System=\"TCIP\" Version=\"1.0\">\n" +
                                    "    <subSystem>Hisense</subSystem>\n" +
                                    "    <messageType>22</messageType>\n" +
                                    "    <isRequest>1</isRequest>\n" +
                                    "    <seq>20190806160612000678</seq>\n" +
                                    "    <needResponse>1</needResponse>\n" +
                                    "    <result>0</result>\n" +
                                    "    <flag>0</flag>\n" +
                                    "    <messageContent>\n" +
                                    "        <Spot>100019</Spot>\n" +
                                    "        <Command>1</Command>\n"+
                                    "        <CtrlStep>0</CtrlStep>\n"+
                                    "    </messageContent>\n" +
                                    "</systemScription>"

                            ).replace("\n"," ");
                            break;
                    }
                    System.out.println(doc);

//              写入缓冲区
//                    writeXMLFile(body, "D:\\Data\\" + xmlFile + ".xml");

                    System.out.println("准备写入流");
                    System.out.println(body);
                    output.writeUTF(body);
                    output.flush();
                    System.out.println("写入流OK");

//                    System.out.println("准备接受");
//                    String data = input.readUTF();
//                    writeXMLFile(data, "D:clientP.xml");
//                    System.out.println(data);
                }
                // 定义我们特定XML的生成工厂 每次的消息包装都从单实例中组装
//                StringBuffer data = new StringBuffer();
//                do {
////                    data.append(br.readLine());
//
//                    String x=br.readLine();
//                    System.out.println(x);
//                } while (br.ready());
//                System.out.println(data);
//
//                Document dom = DocumentHelper.parseText(data.toString());
//
//                OutputFormat format = new OutputFormat();
//                format.setIndentSize(4);  // 行缩进
//                format.setNewlines(true); // 一个结点为一行
//                format.setTrimText(true); // 去重空格
//                format.setPadText(true);
//                format.setNewLineAfterDeclaration(false); // 放置xml文件中第二行为空白行
//
//                Writer out = new PrintWriter("D:\\Data\\xmlbackTest.txt", "utf-8");
//                XMLWriter writer = new XMLWriter(out, format);
//
//                writer.write(dom);


//                DataOutputStream out=new DataOutputStream(soc.getOutputStream());
//                // 定义工厂 API，使应用程序能够从 XML 文档获取生成 DOM 对象树的解析器
//                DocumentBuilderFactory factory = DocumentBuilderFactory
//                        .newInstance();
//                // 定义 API， 使其从 XML 文档获取 DOM 文档实例。使用此类，应用程序员可以从 XML 获取一个 Document
//                DocumentBuilder builder = factory.newDocumentBuilder();
//                // Document 接口表示整个 HTML 或 XML 文档。从概念上讲，它是文档树的根，并提供对文档数据的基本访问
//                Document document = builder.newDocument();
//                //组织生产xml文件内容
//                Element root = document.createElement("persons");
//                document.appendChild(root);
//                Element person = document.createElement("person");
//                Element name = document.createElement("name");
//                name.appendChild(document.createTextNode("java小强"));
//                person.appendChild(name);
//                Element sex = document.createElement("sex");
//                sex.appendChild(document.createTextNode("man"));
//                person.appendChild(sex);
//                Element age = document.createElement("age");
//                age.appendChild(document.createTextNode("99"));
//                person.appendChild(age);
//                root.appendChild(person);
//
//                TransformerFactory tf = TransformerFactory.newInstance();
////                // 此抽象类的实例能够将源树转换为结果树
//                Transformer transformer;
//                transformer = tf.newTransformer();
//
//                DOMSource source = new DOMSource(doc);
//                ByteArrayOutputStream bos = new ByteArrayOutputStream();
//                transformer.transform(source, new StreamResult(bos));
//                String xmlStr = bos.toString();
//                out.writeUTF(xmlStr);

//********************************接收读取客户端传来的内容******************************************
                //接收来自服务器的数据，并解析打印
//                DataInputStream in = new DataInputStream(soc.getInputStream());
//                data = in.readUTF();
//
//                Document dom=DocumentHelper.parseText(data);
//
//                OutputFormat format = new OutputFormat();
//                format.setIndentSize(4);  // 行缩进
//                format.setNewlines(true); // 一个结点为一行
//                format.setTrimText(true); // 去重空格
//                format.setPadText(true);
//                format.setNewLineAfterDeclaration(false); // 放置xml文件中第二行为空白行
//
//                Writer out = new PrintWriter("E:\\xmlTest.txt", "utf-8");
//                XMLWriter writer = new XMLWriter(out, format);
//
//                writer.write(dom);
//
//                out.close();
//                writer.close();


//				System.out.println("接收到的数据:" + data);
//                DOM(data);
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
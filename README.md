# SignalMachine-protocol

实现的功能：模仿信号机回发送，接受消息。

说明：   1.信号机回的xml消息没有 "\n"，但是BufferedReader.readline要以\n或者\r才结束，所以修改源码，自己创建新的类：SelfBufferedReader,修改判断条件。
         2.修改了判断条件，会导致最后的 ">"被去掉，加上信号机穿过来的xml消息前面可能会有乱码，所以对消息进行了处理，除掉乱码，尾部追加>\n。
         3.进行了整体的封装，client里面只需要调用就能接受到转换后的xml消息，及json格式。封装的代码用到了面向对象，多线程技术
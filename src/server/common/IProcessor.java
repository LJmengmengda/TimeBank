package server.common;

import java.io.DataOutputStream;

import client.common.packages.ClientPackage;

public interface IProcessor {
	//处理某消息包的方法   ClientPackage是客户机端的一些类的父类
	///IProcessor是服务器端的一个借口类~~用来处理客户机端的一些类的不同实现方法
	///DataOutputStream dos是每一个receiver得到的输出流，ID是目前的得到的每一个receiver的ID号码
	//之后的话~每一次客户机发来的信息都会告诉服务器自己的ID号码就不用这个参数了
	public int process(ClientPackage p, DataOutputStream dos);
}

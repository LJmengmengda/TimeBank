package client.common;

import java.io.DataOutputStream;

import server.common.packages.ServerPackage;
import client.common.packages.ClientPackage;

public interface IProcessor {
	//处理某消息包的方法
	public void process(ServerPackage sp);
}

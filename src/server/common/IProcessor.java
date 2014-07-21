package server.common;

import java.io.DataOutputStream;

import client.common.packages.ClientPackage;

public interface IProcessor {
	//处理某消息包的方法
	public void process(ClientPackage p, DataOutputStream dos);
}

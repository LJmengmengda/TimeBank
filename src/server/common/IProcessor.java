package server.common;

import java.io.DataOutputStream;

import client.common.packages.TBPackage;

public interface IProcessor {
	//处理某消息包的方法
	public void process(TBPackage p, DataOutputStream dos);
}

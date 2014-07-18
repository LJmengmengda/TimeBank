package client.common;

import client.common.packages.Package;

public interface IProcessor {
	//处理某消息包的方法
	public void process(Package p);
}

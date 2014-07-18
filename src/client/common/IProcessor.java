package client.common;

import client.common.packages.IPackage;

public interface IProcessor {
	//处理某消息包的方法
	public void process(IPackage p);
}

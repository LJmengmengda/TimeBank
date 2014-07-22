package server.common.packages;

import java.util.ArrayList;

import client.common.Request;

public class ClientRequestListPackage extends ServerPackage{
	
	private int total;//request包的对象的数目
	public ClientRequestListPackage(int total, ArrayList<Request> list) {
		super();
		this.total = total;
		this.list = list;
		this.setType(ServerConfig.CLIENT_REQUEST_LIST_REQUEST);
		this.setSrc(0);
	}
	
	private ArrayList<Request> list=new ArrayList<Request>();
	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public ArrayList<Request> getList() {
		return list;
	}

	public void setList(ArrayList<Request> list) {
		this.list = list;
	}
	
	
	
	

}

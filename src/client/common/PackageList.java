package client.common;

import client.common.packages.TBPackage;

/**
 * 
 * 消息链表类
 * @author SSheng
 *
 */
public class PackageList {
	//链表头
	private Node head;
	public int nodeNum = 0;

	//测试用主函数
//	public static void main(String[] args){
//		PackageList p = new PackageList();
//		
//	}
	
	/**
	 * @return返回根节点
	 */
	public Node getHead() {
		return head;
	}
	
	/**
	 * 每次调用自动删除跟节点，并把根节点指向下一节点
	 */
	public void delete(){
		if(head == null){
			return;
		}else if(head.next == null){
			head = null;
			nodeNum--;
		}else{
			head = head.next;
			nodeNum--;
		}
	}
	
	/**
	 * 添加节点
	 * @param p TBPackage包
	 */
	public void add(TBPackage p){
			if(head == null){
				head = new Node(p);
				nodeNum++;
			}else{
				Node temp = head;
				while(temp.next!=null){
					temp = temp.next;
				}
				temp.next = new Node(p);
				nodeNum++;
			}
		}
	
	/**
	 * 测试方法  输出所有节点数据包的类型
	 */
	public void test(){
		Node n = head;
		while(n!=null){
			
			System.out.println(n.p.getType());
			n = n.next;
		}
	}
	
}
//内部节点类
class Node{
	TBPackage p;
	Node next;
	
	public Node(TBPackage p){
		this.p = p;
	}
}



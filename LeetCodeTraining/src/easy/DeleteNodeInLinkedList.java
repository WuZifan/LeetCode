package easy;

import org.junit.Test;

public class DeleteNodeInLinkedList {
	public void deleteNode(ListNode node){
		/*
		 * 之所以不可以直接写 node=node.next
		 * 是因为node只是一个对象名，在node3传入后，node这个对象名指向node3所在的存储空间
		 * 当node=node.next后，node这个对象名就指向node.next这个对象所指向的存储空间
		 * 而node3所指的存储空间没有改变
		 * 因此函数返回后不会有任何变化
		 */
		node.val=node.next.val;
		node.next=node.next.next;
	}
	
	@Test
	public void test(){
		ListNode root=new ListNode(1);ListNode node2=new ListNode(2);
		ListNode node3=new ListNode(3);ListNode node4=new ListNode(4);
		root.next=node2;node2.next=node3;
		node3.next=node4;
		printList(root);deleteNode(node3);
		printList(root);
	}
	
	public void printList(ListNode root){
		if(root==null){
			System.out.println("The LinkedList is empty");
			return;
		}
		ListNode node=root;
		while(node!=null){
			System.out.println(node.val);
			node=node.next;
		}
	}
}

class ListNode{
	int val;
	ListNode next;
	ListNode(int val){
		this.val=val;
	}
}

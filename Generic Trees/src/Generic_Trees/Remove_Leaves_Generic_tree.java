package Generic_Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Remove_Leaves_Generic_tree {

	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
		int arr[]= {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};
		Node root=input(arr);
		removeLeaves(root);
		display(root);

	}
	
	public static Node input(int arr[]) {
		Node root=null;
		Stack <Node> st= new Stack<>();
		
		
		for(int i=0;i<arr.length;++i) {
			if(arr[i]==-1) {
				st.pop();
			}else {
				
				Node temp=new Node();
				temp.data=arr[i];

				if(st.size()>0) {
				   st.peek().children.add(temp);
				}else {
					root=temp;
				}
				st.push(temp);
			}
		}
		
		return root;
	}

	
	
	public static void display(Node root) {
		
		String str= root.data+" -> ";
		
		for(Node child: root.children) {
			str+=child.data + " ";
		}
		str+=".";
		System.out.println(str);
		
		for(Node child: root.children) {
			display(child);
		}
		
		
	}


    
	public static void removeLeaves(Node root) {
		
		for(int i=root.children.size()-1; i>=0; --i) {
			Node child=root.children.get(i);
			if(child.children.size()==0) {
				root.children.remove(child);
			}
		}
		

		
	    for(Node child: root.children) {
	    	removeLeaves(child);
		}
		
				
	}


}



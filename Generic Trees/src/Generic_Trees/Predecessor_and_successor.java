package Generic_Trees;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Predecessor_and_successor {
	
	static int pre;
	static int sucessor;
	static int state;

	public static void main(String[] args) {

		Scanner s= new Scanner(System.in);
		int arr[]= {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};
		Node root=input(arr);


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
	
	
	 public static void predecessorAndSuccessor(Node root, int data) {
		 
		 if(state==0) {
			 if(root.data==data) {
				 state=1;
			 }else {
				 pre=root.data;
			 }
		 }else if(state==1) {
			 sucessor=root.data;
			 state=2;
		 }
		 
		 for(Node child:root.children) {
			 predecessorAndSuccessor(child, data);
		}
		 
		 
		 
		 

		  
		   
		  }
	 
	 }

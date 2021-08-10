package Generic_Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class LevelOrder_LineWise_zigzag {

	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
		int arr[]= {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};
		Node root=input(arr);
		LevelLineZigZag(root);

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
		   String str= root.data+"-> ";
		   for(Node child:root.children) {
			   str=str+child.data+ ",";
		   }
		   str= str+".";
		   System.out.println(str);
		   for(Node child:root.children) {
			   display(child);
		   }
	   }


	public static void LevelLineZigZag(Node root) {
		
		Stack<Node> mst= new Stack<>();
		Stack<Node> cst= new Stack<>();
		int level=0;
		
		
		mst.push(root);
		
		while(mst.size()!=0) {
			
			Node node= mst.pop();
			
			System.out.print(node.data + " ");
			
			if(level%2==0) {
				for(int i=0;i<node.children.size();++i) {
					cst.push(node.children.get(i));
				}
			}else {
				for(int i=node.children.size()-1; i>=0; --i) {
					cst.push(node.children.get(i));
				}
				
			}
			
			
			if(mst.size()==0) {
				mst=cst;
				cst=new Stack<>();
				System.out.println();
				level++;
			}
			
		}
	}



}

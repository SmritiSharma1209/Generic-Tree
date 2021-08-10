package Generic_Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class LevelOrder_LineWise3 {

	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
		int arr[]= {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};
		Node root=input(arr);
		LevelLineWise3(root);

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

	public static void LevelLineWise3(Node root) {
		Queue <Node> mq= new LinkedList<>();
		
		mq.add(root);
		
		while(mq.size()>0) {
			
			int cicl=mq.size();
			
			for(int i=0; i <cicl ;++i) {
				Node temp= mq.remove();
				System.out.print(temp.data + " ");
				
				for(Node child: temp.children) {
					mq.add(child);
				}
			}
			System.out.println();     //yaha level khatam ho gaya.
		}
		
		
	}


	
	
}

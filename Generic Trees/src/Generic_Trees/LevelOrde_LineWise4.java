package Generic_Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class LevelOrde_LineWise4 {

	public static void main(String[] args) {
		
		Scanner s= new Scanner(System.in);
		int arr[]= {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};
		Node root=input(arr);
		LevelLineWise4(root);


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

	 private static class Pair{
		Node node;
		int Level;
		
		public Pair(Node node, int Level) {
			this.node=node;
			this.Level=Level;
		}
	}
	
	public static void LevelLineWise4(Node root) {
		
		Queue <Pair> mq= new LinkedList<>();
		mq.add(new Pair(root, 1));
		
		int level=1;
		
		while(mq.size()>0) {
			
		    Pair temp =mq.remove();
		    if(temp.Level>level) {
		    	level=temp.Level;
		    	System.out.println();
		    	
		    }
			System.out.print(temp.node.data+ " ");
			
			for(Node child: temp.node.children) {
				mq.add(new Pair(child, temp.Level+1));
			}
		}
		
		
		
	}
}

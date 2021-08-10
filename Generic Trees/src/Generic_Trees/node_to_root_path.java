package Generic_Trees;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class node_to_root_path {

	public static void main(String[] args) {
		
		Scanner s= new Scanner(System.in);
		int arr[]= {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};
		Node root=input(arr);
		
	     ArrayList<Integer> path=findPath(root,110);
	     System.out.print(path);
		//display(root);

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

    
	
	public static ArrayList<Integer> findPath(Node root, int data) {
		
		if(root.data==data) {
			ArrayList<Integer> list = new ArrayList<>();
			list.add(root.data);
			return list;
		}
		
		for(Node child: root.children) {
			ArrayList<Integer> ptc = findPath(child, data);    //ptc - path till child
			if( ptc.size()>0) {
				ptc.add(root.data);
				return ptc;
			}
			
			
		}
		
		return new ArrayList<>();
		
}
}

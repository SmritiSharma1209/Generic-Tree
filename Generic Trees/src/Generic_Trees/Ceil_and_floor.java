package Generic_Trees;

import java.util.Scanner;
import java.util.Stack;

public class Ceil_and_floor {
	
	
	static int ceil;
	static int floor;

	public static void main(String[] args) {
		
		Scanner s= new Scanner(System.in);
		int arr[]= {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};
		Node root=input(arr);
		ceil=Integer.MAX_VALUE;        //smallest among the largest
		floor=Integer.MIN_VALUE;       // largest among the smaller 
		floorAndCeil(root,65);
		System.out.print(ceil + " "+ floor);
		

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

	
	public static void floorAndCeil(Node root, int data) {
		
		if(root.data>data) {
			
			if(ceil>root.data) {
				ceil=root.data;
			}
			
		}
			
		if(root.data<data) {
			
			if(floor<root.data) {
				floor=root.data;
			}
			
		}
		
		
		for(Node child: root.children) {
			floorAndCeil(child,data);
		}
	
		
		
		
	}

}

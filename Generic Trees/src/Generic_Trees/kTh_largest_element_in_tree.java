package Generic_Trees;

import java.util.Scanner;
import java.util.Stack;

public class kTh_largest_element_in_tree {
	
	
	static int ceil;
	static int floor;

	public static void main(String[] args) {
		
		Scanner s= new Scanner(System.in);
		int arr[]= {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};
		Node root=input(arr);
		ceil=Integer.MAX_VALUE;
		floor=Integer.MIN_VALUE;
		System.out.println(KthLargest(root, 3));

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
			if(root.data<ceil) {
				ceil=root.data;
			}
			
		}
		
		if(root.data<data) {
			
			if(root.data>floor) {
				floor=root.data;
			}
			
		}
		
		for(Node child: root.children) {
			floorAndCeil(child, data);
		}
	}

	
	public static int KthLargest(Node root, int k) {
		
		floor= Integer.MIN_VALUE;
		int factor= Integer.MAX_VALUE;    //Compare with infinity so the value of the floor will be the largest element
		for(int i=0;i<k; ++i) {
			floorAndCeil(root,factor);
			factor=floor;
			floor=Integer.MIN_VALUE;
		}
		
		return factor;
		
	}
}

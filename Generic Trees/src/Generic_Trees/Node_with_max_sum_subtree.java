package Generic_Trees;

import java.util.Scanner;
import java.util.Stack;

public class Node_with_max_sum_subtree {

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

	static int msn=0;                            //Maximum sum node;
	static int ms=Integer.MIN_VALUE;            //Initially Max sum is -infinity
	public static int NodewithMaxsum(Node root) {
		
		int sum=0;
		
		for(Node child: root.children) {
			int cs= NodewithMaxsum(child);
			sum=sum+cs;
		}
		
		if(sum>ms) {
			msn=root.data;
			ms=sum;
		}
		
		sum=sum+root.data;
		return sum;
	}
}

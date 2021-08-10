package Generic_Trees;

import java.util.Scanner;
import java.util.Stack;

public class Multisolver_size_height {
	
	static int size;
	static int min;
	static int max;
	static int height;

	public static void main(String[] args) {
		
		Scanner s= new Scanner(System.in);
		int arr[]= {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};
		Node root=input(arr);
		size=0;
		min=Integer.MAX_VALUE;
		max=Integer.MIN_VALUE;
		height=0;
		multisolver(root,0);
		
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

	
    public static void multisolver(Node root,int depth) {
    	size++;
    	min=Math.min(min, root.data);
    	max= Math.max(max, root.data);
    	height= Math.max(height, depth);
    	
    	for(Node child: root.children) {
    		multisolver(child, depth+1);
    	}
    }
}

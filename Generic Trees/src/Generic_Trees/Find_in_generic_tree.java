package Generic_Trees;

import java.util.Scanner;
import java.util.Stack;

public class Find_in_generic_tree {

	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
		int arr[]= {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};
		Node root=input(arr);
		
		System.out.println(find(root, 110));
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

   
	public static boolean find(Node root, int data) {
		
		if(root.data==data) {
			return true;
		}
		
	    for(Node child : root.children) {
	    	
	    	boolean fic= find(child,data);
	    	if(fic) {
	    		return true;
	    	}
	    }
	    return false;
	}
}

package Generic_Trees;

import java.util.Scanner;
import java.util.Stack;

public class Linearize_tree_efficient_approach {

	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
		int arr[]= {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};
		Node root=input(arr);
		Linearize2(root);
		display(root);
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
		
		String str= root.data+" -> ";
		
		for(Node child: root.children) {
			str+=child.data + " ";
		}
		str+=".";
		System.out.println(str);
		
		for(Node child: root.children) {
			display(child);
		}
		
		
	}


     public static Node Linearize2(Node root) {
    	 
    	 if(root.children.size()==0) {
    		 return root;
    	 }
    	 
    	 Node lkt= Linearize2(root.children.get(root.children.size()-1));
    	 Node last=root.children.get(root.children.size()-1);
    	 
    	 while(root.children.size()>1) {
    		 root.children.remove(root.children.size()-1);
    		 Node sc= root.children.get(root.children.size()-1);
    		 Node sct=Linearize2(sc);
    		 sct.children.add(last);
    	 }
    	 
    	 return lkt;
     }
}

package Generic_Trees;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Lowest_common_ancestor {

	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
		int arr[]= {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};
		Node root=input(arr);
         System.out.println(lca(root,70,110));
		//System.out.print(anc);

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

	
	 public static int lca(Node node, int d1, int d2) {
		 
		 ArrayList<Integer> p1= nodeToRootPath(node, d1);
		 ArrayList<Integer> p2=nodeToRootPath(node,d2);
		 
		 int i= p1.size()-1;
		 int j=p2.size()-1;
		 
		 while(i>=0 && j>=0 && p1.get(i)==p2.get(j)) {
			 i--;
			 j--;
		 }
		 
		 i++;
		 j++;
		 
		 return p1.get(i);
		 
	}
	 
	 public static ArrayList nodeToRootPath(Node root, int data) {
		 
		 if(root.data==data) {
			 ArrayList<Integer> list= new ArrayList<>();
			 list.add(root.data);
			 return list;
			 
		 }
		 
		 for(Node child: root.children) {
			 
			 ArrayList <Integer> res= nodeToRootPath(child,data);
			 if(res.size()>0) {
				 res.add(root.data);
				 return res;
			 }
			 
		 }
		 
		 return  new ArrayList<>();
		 
	 }
}

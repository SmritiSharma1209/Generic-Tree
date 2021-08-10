package Generic_Trees;

import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class Are_Trees_mirror_images {

	public static void main(String[] args) {
		Scanner s= new Scanner(System.in);
		//int arr[]= {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1,-1};
		//Node root=input(arr);
		int arr1[]= {10 ,20, -1, 30, 50, -1, 60, -1 ,-1, 40, -1, -1};
		int arr2[]= {100 ,200, -1, 300, 500, -1, 600, -1, -1, 400, -1, -1};
		Node root1= input(arr1);
		Node root2= input(arr2);
		
		System.out.println(areMirror(root1,root2));

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

	
	public static boolean areMirror(Node n1, Node n2) {     //Pehle ek tree ko uski mirror image mai convert karo. 
		                                                     //Fir dusre tree se aap iss mirror wale tree ki similarity check karo
//	    mirror(n1);
//	    
//	    if(n1.children.size()!=n2.children.size()) {
//	    	return false;
//	    }
//	    
//	    for(int i=0;i<n1.children.size() ; ++i) {
//	    	Node c1= n1.children.get(i);
//	    	Node c2= n2.children.get(i);
//	    	
//	    	if(areMirror(c1,c2)==false){
//	    		return false;
//	    	}
//	    }
//	    return true;
		
		   //OR
		
		if(n1.children.size()!=n2.children.size()) {
			return false;
		}
		
		for(int i=0;i<n1.children.size();++i) {
			int j= n1.children.size()-1-i;
			Node c1= n1.children.get(i);
			Node c2=n2.children.get(j);
			
			if(areMirror(c1,c2)==false) {
				return false;
				
			}
		}
		return true;
	  }
	
	public static void mirror(Node root) {
		
		for(Node child:root.children) {
			mirror(child);
		}
		Collections.reverse(root.children);
	}
}

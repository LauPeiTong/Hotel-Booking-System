package com.catravel;

import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import javax.xml.crypto.Data;

import org.springframework.beans.factory.annotation.Autowired;

import com.catravel.model.*;
import com.catravel.model.BookingRoom;
import com.catravel.repository.BookingRepository;
import com.catravel.repository.HotelRepository;
import com.catravel.repository.RoomTypeRepository;

/*
 * just for testing some code
 * ignore this
 */
import java.util.*;

public class main {
	
	private static final String SPACES = " ";
    static int MAX = 26;
    
	// Node in the binary tree, data is character of the String
	// ,count holds the frequency
	static class Node{ 
	    char data;
	    int count;
	    Node left, right;
	}
	 
	// static method to add a new node to the Binary Tree
	static Node addnew(char data){
	 
	    // Instantiate a new node and assign the data part, set count as 1,
		// ,left and right children as null
		Node newnode = new Node();
	    newnode.data = data;
	    newnode.count = 1;
	    newnode.left = newnode.right = null;
	 
	    return newnode;
	}
	 
	// Function to add a node to the Binary Tree
	static Node insert(Node root, char data){
	 
	    if (root == null){
	        return addnew(data);
	    }
	     
	    //Queue is applied for insertion and push the root of tree into Queue
	    Queue<Node> queue= new LinkedList <Node>();
	    queue.add(root);
	 
	    while (!queue.isEmpty()){
	    	Node temp = queue.peek();
	    	queue.remove();
	 
	        // If the character to be inserted is present,update the cnt
	        if (temp.data == data){
	            temp.count++;
	            break;
	        }
	         
	        // If the left child is
	        // empty add a new node
	        // as the left child
	        if (temp.left == null){
	            temp.left = addnew(data);
	            break;
	        }
	        else{
	            // If the character is present
	            // as a left child, update the
	            // cnt and exit the loop
	            if (temp.left.data == data){
	                temp.left.count++;
	                break;
	            }
	             
	            // Add the left child to
	            // the queue for further
	            // processing
	            queue.add(temp.left);
	        }
	         
	        // If the right child is empty,
	        // add a new node to the right
	        if (temp.right == null){
	            temp.right = addnew(data);
	            break;
	        }
	        else{
	            // If the character is present
	            // as a right child, update the
	            // cnt and exit the loop
	            if (temp.right.data == data){
	                temp.right.count++;
	                break;
	            }
	             
	            // Add the right child to
	            // the queue for further
	            // processing
	            queue.add(temp.right);
	        }
	    }
	 
	    return root;
	}
	 
	// Function to print the
	// level order traversal of
	// the Binary Tree
	static void printlvlorder(Node root)
	{
	 
	    // Add the root to the queue
	    Queue<Node> Q = new LinkedList<Node>();
	    Q.add(root);
	 
	    while (!Q.isEmpty()){
	    	Node temp = Q.peek();
	         
	    	System.out.println(temp.data + " " + temp.count);
	        // If the cnt of the character
	        // is more then one, display cnt
	        if (temp.count > 1){
	        	System.out.println("**************1");
	            System.out.print((temp.data +""+ temp.count));
	        }
	         
	        // If the cnt of character
	        // is one, display character only
	        else{
	        	System.out.println("**************2");
	            System.out.print((char)temp.data);
	        }
	        Q.remove();
	         
	        // Add the left child to
	        // the queue for further
	        // processing
	        if (temp.left != null){
	            Q.add(temp.left);
	        }
	         
	        // Add the right child to
	        // the queue for further
	        // processing
	        if (temp.right != null){
	            Q.add(temp.right);
	        }
	    }
	}
	 
	public static void main(String[] args){
	 
//	    String s = "geeksforgeeks";
		Scanner in = new Scanner(System.in);
		StringBuilder stringBuild =new StringBuilder();
		
		int n = 0 ,j;
//		String word, s = " ",stringText = " ";
		
		//prompt user enter text
		System.out.print("Please enter number of strings:  ");
		n = in.nextInt();
		System.out.print("\n\n");
		String[] strArray = new String[n+1];
		
		for(j = 0; j<=n-1 ; j++){
//			strArray[j] = in.nextLine();
			System.out.print("Please enter your line of String: ");
			strArray[j] = in.next();
			stringBuild.append(strArray[j]);
			stringBuild.append(SPACES);		
			System.out.println();
		}
		
	    Node root = null;
	 
	    // Add individual characters
	    // to the String one by one
	    // in level order

//	    for (int i = 0; i < s.length(); i++){
//	        root = insert(root, s.charAt(i));
//	    }
	    for (int i = 0, k= 0 ; k < strArray.length - 1; i++){
	    	if(i == strArray[k].length() - 1) {
	    		k++;
	    		i = 0;
	    	}
	        root = insert(root, strArray[k].charAt(i));
	    }

	    
	    // Print the level order
	    // of the constructed
	    // binary tree
	    printlvlorder(root);
	 
	}
}


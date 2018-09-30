/* Written By: Afnan Sultan (N01154597)
   Dr. Kenneth Martin, Data Structures COP3530
   Date Last Modified: 9/23/18
   
   This program takes an array of strings, splits them into three inputs.
   The program concerns the Josephus problem.
   The inputs are the size, the holder, and the pass. */

import java.util.Scanner;

class Link{

   public int linkData; //data for each link
   public Link next; // next pointer

   public Link(int linkNumber){
      
      linkData = linkNumber;
   } //Link
   
   public void printLink() {
   
      System.out.print(" " + linkData + " "); //print each link
      
   } // printLink()

} // class Link

class LinkList{

   private Link first; //first link
   private Link last; // last link
   private Link current; // current link

   public LinkList(){
   
      first = null;
      last = null; 
      current = null;
   } // constructor LinkList()

   public boolean isEmpty(){
      return(first == null); // return if true
   } // isEmpty()

   public void fill(int listSize){
   
      for(int i=1; i < listSize+1; i++){ //start at 1, loop until size+1
         Link newLink = new Link(i); // create new link based on counter
      
         if(isEmpty()){ 
         
            first = newLink;
            last = newLink;
            current = first;
         } // if
         
         else{
         
            current.next = newLink; // assign link after current to newlink
            newLink.next = first; // assign link after new link to first
            last = newLink; // tie linked list together, make it circular
            current = current.next; // increment current 
         } // else
      } // for
   } // fill


   public Link search(int holder, int listSize){
   
         current = first; // assign first to current
   
      for(int i = 0; i < listSize; i++){ // go through list
           if(current.linkData == holder){ // find holder
         
            break;
         } // if
         
         else{
           current = current.next; // continue going through list
         } // else
      } // for
   
     return current;
     
   } //search()
   
   public void delete(int hold, int passing, int size){
   
      Link current = search(hold, size); // search for current
      Link previous = first; // assign first to previous
   
      while(size!= 1){
      
         for(int i = 0; i < passing; i++){ // cycle through all links until passing is found
            previous = current; // assign current to previous
            current = current.next; // increment current
         } // for
      
         
         if(current == last)
         {
            last = previous; // assign last as previous if current is last
            first = current.next; // assign LL circular
         } // if
         
         else if (current == first)
         {
            last = previous; // assign last as previous 
            first = current.next; // keep LL circular
         } // else if
         
         current = current.next; // continue through list
         previous.next = current; // keep previous before current
         printList(--size); // decrement list
         
      } // while
      
   } // delete()


   public void printList(int size){
   
      System.out.print("\nList:\n"); 
   
      Link cur = first; // assign first to temp current
   
      for(int i = 1; i < size+1; i++){ // go through list
         

         cur.printLink(); // print temp current
         cur = cur.next; // go to next temp cur
         
      } // for
      
      System.out.print("");
   
   } // printList()
   
} // class LinkList

class n01154597{

   public static void main(String[] args){
   
      LinkList circle = new LinkList();
      Scanner input = new Scanner(System.in);
   
      System.out.print("Please enter 3 integers (size, holder, passing): ");
   
      String str_input = input.nextLine(); //take input as a string
   
      while (!str_input.equals("stop")) { // let user enter inputs until stop is entered
      
         
         String[] input_array = str_input.split(" "); // split string into three pieces of data

         int listSize = Integer.parseInt(input_array[0]);
         int holder = Integer.parseInt(input_array[1]);
         int pass = Integer.parseInt(input_array[2]);
         
         circle.fill(listSize); // fill circular linked list
         circle.printList(listSize); // print list based on listsize
         circle.delete(holder, pass, listSize); // delete link based on three inputs
         
         System.out.print("\nPlease enter 3 integers (size, holder, passing): ");
         str_input = input.nextLine();
      
      } // while
       
   } // main

} // class n01154597 (class Josephus)
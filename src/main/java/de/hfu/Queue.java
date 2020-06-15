package de.hfu;

public class Queue {
   int[] queue;
   int head;
   int tail;
   private final int maxqueuelength;

   public Queue(int max){
	   if (max < 1) throw new IllegalArgumentException("Queue Arraylength " + max);
	   maxqueuelength = max;
	   queue = new int[max];
	   head = 0;
	   tail = -1;
   }

   
   public void enqueue(int a){
	   if((tail - head) < maxqueuelength -1 ){
		    tail++;  //Schlange noch nicht voll
		  }
	   else {
		   throw new IllegalStateException("enqueue into full queue");
	   }
	   
		  queue[tail % maxqueuelength] = a; // Tail erhöhen und enqueuen
   }
   

   public int dequeue(){
	   if(tail < head){
		    throw new IllegalStateException("dequeue on empty queue"); // LEERE Q
		  }
	   
	   
	   
		  return queue[(head++) % maxqueuelength];
   }

}
package de.hfu;

import static org.junit.Assert.*;

import org.junit.Test;
import de.hfu.Queue.*;

public class QueueTest {

		@Test
		public void testEnqueue() {
			 Queue q = new Queue(3);
			 
			for(int i = 0; i <= 2; i++) {
						
					q.enqueue(i);
				
					assertEquals( i , q.queue[i]);
				
			}
		}
		
	

		@Test
		public void testDequeue() {
			
			 Queue q = new Queue(3);
			 	for(int i = 0; i <= 2; i++) {
					
					q.enqueue(i);
			}
			for(int i = 0; i < 3; i++) {
				
				q.dequeue();
				assertEquals(i, q.queue[i]);
			}
	
			
}}

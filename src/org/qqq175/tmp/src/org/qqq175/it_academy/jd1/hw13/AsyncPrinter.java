/**
 * 
 */
package org.qqq175.it_academy.jd1.hw13;

/**
 * realizes a non-synchronized number printer thread
 * @author qqq175
 *
 */
public class AsyncPrinter extends Thread{
	/** contains current number to print*/
	private static int counter = 0;
	/** contains last printed number to synchronize print order*/
	private static int lastPrinted = 0;
	
	/**
	 * Constructor. Starts new thread at creation.
	 */
	AsyncPrinter(){
		this.start();
	}
	
	/**
	 *  realizes a non-synchronized number printer
	 */
	@Override
	public void run(){
		while(counter < 10){
			int start = counter++ * 10 + 1;
			int end = start + 9;
			StringBuilder curLine = new StringBuilder(Thread.currentThread().getName() + ": ");
			
			//make next line
			for(int i = start; i <= end; i++){
				curLine.append(Integer.toString(i)).append(" ");
			}
			
			//check and wait until previous line are printed
			while(lastPrinted != start - 1)
			{
				try {
					Thread.sleep(0, 50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			//print next line
			System.out.println(curLine.toString());
			lastPrinted = end;
		}
	}

}

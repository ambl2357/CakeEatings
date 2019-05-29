package BackJoon;

public class CakePlate {
	private int breadCount = 0;
	public CakePlate() {
		
	}
	
	public synchronized void makeBread() {
		if(breadCount>=10) {
			try {
				System.out.println("bread is lest");
				wait();
			}catch(InterruptedException ire) {}
		}
		breadCount++;
		System.out.println("make one more bread : " + breadCount+"°³");
		this.notifyAll();
	}
	
	public synchronized void eatBread() {
		if(breadCount<1) {
			try {
				System.out.println("wait for lack of bread ");
				wait();
			}catch(InterruptedException ire) {}
		}
			breadCount--;
			System.out.println("eat one bread: " + breadCount+"°³");
			this.notifyAll();
	}
}

package Model;

import View.Window;

public class ThreadBarres implements Runnable{
	private int waitingTime = 10;
	private double perteEnergie = 0.001;
	private double perteVie = 0.001;
	private double regenPouvoir1 = 1;
	private double regenPouvoir2 = 1;
	private Player p;
	private Window window;
	private Thread thread;

	public ThreadBarres(int waitingTime, double perteEnergie, double perteVie, Player p,Window window) {
		this.waitingTime = waitingTime;
		this.perteEnergie = perteEnergie;
		this.p = p;
		this.window = window;
		this.perteVie = perteVie;
		this.thread = new Thread(this);
		thread.start();	
	}
	
	public void run() {
		try {
			while (true) {
				Thread.sleep(waitingTime);
				if (p.energy > 0) {
					p.energy -= perteEnergie;
				} if (p.vie > 0) {
					p.vie -= perteVie;
				} if (p.pouvoir1 <= 100) {
					p.pouvoir1 += regenPouvoir1;
				} if (p.pouvoir2 <= 100) {
					p.pouvoir2 += regenPouvoir2;
				}
				window.update();

			}
		}
		catch(Exception e){
			
		}
	}

}

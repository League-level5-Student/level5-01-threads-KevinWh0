package _01_Olympic_Rings;

import org.jointheleague.graphical.robot.Robot;

public class OlympicRings_Threaded {
	// Make A Program that uses Threads and robots to draw the Olympic rings. One
	// robot should draw one ring simultaneously with the other 4 robots.
	static Robot r[] = new Robot[5];

	static void moveRobots(int id) {
		r[id].penDown();
		r[id].setPenWidth(id*5);

		for (int i = 0; i < 360; i++) {
			r[id].move(1);
			r[id].setAngle(i);
		}

		r[id].penUp();
		r[id].move(1000);

	}

	public static void main(String[] args) {

		for (int i = 0; i < r.length; i++) {
			

			if (i == 3 || i == 1) {
				r[i] = new Robot(70 * i, 470);

			} else
				r[i] = new Robot(70 * i, 400);
			
			
			switch (i) {

			case 0:
				 r[i].setPenColor(0, 129, 200);
				 //r[i].setPenColor(255, 0, 0);
				 //yellow black green
				break;
			case 1:
				 r[i].setPenColor(252, 177, 49);
				break;
			case 2:
				 r[i].setPenColor(0, 0, 0);
				break;
			case 3:
				 r[i].setPenColor(0, 255, 8);
				break;
			case 4:
				 r[i].setPenColor(238, 51, 78);
				break;
			}

		}
		Thread r0 = new Thread(() -> moveRobots(0));
		Thread r1 = new Thread(() -> moveRobots(1));
		Thread r2 = new Thread(() -> moveRobots(2));
		Thread r3 = new Thread(() -> moveRobots(3));
		Thread r4 = new Thread(() -> moveRobots(4));

		r0.start();
		r1.start();
		r2.start();
		r3.start();
		r4.start();

	}
}

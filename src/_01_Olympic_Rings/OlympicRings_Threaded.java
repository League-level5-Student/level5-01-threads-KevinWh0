package _01_Olympic_Rings;

import java.awt.Color;

import org.jointheleague.graphical.robot.Robot;

public class OlympicRings_Threaded {
	// Make A Program that uses Threads and robots to draw the Olympic rings. One
	// robot should draw one ring simultaneously with the other 4 robots.
	static Robot r[] = new Robot[5];

	static void moveRobots(int id) {
		r[id].penDown();
		// r[id].setPenWidth(id);

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

//			switch (i) {
//
//			case 0:
//				 //r[i].setPenColor(0, 129, 200);
//				 r[i].setPenColor(255, 0, 0);
//
//				break;
//			case 1:
//				 r[i].setPenColor(252, 177, 49);
//				break;
//			case 2:
//				 //r[i].setPenColor(0, 0, 0);
//				 r[i].setPenColor(0, 129, 200);
//
//				break;
//			case 3:
//				 r[i].setPenColor(0, 255, 8);
//				break;
//			case 4:
//				 r[i].setPenColor(238, 51, 78);
//				break;
//			default:
//				 r[i].setPenColor(0, 0, 200);
//
//				break;
//			}
			r[i].setPenColor(0, 0, 255);

			r[i].setPenColor(Color.red);

		}
		 //Thread r0 = new Thread(() -> moveRobots(0));

		Thread r0 = new Thread(() -> {
			r[0].setPenColor(Color.blue);
			r[0].penDown();
			// r[id].setPenWidth(id);

			for (int i = 0; i < 360; i++) {
				r[0].move(1);
				r[0].setAngle(i);
			}

			r[0].penUp();
		});
		Thread r1 = new Thread(() -> {
			r[1].setPenColor(Color.yellow);
			r[1].penDown();
			// r[id].setPenWidth(id);

			for (int i = 0; i < 360; i++) {
				r[1].move(1);
				r[1].setAngle(i);
			}

			r[1].penUp();
		});
		Thread r2 = new Thread(() -> {
			r[2].setPenColor(Color.black);
			r[2].penDown();
			// r[id].setPenWidth(id);

			for (int i = 0; i < 360; i++) {
				r[2].move(1);
				r[2].setAngle(i);
			}

			r[2].penUp();
		});
		Thread r3 = new Thread(() -> {
			r[3].setPenColor(Color.green);
			r[3].penDown();
			// r[id].setPenWidth(id);

			for (int i = 0; i < 360; i++) {
				r[3].move(1);
				r[3].setAngle(i);
			}

			r[3].penUp();
		});
		Thread r4 = new Thread(() -> {
			r[4].setPenColor(Color.red);
			r[4].penDown();
			// r[id].setPenWidth(id);

			for (int i = 0; i < 360; i++) {
				r[4].move(1);
				r[4].setAngle(i);
			}

			r[4].penUp();
		});
//		Thread r1 = new Thread(() -> moveRobots(1));
//		Thread r2 = new Thread(() -> moveRobots(2));
//		Thread r3 = new Thread(() -> moveRobots(3));
//		Thread r4 = new Thread(() -> moveRobots(4));

		r0.start();
		r1.start();
		r2.start();
		r3.start();
		r4.start();

	}
}

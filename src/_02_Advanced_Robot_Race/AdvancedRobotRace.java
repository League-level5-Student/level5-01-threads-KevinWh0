package _02_Advanced_Robot_Race;

import java.util.Random;

import javax.swing.JOptionPane;

import org.jointheleague.graphical.robot.Robot;

public class AdvancedRobotRace {
	// Re-do the robot race recipe from level 3 module 0.
	// This time, use threads to make all of the robots go at the same time.
	static Robot r[] = new Robot[5];

	static final int finishLine = 100;
	static boolean gameOver = false;

	static Random rand = new Random();
	static Thread r0;
	static Thread r1;
	static Thread r2;
	static Thread r3;
	static Thread r4;

	public static void main(String[] args) {
		for (int i = 0; i < r.length; i++) {

			r[i] = new Robot(200 * (1 + i), 500);
			int speed = rand.nextInt(20) + 1;
			
			System.out.println(speed);
			r[i].setSpeed(speed);
		}
		r0 = new Thread(() -> moveRobots(0));
		r1 = new Thread(() -> moveRobots(1));
		r2 = new Thread(() -> moveRobots(2));
		r3 = new Thread(() -> moveRobots(3));
		r4 = new Thread(() -> moveRobots(4));

		r0.start();
		r1.start();
		r2.start();
		r3.start();
		r4.start();

	}

	static void moveRobots(int id) {
		while (!gameOver) {
			// r[id].move(1000);
			r[id].move(20);

			if (r[id].getY() < finishLine) {
				r0.interrupt();
				r1.interrupt();
				r2.interrupt();
				r3.interrupt();
				r4.interrupt();
				if (!gameOver) {
					gameOver = true;

					JOptionPane.showMessageDialog(null, "Robot " + id + " wins");

				}
			}
		}
	}
}

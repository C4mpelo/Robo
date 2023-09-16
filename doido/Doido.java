package doido;
import robocode.*;
import java.awt.Color;

/**
 * MyClass - doido (Campelo)
 */
public class Doido extends Robot {
	public void run() {
		setColors(Color.black,Color.black,Color.blue,Color.red,Color.white);
		while(true){
			ahead(80);
			turnRight(80);
			turnGunRight(360);
			ahead(80);
			turnLeft(80);
			turnGunRight(360);
			ahead(80);
			turnGunRight(360);
		}
	}
	//tank robô inimigo detectado
	public void onScannedRobot(ScannedRobotEvent e) {
		String robotank = e.getName();
		double distancia = e.getDistance();
		System.out.println(robotank + " distância " + distancia);
		if (distancia < 135) {
			fire(3);
		} else {
			fire(1);
		}
	}
	//colisão com a parede
	public void onHitWall(HitWallEvent e) {
		back(50);
		turnRight(90);
	}
	public void onHitByBullet(HitByBulletEvent e) {
        // Quando é atingido por uma bala inimiga
        turnLeft(90 - e.getBearing()); // Vira para a direção da bala
    }
}

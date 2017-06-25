package component.bird;

import com.badlogic.gdx.math.Rectangle;

import component.bullet.Bullet;
import component.bullet.CannonBulletR;
import component.bullet.SilverBulletR;

public class SilverBirdR extends BirdRight {

	public SilverBirdR(int ID, int x, int y) {
		super(ID, x, y);
		System.out.println("creo de el clasico de la derecha");
		bounds = new Rectangle(super.position.x, super.position.y, Bird.WIDTH, Bird.HEIGHT);
	}

	@Override
	public void shoot() {
		Bullet b = new SilverBulletR(position.x, position.y);
		bullets.add(b);			
	}

}
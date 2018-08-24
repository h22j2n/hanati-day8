public class Unit {
	
	private Weapon weapon;
	
	private String name;
	
	public Unit() {}

	public Unit(String name) {
		this.name = name;
	}

	public Weapon getWeapon() {
		return weapon;
	}

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void attack() {
		weapon.attack();
	}
	
	public static void main(String[] args) {
		Unit unit = new Unit("SCV");
		
		Weapon weapon = null;
		
		weapon = new Gun();
		weapon.attack();
		
		
		weapon = new Gun();	
		unit.setWeapon(weapon);
		unit.attack();
		
		weapon = new Sword();
		unit.setWeapon(weapon);
		unit.attack();
	}
	
}

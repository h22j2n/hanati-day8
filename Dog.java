
public class Dog extends Animal {
	
	private boolean loyalty;

	public Dog(String name, int age, boolean loyalty) {
		this.name = name;
		this.age = age;
		this.loyalty = loyalty;
	}
	
	

	public Dog() {
		this(null, 0, false);
	}


	@Override
	public void sleep() {
		System.out.println("강아지가 주무십니다.");
	}

	@Override
	public void eat() {
		System.out.println("강아지가 먹습니다.");
	}
	
	
	public static void main(String[] args) {
		Animal animal = null;
		animal = new Dog("루니",2,false);
		animal.printInfo();
		animal.eat();
		animal.sleep();
	}

}

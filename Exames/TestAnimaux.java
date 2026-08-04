//Questao 9
abstract class Animal {
	abstract public void faireSon() {
	}
}

class Chien extends Animal {
	@Override
	public void faireSon() {
		System.out.println("Chien -> Wouf");
	}
}

class Chat extends Animal {
	@Override
	public void faireSon() {
		System.out.println("Chat -> Miaou");
	}
}

class Vache extends Animal {
	@Override
	public void faireSon() {
		System.out.println("Vache -> Meuh");
	}
}

public class TestAnimaux {
	public static void main(String[] args) {
		String Animal[] = {"Chien", "Chat", "Vache"};
		Animal a = new Animal();
		for (int i = 0; i < Animal.length(); i++) {
			if (Animal[i] == "Chien") {Chien a = new Chien();}
			else if (Animal[i] == "Chat") {Chien a = new Chat();}
			else {Vache a = new Vache();}
			a.faireSon();
		}		
	}
}

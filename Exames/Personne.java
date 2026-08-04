//Questao 8
public class Personne {
	private String nom;
	private int age;
	
	public Personne(String nom, int age) {
		this.nom = nom;
		this.age = age;
	}
	
	public void sePresenter() {
		System.out.println("Bonjour, je m'appelle " + nom);
		System.out.println("J'ai " + age + " ans.");
	}
	
	public static void main(String[] args) {
		Etudiant e = new Etudiant("Alice", 22, "informatique");
		e.sePresenter();
	}
}

class Etudiant extends Personne {
	private String programme;
	
	public Etudiant(String nom, int age, String programme) {
		super(nom, age);
		this.programme = programme;
	}
	
	@Override
	public void sePresenter() {
		super.sePresenter();
		System.out.println("Je suis étudiante en " + programme + ".");
	}
	
}

//Questao 7
public class Livre {
	private String titre;
	private String auteur;
	private int nombrePages;
	
	public Livre(String titre, String auteur, int nombrePages) {
		this.titre = titre;
		this.auteur = auteur;
		this.nombrePages = nombrePages;
	}
	
	public String getTitre() {
		return this.titre;
	}
	
	public String getAuteur() {
		return this.auteur;
	}
	
	public int getNombrePages() {
		return this.nombrePages;
	}
	
	public void setTitre(String titre) {
		this.titre = titre;
	}
	
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	
	public void setNombrePages(int nombrePages) {
		this.nombrePages = nombrePages;
	}
	
	public void afficherInformations() {
		System.out.println("Livre.....: " + titre);
		System.out.println("Auteur....: " + auteur);
		System.out.println("Nb. Pages.: " + nombrePages);
	}
	
	public static void main(String[] args) {
		Livre lv1 = new Livre("Devoradores de Estrelas", "Andy Weir", 512);
		Livre lv2 = new Livre("O Exorcista", "Wiliam Blatty", 336);
		lv1.afficherInformations();
		System.out.println("================================================");
		lv2.afficherInformations();
	}
}

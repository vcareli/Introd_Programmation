//questao 1 e 2
import java.util.*;

public class Produit {
	private String produit;
	private double prix;
	private int quantite;
	
	public Produit(String produit, double prix, int quantite) {
		this.produit = produit;
		this.prix = prix;
		this.quantite = quantite;
	}
	
	public String getProduit() {return this.produit;}
	
	public double getPrix() {return this.prix;}

	public int getQuantite() {return this.quantite;}
	
	public void appliquerRabais(double percent) {
		this.prix = (1 - percent) * this.prix;
	}
	
	public static void main(String[] args) {
		List<Produit> liste = new ArrayList<>();
		Magazin loja = new Magazin();
		liste.add(new Produit("Voiture", 100.00, 5));
		liste.add(new Produit("Maison", 8000.00, 2));
		System.out.println("-------------Liste-Prod--------");
		for (Produit p : liste) {
			System.out.println("Produit : " + p.getProduit() + " Prix : " + p.getPrix());
			if (p.getProduit().equals("Maison")) {
				p.appliquerRabais(0.1);
				System.out.println("-------------Liste rabais-----");
				System.out.println("Produit : " + p.getProduit() + " Prix (rabais) : " + p.getPrix());
			}
		}
		loja.ajouterProduit(new Produit("Bike", 10.5, 0));
		loja.ajouterProduit(new Produit("Velo", 12, 2));
		
		System.out.println("-----Liste Loja------------");
		for (Produit p : loja.getProduit()) {
			System.out.println("Produit : " + p.getProduit() + " Prix : " + p.getPrix());
		}
		System.out.println("-----Produit en rupture-------");
		loja.afficherProduitsEnRupture();
	}
}

class Magazin {
	private List<Produit> l = new ArrayList<>();
			
	public void ajouterProduit(Produit p) {
		this.l.add(p);
	}
	
	public List<Produit> getProduit() {
		return this.l;
	}
	
	public void afficherProduitsEnRupture() {
		for (Produit p : this.l) {
			if (p.getQuantite() == 0) {
				System.out.println("Produit : " + p.getProduit() + " Quant : " + p.getQuantite());
			}
		}
	}
}

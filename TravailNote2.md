## Travail noté 2 – INF 1220
Nom...............: *Vieira Careli*

Prénom............: *Vinicius*

Numéro d'étudiant.: *26147256*

Date de remise....: *08/juin/2026*


### Question 1

#### Analyse préliminaire  

Le problème principal concerne la création d'une classe Cercle qui est capable de calculer et retourner l'aire et le périmètre du cercle. En outre, la classe Cercle doit avoir un constructeur et en même temps gérer les problèmes de rayon égal ou inférieur à zéro.
Pour le calcul de l'aire et du périmètre, on utilise les formules mathématiques (A = PI * r²) et (*P = 2 * PI * r*).

#### Code source (copiable)

Votre code source doit être aussi simple que possible, et il doit apparaître de façon lisible dans votre document.
https://lemire.github.io/inf1220-hugo/docs/environnement/?shortjavacode=91be25c3-5044-476d-9c81-2b539061d41e

```java
public class Cercle{
	/*	Private - pour proteger la constant PI et empecher les modifications
		Static - constant PI appartient justa a cette classe
		final - Pour garantir la l'immuabilite de la constante PI
	*/
	private static final double PI = 3.1416;
	private double rayon;	//S'assurer que le rayon soit modifié juste par le constructor

	public Cercle(double rayon){
		this.rayon = (rayon <= 0) ? 0 : rayon;
	}

	public double aire(){
		return this.rayon * this.rayon * PI;
	}

	public double perimetre(){
		return 2 * this.rayon * PI;
	}
}
```

#### Sortie du programme  

```
Aire du cercle de rayon 1: 3.1416
Périmètre du cercle de rayon 1: 6.2832
Aire du cercle de rayon 0: 0.0
Périmètre du cercle de rayon 0: 0.0
```

#### Description du programme

Dans la classe Cercle, j'ai créé une variable PI pour tous les calculs dans cette classe. Cette variable a des attributs : PRIVATE pour protéger la variable et empêcher les modifications ; STATIC pour montrer qu'elle appartient juste à cette classe ; FINAL qui sert à attribuer la condition d'immuabilité de la variable (constante).
La variable rayon, que l'on utilise dans la classe Cercle, a reçu le modificateur PRIVATE, afin de protéger et d'empêcher n'importe quelle modification du rayon ; la seule modification permise est celle faite par la méthode du constructeur.
En premier, j'ai fait le constructeur qui retourne le rayon égal à zéro si on reçoit une valeur inappropriée. Pour cela, j'utilise la structure conditionnelle ternaire, où le this.rayon est égal à 0 ou à la valeur donnée selon le paramètre envoyé.
Ensuite, la fonction aire doit retourner la valeur selon la formule de l'aire d'un cercle : PI * rayon². Et finalement, la fonction périmètre, qui retourne la valeur correspondant à *2 * PI * rayon*.

### Question 2

La question suivante concerne l'utilisation de la norme IEEE 754. D'habitude, Java arrondit les chiffres du type double ou à virgule flottante qui auraient plus de 15 décimales ; c'est un problème de précision. Mais il y a une méthode pour afficher un nombre avec plus de 15 décimales, en utilisant une bibliothèque Math qui s'appelle BigDecimal.

### Question 3

#### Analyse préliminaire  

Selon le code, la valeur de 'a' est 3, car la variable a reçoit la valeur de 'i' avant l'incrément, et après la variable 'i' subit l'incrémentation.

```java
int i = 3;
int a = i++;
```

Si la variable 'a' recevait ++i, alors la valeur de 'a' serait 4. Comme le code :

```java
int i = 3;
int a = ++i;
```

### Question 4

#### Analyse préliminaire  

```java
public class TestMethode {
    public static void test(String test) {
        test = test+test;
    }

    public static void main(String[] args) {
        String chaine ="test";
        test(chaine);
        System.out.println(chaine);
    }
}
```
Dans le code ci-dessus, le résultat du println est juste le contenu de la variable chaine, c'est-à-dire juste le mot 'test'. La ligne println affiche le contenu de la variable chaine ; elle cherche l'adresse mémoire de la variable et affiche la valeur écrite à cet endroit. La méthode test(String test) a un paramètre qui s'appelle test : il s'agit d'une variable avec le même nom, mais elle est liée à une adresse mémoire différente de celle de la variable chaine. Donc la méthode test() n'a pas de retour, elle modifie juste le contenu de sa propre variable.

### Question 5

#### Analyse préliminaire  

Le valeur de la variable 'entier' après l'éxecution du code est égale à 10, parce que le valeur est contiditionel aux variables logiques 'a' et 'b'. Les opérateurs logiques ici, sont: !(Inverser le valeur logique); && (AND); | (OR).
Si la a est false et b est false. Le signe !a inverse le valeur de a.
Donc, la proposition logique (!a && (b | !a)) est égale (vraie AND (false OR vraie)), la resolution est:

(vraie AND (false OR vraie))
(vraie AND (vraie))
vraie

Toutefois, comme l'expréssion est vraie, la variable 'entier' reçoit le valeur 10.

```java
boolean a = false;
boolean b = false;
int entier = (!a && (b | !a)) ? 10 : 20;
```

### Question 6

#### Analyse préliminaire  

Dans le premier exemple Bonhomme, la variable nom a le modificateur static, et le mot clé static est un modificateur qui dit qu'une variable appartient à une classe et que tous les objets utilisent la même variable. Java crée une seule copie dans la mémoire. Toutes les modifications faites dans cette variable sont ajustées pour tous les objets qui l'utilisent. Voici un exemple:

```java
public class Comptoir {
	// Variable a le modificateur static.
	static int totalObjects = 0;
	
	Comptoir() {
		totalObjects++;	// Compte les objects
    }

	public static void afficherTotal() {
		System.out.println("Total des objects: " + totalObjects);
	}

    public static void main(String[] args) {
        Comptoir c1 = new Comptoir();
		Comptoir c2 = new Comptoir();
		Comptoir c3 = new Comptoir();
		Comptoir.afficherTotal();	// Affiche le total des objects
    }
}

```

Le deuxième exemple Bonhomme n'a pas le modificateur static, donc la variable appartient juste à un objet. Java crée une copie pour chaque objet qui l'utilise. Donc si un objet modifie la variable, elle sera changée juste pour cet objet. Ensuite un autre exemple de variable sans le modificateur *static*:

```java
public class CompteBanque {
   //Chaque personne a son propre solde
    double solde;

    CompteBanque(double solde) {
        this.solde = solde;
	}

    public static void main(String[] args) {
        // Création de deux comptes distincts
        CompteBanque compteAna = new CompteBanque(1000.0);
        CompteBanque compteBob = new CompteBanque(500.0);
        // Modification du solde bancaire d'Ana
        compteAna.saldo = 1200.0;
        System.out.println("Saldo da Ana: R$ " + compteAna.solde); // Affiche: 1200.0
        System.out.println("Saldo do Bob: R$ " + compteBob.solde); // Affiche: 500.0
    }
}
```


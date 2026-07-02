## Travail noté 3 – INF 1220
Nom...............: *Vieira Careli*

Prénom............: *Vinicius*

Numéro d'étudiant.: *26147256*

Date de remise....: *30/juin/2026*


### Question 1

#### Analyse préliminaire  

Le présent problème consiste à déterminer la somme de tous les nombres entiers compris entre 1 et 10 000, à l'exception, d'une part, de ceux qui sont divisibles par trois, et, d'autre part, de ceux dont le chiffre des centaines est égal à 2 ou à 3.

Dans un premier temps, on exclut l'ensemble des multiples de 3, c'est-à-dire tous les nombres pour lesquels le reste de la division euclidienne par trois est nul. Par la suite, parmi les nombres restants, on élimine également ceux qui possèdent le chiffre 2 ou le chiffre 3 à la position des centaines.

#### Code source (copiable)

Link pour partager: https://lemire.github.io/inf1220-hugo/docs/environnement/?shortjavacode=cda6a247-8f4c-4a3c-be41-4e855b56d2c0

```java
public class Somme1a10000 {
	public static void main(String[] args) {
		/*
		 * La méthode main doit être créée avec les modificateurs suivants
		 * public : permet à la classe d'accéder à la méthode main
		 * static: ne permet pas les modifications et oblige Java à l'exécuter avant toutes les autres méthodes
		**/
		int somme = 0;
		
		for (int i = 1; i <= 10000; i++) {
			//if pour supprimer les numeros divisibles par 3 (i%3 != 0)
			//et aussi les numeros 2 ou 3 dans les centaines
			//(i/100)%2 -> permet de visualiser les chiffres de centaines.			
			if ((i % 3 != 0) && ((i/100)%10 != 2) && ((i/100)%10 != 3)) {
				somme += i;
			}
		}
		System.out.println("Somme des nombres de 1 à 10 000 :");
		System.out.println("à l'exclusion des nombres divisibles par 3 et");
		System.out.println("des nombres dont le chiffre des centaines est 2 ou 3");
		System.out.println("Somme est: " + somme);
	}
}
```

#### Sortie du programme  

```
Somme des nombres de 1 à 10 000 :
à l'exclusion des nombres divisibles par 3 et
des nombres dont le chiffre des centaines est 2 ou 3
Somme est: 26937467
```

#### Description du programme

Dans un premier temps, le programme procède à l'examen de chaque nombre afin de déterminer s'il n'est pas divisible par trois. Pour ce faire, on utilise une structure conditionnelle fondée sur l'opérateur module: la condition (i % 3 != 0) permet de retenir uniquement les nombres dont la division par trois donne un reste non nul, écartant ainsi tous les multiples de trois.

Ensuite, afin d'exclure les nombres comportant le chiffre 2 ou le chiffre 3 à la position des centaines, j'ai envisagé une méthode permettant d'isoler ce chiffre spécifique. Pour accéder au chiffre des centaines, il suffit de diviser le nombre par 100, puis d'obtenir le reste de cette division par 10, ce qui correspond à l'opération ((n / 100) % 10). Cette technique permet de comparer aisément le chiffre des centaines: s'il est égal à 2 ou à 3, le nombre est alors exclu du calcul de la somme.

Enfin, on fait appel à l'opérateur logique ET (&&) afin de prendre en compte simultanément l'ensemble des critères d'exclusion. Ainsi, pour qu'un nombre soit intégré dans la somme finale, il doit satisfaire cumulativement les trois conditions suivantes: ne pas être divisible par trois, ne pas avoir le chiffre 2 comme chiffre des centaines, et ne pas avoir le chiffre 3 comme chiffre des centaines.

Et enfin, la dernière ligne: le programme affiche le résultat. Ce résultat est une variable de type int, et dans ce cas, l'utilisation de ce type est permise car la variable int est un type primitif qui stocke des nombres entiers, occupe 32 bits en mémoire et couvre les valeurs comprises entre -2.147.483.648 et 2.147.483.647. Or, la somme de 1 à 10000 est égale à 50.005.000, ce qui reste bien dans cette plage. Il n'est donc pas nécessaire d'utiliser d'autres types de variables plus longs.

### Question 2

#### Analyse préliminaire  

Cette application a pour objectif de générer et d’afficher toutes les chaînes de caractères de longueur 4 composées à partir des lettres a, b, c et d. Les combinaisons peuvent être dans n’importe quel ordre et un même caractère peut être utilisé plusieurs fois, à condition de respecter les règles suivantes :

1. Les chaînes doivent être affichées dans l’ordre lexicographique;
2. Le caractère b doit toujours être immédiatement suivi de la lettre a;
3. Les caractères d et a ne doivent jamais apparaître ensemble dans une même chaîne;
4. Le programme ne reçoit aucune donnée en entrée;
5. À la fin de l’exécution, le programme doit afficher le nombre total de chaînes valides affichées.

Pour répondre à ces contraintes, il est nécessaire de concevoir un algorithme capable de construire toutes les combinaisons possibles de quatre caractères, puis de filtrer celles qui ne respectent pas les règles énoncées. En parallèle, une variable de type entier sera utilisée pour compter le nombre de chaînes répondant aux critères établis.

#### Code source (copiable)

Link pour partager: https://lemire.github.io/inf1220-hugo/docs/environnement/?shortjavacode=33e39ce8-71cf-4811-af75-ef5914b31b69

```java
//Chaines abcd
public class Question2 {
	public static void main(String[] args) {
		//Variable char pour stoker les lettres
		char[] list_char = {'a', 'b', 'c', 'd'};
		//Variable pour compter les chaînes
		int mots = 0;

		//Boubles pour definir l'ordre lexicographique
		for(int i = 0; i < list_char.length; i++) {
			for(int j = 0; j < list_char.length; j++) {
				for(int k = 0; k < list_char.length; k++) {
					for(int w = 0; w < list_char.length; w++) {
						//Constructeur String de lettres
						String s = Character.toString(list_char[i]) + Character.toString(list_char[j])
								+ Character.toString(list_char[k]) + Character.toString(list_char[w]);
						//Regle: 'b' toujours suivi par 'a' (Jamais un 'b' sans 'ba')
						boolean ba 			= !(s.contains("b") && !s.contains("ba"));
						//Regle: Jamais un 'a' et un 'd' dans le même chaîne
						boolean not_ad	 	= !(s.contains("a") && s.contains("d"));
						//Regle: Jamais un 'b' et un 'd' dans le même chaîne, par que 'b' est toujours suivi par 'a'
						boolean not_bd		= !(s.contains("b") && s.contains("d"));
						//Jamais finir par un 'b', par que 'b' est toujours suivi par 'a'
						boolean not_end_b	= !s.endsWith("b");

						if (ba && not_end_b && not_ad && not_bd){
							System.out.println(s);
							//Compter juste les chaînes valides
							mots++;
						}
					}
				}
			}
		}

		System.out.println("Total Chaines: " + mots);
	}
}
```

#### Sortie du programme  

```
aaaa
aaac
aaba
aaca
aacc
abaa
abac
abba
acaa
acac
acba
acca
accc
baaa
baac
baba
babc
baca
bacc
bbaa
bbac
bbba
bcba
caaa
caac
caba
caca
cacc
cbaa
cbac
cbba
ccaa
ccac
ccba
ccca
cccc
cccd
ccdc
ccdd
cdcc
cdcd
cddc
cddd
dccc
dccd
dcdc
dcdd
ddcc
ddcd
dddc
dddd
Total Chaines: 51
```

#### Description du programme

Le programme commence par la déclaration d'une variable nommée list_char, qui est un tableau unidimensionnel permettant de stocker les lettres requises par l'exercice. Ce tableau est de type char, car il contient uniquement les caractères a, b, c et d, utilisés pour construire les chaînes conformément aux règles établies.
Une deuxième variable, mots, est également déclarée ; elle a pour rôle de compter le nombre de chaînes valides. Cette valeur sera affichée à la fin de l'exécution.
Les lignes suivantes correspondent à des boucles imbriquées, construites de manière à respecter l'ordre lexicographique. À l'intérieur de ces boucles, une variable s, de type String, est chargée de générer toutes les combinaisons possibles de quatre caractères.
Pour appliquer les règles définies, quatre variables de type booléen sont utilisées. Chacune d'elles vérifie un point essentiel dans la construction des chaînes:
1. La première, nommée ba, est définie par (!(s.contains("b") && !s.contains("ba"))). Elle garantit que la chaîne ne contient jamais la lettre b sans être suivie immédiatement de la lettre a;
2. La deuxième variable, not_ad, est exprimée par (!(s.contains("a") && s.contains("d"))). Elle assure qu'une chaîne ne contient jamais à la fois les lettres a et d;
3. Une troisième variable, également nommée not_ad dans le code initial (mais qui devrait porter un nom distinct pour plus de clarté), sert à vérifier que les lettres b et d ne sont pas présentes ensemble. Cette règle découle de la contrainte précédente : puisque b doit toujours être suivi de a, et que a ne peut pas coexister avec d, il en résulte que b et d sont incompatibles;
4. Enfin, une dernière variable booléenne, not_end_b, est définie par (!s.endsWith("b")). Elle interdit que la lettre b se trouve en dernière position d'une chaîne.

Une fois toutes ces conditions vérifiées, la chaîne est affichée et le compteur mots est incrémenté de 1 pour chaque chaîne valide. En fin de programme, le nombre total de chaînes, que répondant aux critères, est affiché.

### Question-boni

#### Analyse préliminaire  

Pour l'implémentation d'une grille de Sudoku, le code doit conserver, dans une variable de type int[9][9], les chiffres de 1 à 9. Il est toutefois impératif de respecter la règle fondamentale du Sudoku, qui interdit la répétition d'un même nombre dans une ligne ou dans une colonne. Afin que toutes les méthodes puissent accéder à cette variable, le tableau est déclaré avec le modificateur public, car toutes les méthodes seront amenées à y accéder pour le lire ou modifier — par exemple, la méthode nettoyer, qui remplace intégralement une ligne; ou les méthodes valider et afficher, qui se contentent de lire le tableau. En outre, on trouve la méthode creer_matrix, dont la fonction est de remplir le tableau.
Dans cet exercice on ne respect pas le consigne traditionel du Sudoku que est empêcher d'avoir répetition des chiffres dans une même sub-grille (3x3). Cet consigne est plus difficile a régler.

#### Code source (copiable)

Link pour partager: https://lemire.github.io/inf1220-hugo/docs/environnement/?shortjavacode=5dafd979-60d2-4e70-a898-bb09de1f2bd7

```java
import java.util.Random;

public class Sudoku {
	//Un tableau int[9][9] public
	//accessible à toutes les méthodes de ma classe Sudoku.
	public int[][] matriz = new int[9][9];

	void nettoyer(int l) { //Méthode pour nettoyer un ligne lorsque un chiffre est répété
		for (int j = 0; j < matriz.length; j++) {
			matriz[l][j] = 0;	//0 a toute la ligne pour recommencer le boucle
		}
	}

	boolean valider(int l, int c, int n) { //Méthode pour valider s'il y a des chiffres répété
		for (int i = 0; i < matriz.length; i++) {
		//Le 1er for va explorer la ligne pour chercher des chiffres répétés
			if ((matriz[l][i] == n))
				return false;
		}
		for (int j = 0; j < matriz.length; j++) {
		//Le 2eme for va explorer la colonne pour chercher des chiffres répétés.
			if ((matriz[j][c] == n))
				return false;
		}
		return true;
	}

	void creer_matrix() {	//Méthode pour créér le tableau
		Random pere = new Random();
		int n;
		int limit;	//limiter le temps pour valider une ligne ou colonne

		for (int i = 0; i < matriz.length; i++) {	//Les deux boucles pour explorer le tableau
			for (int j = 0; j < matriz.length; j++) {
				limit = 0;
				n = pere.nextInt(9) + 1;	//Reçoit un numero aléatoire de 1 a 9
				while (!valider(i, j, n)) {	//valide dans la rangée et la colonne auxquelles elle appartient.
					n = pere.nextInt(9) + 1;
					limit++;
					if (limit > 200)	//Si cela prend trop de temps pour valider, sors de la boucle while.
						break;
				}
				if (limit < 200)
					matriz[i][j] = n;	//stocker le nombre dans le tableau
				else{
					nettoyer(i);	//Mettre dans la rangée et recommence la ligne
					j = -1;
				}
			}
		}
	}

	void afficher() {	//Méthode pour afficher le tableau
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++) {
				System.out.print(matriz[i][j] + " ");
				if (j == 2 || j == 5)
					System.out.print(" | ");
			}
			System.out.println();
			if (i == 2 || i == 5)
				System.out.println("_______________________");
		}
	}

	public static void main(String[] args) {
		//Main et appel des méthodes
		Sudoku matrix = new Sudoku();
		matrix.creer_matrix();
		matrix.afficher();
	}
}

```

#### Sortie du programme  

```java
5 8 4  | 7 9 1  | 3 2 6 
9 4 2  | 3 8 7  | 1 6 5 
2 6 7  | 5 4 9  | 8 1 3 
_______________________
3 2 9  | 4 7 5  | 6 8 1 
6 5 3  | 1 2 4  | 7 9 8 
7 1 6  | 9 5 8  | 2 3 4 
_______________________
8 7 1  | 6 3 2  | 4 5 9 
1 9 8  | 2 6 3  | 5 4 7 
4 3 5  | 8 1 6  | 9 7 2 
```

#### Description du programme

Le code est divisé en quatre méthodes, à savoir :

1. void creer_matrix() : méthode qui ne retourne aucune valeur et qui est chargée de remplir la variable matrice[9][9] avec les chiffres de 1 à 9.
2. boolean valider(int l, int c, int n) : cette méthode prend trois paramètres — int l pour indiquer la ligne, int c pour la colonne et int n pour le chiffre à valider, afin de déterminer si ce nombre peut occuper la position donnée.
3. void nettoyer(int l) : méthode ne retournant rien et servant à mettre à zéro une ligne désignée par le paramètre int l.
4. void afficher() : méthode de type void, simplement destinée à afficher le tableau déjà rempli par la méthode creer_matrix.

Dans la méthode creer_matrix, on utilise deux boucles pour parcourir le tableau, ainsi que la méthode random pour générer aléatoirement le nombre qui viendra remplir l'array. Ensuite, on valide ce chiffre afin de vérifier s'il n'y a pas de répétition dans la ligne ou la colonne concernée. Dans une boucle while, l'algorithme sélectionne un autre chiffre si la méthode valider retourne false; et pour limiter le nombre de tentatives et ainsi accélérer l'exécution, une variable limit est employée pour restreindre ces essais. S'il s'agit d'un nombre valide, le code stocke ce chiffre dans le tableau; dans le cas contraire, il fait appel à la méthode nettoyer pour remplacer intégralement la ligne par des zéros, puis revient au début de la boucle for, en réinitialisant la variable j à -1. Le processus recommence alors à remplir la ligne entière jusqu'à l'obtention d'une ligne et d'une colonne parfaites. La dernière étape consiste à invoquer la méthode afficher pour achever le programme.
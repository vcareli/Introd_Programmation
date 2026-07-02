public class Bonhomme {
	public static String nom;
	//public String nom;
	public static void Bonhomme(String n) {
		n = "test";
		nom = n;
	}
	public static void main(String[] args) {
		//Bonhomme("test");
		Bonhomme("XXX");
		System.out.println(nom);
	}
}


/*public class Exemplo{
	public static void test(String test){
        test = test+test;
        //test = test;
    } 
    
    public static void main(String[] args){
        
        String chaine ="test";
        
        test(chaine);
        
        System.out.println(chaine);

    }
    
}
*/

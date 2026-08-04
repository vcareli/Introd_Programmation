public class Gatin {
    public static void main(String[] args){
        int[] var = {1, 2, 3, 4, 5};
        boolean c = true;
        for (int e : var) {
        	if (!c) System.out.print(" - ");
            System.out.print(e);
            c = false;
        }
    }
}

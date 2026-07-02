//Exerc28
import java.util.Stack;

public class Exerc28 {
    static void main(String[] args) {
        //Declara variavel
        Stack<Integer> pilha = new Stack<>();
        //Adiciona
        pilha.push(9);
        pilha.push(97);
        pilha.push(1);
        pilha.push(56);
        //Puxa dados
        //System.out.println(pilha.pop());
       System.out.println("dernier: " + pilha.peek());
        while (!pilha.isEmpty()){
            System.out.println(pilha.pop());
        }
    }
}

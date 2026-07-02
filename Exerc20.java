//Exerc20
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Collectors;

class Exerc20 {
    void main() {
        List<String> paresLexicograficos = IntStream.rangeClosed(0, 1000)
            .filter(n -> n % 2 == 0)
            .mapToObj(String::valueOf)
            .sorted()
            .collect(Collectors.toList());
        //System.out.println(paresLexicograficos);
        paresLexicograficos.stream().limit(10).forEach(System.out::println);
    }
}

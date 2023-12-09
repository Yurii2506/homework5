import java.util.List;
import java.util.stream.Collectors;

public class Cago2 {
    public static List<String> textProcessor(List<String> strings) {
        return strings.stream()
                .map(String::toUpperCase)
                .sorted((s1, s2) -> s2.compareTo(s1))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<String> strings = List.of("William", "Polina", "Olivia", "Liam", "Ava");

        List<String> res = textProcessor(strings);

        System.out.println(res);
    }
}
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Kawasaki1 {
    public static String NameFormatter(List<String> names) {
        return IntStream.range(0, names.size())
                .filter(i -> i % 2 == 0)
                .mapToObj(i -> (i + 1) + ". " + names.get(i))
                .collect(Collectors.joining(", "));
    }

    public static void main(String[] args) {
        List<String> names = List.of("William", "Polina", "Olivia", "Liam", "Ava");

        String result = NameFormatter(names);

        System.out.println(result);
    }
}
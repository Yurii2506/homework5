import java.util.Arrays;
import java.util.stream.Collectors;

public class Krico3 {
    public static String manipulateArray(String[] array) {
        return Arrays.stream(array)
                .flatMap(s -> Arrays.stream(s.split(", ")))
                .map(Integer::parseInt)
                .sorted()
                .map(Object::toString)
                .collect(Collectors.joining(", "));
    }
    public static void main(String[] args) {
        String[] array = {"10, 3, 0", "5, 87"};

        String res = manipulateArray(array);

        System.out.println(res);
    }
}
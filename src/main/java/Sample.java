import java.util.List;
import java.util.stream.Stream;

public class Sample {
    public static void main(String[] args) {
        System.out.println("hello world!!");
        List.of("ravi", "pintu").forEach(System.out::println);
        Stream.
                iterate(10, e -> e > 5, e -> e - 1).
                forEach(System.out::println);

        System.out.println("is Prime 11 " + isPrime(11));
        System.out.println("is Prime 18 " + isPrime(18));
        System.out.println("is Prime 2 " + isPrime(2));
        var name = "ravi";
        name = "ravi";
        System.out.println(name);
    }


    public static  boolean isPrime(int n){
       /* boolean result = true;
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                result = false;
                break;
            }
        }
        return result;*/
        return Stream.iterate(2, e -> e < n, e -> e + 1)
                .noneMatch(e -> n % e == 0);
    }
}




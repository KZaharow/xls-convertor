import ru.xls.convertor.Convertor;

public class Starter {

    public static void main(String[] args) {
        int[] arr = {};
        for (int i : arr) {
            System.out.println(i + ":" + Convertor.getResult(i));
        }
    }
}

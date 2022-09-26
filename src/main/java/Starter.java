import ru.xls.convertor.Convertor;

public class Starter {

    public static void main(String[] args) {
        int[] arr = {27, 150, 18279};
        for (int i : arr) {
            System.out.println(i + ":" + Convertor.getResult(i));
        }
    }
}

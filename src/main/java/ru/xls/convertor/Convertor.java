package ru.xls.convertor;

public class Convertor {

    private static final int STEP = 64;
    private static final int MAX = 26;

    public static String getResult(int i) {
        return convert(i, "");
    }

    private static String convert(int i, String s) {
        s = (char) (i % MAX + STEP) + s;
        double result = (double) i / MAX;
        if (Double.compare(result, MAX) > 0) {
            return convert((int) result, s);
        } else {
            return (char) ((int) result + STEP) + s;
        }
    }
}

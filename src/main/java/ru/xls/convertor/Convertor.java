package ru.xls.convertor;

public class Convertor {

    private static final int STEP = 64;
    private static final int MAX = 26;

    public static String getResult(int i) {
        return new StringBuilder(convert(i, ""))
                .reverse()
                .toString();
    }

    private static String convert(int i, String s) {
        s += (char) (i % MAX + STEP);
        double result = (double) i / MAX;
        if (Double.compare(result, MAX) > 0) {
            return convert((int) result, s);
        } else {
            return s + (char) ((int) result + STEP);
        }
    }
}

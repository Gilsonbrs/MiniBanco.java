package dev.itau.utils;

import java.text.NumberFormat;
import java.util.Locale;

public class Utils {
    private static Locale ptBr = new Locale("pt","BR");
    private static String valorString;

    public static String valorDoubleParaString(Double valor){
        valorString = NumberFormat.getCurrencyInstance(ptBr).format(valor);
        return valorString;

    }

}



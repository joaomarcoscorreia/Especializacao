package br.com.joaocorreia.searchcodegithub.util;

/**
 * Created by joaocorreia on 23/10/16.
 */
public class UtilQuery {


    public static String makeQuery(String pSearche, String pLanguage){
        StringBuilder sb = new StringBuilder();
        sb.append(Constantes.QUERY);
        sb.append(Constantes.EQUALS);
        sb.append(pSearche.toLowerCase());
        sb.append(Constantes.PLUS);
        sb.append(Constantes.LANGUAGE);
        sb.append(Constantes.TWODOT);
        sb.append(pLanguage.toLowerCase());
        return sb.toString();  //q=tetris+language:assembly
    }

    public static String makeQueryNoLanguage(String pSearche){
        StringBuilder sb = new StringBuilder();
        sb.append(Constantes.QUERY);
        sb.append(Constantes.EQUALS);
        sb.append(pSearche.toLowerCase());

        return sb.toString();  //q=tetris
    }

}

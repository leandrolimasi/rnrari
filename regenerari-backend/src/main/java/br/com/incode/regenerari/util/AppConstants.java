package br.com.incode.regenerari.util;

/**
 * Created by leandrolimadasilva on 21/05/16.
 *
 * Classe de constantes do App
 *
 */
public interface AppConstants {

    String FRONTEND_URL= "http://localhost:3000/regenerari";
    String ANONIMO= "Anônimo";

    interface  ROLES {
        String VENDEDOR = "VENDEDOR";
        String GERENTE = "GERENTE";
        String ADMIN = "ADMIN";
    }
}

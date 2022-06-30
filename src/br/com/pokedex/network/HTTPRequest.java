package br.com.pokedex.network;

import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.commons.io.IOUtils;

public class HTTPRequest {

    public String requestGetMethod(String stringUrl) {

        try {
            URL url = new URL(stringUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.connect();

            return IOUtils.toString(
                    connection.getInputStream(),
                    "utf-8");


        } catch (Exception e) {
            System.out.println("Algo deu errado, por favor, certifique-se de que o nome do pokemon esta em letras minusculas e escrito corretamente");
        } 
        
        return "";

    }
}

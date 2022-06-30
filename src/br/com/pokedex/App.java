package br.com.pokedex;
import org.json.JSONObject;
import br.com.pokedex.network.HTTPRequest;
import java.util.Scanner;
import org.json.JSONArray;
import br.com.pokedex.asciigen.Img2Ascii;




public class App {

    public static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {

        HTTPRequest chama = new HTTPRequest();

        System.out.println("Por favor, insira o nome do Pokemon que voce deseja saber sobre os atributos!");

        String nomePokemon = input.next();

        JSONObject jason = new JSONObject(chama.requestGetMethod("https://pokeapi.co/api/v2/pokemon/"+nomePokemon));

        //NOME----------------------------------------------------------------------------------------------------------------------------------
        System.out.println("Nome do Pokemon: " + jason.get("name"));

        System.out.println(" ");

        //HABILIDADES---------------------------------------------------------------------------------------------------------------------------
        System.out.println("Habilidades do " + jason.get("name") + ": ");

        for(int i=0; i<jason.getJSONArray("abilities").length(); i++){
            System.out.println(jason.getJSONArray("abilities").getJSONObject(i) .getJSONObject("ability") .get("name"));
        }

        System.out.println(" ");

        //TIPOS-----------------------------------------------------------------------------------------------------------------------------------
        System.out.println("Tipo do " + jason.get("name") + ": ");

        for(int i=0; i<jason.getJSONArray("types").length(); i++){
            System.out.println(jason.getJSONArray("types").getJSONObject(i) .getJSONObject("type") .get("name"));
        }

        System.out.println(" ");

        //STATUS-----------------------------------------------------------------------------------------------------------------------------------
        System.out.println("Status do " + jason.get("name") + ": ");

        for(int i=0; i<jason.getJSONArray("stats").length(); i++){
            System.out.println(jason.getJSONArray("stats").getJSONObject(i).getJSONObject("stat").get("name")+ ": "+jason.getJSONArray("stats").getJSONObject(i).get("base_stat"));
        }

        System.out.println(" ");

        //MOVIMENTOS-----------------------------------------------------------------------------------------------------------------------------------

        System.out.println("Movimentos do " + jason.get("name") + ": ");

        for(int i=0; i<jason.getJSONArray("moves").length(); i++){
            System.out.println(jason.getJSONArray("moves").getJSONObject(i).getJSONObject("move").get("name"));
        }

        System.out.println(" ");

        //IMAGEM-----------------------------------------------------------------------------------------------------------------------------------

        System.out.println("Imagem do " + jason.get("name") + ": ");

        Img2Ascii imagem = new Img2Ascii();
        imagem.convertToAscii(jason.getJSONObject("sprites").getString("front_default"));

        System.out.println(" ");

    }
}

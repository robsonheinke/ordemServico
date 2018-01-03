package heinke.hsmontagens.model;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import heinke.hsmontagens.view.PrimeiroAcesso;

/**
 * Created by heinke on 08/11/17.
 */

public class Ferramentas extends AppCompatActivity {

    public void novaTela(int tela, Context context){
        Intent intent = null;

        switch (tela){
            case 2: //primeiro acesso
                intent = new Intent(context, PrimeiroAcesso.class);
                break;
            case 3: //cadastro usuario
                break;
        }
        startActivity(intent);
    }

    public String removerAcentos(String string) {
        char[] a = string.toCharArray();

        for (int i = 0; i < string.length(); i++) {
            switch (a[i]) {
                case 'á':
                case 'à':
                case 'ã':
                case 'â':
                case 'ä':
                    a[i] = 'a';
                    break;
                case 'Á':
                case 'À':
                case 'Ã':
                case 'Â':
                case 'Ä':
                    a[i] = 'A';
                    break;
                case 'é':
                case 'è':
                case 'ẽ':
                case 'ê':
                case 'ë':
                    a[i] = 'e';
                    break;
                case 'É':
                case 'È':
                case 'Ẽ':
                case 'Ê':
                case 'Ë':
                    a[i] = 'E';
                    break;
                case 'í':
                case 'ì':
                case 'ĩ':
                case 'î':
                case 'ï':
                    a[i] = 'i';
                    break;
                case 'Í':
                case 'Ì':
                case 'Ĩ':
                case 'Î':
                case 'Ï':
                    a[i] = 'I';
                    break;
                case 'ó':
                case 'ò':
                case 'õ':
                case 'ô':
                case 'ö':
                    a[i] = 'o';
                    break;
                case 'Ó':
                case 'Ò':
                case 'Õ':
                case 'Ô':
                case 'Ö':
                    a[i] = 'O';
                    break;
                case 'ú':
                case 'ù':
                case 'ũ':
                case 'û':
                case 'ü':
                    a[i] = 'u';
                    break;
                case 'Ú':
                case 'Ù':
                case 'Ũ':
                case 'Û':
                case 'Ü':
                    a[i] = 'U';
                    break;
            }
        }
        return new String(a);
    }

    public String colocarPrimeiraLetraMaiuscula(String string) {
        String aux = "";

        for (String s : string.toLowerCase().split(" ")) {
            if (s.length() > 2) {
                aux += s.substring(0, 1).toUpperCase() + s.substring(1);
                aux += " ";
            } else {
                aux += s;
                aux += " ";
            }
        }
        aux = aux.substring(0, aux.length() - 1);
        return aux;
    }
}

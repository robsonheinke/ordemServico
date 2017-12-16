package heinke.hsmontagens.view.controller;

import heinke.hsmontagens.view.model.Usuario;

/**
 * Created by heinke on 10/11/17.
 */

public class ControleUsuario {
    public Boolean setNome(String nome, Usuario usuario){
        int i, cont = 0;
        for(i = 0; i < nome.length();i++){
            if(nome.charAt(i) == ' '){
                cont ++;
            }
        }
        if(cont > 0){
            usuario.setNome(nome);
            return true;
        }
        else{
            return false;
        }
    }
}

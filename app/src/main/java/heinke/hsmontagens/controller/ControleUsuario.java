package heinke.hsmontagens.controller;

import android.content.Context;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

import heinke.hsmontagens.model.Database_SQLite;
import heinke.hsmontagens.model.Ferramentas;
import heinke.hsmontagens.model.Usuario;

/**
 * Created by heinke on 10/11/17.
 */

public class ControleUsuario extends Ferramentas {
    public Boolean setNome(String nome, Usuario usuario) {
        int i, cont = 0;

        if (nome.length() < 3) {
            return false;
        } else {
            for (i = 0; i < nome.length(); i++) {
                if (nome.charAt(i) == ' ') {
                    cont++;
                }
            }
        }

        if (cont > 0) {
            usuario.setNome(nome);
            return true;
        } else {
            return false;
        }
    }

    public Boolean setCidade(String cidade, String uf, Usuario usuario, Context context) {
        Database_SQLite db = new Database_SQLite(context);
        cidade = colocarPrimeiraLetraMaiuscula(cidade);
        cidade = removerAcentos(cidade);

        if(db.verificaCidade(cidade,uf)){
            usuario.setEndereco(cidade + " - " + uf);
            return true;
        }
        else{
            return false;
        }
    }

    public Boolean setUf(String uf, Usuario usuario, Context context) {
        Database_SQLite db = new Database_SQLite(context);
        ArrayList<String> estados = db.consultaTodasUF();

        if (estados.contains(uf.toUpperCase())) {
            usuario.setEndereco(uf);
            return true;
        } else {
            return false;
        }
    }

    public Boolean setTelefone(String telefone, Usuario usuario) {
        if(telefone.length() < 13){
            return false;
        }
        else{
            for (int i = 0; i < telefone.length(); i++) {
                if(i != 0 && i != 3 && i != 9){
                    System.out.println(i);
                    char ch = telefone.charAt(i);
                    if (ch < 48 || ch > 57){
                        return false;
                    }
                }
            }
        }
        usuario.setTelefone(telefone);
        return true;
    }

    public Boolean setEmail(String email, Usuario usuario) {
        if (android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            usuario.setEmail(email);
            return true;
        }
        return false;
    }

    public Boolean setAniversario(String aniversario, Usuario usuario) {
        int dia = Integer.parseInt(aniversario.substring(0,2));
        int mes = Integer.parseInt(aniversario.substring(3,5));
        int ano = Integer.parseInt(aniversario.substring(6));

        Calendar calendar = Calendar.getInstance();
        int anoAtual = calendar.get(Calendar.YEAR);

        System.out.println(anoAtual);
        System.out.println(anoAtual - 70);
        System.out.println(anoAtual - 15);
        System.out.println("ano:"+ano);
        System.out.println("mes:"+mes);
        System.out.println("dia:"+dia);

        if(dia > 31 || mes > 12 || ano < (anoAtual - 70) || ano > (anoAtual- 15)){
            System.out.println("ano invalido");
            return false;
        }
        if((ano % 4 == 0 && ano % 100 != 0) || ano % 400 == 0){
            if(dia == 29 && mes == 2){
                System.out.println("to aqui");
            }
        }

        return false;
    }

    public Boolean setSenha(String senha, Usuario usuario) {
        return false;
    }


}

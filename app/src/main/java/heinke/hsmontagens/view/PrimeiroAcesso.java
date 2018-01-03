package heinke.hsmontagens.view;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import heinke.hsmontagens.R;
import heinke.hsmontagens.controller.ControleUsuario;
import heinke.hsmontagens.model.Ferramentas;
import heinke.hsmontagens.model.Usuario;

public class PrimeiroAcesso extends Ferramentas implements View.OnClickListener, View.OnKeyListener, View.OnFocusChangeListener {
    private EditText nome
                    ,cidade
                    ,uf
                    ,telefone
                    ,email
                    ,aniversario
                    ,senha
                    ,confirmar_senha;

    private Button cadastrar;

    private Usuario usuario;
    int teste = 0;

    @Override
    protected void onCreate(Bundle savedInstanced){
        super.onCreate(savedInstanced);
        setContentView(R.layout.activity_primeiro_acesso);

        usuario = new Usuario();

        nome = (EditText) findViewById(R.id.nomeCompleto);
            nome.setOnFocusChangeListener(this);
        cidade = (EditText) findViewById(R.id.cidade);
            cidade.setOnFocusChangeListener(this);
        uf = (EditText) findViewById(R.id.uf);
            uf.setOnFocusChangeListener(this);
        telefone = (EditText) findViewById(R.id.telefone);
            telefone.setOnKeyListener(this);
        email = (EditText) findViewById(R.id.email);
        aniversario = (EditText) findViewById(R.id.dataNascimento);
            aniversario.setOnKeyListener(this);
        senha = (EditText) findViewById(R.id.senha);
        confirmar_senha = (EditText) findViewById(R.id.confirmarSenha);

        cadastrar = (Button) findViewById(R.id.cadastrar);
            cadastrar.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        ControleUsuario controleUsuario =  new ControleUsuario();

        if(view.getId() == R.id.cadastrar){
            if(!controleUsuario.setNome(nome.getText().toString(),usuario)){
                nome.setError(getString(R.string.cadastroNome));
                nome.setFocusable(true);
                nome.requestFocus();
            }
            else if(!controleUsuario.setUf(uf.getText().toString(),usuario,this)){
                uf.setError(getString(R.string.cadastroUf));
                uf.setFocusable(true);
                uf.requestFocus();
            }
            else if(!controleUsuario.setCidade(cidade.getText().toString(), uf.getText().toString(), usuario,this)){
                cidade.setError(getString(R.string.cadastroCidade));
                cidade.setFocusable(true);
                cidade.requestFocus();
            }
            else if(!controleUsuario.setTelefone(telefone.getText().toString(), usuario)){
                telefone.setError(getString(R.string.cadastroTelefone));
                telefone.setFocusable(true);
                telefone.requestFocus();
            }
            else if(!controleUsuario.setEmail(email.getText().toString(),usuario)){
                email.setError(getString(R.string.cadastroEmail));
                email.setFocusable(true);
                email.requestFocus();
            }
            else if(!controleUsuario.setAniversario(aniversario.getText().toString(),usuario)){

            }
            else{
                alertaTela(this);
            }
        }
    }

    private void alertaTela (Context context) {
        Button sim, nao;
        Intent intent = new Intent();

        final Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.alert_cadastrar_empresa);

        sim = dialog.findViewById(R.id.sim);
        nao = dialog.findViewById(R.id.nao);

        sim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        nao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }

    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        String aux;
        if(keyCode == event.KEYCODE_TAB || keyCode == event.KEYCODE_ENTER){

        }
        else if(v.getId() == R.id.telefone && event.getAction() == KeyEvent.ACTION_DOWN){
            if(keyCode == event.KEYCODE_DEL){
                if(telefone.getText().length() == 2){
                    telefone.setText("");
                    telefone.setSelection(0);
                }
                else if(telefone.getText().length() == 5){
                    aux = telefone.getText().subSequence(0,4).toString();
                    telefone.setText(aux);
                    telefone.setSelection(aux.length());
                }
                else if(telefone.getText().length() == 11){
                    aux = telefone.getText().subSequence(0,10).toString();
                    telefone.setText(aux);
                    telefone.setSelection(aux.length());
                }
            }
            else if(telefone.getText().length() == 0){
                aux = "(" + telefone.getText().toString();
                telefone.setText(aux);
                telefone.setSelection(aux.length());
            }
            else if(telefone.getText().length() == 3){
                aux = telefone.getText().toString() + ")";
                telefone.setText(aux);
                telefone.setSelection(aux.length());
            }
            else if(telefone.getText().length() == 9){
                aux = telefone.getText().toString() + "-";
                telefone.setText(aux);
                telefone.setSelection(aux.length());
            }
            else if(telefone.getText().length() >= 14){
                Toast.makeText(this,getString(R.string.avisoTelefone),Toast.LENGTH_SHORT).show();
                aux = telefone.getText().subSequence(0,13).toString();
                telefone.setText(aux);
                telefone.setSelection(aux.length());
            }
        }
        else if(v.getId() == R.id.dataNascimento && event.getAction() == KeyEvent.ACTION_DOWN){
            if(keyCode == event.KEYCODE_DEL){
                if(aniversario.getText().length() == 4){
                    aux = aniversario.getText().subSequence(0,3).toString();
                    aniversario.setText(aux);
                    aniversario.setSelection(aux.length());
                }
                else if(aniversario.getText().length() == 7){
                    aux = aniversario.getText().subSequence(0,5).toString();
                    aniversario.setText(aux);
                    aniversario.setSelection(aux.length());
                }
            }
            else if(aniversario.getText().length() == 2){
                aux = aniversario.getText().toString() + "/";
                aniversario.setText(aux);
                aniversario.setSelection(aux.length());
            }
            else if(aniversario.getText().length() == 5){
                aux = aniversario.getText().toString() + "/";
                aniversario.setText(aux);
                aniversario.setSelection(aux.length());
            }
            else if(aniversario.getText().length() >= 10){
                Toast.makeText(this,getString(R.string.avisoAniversario),Toast.LENGTH_SHORT).show();
                aux = aniversario.getText().toString();
                aniversario.setText(aux.substring(0,10));
                aniversario.setSelection(aux.length());
            }
        }
        return false;
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if(v.getId() == R.id.nomeCompleto){
            nome.setText(colocarPrimeiraLetraMaiuscula(nome.getText().toString()));
        }
        if(v.getId() == R.id.uf){
            uf.setText(uf.getText().toString().toUpperCase());
        }
        if(v.getId() == R.id.cidade){
            cidade.setText(removerAcentos(cidade.getText().toString()));
            cidade.setText(colocarPrimeiraLetraMaiuscula(cidade.getText().toString()));
        }
    }


}

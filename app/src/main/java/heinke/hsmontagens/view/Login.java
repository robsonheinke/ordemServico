package heinke.hsmontagens.view;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import heinke.hsmontagens.R;
import heinke.hsmontagens.model.Cidade;
import heinke.hsmontagens.model.Database_SQLite;
import heinke.hsmontagens.model.Estado;
import heinke.hsmontagens.model.Ferramentas;
import heinke.hsmontagens.model.Pais;

public class Login extends Ferramentas implements View.OnClickListener,View.OnTouchListener{

    private EditText login, senha;
    private TextView esqueciSenha, primeiroAcesso;
    private Button entrar;

    private Database_SQLite db = new Database_SQLite(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);

      //  inserirDadosSQLite();

        login = (EditText) findViewById(R.id.login);
        senha = (EditText) findViewById(R.id.senha);

        esqueciSenha = (TextView) findViewById(R.id.esqueciSenha);
            esqueciSenha.setOnTouchListener(this);
        primeiroAcesso = (TextView) findViewById(R.id.primeiroAcesso);
            primeiroAcesso.setOnTouchListener(this);

        entrar = (Button) findViewById(R.id.entrar);
            entrar.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Toast.makeText(this, login.getText().toString()+" e "+ senha.getText().toString(), Toast.LENGTH_SHORT).show();

        if(validaLogin(String.valueOf(login.getText()), String.valueOf(senha.getText()))){
            novaTela(3,this);
        }
        else{
            Toast.makeText(this,R.string.erroDeLogin,Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (view.getId()){
            case R.id.esqueciSenha:
                break;
            case R.id.primeiroAcesso:
                novaTela(2,this);
                break;
        }
        return false;
    }

    private Boolean validaLogin(String login, String senha){

        return false;
    }

    @Override
    protected void onPause(){
        super.onPause();
        finish();
    }


}

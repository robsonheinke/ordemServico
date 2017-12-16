package heinke.hsmontagens.view.model;

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
}

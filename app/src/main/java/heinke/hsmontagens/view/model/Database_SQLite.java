package heinke.hsmontagens.view.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by heinke on 08/11/17.
 */

public class Database_SQLite extends SQLiteOpenHelper {

    /*dados do banco*/
    private static final int VERSAO_DB = 1;
    private static final String NOME_DB = "db_ordem_de_servico";

    /*tabelas*/
    private static final String TABELA_USUARIO = "tb_usuario";

    /*tabela usuario*/
    private static final String COLUNA_ID = "id";
    private static final String COLUNA_NOME = "nome_completo";
    private static final String COLUNA_ENDERECO = "endereco";
    private static final String COLUNA_TELEFONE = "telefone";
    private static final String COLUNA_EMAIL = "email";
    private static final String COLUNA_ANIVERSARIO = "aniversario";
    private static final String COLUNA_SENHA = "senha";



    public Database_SQLite(Context context) {
        super(context, NOME_DB, null, VERSAO_DB);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        criarTabelaUsuario(sqLiteDatabase);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    private void criarTabelaUsuario(SQLiteDatabase sqlDB){
        String QUERY = tabelaUsuario();

        sqlDB.execSQL(QUERY);
    }

    private String tabelaUsuario(){
        return "CREATE TABLE " + TABELA_USUARIO + "(" +
                COLUNA_ID +" INTEGER PRIMARY KEY" +
                ", " + COLUNA_NOME + " TEXT" +
                ", " + COLUNA_ENDERECO + " TEXT" +
                ", " + COLUNA_TELEFONE + " TEXT" +
                ", " + COLUNA_EMAIL + " TEXT" +
                ", " + COLUNA_ANIVERSARIO + " TEXT" +
                ", " + COLUNA_SENHA + " TEXT)";
    }
}

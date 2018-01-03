package heinke.hsmontagens.model;

/**
 * Created by heinke on 24/12/17.
 */

public class Pais {
    private int id;
    private String nome;
    private String sigla;

    public Pais(String pais, String _sigla) {
        this.nome = pais;
        this.sigla = _sigla;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
}

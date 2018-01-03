package heinke.hsmontagens.model;

/**
 * Created by heinke on 24/12/17.
 */

public class Estado {
        private int id;
        private String nome;
        private String uf;
        private int pais;

    public Estado(String estado, String _uf, int codPais) {
        this.nome = estado;
        this.uf = _uf;
        this.pais = codPais;
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

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public int getPais() {
        return pais;
    }

    public void setPais(int pais) {
        this.pais = pais;
    }
}

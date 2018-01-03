package heinke.hsmontagens.model;

/**
 * Created by heinke on 24/12/17.
 */

public class Cidade {
    private int id;
    private String cidade;
    private int estado;

    public Cidade(String _cidade, int _estado) {
        this.cidade = _cidade;
        this.estado = _estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
}

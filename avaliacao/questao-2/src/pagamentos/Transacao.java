package pagamentos;

public class Transacao {
    public String id;
    public Boolean status;
    public String tipo;
    public Double valor;
    public Transacao(String id, Boolean status, String tipo, Double valor) {
        this.id = id;
        this.status = status;
        this.tipo = tipo;
        this.valor = valor;
    }
}

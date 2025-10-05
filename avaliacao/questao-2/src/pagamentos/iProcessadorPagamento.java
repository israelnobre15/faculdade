package pagamentos;

public interface iProcessadorPagamento {
    public Transacao processar(Transacao transacao);
}

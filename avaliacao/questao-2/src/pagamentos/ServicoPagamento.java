package pagamentos;

public class ServicoPagamento {
    iFabricaPagamento fabricaPagamento;
    iVerificadorPagamento verificadorPagamento;
    iProcessadorPagamento processadorPagamento;
    iGeradorPagamento geradorPagamento;

    public ServicoPagamento(iFabricaPagamento fabricaPagamento){
        this.fabricaPagamento = fabricaPagamento;
        this.verificadorPagamento = fabricaPagamento.fabricaVerificadorPagamento();
        this.processadorPagamento = fabricaPagamento.fabricaProcessadorPagamento();
        this.geradorPagamento = fabricaPagamento.fabricageradorPagamento();
    }

    public void executaPagamento(Double valor){
        Transacao transacao = this.geradorPagamento.gerarTransacao(valor);
        transacao = this.processadorPagamento.processar(transacao);
        this.verificadorPagamento.validar(transacao);
    };

}

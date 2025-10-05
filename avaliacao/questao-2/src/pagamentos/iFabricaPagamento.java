package pagamentos;

public interface iFabricaPagamento {

    public iGeradorPagamento fabricageradorPagamento();

    public iVerificadorPagamento fabricaVerificadorPagamento();

    public iProcessadorPagamento fabricaProcessadorPagamento();
}

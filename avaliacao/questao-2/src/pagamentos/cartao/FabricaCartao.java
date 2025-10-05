package pagamentos.cartao;

import pagamentos.iFabricaPagamento;
import pagamentos.iGeradorPagamento;
import pagamentos.iProcessadorPagamento;
import pagamentos.iVerificadorPagamento;

public class FabricaCartao implements iFabricaPagamento {


    @Override
    public iGeradorPagamento fabricageradorPagamento() {
        return new GeradorCartao();
    }

    @Override
    public iVerificadorPagamento fabricaVerificadorPagamento() {
        return new VerificadorCartao();
    }

    @Override
    public iProcessadorPagamento fabricaProcessadorPagamento() {
        return new ProcessadorCartao();
    }
}

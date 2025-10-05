package pagamentos.boleto;

import pagamentos.iFabricaPagamento;
import pagamentos.iGeradorPagamento;
import pagamentos.iProcessadorPagamento;
import pagamentos.iVerificadorPagamento;

public class FabricaBoleto implements iFabricaPagamento {


    @Override
    public iGeradorPagamento fabricageradorPagamento() {
        return new GeradorBoleto();
    }

    @Override
    public iVerificadorPagamento fabricaVerificadorPagamento() {
        return new VerificadorBoleto();
    }

    @Override
    public iProcessadorPagamento fabricaProcessadorPagamento() {
        return new ProcessadorBoleto();
    }
}

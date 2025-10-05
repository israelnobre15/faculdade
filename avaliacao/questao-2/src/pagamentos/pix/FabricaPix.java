package pagamentos.pix;

import pagamentos.*;

public class FabricaPix implements iFabricaPagamento {


    @Override
    public iGeradorPagamento fabricageradorPagamento() {
        return new GeradorPix();
    }

    @Override
    public iVerificadorPagamento fabricaVerificadorPagamento() {
        return new VerificadorPix();
    }

    @Override
    public iProcessadorPagamento fabricaProcessadorPagamento() {
        return new ProcessadorPix();
    }
}

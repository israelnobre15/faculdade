package pagamentos.pix;

import pagamentos.Transacao;
import pagamentos.iVerificadorPagamento;

public class VerificadorPix implements iVerificadorPagamento {

    @Override
    public Transacao validar(Transacao transacao) {
        if (transacao.status){
            System.out.println("Sua transação " + transacao.id + "do tipo " + transacao.tipo + " foi paga com sucesso");
            return transacao;
        }
        System.out.println("Sua transação " + transacao.id + "do tipo " + transacao.tipo + " não foi paga com sucesso");
        return transacao;
    }
}

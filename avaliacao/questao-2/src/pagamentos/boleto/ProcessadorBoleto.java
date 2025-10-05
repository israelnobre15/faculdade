package pagamentos.boleto;

import pagamentos.Transacao;
import pagamentos.iProcessadorPagamento;

public class ProcessadorBoleto implements iProcessadorPagamento {

    @Override
    public Transacao processar(Transacao transacao) {

        System.out.println("Sua transação " + transacao.id + "do tipo " + transacao.tipo + " do valor " + transacao.valor + " foi processada");

        transacao.status = true;

        return transacao;

    }
}

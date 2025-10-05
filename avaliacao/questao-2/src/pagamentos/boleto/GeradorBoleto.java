package pagamentos.boleto;
import pagamentos.Transacao;
import pagamentos.iGeradorPagamento;

import java.util.UUID;
public class GeradorBoleto implements iGeradorPagamento {

    @Override
    public Transacao gerarTransacao(Double valor) {
        String id = UUID.randomUUID().toString();
        Boolean status = false;
        String tipo = "Boleto";

        System.out.println("Sua solicitação de pagamento do tipo " + tipo + " do valor " + valor.toString() + " foi gerada");

        return new Transacao(id,status,tipo,valor);
    }
}

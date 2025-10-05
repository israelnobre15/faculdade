package pagamentos.pix;
import pagamentos.Transacao;
import pagamentos.iGeradorPagamento;

import java.util.UUID;
public class GeradorPix implements iGeradorPagamento {

    @Override
    public Transacao gerarTransacao(Double valor) {
        String id = UUID.randomUUID().toString();
        Boolean status = false;
        String tipo = "Pix";

        System.out.println("Sua solicitação de pagamento do tipo " + tipo + " do valor " + valor.toString() + " foi gerada");

        return new Transacao(id,status,tipo,valor);
    }
}

import pagamentos.ServicoPagamento;
import pagamentos.boleto.FabricaBoleto;
import pagamentos.cartao.FabricaCartao;
import pagamentos.pix.FabricaPix;

/*
Durante o desenvolvimento desta atividade, o padrão de projeto escolhido foi abstract factory
pois dentro de cada método de pagamento, temos algumas classes que são semelhantes entre si,
porém possuindo uma diferente heurística, sendo assim, com a fábrica abstrata, podemos passar
para o método Servico de pagamento, qual é a fabrica (basicamente o método de pagamento que será executado)
e ele cuida de todo o serviço da criação dos objetos internos e dependentes.

*/

public class Main {

    public static void main(String[] args) {

        ServicoPagamento pix = new ServicoPagamento(new FabricaPix());

        pix.executaPagamento(15.3);

        ServicoPagamento boleto =  new ServicoPagamento(new FabricaBoleto());

        boleto.executaPagamento(43.3);

        ServicoPagamento cartao = new ServicoPagamento(new FabricaCartao());

        cartao.executaPagamento(500.3);



    }
}
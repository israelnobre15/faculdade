package SistemaVendas;

import java.util.ArrayList;

public class DecoradorEstatisticas extends RelatorioDecoradorBase{
    public DecoradorEstatisticas(iRelatorioVendas relatorio) {
        super(relatorio);
    }

    private String gerarEstatisticas(){
        StringBuilder s = new StringBuilder();

        ArrayList<Pedido> pedidos = relatorio.getPedidos();

        Double quantidadeTotal = 0.0;
        for (Pedido pedido: pedidos) {
            quantidadeTotal += pedido.quantidade;
        }

        Double faturamentoTotal = 0.0;
        for (Pedido pedido: pedidos) {
            faturamentoTotal += pedido.preco * pedido.quantidade;
        }

        s.append("\n--- ESTATÍSTICAS DETALHADAS ---\n")
        .append("Faturamento total R$: " + faturamentoTotal)
        .append("\nQuantidade R$: " + quantidadeTotal);



        return s.toString();

    }

    @Override
    public String gerarRelatorio(){
        return relatorio.gerarRelatorio() + this.gerarEstatisticas();
    }

    @Override
    public String descricao() {
        return relatorio.descricao() + " Estatisticas ";
    }

    @Override
    public ArrayList<Pedido> getPedidos() {
        return relatorio.getPedidos();
    }
}

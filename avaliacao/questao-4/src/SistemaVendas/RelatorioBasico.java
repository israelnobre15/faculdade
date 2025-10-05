package SistemaVendas;

import java.util.ArrayList;

public class RelatorioBasico  implements iRelatorioVendas {
    public ArrayList<Pedido> pedidos;

    public RelatorioBasico(ArrayList<Pedido> pedidos) {
        this.pedidos = pedidos;

    }

    @Override
    public String gerarRelatorio() {
        StringBuilder relatorio = new StringBuilder();
        relatorio.append("\"=== RELATÓRIO BÁSICO DE VENDAS === \n\"");
        relatorio.append("Total de pedidos: ").append(pedidos.size()).append("\n");

        for (Pedido pedido : pedidos) {
            relatorio.append("Pedido #").append(pedido.id)
            .append(" | Cliente: ").append(pedido.cliente)
            .append(" | Quantidade: ").append(String.format("%.2f", pedido.quantidade))
            .append(" | Preco: R$").append(pedido.preco)
            .append(" | Data: ").append(pedido.data)
            .append("\n");

        }
        return relatorio.toString();
    }

    @Override
    public String descricao() {
        return "Relatório básico de vendas";
    }

    @Override
    public ArrayList<Pedido> getPedidos() {
        return this.pedidos;
    }
}

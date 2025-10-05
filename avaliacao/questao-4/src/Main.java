/*
O padrão de projeto escolhido para esta atividade foi o decorator, pois considerando a necessidade
de adição de novas funcionalidades de forma modular é o padrão que mais se aplica, pois adiciona
os novos resultados somente em runtime.
 */


import SistemaVendas.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Pedido> pedidos = new ArrayList<>();
        pedidos.add(new Pedido());
        pedidos.add(new Pedido());
        pedidos.add(new Pedido());
        pedidos.add(new Pedido());
        pedidos.add(new Pedido());
        pedidos.add(new Pedido());
        pedidos.add(new Pedido());
        pedidos.add(new Pedido());
        pedidos.add(new Pedido());
        pedidos.add(new Pedido());

        RelatorioBasico relatorioBasico = new RelatorioBasico(pedidos);

        DecoradorEstatisticas relatorioComercial =  new DecoradorEstatisticas(relatorioBasico);
        System.out.println(relatorioComercial.descricao());
        System.out.println(relatorioComercial.gerarRelatorio());

    }
}
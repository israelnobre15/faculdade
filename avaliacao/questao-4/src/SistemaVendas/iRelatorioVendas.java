package SistemaVendas;

import java.util.ArrayList;

public interface iRelatorioVendas {
    public String gerarRelatorio();
    public String descricao();
    public ArrayList<Pedido> getPedidos();
}

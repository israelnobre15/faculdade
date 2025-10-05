package SistemaVendas;

public abstract class RelatorioDecoradorBase implements iRelatorioVendas{
    protected iRelatorioVendas relatorio;

    public RelatorioDecoradorBase(iRelatorioVendas relatorio) {
        this.relatorio = relatorio;
    }

    @Override
    public String gerarRelatorio() {
        return relatorio.gerarRelatorio();
    }

    @Override
    public String descricao() {
        return  relatorio.descricao();
    }
}

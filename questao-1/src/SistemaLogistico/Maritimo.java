package SistemaLogistico;

public class Maritimo extends ABCModalidade{
    public Maritimo(Double tarifa){
        super(tarifa);
    }

    @Override
    public void calcularTarifa(Remessa remessa) {
        System.out.println("Calculando tarifa");
        System.out.println("Sua tarifa área tem o custo de: "+ remessa.volume * this.tarifa);
    }
}

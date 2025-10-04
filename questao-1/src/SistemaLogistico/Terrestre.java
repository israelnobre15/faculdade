package SistemaLogistico;

public class Terrestre extends ABCModalidade{

    public Terrestre(Double tarifa) {
        super(tarifa);

    }
    @Override
    public void calcularTarifa(Remessa remessa) {
        System.out.println("Calculando tarifa");
        System.out.println("Sua tarifa área tem o custo de: "+ remessa.distancia * this.tarifa);
    }
}

package SistemaLogistico;

public class Aereo extends ABCModalidade {


    public Aereo(Double tarifa) {
        super(tarifa);
    }

    @Override
    public void calcularTarifa(Remessa remessa) {
        System.out.println("Calculando tarifa");
        System.out.println("Sua tarifa aerea tem o custo de: "+ remessa.peso * this.tarifa);

    }
}

package SistemaLogistico;

public class Aereo implements iModalidade {

    Double tarifa;
    Remessa remessa;
    public Aereo(Double tarifa, Remessa remessa) {
        this.tarifa = tarifa;
        this.remessa = remessa;
    }

    @Override
    public void calcularTarifa() {
        System.out.println("Calculando tarifa");
        System.out.println("Sua tarifa aerea tem o custo de: "+ this.remessa.peso * this.tarifa);

    }
}

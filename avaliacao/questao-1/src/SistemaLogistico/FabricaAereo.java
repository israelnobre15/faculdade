package SistemaLogistico;

public class FabricaAereo implements iFabricaModalidade {
    @Override
    public iModalidade fabricar(Double tarifa, Remessa remessa) {
        return new Aereo(tarifa,remessa);
    }
}

package SistemaLogistico;

public class FabricaAereo implements iFabricaModalidade {
    @Override
    public ABCModalidade fabricar(Double tarifa) {
        return new Aereo(tarifa);
    }
}

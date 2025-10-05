package SistemaLogistico;

public class FabricaTerrestre implements iFabricaModalidade {
    @Override
    public iModalidade fabricar(Double tarifa,Remessa remessa) {
        return new Terrestre(tarifa,remessa);
    }
}

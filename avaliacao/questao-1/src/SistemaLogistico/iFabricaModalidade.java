package SistemaLogistico;

public interface iFabricaModalidade {
    public iModalidade fabricar(Double tarifa, Remessa remessa);
}

import SistemaLogistico.*;
// O padrão utilizado nesta atividade é o padrão factory, pois temos uma abstração relacionada
// as possíveis formas de transporte, onde temos uma semelhança entre o método calcular tarifa
// fazendo com que pudessemos ter uma fabrica retornando um tipo abstrato de calculadora de tarifa
// Foi utilizado abstract class ao invés de interface para o iModalidade, para que pudessemos implementar
// um único construtor, mantendo as regras do original.

public class Main {
    public static void main(String[] args) {
        CalculadoraTarifa calculadora = new CalculadoraTarifa();
        Remessa remessa = new Remessa(12.5,14.2,23.0);
        iFabricaModalidade fabricaAerea = new FabricaAereo();
        calculadora.Calcular(fabricaAerea,14.5,remessa);


        iFabricaModalidade fabricaTerrestre = new FabricaTerrestre();
        calculadora.Calcular(fabricaTerrestre,31.2,remessa);

        iFabricaModalidade fabricaMaritimo = new FabricaMaritimo();
        calculadora.Calcular(fabricaMaritimo,45.2,remessa);

    }
}
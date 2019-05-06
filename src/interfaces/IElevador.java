package interfaces;

public interface IElevador {

    public int subir(int atual, int desejado);

    public int descer(int atual, int desejado);

    public void parada();

}

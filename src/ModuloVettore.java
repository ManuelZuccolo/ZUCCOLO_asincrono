import java.util.concurrent.Callable;

public class ModuloVettore implements Callable<Double> {

    private int[] W;

    public ModuloVettore(int[] W) {
        this.W = W;
    }

    @Override
    public Double call() {
        double somma = 0;
        for (int x : W) {
            somma += x * x;
        }
        return Math.sqrt(somma);
    }
}

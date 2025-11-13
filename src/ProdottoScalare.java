import java.util.concurrent.Callable;

public class ProdottoScalare implements Callable<Integer> {

    private int[] U, V;

    public ProdottoScalare(int[] U, int[] V) {
        this.U = U;
        this.V = V;
    }

    @Override
    public Integer call() {
        int somma = 0;
        for (int i = 0; i < U.length; i++) {
            somma += U[i] * V[i];
        }
        return somma;
    }
}

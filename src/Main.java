import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) {

        // Vettori di esempio
        int[] U = {3, 4, 5};
        int[] V = {2, 1, 0};

        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Creazione dei task
        ProdottoScalare taskProdotto = new ProdottoScalare(U, V);
        ModuloVettore taskModuloU = new ModuloVettore(U);
        ModuloVettore taskModuloV = new ModuloVettore(V);

        try {
            // Avvio task
            Future<Integer> futuroProdotto = executor.submit(taskProdotto);
            Future<Double> futuroModuloU = executor.submit(taskModuloU);
            Future<Double> futuroModuloV = executor.submit(taskModuloV);

            // Attendo i risultati
            int prodotto = futuroProdotto.get();
            double moduloU = futuroModuloU.get();
            double moduloV = futuroModuloV.get();

            // Formula cos(alpha)
            double cosAlpha = prodotto / (moduloU * moduloV);

            // Output
            System.out.println("Prodotto scalare = " + prodotto);
            System.out.println("|U| = " + moduloU);
            System.out.println("|V| = " + moduloV);
            System.out.println("cos(alpha) = " + cosAlpha);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }
}

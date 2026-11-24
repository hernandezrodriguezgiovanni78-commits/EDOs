public class MetodoEuler {

    // Funcion de la ecuacion diferencial: y' = x - y
    public static double evaluarFuncion(double x, double y) {
        return x - y;
    }

    // Solucion exacta: y = x - 1 + 2e^(-x)
    public static double solucionExacta(double x) {
        return x - 1 + 2 * Math.exp(-x);
    }

    public static void main(String[] args) {

        double x0 = 0.0;
        double y0 = 1.0;
        double xFinal = 0.3;

        // Probamos diferentes tamanos de paso
        double[] pasos = {0.1, 0.05, 0.01};

        for (double h : pasos) {

            int nPasos = (int) Math.round((xFinal - x0) / h);

            double x = x0;
            double y = y0;

            System.out.println("\nMETODO DE EULER - h = " + h);
            System.out.println("------------------------------------------");
            System.out.printf("%-10s %-15s %-15s %-15s%n",
                    "Paso", "X", "Y (Euler)", "Error");

            System.out.printf("%-10d %-15.4f %-15.6f %-15.6f%n",
                    0, x, y, Math.abs(solucionExacta(x) - y));

            for (int i = 0; i < nPasos; i++) {

                // Calculamos la pendiente
                double pendiente = evaluarFuncion(x, y);

                // Actualizamos los valores de x y y
                y = y + h * pendiente;
                x = x0 + (i + 1) * h;

                // Calculamos el error absoluto
                double error = Math.abs(solucionExacta(x) - y);

                System.out.printf("%-10d %-15.4f %-15.6f %-15.6f%n",
                        i + 1, x, y, error);
            }
        }
    }
}

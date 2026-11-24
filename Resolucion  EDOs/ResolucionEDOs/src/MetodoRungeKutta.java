public class MetodoRungeKutta {

    // Funcion de la ecuacion diferencial: y' = x + y
    public static double evaluarFuncion(double x, double y) {
        return x + y;
    }

    // Solucion exacta: y = 2e^x - x - 1
    public static double solucionExacta(double x) {
        return 2 * Math.exp(x) - x - 1;
    }

    public static void main(String[] args) {

        double x0 = 0.0;
        double y0 = 1.0;
        double h = 0.1;
        double xFinal = 0.3;

        int nPasos = (int) Math.round((xFinal - x0) / h);

        double x = x0;
        double y = y0;

        System.out.println("METODO RUNGE-KUTTA DE CUARTO ORDEN (RK4)");
        System.out.println("-----------------------------------------------");
        System.out.printf("%-10s %-15s %-15s %-15s%n",
                "Paso", "X", "Y (RK4)", "Error");

        System.out.printf("%-10d %-15.4f %-15.6f %-15.6f%n",
                0, x, y, Math.abs(solucionExacta(x) - y));

        for (int i = 0; i < nPasos; i++) {

            // Calculamos las cuatro pendientes
            double k1 = evaluarFuncion(x, y);

            double k2 = evaluarFuncion(
                    x + h / 2,
                    y + h * k1 / 2
            );

            double k3 = evaluarFuncion(
                    x + h / 2,
                    y + h * k2 / 2
            );

            double k4 = evaluarFuncion(
                    x + h,
                    y + h * k3
            );

            // Actualizamos el valor de y
            y = y + (h / 6) * (k1 + 2 * k2 + 2 * k3 + k4);

            // Actualizamos x
            x = x0 + (i + 1) * h;

            // Calculamos el error absoluto
            double error = Math.abs(solucionExacta(x) - y);

            System.out.printf("%-10d %-15.4f %-15.6f %-15.6f%n",
                    i + 1, x, y, error);
        }
    }
}

import java.util.Scanner;


public class Aplicacion_If_While {

	public static void main(String[] args) {
		
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        int cantidadVehiculos = 0;
        double sumaVelocidades = 0.0;

        while (opcion != 3) {
            mostrarMenu();
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    cantidadVehiculos++;
                    System.out.println("Vehiculo " + cantidadVehiculos);
                    int vueltas = 0;
                    double distanciaTotal = 0.0;
                    double tiempoTotal = 0.0;

                    while (true) {
                        System.out.print("Ingrese la distancia recorrida en la vuelta " + (vueltas + 1) + " (en kilometros) o -1 para terminar: ");
                        double distanciaVuelta = scanner.nextDouble();

                        if (distanciaVuelta == -1) {
                            break;
                        }

                        System.out.print("Ingrese el tiempo tomado en la vuelta " + (vueltas + 1) + " (en horas): ");
                        double tiempoVuelta = scanner.nextDouble();

                        distanciaTotal += distanciaVuelta;
                        tiempoTotal += tiempoVuelta;
                        vueltas++;
                    }

                    if (vueltas > 0) {
                        double velocidadPromedioVehiculo = calcularVelocidad(distanciaTotal, tiempoTotal);
                        System.out.println("Velocidad promedio del vehículo " + cantidadVehiculos + ": " + velocidadPromedioVehiculo + " km/h");
                        sumaVelocidades += velocidadPromedioVehiculo;
                    } else {
                        System.out.println("No se ingresaron vueltas para el vehiculo " + cantidadVehiculos);
                    }
                    break;

                case 2:
                    if (cantidadVehiculos > 0) {
                        double velocidadPromedioTotal = sumaVelocidades / cantidadVehiculos;
                        System.out.println("Velocidad promedio de todos los vehículos: " + velocidadPromedioTotal + " km/h");
                    } else {
                        System.out.println("No se ingresaron vehiculos");
                    }
                    break;

                case 3:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opcion invalida. Intente nuevamente.");
                    break;
            }
        }

        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n-- Menu --");
        System.out.println("1. Ingresar vehiculo");
        System.out.println("2. Calcular velocidad promedio de todos los vehiculos");
        System.out.println("3. Salir");
        System.out.print("Seleccione una opcion: ");
    }

    private static double calcularVelocidad(double distancia, double tiempo) {
        if (tiempo == 0.0) {
            return 0.0; // Para evitar una división por cero
        }
        return distancia / tiempo;
    }
}


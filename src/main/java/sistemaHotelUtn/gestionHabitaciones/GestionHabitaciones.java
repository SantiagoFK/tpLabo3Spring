package sistemaHotelUtn.gestionHabitaciones;

import sistemaHotelUtn.generales.Gestion;
import sistemaHotelUtn.generales.Json.JsonRepo;
import sistemaHotelUtn.gestionReservas.Reserva;

import java.util.ArrayList;
import java.util.Scanner;

import static sistemaHotelUtn.gestionHabitaciones.Habitacion.setUltimoId;

public class GestionHabitaciones extends Gestion<Habitacion> {
    public GestionHabitaciones() {
        cargarHabitacionesJson();
        setUltimoId(this.getLista().size());
    }

    private Habitacion nuevaHabitacion() {
        int aceptar = 0;
        Scanner scanner = new Scanner(System.in);
        Habitacion nueva = new Habitacion(true, 0.0, 0, new ArrayList<ServiciosHabitacion>());

        while (aceptar == 0) {
            System.out.println("Ingrese precio diario de alquiler: ");
            nueva.setPrecioDiario(scanner.nextDouble());
            System.out.println("Ingrese la capacidad maxima: ");
            nueva.setCapacidadMax(scanner.nextInt());
            //PONER LISTA DE SERVICIOS

            System.out.println("¿Esta de acuerdo con esta informacion? Ingrese 0 para modificar de nuevo los valores");
            System.out.println(nueva.toString());
            aceptar = scanner.nextInt();
        }
        return nueva;
    }

    public Habitacion buscarHabitacion(int ID) {
        Habitacion aux = null;
        boolean encontrado = false;
        for (int i = 0; i < getLista().size() || encontrado; i++) {
            aux = getLista().get(i);
            if (aux.getId() == ID) {
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontro una habitacion con ese ID");
            aux = null;
        }
        return aux;
    }

    public void cargarHabitacionesJson() {
        ArrayList<Habitacion> habitacionesList = new ArrayList<>();
        JsonRepo<Habitacion> habitacionesJson = new JsonRepo<>("habitaciones", habitacionesList, Habitacion.class);
        habitacionesList = habitacionesJson.cargar();
        this.setLista(habitacionesList);

    }


    public void mostrarHabitaciones() {

        for (Habitacion habitacion : this.getLista()) {
            if (habitacion.getEsReservable()) {
                System.out.println(habitacion);

            }
        }
    }

    public Habitacion obtenerHabitacion(int choice) {
        try{
            Habitacion habitacion = this.getLista().get(choice);
            return habitacion;
        }catch (IndexOutOfBoundsException e){
            System.out.println("Entrada erronea");
            return null;
        }
    }

    public void guardarHabitacionJson() {
        ArrayList<Habitacion> habitacionList = this.getLista();
        JsonRepo<Habitacion> habitacionJson = new JsonRepo<>("habitaciones", habitacionList, Habitacion.class);
        habitacionJson.guardar();
    }

    public boolean eliminarHabitacionPorId(int id)
    {
        boolean eliminado = false;

        for(Habitacion habitacion: this.getLista())
        {
            if( habitacion.getId() == id )
            {
                this.getLista().remove(habitacion);
                eliminado = true;
                return eliminado;
            }
        }

        return eliminado;
    }
}

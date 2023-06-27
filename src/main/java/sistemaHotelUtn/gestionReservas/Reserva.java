package sistemaHotelUtn.gestionReservas;

import lombok.Data;
import sistemaHotelUtn.generales.Persona;
import sistemaHotelUtn.gestionClientes.Cliente;
import sistemaHotelUtn.gestionHabitaciones.Habitacion;


import java.io.Serializable;
import java.time.LocalDate;

public class Reserva implements Serializable {
    //region Atributos
    private int id;
    public static int ultimoId = 0;
    private boolean idEstaAsignado = false;
    private boolean estaPago;
    private LocalDate diaCheckIn;
    private LocalDate diaCheckOut;
    private Cliente cliente = null;
    private Habitacion habitacion = null;
    private double saldo;
    private double montoPagar;
    private boolean estaActiva;
    //endregion

    //private ServiciosGastronomia List<ServiciosGastronomia>; agregar servicioGastronomia

    public Reserva() {
    }

    public Reserva(LocalDate diaCheckIn, LocalDate diaCheckOut, Cliente cliente, Habitacion habitacion) {
        this.diaCheckIn = diaCheckIn;
        this.diaCheckOut = diaCheckOut;
        this.cliente = cliente;
        this.habitacion = habitacion;
        this.estaActiva = true;
    }

    //region Getters y Setters
    public int getId() {
        return id;
    }
    public void setId(int id)
    {
        this.id = id;
    }

    public void asignarIdAutoincremental()
    {
        if( ! idEstaAsignado )
        {
            this.id = ++Reserva.ultimoId;
            this.idEstaAsignado = true;
        }
    }

    public LocalDate getDiaCheckIn() {
        return diaCheckIn;
    }

    public void setDiaCheckIn(LocalDate diaCheckIn) {
        this.diaCheckIn = diaCheckIn;
    }

    public LocalDate getDiaCheckOut() {
        return diaCheckOut;
    }

    public void setDiaCheckOut(LocalDate diaCheckOut) {
        this.diaCheckOut = diaCheckOut;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public Double getMontoPagar() {
        return montoPagar;
    }

    public boolean getEstaActiva() {
        return estaActiva;
    }

    public void setEstaActiva(boolean estaActiva) {
        this.estaActiva = estaActiva;
    }

    //endregion

    public void setMontoPagar(Double montoPagar) {
        this.montoPagar = montoPagar;
    }

    @Override
    public String toString() {
        return "{" +
                "\tIdReserva: " + id +
                "||\tCliente: " + cliente.getNombre() + ", " + cliente.getApellido() +
                "\n\tHabitacion: " + habitacion +
                "\n\tSaldo: $" + montoPagar +
                "||\tCheck In: " + diaCheckIn +
                "||\tCheck Out: " + diaCheckOut +
                "||" + "}\n";
    }
}

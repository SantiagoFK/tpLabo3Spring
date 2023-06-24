package sistemaHotelUtn.spring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import sistemaHotelUtn.gestionClientes.Cliente;
import sistemaHotelUtn.gestionClientes.GestionClientes;
import sistemaHotelUtn.gestionEmpleados.Empleado;
import sistemaHotelUtn.gestionEmpleados.GestionEmpleados;
import sistemaHotelUtn.gestionEventos.Evento;
import sistemaHotelUtn.gestionEventos.GestionEventos;
import sistemaHotelUtn.gestionHabitaciones.GestionHabitaciones;
import sistemaHotelUtn.gestionHabitaciones.Habitacion;
import sistemaHotelUtn.gestionReservas.GestionReservas;
import sistemaHotelUtn.gestionReservas.Reserva;


@Controller
public class ControladorGeneral
{
    private GestionEventos gestionEventos = new GestionEventos();
    private GestionEmpleados gestionEmpleados = new GestionEmpleados();
    private GestionClientes gestionClientes = new GestionClientes();
    private GestionReservas gestionReservas = new GestionReservas();
    private GestionHabitaciones gestionHabitaciones = new GestionHabitaciones();
    //private Usuario usuarioActual = null;
    @GetMapping("/")
    public String inicio()
    {
        return "index";
    }

    @GetMapping("/clientes")
    public String clientes()
    {
        return "clientes";
    }

    @GetMapping("/eventos")
    public String eventos(Model model)
    {
        gestionEventos.cargarEventosJson();
        model.addAttribute( "eventos", gestionEventos.getLista());
        return "eventos";
    }

    @PostMapping("/agregarEvento")
    public String agregarEvento(Evento evento)
    {
        evento.asignarIdAutoincremental();
        this.gestionEventos.agregar(evento);
        this.gestionEventos.guardarEventosJson();
        return "redirect:/";
    }

    @PostMapping("/agregarCliente")
    public String agregarCliente(Cliente cliente)
    {
        return "clientes";
    }

/*    @PostMapping("/agregarEmpleado")
    public String agregarEmpleado(Empleado empleado)
    {
        ;
    }

    @PostMapping("/agregarReserva")
    public String agregarReserva(Reserva reserva)
    {
        ;
    }

    @PostMapping("/agregarHabitacion")
    public String agregarHabitacion(Habitacion reserva)
    {
        ;
    }*/

    @GetMapping("/reservas")
    public String reservas()
    {
        return "reservas";
    }

    @GetMapping("/empleados")
    public String empleados()
    {
        return "empleados";
    }

    @GetMapping("/habitaciones")
    public String habitaciones()
    {
        return "habitaciones";
    }
}

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
        gestionEventos.agregar(evento);
        gestionEventos.guardarEventosJson();
        return "redirect:/";
    }

    @GetMapping("/clientes")
    public String clientes(Model model)
    {
        gestionClientes.cargarClientesJson();
        model.addAttribute("clientes", gestionClientes.getLista());
        return "clientes";
    }

    @PostMapping("/agregarCliente")
    public String agregarCliente(Cliente cliente)
    {
        cliente.asignarIdAutoincremental();
        gestionClientes.agregar(cliente);
        gestionClientes.guardarClientesJson();
        return "clientes";
    }

    @GetMapping("/empleados")
    public String empleados(Model model)
    {
        gestionEmpleados.cargarEmpleadosJson();
        model.addAttribute( "empleados", gestionEmpleados.getLista());
        return "empleados";
    }

    @PostMapping("/agregarEmpleado")
    public String agregarEmpleado(Empleado empleado)
    {
        empleado.asignarIdAutoincremental();
        gestionEmpleados.agregar(empleado);
        gestionEmpleados.guardarEmpleadosJson();
        return "empleados";
    }

    @GetMapping("/reservas")
    public String reservas(Model model)
    {
        gestionClientes.cargarClientesJson();
        gestionReservas.cargarReservasJson();
        gestionHabitaciones.cargarHabitacionesJson();
        model.addAttribute("reservas", gestionReservas.getLista());
        model.addAttribute("clientes", gestionClientes.getLista());
        model.addAttribute("habitaciones", gestionHabitaciones.getLista());
        return "reservas";
    }

    @PostMapping("/agregarReserva")
    public String agregarReserva(Reserva reserva, Cliente cliente, Habitacion habitacion)
    {
        reserva.asignarIdAutoincremental();
        //reserva.setCliente(cliente);
        //reserva.setHabitacion(habitacion);
        gestionReservas.agregar(reserva);
        gestionReservas.guardarReservasJson();
        return "reservas";
    }

    @PostMapping("/agregarReserva")
    public String agregarReserva(Reserva reserva)
    {
        reserva.asignarIdAutoincremental();
        //reserva.setCliente(cliente);
        //reserva.setHabitacion(habitacion);
        gestionReservas.agregar(reserva);
        gestionReservas.guardarReservasJson();
        return "reservas";
    }

    @GetMapping("/habitaciones")
    public String habitaciones(Model model)
    {
        gestionHabitaciones.cargarHabitacionesJson();
        model.addAttribute("habitaciones", gestionHabitaciones.getLista());
        return "habitaciones";
    }

    @PostMapping("/agregarHabitacion")
    public String agregarHabitacion(Habitacion habitacion)
    {
        habitacion.asignarIdAutoincremental();
        gestionHabitaciones.agregar(habitacion);
        gestionHabitaciones.guardarHabitacionJson();
        return "habitaciones";
    }
}

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
import sistemaHotelUtn.gestionHabitaciones.ServiciosHabitacion;
import sistemaHotelUtn.gestionHabitaciones.TipoHabitacion;
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
        return "redirect:/eventos";
    }

    @PostMapping("/eliminarEvento")
    public String eliminarEvento(Integer idEvento)
    {
        gestionEventos.cargarEventosJson();
        boolean eliminado = false;

        try
        {
            eliminado = gestionEventos.eliminarEventoPorId(idEvento);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        if( eliminado = true )
            gestionEventos.guardarEventosJson();

        return "redirect:/eventos";
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
        return "redirect:/clientes";
    }

    @PostMapping("/eliminarCliente")
    public String eliminarCliente(Integer idCliente)
    {
        gestionClientes.cargarClientesJson();
        boolean eliminado = false;

        try
        {
            eliminado = gestionClientes.eliminarClientePorId(idCliente);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        if( eliminado = true )
            gestionClientes.guardarClientesJson();

        return "redirect:/clientes";
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
        return "redirect:/empleados";
    }

    @PostMapping("/eliminarEmpleado")
    public String eliminarEmpleado(Integer idEmpleado)
    {
        gestionEmpleados.cargarEmpleadosJson();
        boolean eliminado = false;

        try
        {
            eliminado = gestionEmpleados.eliminarEmpleadoPorId(idEmpleado);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        if( eliminado = true )
            gestionEmpleados.guardarEmpleadosJson();

        return "redirect:/empleados";
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
    public String agregarReserva(Reserva reserva)
    {
        reserva.asignarIdAutoincremental();
        gestionReservas.agregar(reserva);
        gestionReservas.guardarReservasJson();
        return "redirect:/reservas";
    }

    @PostMapping("/eliminarReserva")
    public String eliminarReserva(Integer idReserva)
    {
        gestionReservas.cargarReservasJson();
        boolean eliminado = false;

        try
        {
            eliminado = gestionReservas.eliminarReservaPorId(idReserva);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        if( eliminado = true )
            gestionReservas.guardarReservasJson();

        return "redirect:/reservas";
    }

    @GetMapping("/habitaciones")
    public String habitaciones(Model model)
    {
        gestionHabitaciones.cargarHabitacionesJson();
        model.addAttribute("habitaciones", gestionHabitaciones.getLista());
        model.addAttribute("tipos", TipoHabitacion.values());
        model.addAttribute("servicios", ServiciosHabitacion.values());
        return "habitaciones";
    }

    @PostMapping("/agregarHabitacion")
    public String agregarHabitacion(Habitacion habitacion)
    {
        habitacion.asignarIdAutoincremental();
        gestionHabitaciones.agregar(habitacion);
        gestionHabitaciones.guardarHabitacionJson();
        return "redirect:/habitaciones";
    }

    @PostMapping("/eliminarHabitacion")
    public String eliminarHabitacion(Integer idHabitacion)
    {
        gestionHabitaciones.cargarHabitacionesJson();
        boolean eliminado = false;

        try
        {
            eliminado = gestionHabitaciones.eliminarHabitacionPorId(idHabitacion);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        if( eliminado = true )
            gestionHabitaciones.guardarHabitacionJson();

        return "redirect:/habitaciones";
    }

}

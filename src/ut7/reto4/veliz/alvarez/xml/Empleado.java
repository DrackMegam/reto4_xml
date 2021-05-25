package ut7.reto4.veliz.alvarez.xml;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author David Veliz
 * @author Laura Álvarez
 */
@XmlRootElement
public class Empleado {
    private String nombre;
    private String apellidoPrimero;
    private String apellidoSegundo;
    private String fechaNacimiento;
    private String domicilio;
    private int telefono;

    public Empleado(String nombre, String apellidoPrimero, String apellidoSegundo, String fechaNacimiento, String domicilio, int telefono) {
        this.nombre = nombre;
        this.apellidoPrimero = apellidoPrimero;
        this.apellidoSegundo = apellidoSegundo;
        this.fechaNacimiento = fechaNacimiento;
        this.domicilio = domicilio;
        this.telefono = telefono;
    }

    public Empleado() {
        this.nombre = "";
        this.apellidoPrimero = "";
        this.apellidoSegundo = "";
        this.fechaNacimiento = "";
        this.domicilio = "";
        this.telefono = 123456789;
    }
    

    public String getNombre() {
        return nombre;
    }

    @XmlElement
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPrimero() {
        return apellidoPrimero;
    }

    public void setApellidoPrimero(String apellidoPrimero) {
        this.apellidoPrimero = apellidoPrimero;
    }

    public String getApellidoSegundo() {
        return apellidoSegundo;
    }

    public void setApellidoSegundo(String apellidoSegundo) {
        this.apellidoSegundo = apellidoSegundo;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    @XmlElement
    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDomicilio() {
        return domicilio;
    }

    @XmlElement
    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public int getTelefono() {
        return telefono;
    }

    @XmlElement
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    private static String fechaNacimiento() {
        DateFormat df = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss z", Locale.ENGLISH);
        df.setTimeZone(TimeZone.getTimeZone("GMT"));
        return df.format(new Date());
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", apellidoPrimero=" + apellidoPrimero + ", apellidoSegundo=" + apellidoSegundo + ", fechaNacimiento=" + fechaNacimiento + ", domicilio=" + domicilio + ", telefono=" + telefono + '}';
    }
    
    
    
}
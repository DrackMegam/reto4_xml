/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ut7.reto4.veliz.alvarez.xml;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;

/**
 * @author LOR
 * @author DrackMegam
 */
public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String opcionUsuario = null;

        while (true) {
            System.out.println("1. Crear XML empleado.");
            System.out.println("2. Leer XML empleado.");
            do {
                System.out.printf("|> ");
                opcionUsuario = scan.nextLine();
            } while (!opcionUsuario.equals("1") && !opcionUsuario.equals("2"));
            if (opcionUsuario.equals("1")) {
                escribirXML();
            } else if (opcionUsuario.equals("2")) {
                leerXML();
            }
        }

    }

    private static void escribirXML() {
        try {
            // Creación del objeto persona.
            Persona objetoPersona = crearPersona();

            File archivo = new File(objetoPersona.getNombre()
                    +objetoPersona.getApellidoPrimero()
                    +objetoPersona.getApellidoSegundo()+".xml");
            // Flujo de salida y transformador a XML.
            XMLStreamWriter escribirXML = XMLOutputFactory.newFactory()
                    .createXMLStreamWriter(new BufferedOutputStream(new FileOutputStream(archivo)), "UTF-8");
            JAXBContext jaxbC = JAXBContext.newInstance(Persona.class);
            Marshaller transformador = jaxbC.createMarshaller();
            transformador.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
                    true);

            // Transformo el objeto a XML y flusheo para cerrar datos.
            transformador.marshal(objetoPersona, escribirXML);
            escribirXML.flush();
            escribirXML.close();
        } catch (FileNotFoundException | JAXBException | XMLStreamException e) {
            System.err.println(e);
        }
    }

    private static void leerXML() {
        // Objeto persona y selector de archivos XML.
        Persona objetoPersona = null;
        String nombreArchivo;
        Scanner scan = new Scanner(System.in);
        System.out.println("Nombre del archivo XML (sin extensión)");
        do {
            System.out.printf("|> ");
            nombreArchivo = scan.nextLine();
        } while (nombreArchivo.trim().length() == 0);
        File archivo = new File(nombreArchivo+".xml");

        try {

            // Flujo y transformador
            XMLStreamReader leerXML = XMLInputFactory.newFactory()
                    .createXMLStreamReader(new BufferedInputStream(new FileInputStream(archivo)), "UTF-8");
            JAXBContext jaxbC = JAXBContext.newInstance(Persona.class);
            Unmarshaller transformador = jaxbC.createUnmarshaller();

            // Añado datos al objeto desde el XML.
            objetoPersona = (Persona) transformador.unmarshal(leerXML);
            leerXML.close();

        } catch (IOException | XMLStreamException | JAXBException ex) {
            System.out.println("Error: " + ex.getLocalizedMessage());
        }

        if (objetoPersona != null) {
            System.out.println(objetoPersona.toString());
        }
    }

    private static Persona crearPersona() {
        Scanner scan= new Scanner(System.in);
        String opcion;
        String nombre, apellido1, apellido2, domicilio,fechaNac;
        int numero;

        System.out.println("Nombre: ");
        do {
            System.out.printf("|> ");
            opcion = scan.nextLine();
        } while (opcion.trim().length() == 0);
        nombre=opcion;
        opcion=null;
        System.out.println("Primer apellido: ");
        do {
            System.out.printf("|> ");
            opcion = scan.nextLine();
        } while (opcion.trim().length() == 0);
        apellido1=opcion;
        opcion=null;
        System.out.println("Segundo apellido: ");
        do {
            System.out.printf("|> ");
            opcion = scan.nextLine();
        } while (opcion.trim().length() == 0);
        apellido2=opcion;
        opcion=null;
        System.out.println("Domicilio: ");
        do {
            System.out.printf("|> ");
            opcion = scan.nextLine();
        } while (opcion.trim().length() == 0);
        domicilio=opcion;
        opcion=null;
        System.out.println("Fecha nacimiento: ");
        do {
            System.out.printf("|> ");
            opcion = scan.nextLine();
        } while (opcion.trim().length() == 0);
        fechaNac=opcion;
        opcion=null;
        System.out.println("Nº teléfono: ");
        do {
            System.out.printf("|> ");
            opcion = scan.nextLine();
        } while (opcion.trim().length() != 9);
        numero=Integer.parseInt(opcion);
        opcion=null;

        return new Persona(nombre,apellido1,apellido2,fechaNac,domicilio,numero);
    }

}

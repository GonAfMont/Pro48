package P48;

import P48.*;
import javax.xml.bind.*;
import javax.xml.bind.annotation.*;
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        try {
            JAXBContext JAXBCont;
            JAXBCont = JAXBContext.newInstance(Autos.class);
            Unmarshaller um = JAXBCont.createUnmarshaller();
            Autos autos = (Autos) um.unmarshal(new File("src\\main\\resources\\Coches.xml"));

            Marshaller m = JAXBCont.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            Scanner entrada = new Scanner(System.in);

            boolean consola = true;
            while (consola) {
                System.out.println("\nElija la opción deseada.:\n");
                System.out.println("1. Mostrar el catálogo entero.");
                System.out.println("2. Añadir nuevos autos al catálogo.");
                System.out.println("3. Buscar autos mediante el tipo de marca.");
                System.out.println("4. Salir de la consola.");
                System.out.println("");
                int numero = entrada.nextInt();
                entrada.nextLine();

                switch (numero) {
                    case 1:
                        autos.ImpAutos();
                        break;
                    case 2:
                        Transmision transmision = new Transmision(1);
                        int id = autos.getAutos().length + 1;
                        auto newAuto = new auto(transmision, id);
                        autos.añadirAutos(newAuto);
                        m.marshal(autos, new File("src\\main\\resources\\Autos.xml"));
                        break;
                    case 3:
                        try {
                            System.out.println("Elija qué autos quieres ver según su marca:");
                            for (auto auto : autos.getAutos()) {
                                System.out.println(auto.getMarca());
                            }
                            String modelo = entrada.nextLine();
                            autos.buscarAutos(modelo);
                        } catch (InputMismatchException | IndexOutOfBoundsException e) {
                            System.out.println("Debes usar números enteros y que estén dentro de las opciones");
                        }
                        break;
                    case 4:
                        consola = false;
                        break;
                    default:
                        System.out.println("Procure que el dato que hayas insertado este dentro de las opciones posibles");
                }
            }
            entrada.close();
            m.marshal(autos, System.out);

        } catch (JAXBException | InputMismatchException e) {
            e.printStackTrace();
        }

    }
}

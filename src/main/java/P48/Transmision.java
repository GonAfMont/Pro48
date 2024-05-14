package P48;

import java.util.*;
import P48.*;
import javax.xml.bind.annotation.*;

@XmlRootElement(name="transmision")
@XmlType(propOrder = {"tipo", "velocidades"})
@XmlAccessorType(XmlAccessType.FIELD)

public class Transmision {
	private static Scanner scanner = new Scanner(System.in);
	@XmlElement(name = "tipo")
	private String tipo;
	@XmlElement(name = "velocidadeses")
	private Integer velocidades;
	
	public Transmision(){}
	public Transmision(String tipo,Integer velocidades){
		this.tipo = tipo;
		this.velocidades = velocidades;
	}
	
	public Transmision(int numero) {
		if (numero == 1) {
			this.tipo = EscribirTipo();
	        this.velocidades = EscribirVelocidades(); 
		}
	}
	
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String EscribirTipo() {
	    try {
	        System.out.println("Selecciona tipo de transmisión.");
	        String[] tiposTransmision = {"manual", "automática"};
	        for (int i = 0; i < tiposTransmision.length; i++) {
	            System.out.println((i + 1) + ". " + tiposTransmision[i]);
	        }
	        int numero = scanner.nextInt();
	        scanner.nextLine();
	        if (numero < 1 || numero > tiposTransmision.length) {
	            throw new IndexOutOfBoundsException();
	        }
	        String tipoTransmision = tiposTransmision[numero - 1];
	        return tipoTransmision;
	    } catch (InputMismatchException | IndexOutOfBoundsException e) {
	        System.out.println("Selecciona una de los opciones disponibles.");
	        return EscribirTipo();
	    }
	}
	
	public Integer getVelocidades() {
		return velocidades;
	}
	public void setVelocidades(Integer velocidades) {
		this.velocidades = velocidades;
	}
	
	public Integer EscribirVelocidades() {
	    try {
	        System.out.println("Selecciona la velocidad de la transmisión.");
	        int velocidades = scanner.nextInt();
	        scanner.nextLine();
	        if (velocidades < 0) {
	            throw new InputMismatchException();
	        }
	        return velocidades;
	    } catch (InputMismatchException e) {
	        System.out.println("Seleccina un número entero válido.");
	        return EscribirVelocidades();
	    }
	}		 

}
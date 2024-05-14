
package P48;

import java.util.*;
import P48.*;
import javax.xml.bind.annotation.*;

@XmlRootElement(name="auto")
@XmlType(propOrder = {"id","marca", "modelo", "año", "color", "tipo_motor", "cilindrada", "potencia", "transmision"})
@XmlAccessorType(XmlAccessType.FIELD)

public class auto {
	private static Scanner sc = new Scanner(System.in);
	@XmlAttribute(name = "id", required = true)
	private int id;
	@XmlElement(name = "marca")
	private String marca;
	@XmlElement(name = "modelo")
	private String modelo;
	@XmlElement(name = "año")
	private Integer año;
	@XmlElement(name = "color")
	private String color;
	@XmlElement(name = "tipo_motor")
	private String tipo_motor;
	@XmlElement(name = "cilindrada")
	private String cilindrada;
	@XmlElement(name = "potencia")
	private String potencia;
	@XmlElement(name = "transmision")
	private Transmision transmision;

	
	public auto(Integer id,String marca, String modelo, Integer año, String color, String tipo_motor, String cilindrada, String potencia,Transmision  transmision){
		this.marca = marca;
		this.modelo = modelo;
		this.año = año;
		this.color = color;
		this.tipo_motor = tipo_motor;
		this.cilindrada = cilindrada;
		this.potencia = potencia;
		this.transmision = transmision;
	    this.id = id;
	}

	auto(Transmision transmision, int id) {
		// TODO Auto-generated constructor stub
		this.transmision = transmision;
		 this.id = id;
	}

	public void Auto(Transmision transmision, int id) {
		this.transmision = transmision;
		this.id = id;
		this.EscrbirMarca();
		this.EscrbirModelo();
		this.EscrbirAño();
		this.EscrbirColor();
		this.EscrbirTipo_motor();
		this.EscrbirCilindrada();
		this.EscrbirPotencia();
	}
	
	
	public int getId() {
		return id;
	}
	public void setIdentificacion(int id) {
		this.id = id;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public Integer getAño() {
		return año;
	}
	public void setAño(Integer año) {
		this.año = año;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getTipo_motor() {
		return tipo_motor;
	}
	public void setTipo_motor(String tipo_motor) {
		this.tipo_motor = tipo_motor;
	}
	public String getCilindrada() {
		return cilindrada;
	}
	public void setCilindrada(String cilindrada) {
		this.cilindrada = cilindrada;
	}
	public String getPotencia() {
		return potencia;
	}
	public void setPotencia(String potencia) {
		this.potencia = potencia;
	}
	
	public Transmision getTransmision() {
		return transmision;
	}
	public void setTransmision(Transmision transmision) {
		this.transmision = transmision;
	}
	
	
	public void EscrbirMarca() {
		this.marca = sc.nextLine();
	}
	
	public void EscrbirModelo() {
        this.modelo = sc.nextLine();
    }
	
	public void EscrbirAño() {
		try {
        this.año = sc.nextInt();
        sc.nextLine();
		} catch (InputMismatchException e) {
			System.out.println("Debe introducir un número.");
            sc.nextLine();
            this.EscrbirAño();
		};
	}

	public void EscrbirColor() {
        this.color = sc.nextLine();
    }
	
	public void EscrbirTipo_motor() {
        this.tipo_motor = sc.nextLine();;
	}
	
	public void EscrbirCilindrada() {
        this.cilindrada = sc.nextLine();;
	}
	
	public void EscrbirPotencia() {
        this.potencia = sc.nextLine();;
	}
	
	
	public void ImpAuto() {
		System.out.println("Marca: " + this.marca);
		System.out.println("Modelo: " + this.modelo);
		System.out.println("Año: " + this.año);
		System.out.println("Color: " + this.color);
		System.out.println("Tipo de motor:  " + this.tipo_motor);
		System.out.println("Cilindrada: " + this.cilindrada);
		System.out.println("Potencia: " + this.potencia);
		if (this.transmision.getVelocidades() != null) {
			System.out.println("Velocidad de tranmisión:  " + this.transmision.getVelocidades());
		}
		System.out.println("Tipo de transmisión: " + this.transmision.getTipo());
		
	}
}

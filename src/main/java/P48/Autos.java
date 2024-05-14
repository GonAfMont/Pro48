package P48;

import P48.*;
import javax.xml.bind.annotation.*;

@XmlRootElement(name="autos")
@XmlType(propOrder = {"auto"})
@XmlAccessorType(XmlAccessType.FIELD)


public class Autos {
    @XmlElementWrapper(name = "autos")
    @XmlElement(name = "auto")
    private auto[] auto;

    public Autos() {}

    public Autos(auto[] auto) {
        this.auto = auto;
    }

    public auto[] getAutos() {
        return auto;
    }

    public void setAutos(auto[] auto) {
        this.auto = auto;
    }

    public void ImpAutos() {
        for (int i = 0; i < auto.length; i++) {
            auto[i].ImpAuto();
        }
    }

    public void añadirAutos(auto newAuto) {
    	auto[] newArray = new auto[auto.length + 1];
        System.arraycopy(auto, 0, newArray, 0, auto.length);
        newArray[auto.length] = newAuto;
        this.auto = newArray;
    }

    public void buscarAutos(String modelo) {
        for (auto auto : auto) {
            if (auto.getMarca().equals(modelo)) {
                auto.ImpAuto();
            }
        }
    }
}
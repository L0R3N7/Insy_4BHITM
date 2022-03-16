package model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "Route")
public class Route {
    private String name;
    private GPSList gpsList;

    public Route(){}

    @XmlAttribute(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement(name = "GPSList")
    public GPSList getGpsList() {
        return gpsList;
    }

    public void setGpsList(GPSList gpsList) {
        this.gpsList = gpsList;
    }

    @Override
    public String toString() {
        return "Route{" +
                "name='" + name + '\'' +
                ", gpsList=" + gpsList.toString() +
                '}';
    }
}

package model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "Route")
public class Route {
    private String name;
    private Double avg_dur;
    private Double total_dist;
    private GPSList gpsList;

    public Route(){}

    @XmlAttribute(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlAttribute(name = "avg_duration")
    public Double getAvg_dur() {
        return avg_dur;
    }

    public void setAvg_dur(Double avg_dur) {
        this.avg_dur = avg_dur;
    }

    @XmlAttribute(name = "total_distant")
    public Double getTotal_dist() {
        return total_dist;
    }

    public void setTotal_dist(Double total_dist) {
        this.total_dist = total_dist;
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

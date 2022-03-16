package model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "GPS")
public class GPS {
    private Double longitude, latitude;
    private Integer order;

    public GPS(Double longitude, Double latitude, Integer order) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.order = order;
    }

    public GPS() {
    }


    @XmlAttribute
    public Double getLongitude() {
        return longitude;
    }

    @XmlAttribute
    public Double getLatitude() {
        return latitude;
    }

    @XmlAttribute
    public Integer getOrder() {
        return order;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "GPS{" +
                "longitude=" + longitude +
                ", latitude=" + latitude +
                ", order=" + order +
                '}';
    }
}

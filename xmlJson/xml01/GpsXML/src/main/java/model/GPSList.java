package model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "GPSList")
public class GPSList {

    private List<GPS> gps = new ArrayList<>();

    @XmlElement(name = "GPS")
    public List<GPS> getGps() {
        return gps;
    }

    public void addGps(GPS gps){
        this.gps.add(gps);
    }

    public void setGps(List<GPS> gps) {
        this.gps = gps;
    }

    @Override
    public String toString() {
        return "GPSList{" +
                "gpsList=" + gps.size() +
                '}';
    }
}

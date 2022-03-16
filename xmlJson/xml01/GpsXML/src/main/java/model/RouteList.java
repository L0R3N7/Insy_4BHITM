package model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "RouteList")
public class RouteList {
    private List<Route> route = new ArrayList<>();

    public RouteList() {
    }

    @XmlElement(name = "Route")
    public List<Route> getRoute() {
        return route;
    }

    public void addRoute(Route route){
        this.route.add(route);
    }

    public void setRoute(List<Route> route) {
        this.route = route;
    }

    @Override
    public String toString() {
        return "RouteList{" +
                "route=" + route +
                '}';
    }
}

import model.GPS;
import model.RouteList;

import java.time.Duration;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        XMLParser xmlParser = new XMLParser();

        RouteList routeList;


        // Start Program
        // read in XML
        routeList = xmlParser.unmarshall();

        if (routeList==null){
            System.err.println("File could not be read");
        }

        routeList.getRoute().get(routeList.getRoute().size()-1).setAvg_dur(1.30);
        routeList.getRoute().get(routeList.getRoute().size()-1).setTotal_dist(6.2);


        //Change routeList
        int max = routeList.getRoute().get(routeList.getRoute().size()-1).getGpsList().getGps().stream().max(Comparator.comparingInt(GPS::getOrder)).orElse(new GPS(0D, 0D, 0)).getOrder();
        routeList.getRoute().get(routeList.getRoute().size()-1).getGpsList().addGps(new GPS(Math.random()*10, Math.random()*10, max+1));


        // Saving routList to file
        xmlParser.marshall(routeList);
    }

}

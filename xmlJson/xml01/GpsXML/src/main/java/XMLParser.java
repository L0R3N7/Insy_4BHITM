import model.RouteList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class XMLParser {
    public XMLParser() {
    }

    public void marshall(RouteList routeList){
        try{
            JAXBContext jaxbContextGPS = JAXBContext.newInstance(RouteList.class);
            Marshaller marshallerGPS = jaxbContextGPS.createMarshaller();
            marshallerGPS.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshallerGPS.marshal(routeList, new File("src/main/resources/gps.xml"));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public RouteList unmarshall(){
        try{
            JAXBContext jc = JAXBContext.newInstance(RouteList.class);
            Unmarshaller ums = jc.createUnmarshaller();
            return  (RouteList) ums.unmarshal(new File("src/main/resources/gps.xml"));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }
}

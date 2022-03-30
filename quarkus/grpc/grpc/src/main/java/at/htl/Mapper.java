package at.htl;

import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;

@org.mapstruct.Mapper(componentModel = "cdi")
public interface Mapper {


    GetTrackInfoReply.Coordinate toProto(Model.Coordinate coordinate);
    GetTrackInfoReply.Rating toProto(Model.Rating rating);
    @Mapping(source = "id" , target = "userId")
    @Mapping(source = "dateOfBirth" , target = "dateOfBirth", qualifiedByName = "LocalDateMapLong")
    User toProto(Model.User user);
    TrackLog toProto(Model.TrackLog  trackLog);

    @Named("LocalDateMapLong")
    public static long map(LocalDate value){
        return value.toEpochSecond(LocalTime.NOON, ZoneOffset.UTC);
    }
    public static long map(LocalDateTime timestamp) {return timestamp.toEpochSecond(ZoneOffset.UTC);}
}

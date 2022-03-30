package at.htl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface Model {
    record Track(int id, String name, Rating rating, List<Coordinate> trackPoints){}
    record Coordinate(double longitude, double latitude){}
    record  User(int id, String firstName, String lastName, LocalDate dateOfBirth, boolean female){}
    record TrackLog(User user, LocalDateTime timestamp, int durationSeconds){}
    enum Rating {
        Easy,
        Intermediate,
        Difficult
    }
}
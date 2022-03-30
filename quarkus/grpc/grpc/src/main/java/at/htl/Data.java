package at.htl;

import javax.enterprise.context.ApplicationScoped;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@ApplicationScoped
public class Data {
    private final Map<Integer, Model.Track> tracks;
    private final Map<Integer, Model.User> users;
    private final Map<Integer, List<Model.TrackLog>> trackLogs;

    public Data() {
        this.tracks = new HashMap<>() {{
            put(1, new Model.Track(1, "Ameisberg Runde", Model.Rating.Intermediate, List.of(
                    new Model.Coordinate(123.4567, 32.1987),
                    new Model.Coordinate(124.0123, 32.8651),
                    new Model.Coordinate(123.9841, 32.6989)
            )));
            put(2, new Model.Track(2, "Fischteich Runde", Model.Rating.Easy, List.of(
                    new Model.Coordinate(88.9876, 45.1234),
                    new Model.Coordinate(88.9543, 45.5678),
                    new Model.Coordinate(88.8321, 45.9654),
                    new Model.Coordinate(88.7654, 46.1234)
            )));
            put (3, new Model.Track(3, "Klippensteig", Model.Rating.Difficult, List.of(
                    new Model.Coordinate(45.8744, 89.1234),
                    new Model.Coordinate(45.8745, 89.3456)
            )));
        }};
        this.users = new HashMap<>() {{
            put(1, new Model.User(1, "Horst", "Fuchs",
                    LocalDate.of(1988, 3,12), false));
            put(2, new Model.User(2, "Susi", "Schwammal",
                    LocalDate.of(1993, 7, 18), true));
        }};
        this.trackLogs = new HashMap<>();
    }

    public Collection<Model.Track> getAllTracks(){
        return Collections.unmodifiableCollection(this.tracks.values());
    }

    public Collection<Model.User> getAllUsers(){
        return Collections.unmodifiableCollection(this.users.values());
    }

    public Collection<Model.TrackLog> getUserLogs(int trackId){
        List<Model.TrackLog> logs;
        if (trackLogs.containsKey(trackId)){
            logs = trackLogs.get(trackId);
        } else {
            logs = new ArrayList<>();
        }
        return Collections.unmodifiableCollection(logs);
    }

    public boolean addUserTrackLog(int userId, int trackId, int durationSeconds){
        if (!this.users.containsKey(userId) || !this.tracks.containsKey(trackId)){
            return false;
        }
        var user = this.users.get(userId);
        List<Model.TrackLog> logs;
        if (trackLogs.containsKey(trackId)){
            logs = trackLogs.get(trackId);
        } else {
            logs = new ArrayList<>();
            trackLogs.put(trackId, logs);
        }
        logs.add(new Model.TrackLog(user, LocalDateTime.now(), durationSeconds));
        return true;
    }
}
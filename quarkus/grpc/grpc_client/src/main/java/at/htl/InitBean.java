package at.htl;


import io.quarkus.grpc.GrpcClient;
import io.quarkus.runtime.StartupEvent;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@ApplicationScoped
public class InitBean {

    @GrpcClient
    Track client;

    private static final Logger LOGGER = Logger.getLogger("Init");

    public void onStart(@Observes StartupEvent ev) {
        this.client.getTrackIds(GetTrackIdsRequest.getDefaultInstance()).subscribe().with(reply -> {
            var ids = reply.getIdList();
            var str = ids.stream().map(Object::toString)
                    .collect(Collectors.joining(", "));
            LOGGER.info("Received the track IDs: " + str);
            for (var id : ids){
                printTrackInfo(id);
            }
        });
        this.client.getUsers(GetUsersRequest.getDefaultInstance()).subscribe().with(getUsersReply -> {
            var users = getUsersReply.getUserList();
            var str = users.stream().map(Object::toString)
                    .collect(Collectors.joining(", "));
            LOGGER.info("User: \n"+str);
        });

        this.addTrackLogs();
        LOGGER.info("The application is starting...");
    }

    private void addTrackLogs() {
        addTrackLog(1, 1, 3600);
        addTrackLog(1, 5, 200);
        addTrackLog(19, 2, 4800);
        addTrackLog(2,2, 6781);
        addTrackLog(1, 3, 5321);
        addTrackLog(1, 3, 4988);
        addTrackLog(2, 1, 3451);
        this.client.getTrackInfoByTrack(GetTrackInfoByTrackRequest.newBuilder().setTrackId(1).build()).subscribe().with(getUsersReply -> {
            var str = getUsersReply.toString();
            System.out.println("tackinfo from 1\n"+str);
        });
    }

    private void addTrackLog(int userId, int trackId, int durationSecs) {
        var request = AddTrackLogRequest.newBuilder()
                .setUserId(userId)
                .setTrackId(trackId)
                .setDurationSeconds(durationSecs)
                .build();
        this.client.addTrackLog(request).subscribe().with(reply -> {
            LOGGER.info("Adding track log for track #" + trackId + " and user #"
                    + userId + " was a success: " + reply.getSuccess());
        });
    }

    private void printTrackInfo(int trackId){
        this.client.getTrackInfo(GetTrackInfoRequest.newBuilder().setId(trackId).build())
                .subscribe()
                .with(reply -> {
                    LOGGER.info("Data for track " + trackId + ": " + reply.toString());
                });
    }
}
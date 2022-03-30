package at.htl;

import io.quarkus.grpc.GrpcService;
import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.unchecked.Unchecked;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@GrpcService
public final class TrackService implements Track {

    private final Data data;
    private final Mapper mapper;

    public TrackService(Data data, Mapper mapper) {
        this.data = data;
        this.mapper = mapper;
    }

    @Override
    public Uni<GetUsersReply> getUsers(GetUsersRequest request) {
        return Uni.createFrom().item(()->{
            var users = this.data.getAllUsers().stream().map(this.mapper::toProto).toList();
            return GetUsersReply.newBuilder().addAllUser(users).build();
        });
    }

    @Override
    public Uni<GetTrackInfoByTrackReply> getTrackInfoByTrack(GetTrackInfoByTrackRequest request) {
        var result = data.getUserLogs(request.getTrackId()).stream().collect(Collectors.toList());
        var builder = GetTrackInfoByTrackReply.newBuilder();
        var trackLogBuilder = TrackLog.newBuilder();

        for (Model.TrackLog r : result) {
            trackLogBuilder.setDurationSeconds(r.durationSeconds());
            trackLogBuilder.setTimestamp(Mapper.map(r.timestamp()));
            trackLogBuilder.setUser(mapper.toProto(r.user()));
            builder.addTracklog(trackLogBuilder.build());
        }

        return Uni.createFrom().item(()->{
            return builder.build();
        });

    }

    @Override
    public Uni<GetTrackIdsReply> getTrackIds(GetTrackIdsRequest request) {
        return Uni.createFrom().item(()->{
            var tracksIds = this.data.getAllTracks().stream().map(Model.Track::id).toList();
            return GetTrackIdsReply.newBuilder().addAllId(tracksIds).build();
        });
    }

    @Override
    public Uni<GetTrackInfoReply> getTrackInfo(GetTrackInfoRequest request) {
        return Uni.createFrom().item(Unchecked.supplier(()->{
            var track = this.data.getAllTracks().stream()
                    .filter(t -> t.id() == request.getId()).findAny().orElse(null);
            var builder = GetTrackInfoReply.newBuilder();
            if (track == null){
                throw new RuntimeException("Track with id " + request.getId() + " not found");
            }
            builder.setId(track.id());
            builder.setName(track.name());
            builder.setRating(this.mapper.toProto(track.rating()));
            builder.addAllCoordinate(track.trackPoints().stream().map(this.mapper::toProto).toList());
            return builder.build();
        }));
    }

    @Override
    public Uni<AddTrackLogReply> addTrackLog(AddTrackLogRequest request) {
        return Uni.createFrom().item(()->{
            var success = this.data.addUserTrackLog(request.getUserId(),
                    request.getTrackId(), request.getDurationSeconds());
            return AddTrackLogReply.newBuilder().setSuccess(success).build();
        });
    }
}
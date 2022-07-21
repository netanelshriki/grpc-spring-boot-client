package net.dev.grpcspringclient.services;


import net.dev.speakers.*;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class SpeakerServiceClient extends SpeakerManagerGrpc.SpeakerManagerImplBase {

    @GrpcClient("speaker-manager")
    private SpeakerManagerGrpc.SpeakerManagerBlockingStub speakerManager;

    public CreateSpeakerResponse createSpeaker(String name) {

        CreateSpeakerRequest request = CreateSpeakerRequest.newBuilder()
                .setName(name)
                .setLastName("shriki")
                .setAge(24)
                .build();

        return speakerManager.createSpeaker(request);

    }


    public DeleteSpeakerResponse deleteSpeaker(int id) {

        DeleteSpeakerRequest deleteSpeakerRequest = DeleteSpeakerRequest.newBuilder()
                .setId(id)
                .build();

        return speakerManager.deleteSpeaker(deleteSpeakerRequest);

    }
}

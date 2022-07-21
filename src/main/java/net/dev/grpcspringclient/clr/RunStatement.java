package net.dev.grpcspringclient.clr;

import net.dev.grpcspringclient.services.SpeakerServiceClient;
import lombok.RequiredArgsConstructor;
import net.dev.speakers.CreateSpeakerResponse;
import net.dev.speakers.DeleteSpeakerResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
@RequiredArgsConstructor
public class RunStatement implements CommandLineRunner {

    private final SpeakerServiceClient speakerServiceClient;

    @Override
    public void run(String... args) throws Exception {

        CreateSpeakerResponse createSpeakerResponse = speakerServiceClient.createSpeaker("david");

        System.out.println(createSpeakerResponse);

        System.out.println("-------------------------------------------------------------");

        DeleteSpeakerResponse deleteSpeakerResponse = speakerServiceClient.deleteSpeaker(5);

        System.out.println(deleteSpeakerResponse);


    }
}

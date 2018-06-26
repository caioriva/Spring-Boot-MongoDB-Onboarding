package com.criva.onboardingproject.model.vo.message;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "context")
public class ContextVO {

    @Id
    @Field("_id")
    @Getter
    private String id;

    @Field("recipient_participant_id")
    @Getter
    @Setter
    private String recipientParticipantId;

    @Field("received")
    @Getter
    @Setter
    private Boolean received;

    @Field("viewed")
    @Getter
    @Setter
    private Boolean viewed;

    public ContextVO() {
    }

    public ContextVO(String id, String recipientParticipantId, Boolean received, Boolean viewed) {
        this.id = id;
        this.recipientParticipantId = recipientParticipantId;
        this.received = received;
        this.viewed = viewed;
    }

    public ContextVO(String recipientParticipantId, Boolean received, Boolean viewed) {

        this.recipientParticipantId = recipientParticipantId;
        this.received = received;
        this.viewed = viewed;
    }
}

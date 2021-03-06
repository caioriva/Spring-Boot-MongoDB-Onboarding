package com.criva.onboardingproject.service;

import com.criva.onboardingproject.model.dao.RoomDAO;
import com.criva.onboardingproject.model.dto.RoomCreation;
import com.criva.onboardingproject.model.vo.room.Participant;
import com.criva.onboardingproject.model.enumerator.Role;
import com.criva.onboardingproject.model.vo.room.Room;
import com.criva.onboardingproject.service.participant.ParticipantService;
import com.criva.onboardingproject.service.room.RoomService;
import com.criva.onboardingproject.service.room.RoomServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.*;

public class RoomServiceTests {

    private RoomDAO roomDAO;
    private ParticipantService participantService;

    private RoomService roomService;

    @Before
    public void setUp() {

        roomDAO = mock(RoomDAO.class);
        participantService = mock(ParticipantService.class);

        roomService = new RoomServiceImpl(roomDAO, participantService);
    }

    @Test
    public void testRoomCreatedWithCorrectParticipantsNumber() {

        RoomCreation roomCreation = new RoomCreation("", "", Arrays.asList("", ""));

        when(participantService.saveParticipants(anyList())).thenReturn(
                Arrays.asList(new Participant("", "", Role.OWNER),
                        new Participant("", "", Role.GUEST),
                        new Participant("", "", Role.GUEST)));
        when(roomDAO.save(any(Room.class))).thenReturn(
                new Room("", "", Arrays.asList("", "", "")));

        Room room = roomService.createRoom(roomCreation);

        Assert.assertEquals(3, room.getParticipantsId().size());
        verify(participantService, times(1)).saveParticipants(anyList());
        verify(roomDAO, times(1)).save(any(Room.class));
    }
}

package edu.umb.cs680.hw06;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class DVDPlayerTest {

    @Test
    public void test() {
    	DVDPlayer playerInstance = DVDPlayer.getInstance();
        State state1 = playerInstance.getState();
//        state1.openCloseButtonPushed();
        assertEquals(DrawerClosedNotPlaying.getInstance(), state1);
        
//
        playerInstance.playButtonPushed();
        State state2 = playerInstance.getState();
        assertEquals(DrawerClosedPlaying.getInstance(), state2);
        
    }
    
    @Test
    public void test_2() {
    	DVDPlayer playerInstance = DVDPlayer.getInstance();
        State state1 = playerInstance.getState();
//        state1.openCloseButtonPushed();
        assertEquals(DrawerClosedNotPlaying.getInstance(), state1);
        
//
        playerInstance.playButtonPushed();
        State state2 = playerInstance.getState();
        assertEquals(DrawerClosedPlaying.getInstance(), state2);
        
        playerInstance.stopButtonPushed();
        assertEquals(DrawerClosedNotPlaying.getInstance(), DVDPlayer.getInstance().getState());
        
    }
}
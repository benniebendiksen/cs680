package edu.umb.cs680.hw06;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class DVDPlayerTest {

    @Test
    public void test() {
        State state1 = DVDPlayer.getInstance().getState();
        DVDPlayer.getInstance().openCloseButtonPushed();
        assertEquals(DrawerOpen.getInstance(), state1);
        assertEquals(DrawerClosedNotPlaying.getInstance(), state1);

        State state2 = DVDPlayer.getInstance().getState();
        DVDPlayer.getInstance().playButtonPushed();
        assertEquals(DrawerClosedPlaying.getInstance(), state2);
        
        DVDPlayer.getInstance().stopButtonPushed();
        assertEquals(DrawerClosedNotPlaying.getInstance(), DVDPlayer.getInstance().getState());
    }
}
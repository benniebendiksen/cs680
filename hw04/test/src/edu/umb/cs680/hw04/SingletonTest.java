package edu.umb.cs680.hw04;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class SingletonTest {

    @Test
    public void notNull() {
        assertNotNull(Singleton.getInstance());
    }

    @Test
    public void identIns() {
        assertEquals(Singleton.getInstance().hashCode(), Singleton.getInstance().hashCode());
    }


}
package edu.umb.cs680.hw06;

public class DrawerClosedPlaying implements State{
    
	private DrawerClosedPlaying() {};
	private static DrawerClosedPlaying instance = null;
	
	public static DrawerClosedPlaying getInstance() {
		if(instance==null) 
			instance = new DrawerClosedPlaying();
		return instance;
	}

    @Override
    public void openCloseButtonPushed() {       
        DVDPlayer player = DVDPlayer.getInstance();
        player.stop();
        player.open();
        player.ChangeState(DrawerOpen.getInstance());
       
    }

    @Override
    public void playButtonPushed() {
    }

    @Override
    public void stopButtonPushed() {
       
        DVDPlayer player = DVDPlayer.getInstance();
        player.stop();
        player.ChangeState(DrawerClosedNotPlaying.getInstance());
    }

}
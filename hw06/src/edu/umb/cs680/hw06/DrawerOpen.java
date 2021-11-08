package edu.umb.cs680.hw06;

public class DrawerOpen implements State{

	private DrawerOpen() {};
	private static DrawerOpen instance = null;
	
	public static DrawerOpen getInstance() {
		if(instance==null) 
			instance = new DrawerOpen();
		return instance;
    }

    @Override
    public void openCloseButtonPushed() {
       DVDPlayer player = DVDPlayer.getInstance();
       player.close();
       player.ChangeState(DrawerClosedNotPlaying.getInstance());
    }

    @Override
    public void playButtonPushed() {
        DVDPlayer player = DVDPlayer.getInstance();
        player.close();
        player.play();
        player.ChangeState(DrawerClosedPlaying.getInstance());
    }

    @Override
    public void stopButtonPushed() {
    }

}
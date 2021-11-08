package edu.umb.cs680.hw06;

public class DrawerClosedNotPlaying implements State{
    
	private DrawerClosedNotPlaying() {};
	private static DrawerClosedNotPlaying instance = null;
	
	public static DrawerClosedNotPlaying getInstance() {
		if(instance==null) 
			instance = new DrawerClosedNotPlaying();
		return instance;
    }
  
    @Override
    public void openCloseButtonPushed() {
        DVDPlayer player = DVDPlayer.getInstance();
        player.open();
        player.ChangeState(DrawerOpen.getInstance());
        
    }

    @Override
    public void playButtonPushed() {
        DVDPlayer.getInstance().play();
        DVDPlayer.getInstance().ChangeState(DrawerClosedPlaying.getInstance());
       
    }

    @Override
    public void stopButtonPushed() {
    }

}
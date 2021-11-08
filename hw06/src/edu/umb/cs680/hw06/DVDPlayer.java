package edu.umb.cs680.hw06;


public class DVDPlayer implements State{


    private static State state;
    private static DVDPlayer instance = null;

    private DVDPlayer() {

    };


    public static DVDPlayer getInstance() {
    	
        state = DrawerClosedNotPlaying.getInstance();
        if (instance == null)
            instance = new DVDPlayer();

        return instance;
    }
 

    public State getState() {
        return state;
    }

    public void ChangeState(State state) {
        DVDPlayer.state = state;
    }
    

    @Override
    public void openCloseButtonPushed() {
        state.openCloseButtonPushed();
        }
    
    @Override
    public void playButtonPushed() {
       state.playButtonPushed();
    }

    @Override
    public void stopButtonPushed() {
        state.stopButtonPushed();
    }
    public void play(){
        System.out.printf("DVD Player play button pressed");
    }
    public void open(){
        System.out.printf("DVD Player open button pressed");
    }
    public void close(){
        System.out.printf("DVD Player close button pressed");
    }
    public void stop(){
        System.out.printf("DVD Player stop button pressed");
    }

    public static void main(String[] args) {
        DVDPlayer somePlayer = DVDPlayer.getInstance();
        System.out.printf("The Current State of Your DVD Player Is: \"%s\"\n", somePlayer.getState());
       
    }
    
}
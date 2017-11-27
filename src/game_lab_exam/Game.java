package game_lab_exam;

public class Game {
    public Player player;
    public DealerTream dealerTream;
    public boolean isGameOver;

    public Game(){
        player = new Player();
        dealerTream = new DealerTream();
    }
}

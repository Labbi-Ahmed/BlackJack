package game_lab_exam;

import java.util.Scanner;

import static java.lang.Thread.sleep;

public class BlackJack {
    public static Game game = new Game();
    public static int trun;
    public static int[] cardList = new int[10];
    public static boolean willShow =false;
    public static int[] getCardList(){
        return cardList;
    }

    public static void check(){
            ///System.out.println(game.player.getTotalPoint() + "  is");
        if (game.player.getTotalPoint() > 21){
            System.out.println("Player lost");
            game.isGameOver = true ;
        }
        else if (game.dealerTream.getTotalPoint() > 21){
            System.out.println("Dealer lost");
            game.isGameOver = true ;
        }
    }
    public static void main(String[] args){
        int card1 , card2;
        int trun = 1;
        card1= game.player.hit();
        card2 = game.player.hit();
        System.out.println("you gat " + card1 + " and  " + card2);
        System.out.println("your total is "+game.player.getTotalPoint());
        card1 = game.dealerTream.hit();
        System.out.println("\nThe dealer has a " + card1 + "  showing and a hidden card.");
        System.out.println("his total is hidden, too");


        String decision;

        Scanner scanf = new Scanner(System.in);
        trun = 1;


        do {


            if (trun == 1){
                System.out.println("\nDo you want to hit? stay ? hit ");
                decision  = scanf.nextLine();
                if (decision.contains("hit")){
                    card1 = game.player.hit();
                    System.out.println("you draw a " + card1);
                    System.out.println("your total is " + game.player.getTotalPoint()+"\n");
                    check();

                }
                else {
                    System.out.println("\nOkay dealer turn\n");
                    trun = 2;
                }
            }
            else if (trun == 2){
                if(game.player.getTotalPoint() > game.dealerTream.getTotalPoint()){

                    System.out.println("Dealer chooses to hit :");
                    ///System.out.println("The dealer has a " + card1 +" showing, and a hidden card and Dealer total point " + game.dealerTream.getTotalPoint());
                    card1 = game.dealerTream.hit();
                    System.out.println("He draw a " + card1);
                    if (willShow == true){
                        System.out.println("his total is : " + game.dealerTream.getTotalPoint());
                    }
                    else {
                        System.out.println("his total is hidden");
                    }
                    if (game.dealerTream.getTotalPoint() > 10){
                       card1 = game.dealerTream.hit();
                       System.out.println("his hidden was " + card1 +" \nhis totalpoint is " +game.dealerTream.getTotalPoint());
                        check();
                        if (game.isGameOver == false && game.player.getTotalPoint() < game.dealerTream.getTotalPoint()){
                            try {
                                sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            trun = 1;
                                System.out.println("Dealer chooes to stay");

                        }
                    }



                }else {
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    trun = 1;
                    System.out.println("Deale chooes to stay");
                }
            }

            //check();
        }while (game.isGameOver == false);
    }
}

package game_lab_exam;

public class DealerTream {

    private  int totalPoint;
    public DealerTream(){
        totalPoint = 0;
    }


    public int getTotalPoint(){
        return totalPoint;
    }

    private  boolean isavilable(int cardValue)
    {
        int[] cardList = BlackJack.getCardList();
        if(cardValue > 1 && cardList[cardValue-2] < 4)
            return true;
        return false;
    }

    public int hit(){

        CardGame card;
        do{
            card = new CardGame();
        }while (isavilable(card.getCardvalue()) == false);

        int[] cardList = BlackJack.getCardList();
        cardList[card.getCardvalue()-2]++;

        totalPoint += card.getCardvalue();

        return  card.getCardvalue();
    }
}

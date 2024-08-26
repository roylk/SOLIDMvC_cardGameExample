package games;

import com.example.cardgame.controller.GameController;
import com.example.cardgame.model.DeckFactory;
import com.example.cardgame.model.DeckFactory.*;
import com.example.cardgame.view.GameSwingView;

public class Games {
    public static void main(String[] args){
        GameSwingView gsv = new GameSwingView();
        gsv.createAndShowGUI();

        //GameController gc = new GameController(new Deck(),new View(),new HighCardGameEvaluator());
        //GameController gc = new GameController(new Deck(),new CommandLineView(),new LowCardGameEvaluator());
        //GameController gc = new GameController(new Deck(), gsv, new LowCardGameEvaluator());
        GameController gc = new GameController(DeckFactory.makeDeck(DeckType.normal), gsv, new LowCardGameEvaluator());
        gc.run();
    }


}

package games;

import com.example.cardgame.controller.GameController;
import com.example.cardgame.model.DeckFactory;
import com.example.cardgame.model.DeckFactory.*;
import com.example.cardgame.view.GameSwingPassiveView;
import com.example.cardgame.view.GameSwingView;
import com.example.cardgame.view.GameViewable;
import com.example.cardgame.view.GameViewables;

public class Games {
    public static void main(String[] args){
        GameViewables views = new GameViewables();

        GameSwingView gsv = new GameSwingView();
        gsv.createAndShowGUI();
        views.addViewable(gsv);

        for (int i = 0; i< 3; i++){
            GameSwingPassiveView passiveView = new GameSwingPassiveView();
            passiveView.createAndShowGUI();
            views.addViewable(passiveView);
            try {
                Thread.sleep(2500);
            }catch (InterruptedException e){
                e.printStackTrace();
            }

        }

        //GameController gc = new GameController(new Deck(),new View(),new HighCardGameEvaluator());
        //GameController gc = new GameController(new Deck(),new CommandLineView(),new LowCardGameEvaluator());
        //GameController gc = new GameController(new Deck(), gsv, new LowCardGameEvaluator());
        //GameController gc = new GameController(DeckFactory.makeDeck(DeckType.normal), gsv, new LowCardGameEvaluator());
        GameController gc = new GameController(DeckFactory.makeDeck(DeckType.normal), views, new LowCardGameEvaluator());
        gc.run();
    }

}

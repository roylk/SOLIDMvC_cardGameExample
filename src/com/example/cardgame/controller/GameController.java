package com.example.cardgame.controller;

import com.example.cardgame.model.*;
import com.example.cardgame.view.GameViewable;
import games.GameEvaluator;
import java.util.ArrayList;
import java.util.List;

public class GameController {
    public void nextAction(String nextChoice) {
        if("+q".equals(nextChoice)){
            exitGame();
        }else{
            startGame();
        }
    }
    enum GameState{
        AddingPlayers, CardsDealt, WinnerRevealed
    }

    Deck deck;
    List<IPlayer> players;
    IPlayer winner;
    //CommandLineView view;
    GameViewable view;

    GameState gameState;
    GameEvaluator evaluator;

    public GameController(Deck deck, GameViewable view, GameEvaluator evaluator){
        super();
        this.deck = deck;
        this.view = view;
        this.players = new ArrayList<IPlayer>();
        this.gameState = GameState.AddingPlayers;
        this.evaluator = evaluator;
        view.setController(this);
    }

    public void run(){
        while (gameState == GameState.AddingPlayers){
            view.promptForPlayerName();
        }
        switch(gameState){
            case CardsDealt:
                view.promptForFlip();
                break;
            case WinnerRevealed:
                view.promptForNewGame();
                break;
        }
    }

    public void addPlayer(String playerName){
        if(gameState == GameState.AddingPlayers){
            players.add(new Player(playerName));
            view.showPlayerName(players.size(),playerName);
        }
    }

    public void startGame(){
        if(gameState != GameState.CardsDealt){
            deck.shuffle();
            int playerIndex = 1;
            for (IPlayer player: players){
                player.addCardToHand(deck.removeTopCard());
                view.showFaceDownCardForPlayer(playerIndex++,player.getName());
                gameState = GameState.CardsDealt;
            }
            this.run();
        }
    }

    public void flipCards(){
        int playerIndex = 1;
        for(IPlayer player:players){
            PlayingCard pc = player.getCard(0);
            pc.flip();
            view.showCardForPlayer(playerIndex++,player.getName(), pc.getRank().toString(),pc.getSuit().toString());
        }
        evaluateWinner();
        displayWinner();
        rebuildDeck();
        gameState = GameState.WinnerRevealed;
        this.run();
    }

    public void displayWinner(){
        view.showWinner(winner.getName());
    }
    public void rebuildDeck(){
        for( IPlayer player:players){
            deck.returnCardToDeck(player.removeCard());
        }
    }

    public void evaluateWinner(){
        winner =new WinningPlayer(evaluator.EvaluateWinner(players));
    }

    public void exitGame(){
        System.exit(0);
    }
}

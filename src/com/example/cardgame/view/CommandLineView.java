package com.example.cardgame.view;

import com.example.cardgame.controller.GameController;

import java.util.Scanner;

public class CommandLineView implements GameViewable {
    GameController controller;
    Scanner keyboard =  new Scanner(System.in);

    public void setController(GameController gc){
        this.controller = gc;
    }

    public void promptForPlayerName(){
        System.out.println("Enter player name");
        String name = keyboard.nextLine();
        if(name.isEmpty()){
            controller.startGame();
        }else{
            controller.addPlayer(name);
        }
    }
    /*public void promptForNewGame(){
        System.out.println("Press enter to deal again");
        keyboard.nextLine();
        controller.startGame();
    }*/

    public void promptForNewGame(){
        System.out.println("Press enter to deal again");
        controller.nextAction(keyboard.nextLine());
        //controller.startGame();
    }

    public void promptForFlip(){
        System.out.println("Press Enter to reveal the card");
        keyboard.nextLine();
        controller.flipCards();
    }

    public void showWinner(String name){
        System.out.println("the winner is :"+ name + " !");
    }

    public void showPlayerName(int playerIndex, String playerName){
        System.out.println("["+playerIndex+"]["+playerName+"]");
    }

    public void showFaceDownCardForPlayer(int playerIndex, String playerName){
        System.out.println("["+playerIndex+"]["+playerName+"][x]");
    }

    public void showCardForPlayer(int i, String playerName, String rank, String suit){
        System.out.println("["+i+"]["+playerName+"]["+rank+"]["+suit+"]");
    }
}

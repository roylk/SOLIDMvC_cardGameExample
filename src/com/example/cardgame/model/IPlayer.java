package com.example.cardgame.model;

public interface IPlayer {
	public PlayingCard getCard(int index);
	public void addCardToHand(PlayingCard pc);
	public String getName();

	public PlayingCard removeCard();

}

package BlackJack.model;

public interface ICardDealtObserver {
	
	void CardDealt(Card a_addToHand, String name);
}
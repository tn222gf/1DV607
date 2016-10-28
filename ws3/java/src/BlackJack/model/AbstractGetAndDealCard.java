package BlackJack.model;

public abstract class AbstractGetAndDealCard {

	public static void getAndDealCard(Deck a_deck, Player a_player, boolean show) {
		  Card c;
		  
		  c = a_deck.GetCard();
		  c.Show(show);
		  a_player.DealCard(c);
	  }
}

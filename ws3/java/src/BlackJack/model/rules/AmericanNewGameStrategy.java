package BlackJack.model.rules;

import BlackJack.model.Deck;
import BlackJack.model.AbstractGetAndDealCard;
import BlackJack.model.Dealer;
import BlackJack.model.Player;

class AmericanNewGameStrategy implements INewGameStrategy {

  public boolean NewGame(Deck a_deck, Dealer a_dealer, Player a_player) {

	  AbstractGetAndDealCard.getAndDealCard(a_deck, a_player, true);

	  AbstractGetAndDealCard.getAndDealCard(a_deck, a_dealer, true);
    
	  AbstractGetAndDealCard.getAndDealCard(a_deck, a_player, true);

	  AbstractGetAndDealCard.getAndDealCard(a_deck, a_dealer, false);

    return true;
  }  
}
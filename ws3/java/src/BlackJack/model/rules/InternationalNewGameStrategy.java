package BlackJack.model.rules;

import BlackJack.model.Dealer;
import BlackJack.model.Player;

class InternationalNewGameStrategy implements INewGameStrategy {

  public boolean NewGame(Dealer a_dealer, Player a_player) {

	  a_dealer.DealCard(true, a_player);

	  a_dealer.DealCard(true, a_dealer);
	  
	  a_dealer.DealCard(true, a_player);

	  return true;
  }
}
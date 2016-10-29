package BlackJack.model.rules;

import BlackJack.model.Player;

public interface IWinDeciderStrategy {
	boolean IsDealerWinner(Player a_dealer, Player a_player);
}

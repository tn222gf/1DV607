package BlackJack.model.rules;

import BlackJack.model.Player;

public class PlayerWinsWhenEqualStrategy implements IWinDeciderStrategy{

	public boolean WhoWins(Player a_dealer, Player a_player) {
		
		if (a_dealer.CalcScore() <= a_player.CalcScore()) {
			return false;
		} else {
			return true;
		}
	}
}

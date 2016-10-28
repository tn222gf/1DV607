package BlackJack.controller;

import BlackJack.view.IView;
import BlackJack.model.Card;
import BlackJack.model.Game;
import BlackJack.model.ICardDealtObserver;

public class PlayGame implements ICardDealtObserver {

	private Game m_game;
	private  IView m_view;

	public PlayGame(Game a_game, IView a_view) {
		m_game = a_game;
		m_view = a_view;
		m_game.addCardDealtObserver(this);
	}

	public boolean Play() {

		m_view.DisplayWelcomeMessage();

		m_view.DisplayDealerHand(m_game.GetDealerHand(), m_game.GetDealerScore());
		m_view.DisplayPlayerHand(m_game.GetPlayerHand(), m_game.GetPlayerScore());

		if (m_game.IsGameOver())
		{
			if (m_game.IsDealerWinner()) {
				m_view.DisplayGameOverDealerWin();
			} else {
				m_view.DisplayGameOverPlayerWin();
			}

		}

		int input = m_view.GetInput();

		if (input == 'p')
		{
			m_game.NewGame();
		}
		else if (input == 'h')
		{
			m_game.Hit();
		}
		else if (input == 's')
		{
			m_game.Stand();
		}

		return input != 'q';
	}

	public void CardDealt(Card a_addToHand, String name) {
		try {
			Thread.sleep(300);
		} catch (Exception e) {

		}
		
		if (name.equals("Player")) {
			m_view.DisplayPlayerCard(a_addToHand);
		} else if (name.equals("Dealer")) {
			m_view.DisplayDealerCard(a_addToHand);
		}
		
		try {
			Thread.sleep(1500);
		} catch (Exception e) {

		}
	}

}
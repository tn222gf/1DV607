package BlackJack.controller;

import BlackJack.view.Commands;
import BlackJack.view.IView;
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

		Commands com = m_view.GetInput();

		if (com == Commands.Play)
		{
			m_game.NewGame();
		}
		else if (com == Commands.Hit)
		{
			m_game.Hit();
		}
		else if (com == Commands.Stand)
		{
			m_game.Stand();
		}
		else if (com == Commands.Quit)
		{
			return false;
		}
		
		return true;
	}

	public void CardDealt() {
		m_view.DisplayWhenNewCard(m_game.GetDealerHand(), m_game.GetDealerScore(), m_game.GetPlayerHand(), m_game.GetPlayerScore());
	}

}
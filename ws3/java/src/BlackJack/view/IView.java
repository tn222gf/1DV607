package BlackJack.view;

import BlackJack.model.Card;

public interface IView
{
  void DisplayWelcomeMessage();
  int GetInput();
  void DisplayCard(BlackJack.model.Card a_card);
  void DisplayPlayerCard(BlackJack.model.Card a_card);
  void DisplayDealerCard(BlackJack.model.Card a_card);
  void DisplayPlayerHand(Iterable<BlackJack.model.Card> a_hand, int a_score);
  void DisplayDealerHand(Iterable<BlackJack.model.Card> a_hand, int a_score);
  void DisplayGameOverDealerWin();
  void DisplayGameOverPlayerWin();
  void DisplayWhenNewCard(Iterable<Card> a_dealerHand, int a_dealerScore, Iterable<Card> a_playerHand, int a_playerScore);
  
}
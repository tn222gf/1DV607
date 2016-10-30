package BlackJack.view;

import BlackJack.model.Card;

public interface IView
{
  void DisplayWelcomeMessage();
  int GetInput();
  void DisplayCard(Card a_card);
  void DisplayPlayerCard(Card a_card);
  void DisplayDealerCard(Card a_card);
  void DisplayPlayerHand(Iterable<Card> a_hand, int a_score);
  void DisplayDealerHand(Iterable<Card> a_hand, int a_score);
  void DisplayGameOverDealerWin();
  void DisplayGameOverPlayerWin();
  void DisplayWhenNewCard(Iterable<Card> a_dealerHand, int a_dealerScore, Iterable<Card> a_playerHand, int a_playerScore);
  
}
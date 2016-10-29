package BlackJack.model;

import BlackJack.model.rules.*;

public class Dealer extends Player {

  private Deck m_deck;
  private INewGameStrategy m_newGameRule;
  private IHitStrategy m_hitRule;
  private IWinDeciderStrategy m_winDeciderRule;

  public Dealer(RulesFactory a_rulesFactory) {
  
    m_newGameRule = a_rulesFactory.GetNewGameRule();
    m_hitRule = a_rulesFactory.GetHitRule();
    m_winDeciderRule = a_rulesFactory.GetNewWinDeciderRule();
    
    /*for(Card c : m_deck.GetCards()) {
      c.Show(true);
      System.out.println("" + c.GetValue() + " of " + c.GetColor());
    }    */
  }
  
  
  public boolean NewGame(Player a_player) {
    if (m_deck == null || IsGameOver()) {
      m_deck = new Deck();
      ClearHand();
      a_player.ClearHand();
      return m_newGameRule.NewGame(m_deck, this, a_player);   
    }
    return false;
  }

  public boolean Hit(Player a_player) {
    if (m_deck != null && a_player.CalcScore() < g_maxScore && !IsGameOver()) {
      
      AbstractGetAndDealCard.getAndDealCard(m_deck, a_player, true);
      
      return true;
    }
    return false;
  }

  public boolean IsDealerWinner(Player a_player) {
    
	  if (a_player.CalcScore() > g_maxScore) {
		  return true;
	  } else if (CalcScore() > g_maxScore) {
		  return false;
	  }

	  return m_winDeciderRule.IsDealerWinner(this, a_player);
  }

  public boolean IsGameOver() {
    if (m_deck != null && m_hitRule.DoHit(this) != true) {
        return true;
    }
    return false;
  }
  
  public boolean stand() {

	  if (m_deck != null) {
		  ShowHand();
		  
		  while (m_hitRule.DoHit(this)) {
			  AbstractGetAndDealCard.getAndDealCard(m_deck, this, true);
		  }
	  }
	  
	  return true;
  }
}
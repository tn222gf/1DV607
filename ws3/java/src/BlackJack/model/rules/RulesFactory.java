package BlackJack.model.rules;

public class RulesFactory {

  public IHitStrategy GetHitRule() {
    return new SoftSevenTeenHitStrategy();
  }

  public INewGameStrategy GetNewGameRule() {
    return new AmericanNewGameStrategy();
  }
  
  public IWinDeciderStrategy GetNewWinDeciderRule() {
	  return new PlayerWinsWhenEqualStrategy();
  }
  
}
package BlackJack.view;

public class SimpleView implements IView 
{

  public void DisplayWelcomeMessage()
        { 
          System.out.println("Hello Black Jack World");
          System.out.println("Type 'p' to Play, 'h' to Hit, 's' to Stand or 'q' to Quit\n");
        }

        public int GetInput()
        {
        	return getInputChar();
        }

        protected int getInputChar() {

        	try {

        		int c = System.in.read();

        		while (c == '\r' || c =='\n') {

        			c = System.in.read();
        		}
        		return c;
        	} catch (java.io.IOException e) {

        		System.out.println("" + e);
        		return 0;
        	}
        }
        
        public void DisplayCard(BlackJack.model.Card a_card)
        {
            System.out.println("" + a_card.GetValue() + " of " + a_card.GetColor());
        }
        
        public void DisplayPlayerCard(BlackJack.model.Card a_card)
        {
            System.out.println("Player drew: " + a_card.GetValue() + " of " + a_card.GetColor() + "\n");
        }
        
        public void DisplayDealerCard(BlackJack.model.Card a_card)
        {
            System.out.println("Dealer drew: " + a_card.GetValue() + " of " + a_card.GetColor() + "\n");
        }

        public void DisplayPlayerHand(Iterable<BlackJack.model.Card> a_hand, int a_score)
        {
            DisplayHand("Player", a_hand, a_score);
        }

        public void DisplayDealerHand(Iterable<BlackJack.model.Card> a_hand, int a_score)
        {
            DisplayHand("Dealer", a_hand, a_score);
        }

        private void DisplayHand(String a_name, Iterable<BlackJack.model.Card> a_hand, int a_score)
        {
            System.out.println(a_name + " Has: ");
            for(BlackJack.model.Card c : a_hand)
            {
                DisplayCard(c);
            }
            System.out.println("Score: " + a_score);
            System.out.println("");
        }

        public void DisplayGameOverDealerWin()
        {
        	System.out.println("GameOver: ");
        	System.out.println("Dealer Won!");
        }
        
        public void DisplayGameOverPlayerWin()
        {
        	System.out.println("GameOver: ");
        	System.out.println("You Won!");
        }
    }
package BlackJack.view;

import BlackJack.model.Card;

public class SimpleView implements IView 
{

	public void DisplayWhenNewCard(Iterable<Card> a_dealerHand, int a_dealerScore, Iterable<Card> a_playerHand, int a_playerScore) {

		try {
			Thread.sleep(1500);
		} catch (Exception e) {

		}
		
		DisplayWelcomeMessage();
		
		DisplayDealerHand(a_dealerHand, a_dealerScore);
		DisplayPlayerHand(a_playerHand, a_playerScore);

	}

	public void DisplayWelcomeMessage()
	{ 
		for(int i = 0; i < 50; i++) {System.out.print("\n");}; 
		System.out.println("Hello Black Jack World");
		System.out.println("Type 'p' to Play, 'h' to Hit, 's' to Stand or 'q' to Quit\n");
	}

	public Commands GetInput()
	{
		int input;
		boolean isCommand = false;
		Commands com = null;
		
		while (!isCommand) {
			
			input = getInputChar();
			
			if (input == 'p') {
				com = Commands.Play;
				isCommand = true;
				
			} else if (input == 'h') {
				com = Commands.Hit;
				isCommand = true;
				
			} else if (input == 's') {
				com = Commands.Stand;
				isCommand = true;
				
			} else if (input == 'q') {
				com = Commands.Quit;
				isCommand = true;
			}	
		}
		
		return com; 
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

	public void DisplayCard(Card a_card)
	{
		System.out.println("" + a_card.GetValue() + " of " + a_card.GetColor());
	}

	public void DisplayPlayerCard(Card a_card)
	{
		System.out.println("Player drew: " + a_card.GetValue() + " of " + a_card.GetColor() + "\n");
	}

	public void DisplayDealerCard(Card a_card)
	{
		System.out.println("Dealer drew: " + a_card.GetValue() + " of " + a_card.GetColor() + "\n");
	}

	public void DisplayPlayerHand(Iterable<Card> a_hand, int a_score)
	{
		DisplayHand("Player", a_hand, a_score);
	}

	public void DisplayDealerHand(Iterable<Card> a_hand, int a_score)
	{
		DisplayHand("Dealer", a_hand, a_score);
	}

	private void DisplayHand(String a_name, Iterable<Card> a_hand, int a_score)
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
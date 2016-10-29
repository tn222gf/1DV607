package BlackJack.view;

import BlackJack.model.Card;

public class SwedishView implements IView 
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

		System.out.println("Hej Black Jack Världen");
		System.out.println("----------------------");
		System.out.println("Skriv 'p' för att Spela, 'h' för nytt kort, 's' för att stanna 'q' för att avsluta\n");
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
		if (a_card.GetColor() == BlackJack.model.Card.Color.Hidden)
		{
			System.out.println("Dolt Kort");
		}
		else
		{
			String colors[] = 
				{ "Hjärter", "Spader", "Ruter", "Klöver" };
			String values[] =  
				{ "två", "tre", "fyra", "fem", "sex", "sju", "åtta", "nio", "tio", "knekt", "dam", "kung", "ess" };
			System.out.println("" + colors[a_card.GetColor().ordinal()] + " " + values[a_card.GetValue().ordinal()]);
		}
	}

	public void DisplayPlayerCard(BlackJack.model.Card a_card)
	{
		System.out.println("Spelare drog: " + a_card.GetColor() + " " + a_card.GetValue() + "\n");
	}

	public void DisplayDealerCard(BlackJack.model.Card a_card)
	{
		System.out.println("Croupier drog: " + a_card.GetColor() + " " + a_card.GetValue() + "\n");
	}

	public void DisplayPlayerHand(Iterable<BlackJack.model.Card> a_hand, int a_score)
	{
		DisplayHand("Spelare", a_hand, a_score);
	}
	public void DisplayDealerHand(Iterable<BlackJack.model.Card> a_hand, int a_score)
	{
		DisplayHand("Croupier", a_hand, a_score);
	}

	public void DisplayGameOverDealerWin()
	{
		System.out.println("Slut: ");
		System.out.println("Croupiern Vann!");
	}

	public void DisplayGameOverPlayerWin()
	{
		System.out.println("Slut: ");
		System.out.println("Du vann!");
	}

	private void DisplayHand(String a_name, Iterable<BlackJack.model.Card> a_hand, int a_score)
	{
		System.out.println(a_name + " Har: " + a_score);
		for(BlackJack.model.Card c : a_hand)
		{
			DisplayCard(c);
		}
		System.out.println("Poäng: " + a_score);
		System.out.println("");
	}
}

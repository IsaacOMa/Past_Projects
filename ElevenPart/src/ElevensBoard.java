import java.util.List;
import java.util.ArrayList;

/**
 * The ElevensBoard class represents the board in a game of Elevens.
 * This is the working version
 */
public class ElevensBoard extends Board {

	/**
	 * The size (number of cards) on the board.
	 */
	private static final int BOARD_SIZE = 9;

	/**
	 * The ranks of the cards for this game to be sent to the deck.
	 */
	private static final String[] RANKS =
		{"ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king"};

	/**
	 * The suits of the cards for this game to be sent to the deck.
	 */
	private static final String[] SUITS =
		{"spades", "hearts", "diamonds", "clubs"};

	/**
	 * The values of the cards for this game to be sent to the deck.
	 */
	private static final int[] POINT_VALUES =
		{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 0, 0};
	
	private Card cards[];

	/**
	 * Flag used to control debugging print statements.
	 */
	private static final boolean I_AM_DEBUGGING = false;


	/**
	 * Creates a new <code>ElevensBoard</code> instance.
	 */
	 public ElevensBoard() {
	 	super(BOARD_SIZE, RANKS, SUITS, POINT_VALUES);
	 }

	/**
	 * Determines if the selected cards form a valid group for removal.
	 * In Elevens, the legal groups are (1) a pair of non-face cards
	 * whose values add to 11, and (2) a group of three cards consisting of
	 * a jack, a queen, and a king in some order.
	 * @param selectedCards the list of the indices of the selected cards.
	 * @return true if the selected cards form a valid group for removal;
	 *         false otherwise.
	 */
	@Override
	public boolean isLegal(List<Integer> selectedCards) {
		if (selectedCards.size() == 2)
		{
			return containsPairSum11(selectedCards);
		}
		else if (selectedCards.size() == 3)
		{
			cardIndexes();
			return containsJQK(selectedCards);
		}
		else 
			return false;
		/* *** TO BE IMPLEMENTED IN ACTIVITY 9 *** */
	}

	/**
	 * Determine if there are any legal plays left on the board.
	 * In Elevens, there is a legal play if the board contains
	 * (1) a pair of non-face cards whose values add to 11, or (2) a group
	 * of three cards consisting of a jack, a queen, and a king in some order.
	 * @return true if there is a legal play left on the board;
	 *         false otherwise.
	 */
	@Override
	public boolean anotherPlayIsPossible() {
		List<Integer> currentIndexes = cardIndexes();
		
		return containsPairSum11(currentIndexes) || containsJQK(currentIndexes);
		
//		boolean foundPairSum11 = false;
//		boolean foundRoyalties = false;
//		for (int index1 = 0; index1 < BOARD_SIZE; index1++)
//		{
//			for (int index2 = index1 + 1; index2 < BOARD_SIZE; index2++)
//			{
//				
//				if (cardAt(index1).pointValue() + cardAt(index2).pointValue() == 11)
//				{
//					foundPairSum11 = true;
//				}
//			}
//		}
//		
//		boolean foundJack = false;
//		boolean foundQueen = false;
//		boolean foundKing = false;
//		for(int i = 0; i < BOARD_SIZE; i++)
//		{
//			if (cardAt(i).rank().equals("jack"))
//				foundJack = true;
//			else if (cardAt(i).rank().equals("queen"))
//			{
//				foundQueen = true;
//			}
//			else if (cardAt(i).rank().equals("king"))
//			{
//				foundKing = true;
//			}
//		}
//		if (foundJack == true && foundQueen == true && foundKing == true)
//		{
//			foundRoyalties = true;
//		}
//		
//		return foundRoyalties || foundPairSum11;
		
		/* *** TO BE IMPLEMENTED IN ACTIVITY 9 *** */
	}

	/**
	 * Check for an 11-pair in the selected cards.
	 * @param selectedCards selects a subset of this board.  It is list
	 *                      of indexes into this board that are searched
	 *                      to find an 11-pair.
	 * @return true if the board entries in selectedCards
	 *              contain an 11-pa
	 *              2+ir; false otherwise.
	 */
	private boolean containsPairSum11(List<Integer> selectedCards) {
		boolean foundPairSum11 = false;
		for (int index1 = 0; index1 < selectedCards.size(); index1++)
		{
			int card1 = selectedCards.get(index1).intValue();
			for (int index2 = index1 + 1; index2 < selectedCards.size(); index2++)
			{
				
				int card2 = selectedCards.get(index2).intValue();
				
				if (cardAt(card1).pointValue() + cardAt(card2).pointValue() == 11)
				{
					foundPairSum11 = true;
				}
			}
		}
		return foundPairSum11;
		/* *** TO BE IMPLEMENTED IN ACTIVITY 9 *** */
	}

	/**
	 * Check for a JQK in the selected cards.
	 * @param selectedCards selects a subset of this board.  It is list
	 *                      of indexes into this board that are searched
	 *                      to find a JQK group.
	 * @return true if the board entries in selectedCards
	 *              include a jack, a queen, and a king; false otherwise.
	 */
	private boolean containsJQK(List<Integer> selectedCards) {
		boolean foundJack = false;
		boolean foundQueen = false;
		boolean foundKing = false;
		for(Integer kObj : selectedCards)
		{
			int k = kObj.intValue();
			if (cardAt(k).rank().equals("jack"))
				foundJack = true;
			else if (cardAt(k).rank().equals("queen"))
			{
				foundQueen = true;
			}
			else if (cardAt(k).rank().equals("king"))
			{
				foundKing = true;
			}
		}
		return foundJack && foundQueen && foundKing;
		
		
		/* *** TO BE IMPLEMENTED IN ACTIVITY 9 *** */
	}
		/* *** TO BE IMPLEMENTED IN ACTIVITY 9 *** */
	}


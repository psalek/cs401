package lesson5.lecture.factorymethods2.rulesets;

import java.awt.Component;

import lesson5.lecture.factorymethods2.gui.ProfileWindow;



/**
 * Rules:
 * 1. all fields non empty
 * 2. favorite restaurant cannot equal favorite movie
 * 3. id must be numeric
 * 4. firstname and lastname fields may not contain spaces or 
 * characters other than a-z, A-Z.
 *
 */
public class CustomerProfileRuleSet implements RuleSet {

	private ProfileWindow profWin;
	@Override
	public void applyRules(Component ob) throws RuleException {
		profWin = (ProfileWindow)ob;
		nonemptyRule();
		idNumericRule();
		favRestAndMovieRule();		
		correctCharTypeRule();
		
	}
	
	private void nonemptyRule() throws RuleException {
		if(profWin.getIdValue().trim().isEmpty() ||
		     profWin.getIdValue().trim().isEmpty() ||
			 profWin.getFirstNameValue().trim().isEmpty() ||
			 profWin.getLastNameValue().trim().isEmpty() ||
			 profWin.getFavoriteRestaurantValue().trim().isEmpty() ||
		     profWin.getFavoriteMovieValue().trim().isEmpty()) {
			   throw new RuleException("All fields must be nonempty");
		}
	}
	
	private void favRestAndMovieRule() throws RuleException {
		if(profWin.getFavoriteMovieValue().trim().equals(
				profWin.getFavoriteRestaurantValue().trim())) {
			throw new RuleException("Favorite movie must not equal favorite restaurant");
		}
	}

	private void idNumericRule() throws RuleException {
		String val = profWin.getIdValue().trim();
		try {
			Integer.parseInt(val);
			//val is numeric
		} catch(NumberFormatException e) {
			throw new RuleException("ID must be numeric");
		}		
	}
	private void correctCharTypeRule() throws RuleException {
		char[] fname = profWin.getFirstNameValue().toCharArray();
		char[] lname = profWin.getLastNameValue().toCharArray();
		for(char c: fname) {
			if(!Util.isInRangeAtoZ(c) || !Util.isInRangeatoz(c)) 
				throw new RuleException("All characters in first name must be "
						+ "in range A-Z or a-z");
		}
		for(char c: lname) {
			if(!Util.isInRangeAtoZ(c) || !Util.isInRangeatoz(c)) 
				throw new RuleException("All characters in lasst name must be "
						+ "in range A-Z or a-z");
		}
	}


}

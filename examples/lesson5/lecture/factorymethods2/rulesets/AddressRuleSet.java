package lesson5.lecture.factorymethods2.rulesets;

import java.awt.Component;

import lesson5.lecture.factorymethods2.gui.AddrWindow;



/**
 * Rules:
 *  1. All fields must be nonempty 
 *  2. ID field must be numeric 
 *  3. Zip must be numeric with exactly 5 digits 
 *  4. State must have exactly two characters in the range A-Z 5. 
 *  5. ID field may not equal zip field.
 *
 */

public class AddressRuleSet implements RuleSet {
	private AddrWindow addr;

	@Override
	public void applyRules(Component ob) throws RuleException {
		addr = (AddrWindow) ob;
		nonemptyRule();
		idNumericRule();
		zipNumericRule();
		stateRule();
		idNotZipRule();
	}

	private void nonemptyRule() throws RuleException {
		if(addr.getIdValue().trim().isEmpty() ||
				addr.getStreetValue().trim().isEmpty() ||
				addr.getCityValue().trim().isEmpty() ||
				addr.getStateValue().trim().isEmpty() ||
				addr.getZipValue().trim().isEmpty()) {
			throw new RuleException("All fields must be non-empty!");
		}
	}

	private void idNumericRule() throws RuleException {
		String val = addr.getIdValue().trim();
		try {
			Integer.parseInt(val);
			//val is numeric
		} catch(NumberFormatException e) {
			throw new RuleException("ID must be numeric");
		}		
	}

	private void zipNumericRule() throws RuleException {
		String val = addr.getZipValue().trim();
		try {
			Integer.parseInt(val);
			//val is numeric
		} catch(NumberFormatException e) {
			throw new RuleException("Zipcode must be numeric");
		}
		if(val.length() != 5) throw new RuleException("Zipcode must have 5 digits");
	}

	private void stateRule() throws RuleException {
		String state = addr.getStateValue().trim();
		if(state.length() != 2) throw new RuleException("State field must have two characters");
		if(!Util.isInRangeAtoZ(state.charAt(0)) 
				|| !Util.isInRangeAtoZ(state.charAt(1))) {
			throw new RuleException("Characters is state field must be in range A-Z");
		}
	}
	
	

	private void idNotZipRule() throws RuleException {
		String zip = addr.getZipValue().trim();
		String id = addr.getIdValue().trim();
		if(zip.equals(id)) throw new RuleException("ID may not be the same as zipcode");
	}

}

package edu.miracosta.cs113;

public class Term {
	private final char VARIABLE_SYMBOL = 'x';
	private final char MINUS_SYMBOL = '-';
	private final char PLUS_SYMBOL = '+';
	
	public int coefficient;
	public int exponent;
	
	public Term() {
		this.coefficient = 1;
		this.exponent = 1;
	}
	
	//Method comment
	public Term(String term) {
		if(!term.isEmpty()) {
			if(term.contains(Character.toString(VARIABLE_SYMBOL))) {
				//Split string in between X
				String[] splitTerm = term.split(Character.toString(VARIABLE_SYMBOL));
				
				//Parse left side of variable X
				this.coefficient = parseCoefficientString(splitTerm[0]);
				
				//if right side of variable X is available
				if(splitTerm.length == 2) {
					this.exponent = parseExponentString(splitTerm[1]);
				} else {
					this.exponent = 1;
				}
			}
			else {
				this.coefficient = parseCoefficientString(term);
				this.exponent = 0;
			}
		}
	}
	
	private int parseCoefficientString(String str) {
		if(str.length() == 1 && str.charAt(0) == MINUS_SYMBOL) {
			return -1;
		}
		else if(str.length() == 1 && str.charAt(0) == PLUS_SYMBOL) {
			return 1;
		}
		else {
			return Integer.parseInt(str);
		}
	}
	
private int parseExponentString(String str) {
		return Integer.parseInt(str.substring(1));
	}
	
	public Term(int c, int e) {
		setAll(c,e);
	}
	
	public Term(Term term) {
		setAll(term.coefficient, term.exponent);
	}

	public int getCoefficient() {
		return coefficient;
	}
	
	public void setCoefficient(int c) {
		this.coefficient = c;
	}
	
	public int getExponent() {
		return this.exponent;
	}
	
	public void setExponent(int e) {
		this.exponent = e;
	}
	
	public void setAll(int c, int e) {
		setCoefficient(c);
		setExponent(e);
	}
	
	public Term clone() {
		return new Term(this.coefficient, this.exponent);
	}
	
	public int compareTo(Term otherTerm) {
		if(this.exponent == otherTerm.exponent) {
			return 0;
		} else if (this.exponent < otherTerm.exponent) {
			return -1;
		} else {
			return 1;
		}
	}
	
	public String toString() {
		var result = "";
		if (this.coefficient == 0) {
			return result;
		}
		
		if(this.exponent == 0) {
			if (this.coefficient >= 0) {
				result += "+";
			}
			return result + this.coefficient;
		}
		if(this.exponent == 1) {
			return "x"; //incomplete
		}
		
		return this.coefficient + "^" + this.exponent;
	}
}

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
	
	
	/**
	 * <summary>
	 * String constructor
	 * </summary>
	 * @param "term" term as a String
	 */
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
	
	/**
	 * <summary>
	 * Parses a coefficient string
	 * </summary>
	 * @param str Coefficient as a string
	 * @return Coefficient as an integer
	 */
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
	
	/**
	 * <summary>
	 * Parses an exponent string
	 * </summary>
	 * @param str Exponent as a string
	 * @return Exponent as an integer
	 */
	private int parseExponentString(String str) {
		return Integer.parseInt(str.substring(1));
	}
	
	/**
	 * <summary>
	 * Fully loaded constructor
	 * </summary>
	 * @param c Coefficient
	 * @param e Exponent
	 */
	public Term(int c, int e) {
		setAll(c,e);
	}
	
	/**
	 * <summary>
	 * Fully loaded constructor
	 * </summary>
	 * @param term Copy Constructor
	 */
	public Term(Term term) {
		setAll(term.coefficient, term.exponent);
	}

	/**
	 * Returns the coefficient
	 * @return coefficient
	 */
	public int getCoefficient() {
		return coefficient;
	}
	
	/**
	 * Sets the coefficient
	 * @param c Coefficient
	 */
	public void setCoefficient(int c) {
		this.coefficient = c;
	}
	
	/**
	 * Gets the exponent
	 * @return Exponent
	 */
	public int getExponent() {
		return this.exponent;
	}
	
	/**
	 * Sets the exponent
	 * @param e Exponent
	 */
	public void setExponent(int e) {
		this.exponent = e;
	}
	
	/**
	 * Set the coefficient and exponent
	 * @param c Coefficient
	 * @param e Exponent
	 */
	public void setAll(int c, int e) {
		setCoefficient(c);
		setExponent(e);
	}
	
	/**
	 * Clones the current Term, creating a new one
	 */
	public Term clone() {
		return new Term(this.coefficient, this.exponent);
	}
	
	/**
	 * Compares the exponents for terms
	 * @param otherTerm Term you are comparing to
	 * @return 0 = Same, -1 = parameter passed is higher exponent, 1 = parameter passed is less than exponent
	 */
	public int compareTo(Term otherTerm) {
		if(this.exponent == otherTerm.exponent) {
			return 0;
		} else if (this.exponent < otherTerm.exponent) {
			return -1;
		} else {
			return 1;
		}
	}
	
	
	@Override
	public boolean equals(Object o) {
		var castedTerm = (Term)o;
		return equals(castedTerm);
	}
	
	/**
	 * Used for the override equals after the object passed has been casted
	 * @param other Other term being compared
	 * @return true is both terms are equal, false if terms are different
	 */
	public boolean equals(Term other) {
		return this.coefficient == other.coefficient && this.exponent == other.exponent;
	}
	
	@Override
    public String toString() {
        String coefficientString;
        String exponentString;
        String ce = null;

        //handle x = 0

        if(this.exponent == 0) {
        	exponentString = "";

            if(this.coefficient == 0) {
            	coefficientString = "";
            } else if (this.coefficient == 1) {
            	coefficientString = "+x";
            	exponentString = "";
            } else if (this.coefficient == -1) {
            	coefficientString = "-x";
            	exponentString = "";
            } else if(this.coefficient > 1) {
            	coefficientString = "+" + Integer.toString(this.coefficient);

            } else if (this.coefficient < -1) {
            	coefficientString = Integer.toString(this.coefficient);

            } else
            	coefficientString = "";

        } else if(this.exponent == 1) { //handle x = 1
        	exponentString = "";
            if(this.coefficient == 0) {
            	coefficientString = "";
            } else if (this.coefficient == 1) {
            	coefficientString = "+x";
            	exponentString = "";
            } else if (this.coefficient == -1) {
            	coefficientString = "-x";
            	exponentString = "";
            } else if(this.coefficient > 1) {
            	coefficientString = "+" + Integer.toString(this.coefficient) + "x";

            } else if (this.coefficient < -1) {
            	coefficientString = Integer.toString(this.coefficient) + "x";

            } else
            	coefficientString = "";
        } else {
        	exponentString = "^" + Integer.toString(this.exponent);
                if(this.coefficient == 1) {
                	coefficientString = "+x";
                } else if(this.coefficient == -1) {
                	coefficientString = "-x";
                } else if(this.coefficient > 1) {
                	coefficientString = "+" + Integer.toString(this.coefficient) + "x";

                } else if (this.coefficient < -1) {
                	coefficientString = Integer.toString(this.coefficient) + "x";

                } else {
                	coefficientString = "";
                	exponentString = "";
                } 

            }

        ce = coefficientString + exponentString;

        return ce;
    }
}

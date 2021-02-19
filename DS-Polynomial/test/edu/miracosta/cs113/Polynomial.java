package edu.miracosta.cs113;

import java.util.LinkedList;

public class Polynomial implements Cloneable {
	LinkedList<Term> list = new LinkedList<Term>();

	public Polynomial() {
		
	}
	
	public Polynomial(Polynomial p) {
        for(Term t: p.list) {
            list.add(new Term(t)) ;
        }
    }
	
	public int getNumTerms() {
		return this.list.size();
	}
	
	public void addTerm(Term term) {
		if(this.list.size() > 0) {
			for(int i = 0; i < this.list.size(); i++) {
				// 0 = Same, -1 = parameter passed is lower exponent, 1 = parameter passed is higher exponent
				var comparedValue = this.list.get(i).compareTo(term);
				if(comparedValue == 0) {
					// Call CLT method
					Term combinedTerm = CombineLikeTerms(this.list.get(i), term);
					this.list.remove(i);
					if(combinedTerm.getCoefficient() != 0) {
						this.list.add(i, combinedTerm);						
					}
					break;
				}
				else if(comparedValue == -1) {
					this.list.add(i, term);
					break;
				} else if (comparedValue == 1){
					// if size == i , add to end list
					if(i == this.list.size() - 1) {
						this.list.add(term);
						break;
					}
				}
			}
		}
		else {
			this.list.add(term);
		}

	}
	
	private Term CombineLikeTerms(Term term1, Term term2) {
		int coefficient1 = term1.getCoefficient();
		int coefficient2 = term2.getCoefficient();
		int newCoefficient = coefficient1 + coefficient2;
		
		return new Term(newCoefficient, term1.getExponent());
	}
	
	public void add(Polynomial p) {
		for(Term term : p.list) {
			this.addTerm(term);
		}
	}
	
	public Term getTerm(int i) {
		return list.get(i);
	}
	
	public void clear() {
		this.list = new LinkedList<Term>();
	}
	
	@Override // Needs work
	public String toString() {
		return this.list.toString();
	}
	
	@Override
	public boolean equals(Object o) {
		var castedTerm = (Polynomial)o;
		return equals(castedTerm);
	}
	
	/**
	 * Used for the override equals after the object passed has been casted
	 * @param other Other polynomial being compared
	 * @return true is both polynomial are equal, false if polynomial are different
	 */
	public boolean equals(Polynomial other) {
		return this.list == other.list;
	}
}

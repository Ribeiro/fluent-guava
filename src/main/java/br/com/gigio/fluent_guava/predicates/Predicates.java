package br.com.gigio.fluent_guava.predicates;

import com.google.common.base.Predicate;
/***
 * 
 * @author gribeiro
 *
 */
public class Predicates {
	
	 public static Predicate<Integer> byEvenNumbers() {
	        return new Predicate<Integer>() {
	            
	            public boolean apply(Integer integer) {
	                return integer % 2 == 0;
	            }
	        };
	    }

	    public static Predicate<Integer> bigValues() {
	        return new Predicate<Integer>() {
	            
	            public boolean apply(Integer integer) {
	                return integer > 5;
	            }
	        };
	    }

}

package br.com.gigio.fluent_guava.functions;

import com.google.common.base.Function;
/***
 * 
 * @author gribeiro
 *
 */
public class Functions {
	
	 public static Function<Integer, Integer> byHalf() {
	        return new Function<Integer, Integer>() {
	            
	            public Integer apply(Integer integer) {
	                return integer / 2;
	            }
	        };
	    }

}

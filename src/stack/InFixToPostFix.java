package stack;

import java.util.*;

public class InFixToPostFix {
	public static void main(String[] args) {
		List<String> tests = new ArrayList<String>();
		tests.add("(a+b)/c");
		tests.add("a+b*(c^d-e)^(f+g*h)-i");
		tests.add("a+b*c");
		tests.add("(a+b)*c");
		tests.add("A*(B+C)/D");
		tests.add("a^b+c+d");
		for(String test: tests) {
			
		}
		System.out.println(tests.get(1) + " -> " + inFixToPostFix(tests.get(1).toLowerCase()));
	}

	private static String inFixToPostFix(String exp) {
		Deque<Character> stackA = new ArrayDeque<Character>();
		StringBuilder result = new StringBuilder();

		exp.chars().forEach(x -> {
			Character c = (char)x;
			if (isAritmeticOperator(c)) {
				proccessAritmeticSymbol(result, c, stackA);

			} else if (c.equals('(')) {
				stackA.addFirst(c);

			} else if (c.equals(')')) {
				proccessClosedParenthesis(result, stackA);	

			} else {
				result.append(c);
			}
		}	 
		);
		proccessRemain(result, stackA);
		return result.toString();
	}

	private static void proccessAritmeticSymbol(StringBuilder result,
	 	Character c, Deque<Character> stackA) {

		if (stackA.size() >= 1) {
			Character lastIn = stackA.getFirst();
			if (lastIn.equals('(')) {
				stackA.addFirst(c);

			} else if (samePriority(c, lastIn)) {
				if (leftToRighAssocition(c)) {
					result.append(stackA.removeFirst());
					stackA.addFirst(c);	
				} else {
					stackA.addFirst(c);
				}
					
			} else if (highPriority(c)) {
				stackA.addFirst(c);
			} else {
				result.append(stackA.removeFirst());
				stackA.addFirst(c);	
				
			}
		} else {
			stackA.addFirst(c);
		}	
	}

	private static boolean isAritmeticOperator(Character c) {
		if (c.equals('+')||c.equals('*')||c.equals('-')||c.equals('/')||c.equals('^')) 
			return true;
		else return false;
	}

	private static boolean samePriority(Character a, Character b) {
		if (a.equals('+') && b.equals('-')) return true;
		else if (a.equals('-') && b.equals('+')) return true;
		else if (a.equals('/') && b.equals('*')) return true;
		else if (a.equals('*') && b.equals('/')) return true;	
		else if (a.equals('^') && b.equals('^')) return true;	
		else return false;
	}

	private static boolean highPriority(Character a) {
		if (a.equals('^')) return true;
		else if (a.equals('*') || a.equals('/')) return true;
		else return false;
		
	}

	private static void proccessRemain(StringBuilder result, Deque<Character> stack) {
		while (stack.size() > 0) {
			result.append(stack.removeFirst());
		}
	}

	private static void proccessClosedParenthesis(
		StringBuilder result, Deque<Character> stack) {
			Character c;			

			do {
				c = stack.removeFirst();
				if (!c.equals('(')) result.append(c);
			} while (!c.equals('('));
	}

	private static boolean leftToRighAssocition(Character a) {
		if (a.equals('^')) return false;// + - and * / have Left to Right association
		else return true;
	}
} 
package stack;

import java.util.*;


public class CheckParenthesis {
	    
    public static void main(String[] arg) {
        String[] args = new String[10];
        args[0] = "()";
        args[1] = "[()]";
        args[2] = "{{()}}";
        args[3] = "[()[]{}]";
        args[4] = "(";
        args[5] = ")";
        args[6] = "())";
        args[7] = "({[})";
        args[8] = "((";
        args[9] = "))";
        
        Arrays.stream(args).forEach(s ->{
            System.out.print(s + " ");
	    System.out.println(checkParenthesis(s));

        });
    }
    
    private static boolean checkParenthesis(String s) {
        boolean result = true;
        Deque<Character> stack = new ArrayDeque<Character>();
        if (s.length() == 1) return false;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
           
            if (openChar(c)) {
               
                stack.addFirst(c);   
            } else {
                
                Character aux;
                try {
                    aux = stack.removeFirst();    
                } catch (NoSuchElementException e) {
                    result = false;
                    break;
                }
                
                if (openChar(aux)){
                    if (!sameType(aux, c)) {
                        result = false;
                        break;
                    }
                } else {
                    result = false;
                    break;
                }
            }
        }
        if (stack.size() > 0) return false;
        return result;
    }
    
    static boolean openChar(Character c) {
        if (c.equals('[') || c.equals('(') || c.equals('{')) return true;
        else return false;
    }
    
    static boolean sameType(Character open, Character close) {
        if (open.equals('(') && close.equals(')')) return true;
        else if (open.equals('[') && close.equals(']')) return true;
        else if (open.equals('{') && close.equals('}')) return true;
        else return false;
        
    }
}

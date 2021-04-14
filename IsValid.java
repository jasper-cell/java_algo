package niuke;

import java.util.Stack;

/**
 * 描述:  对字符串中的括号是否有效进行相应的匹配
 */
public class IsValid {
    public boolean isValid (String s) {
        // write code here
        Stack<Character> c = new Stack<Character>();
        char[] arr =  s.toCharArray();
        for(int i= 0; i< arr.length; i++){
            if(c.empty()){
                c.push(s.charAt(i));
                continue;
            }
            if(s.charAt(i) == ')' && c.peek() == '('){c.pop();}
            else if(s.charAt(i) == '}' && c.peek() == '{'){c.pop();}
            else if(s.charAt(i) == ']' && c.peek() == '['){c.pop();}
            else{c.push(s.charAt(i));}
        }

        return c.empty();
    }
}

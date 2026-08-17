import java.util.*;
class Solution{
	
	public static void main(String []argh)
	{
		Scanner sc = new Scanner(System.in);
		
		while (sc.hasNext()) {
			String input=sc.next();
            //Complete the code
            Stack <Character> stack = new Stack<>();
            boolean check = true;
            for(int i =0; i< input.length() ; i++){
                char ch = input.charAt(i);
                
                // check bracket 
                if (ch == '(' || ch == '{' || ch == '['){
                    stack.push(ch);
                }
                else{
                    if(stack.empty()){
                        check = false;
                        break; 
                    }
                    char top = stack.pop();
                    
                    if ((ch == ')' && top != '(') || 
                    (ch == ']' && top != '[') ||
                    (ch == '}' && top != '{') ){
                        check =  false;
                        break;
                    }
                }
                
            }
            if(!stack.empty()){
                check = false;
            }
            System.out.println(check);
		}
		
	}
}




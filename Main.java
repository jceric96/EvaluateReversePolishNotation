import java.util.*;

public class Main {

    static Stack<Integer> nums = new Stack<>();

    static int evalRPN(String[] tokens) {
        for (String token : tokens) {
            if (token.equals("+")) {
                nums.push(nums.pop() + nums.pop());
            } else if (token.equals("-")) {
                int number1 = nums.pop(), number2 = nums.pop();
                nums.push(number2 - number1);
            } else if (token.equals("*")) {
                nums.push(nums.pop() * nums.pop());
            } else if (token.equals("/")) {
                int number1 = nums.pop(), number2 = nums.pop();
                nums.push(number2 / number1);
            } else {
                nums.push(Integer.valueOf(token));
            }
        }
        return nums.pop();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;

        int _tokens_size = 0;
        _tokens_size = Integer.parseInt(in.nextLine().trim());
        String[] _tokens = new String[_tokens_size];
        String _tokens_item;
        for (int _tokens_i = 0; _tokens_i < _tokens_size; _tokens_i++) {
            try {
                _tokens_item = in.nextLine();
            } catch (Exception e) {
                _tokens_item = null;
            }
            _tokens[_tokens_i] = _tokens_item;
        }

        res = evalRPN(_tokens);
        System.out.println(String.valueOf(res));

    }
}

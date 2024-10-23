public class Main {
    public static void main(String[] args) throws Exception {
        String postfix = "1_2_+_3_*";
        int result = postfixToInfix.checkPostfix(postfix);
        System.out.println("Postfix to Infix ---> " + result);
    }
}

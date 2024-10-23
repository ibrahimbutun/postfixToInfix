public class postfixToInfix {
    public static int checkPostfix(String postfix) throws Exception {
        GenericStack<Integer> stk = new GenericStack<>(Integer.class, postfix.length());
        //split kullanarak alt tire ile ayırıyoruz.
        //alt tire yerine boşluk kullansak da çalışıyor. !!
        String[] tokens = postfix.split("_");

        //for döngüsü ile dizideki elemanları tek tek geziyoruz.
        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];
            if (isNumeric(token)) {
                stk.push(Integer.parseInt(token));
            } else {
                if (stk.isEmpty()) {
                    throw new Exception("Stack bos!");
                }
                int operand2 = stk.pop();
                if (stk.isEmpty()) {
                    throw new Exception("Stack bos!");
                }
                int operand1 = stk.pop();
                int result = applyOperation(token, operand1, operand2);
                stk.push(result);
            }
        }
        return stk.pop();
    }

    //girilen girdinin sayı olup olmadığını kontrol ediyoruz.
    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static int applyOperation(String operator, int operand1, int operand2) throws Exception {
        //switch-case yapısı ile matematiksel operatörleri kontrol ediyoruz.
        return switch (operator) {
            case "+" -> operand1 + operand2;
            case "-" -> operand1 - operand2;
            case "*" -> operand1 * operand2;
            case "/" -> operand1 / operand2;
            default -> throw new Exception("unknown operator!!!" + operator);
        };
    }

    public static void main(String[] args) throws Exception {
//        String postfix = "1_2_+_3_*";
//        int result = checkPostfix(postfix);
//        System.out.println();
//        System.out.println("Postfix to Infix -->> " + result);
    }
}

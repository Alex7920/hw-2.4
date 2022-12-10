public class Main {
    public static void main(String[] args) {
        boolean result = Validator.check("test_1234", "D_1hWiKjjP_9", "D_1hWiKjjP_9");
        if (result){
            System.out.println("Логин или парль корректный");
        }else {
            System.out.println("Логин или пароль некорректный");
        }
    }
}
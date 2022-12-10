public class Validator {
    private static final String VALID_CHARACTERS = "0123456789_abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static boolean check(String login, String password, String confirmPassword) {
        try {
            validate(login, password, confirmPassword);
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;

    }

    private static void validate(String login, String password, String confirmPassword)
            throws WrongPasswordException, WrongLoginException {

        if (login == null || login.length() > 20) {
            throw new WrongLoginException("длинна логина должна быть меньше или равна 20");
        }
        if (password == null || password.length() >= 20) {
            throw new WrongPasswordException("длинна парля должна быть меньше 20");
        }
        if (confirmPassword==null || !password.equals(confirmPassword)){
            throw new WrongPasswordException(" Пароли должны совпадать");

        }
        validateCharacters(login, true);
        validateCharacters(password, false);
    }
    private static void validateCharacters(String s,boolean islogin) throws WrongLoginException, WrongPasswordException {
        for (int i = 0; i < s.length(); i ++){
            if (!VALID_CHARACTERS.contains(String.valueOf(s.charAt(i)))) {
               if (islogin){
                   throw new WrongLoginException("В логине сдержится некорректный символ'"+s.charAt(i) + "'!");
               } else {
                   throw new WrongPasswordException("В пароле содержится некорректный символ'" +s.charAt(i) + "'!");
               }
            }
        }
    }
}
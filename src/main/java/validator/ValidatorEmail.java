package validator;

public class ValidatorEmail {
    private static final String EMAIL_REG_EXP = "^([\\w-.]{2,20})@((?:[\\w-]{0,10}\\.)?\\w[\\w-]{0,10})\\.([a-z]{2,6})$";

    public boolean isValidEmail(String email) {
        return email != null && email.matches(EMAIL_REG_EXP);
    }
}

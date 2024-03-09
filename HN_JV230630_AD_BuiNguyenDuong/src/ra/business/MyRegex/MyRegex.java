package ra.business.MyRegex;

public final class MyRegex {
    public static final String emNameRegex ="^[\\w|\\W]{10,50}$";
    public static final String subjectIdRegex ="^(MH)[0-9]{3}$";

    public static final String phoneRegex ="(0)[0-9]{9,10}";
    public static final String emailRegex ="^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^-]+(?:\\.[a-zA-Z0-9_!#$%&’*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";
    public static final String splitOrderId ="(PN|PX)-([0-9]{4})-([0-9]{2})";

}



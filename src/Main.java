import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        String s1 = "Hello";
        String s2 = "world";
        String s3 = "Concatenation";
        String s4 = "String";
        String s5 = "Code";
        String s6 = "abba";
        String s7 = "Abba";
        String m1 = "+012345678912";
        String m2 = "012345678912";
        String m3 = "+0123456789123";
        String m4 = "+01234567891";
        String m5 = "+01234567891b";
        String studName1 = "Roman";
        String studSurname1 = "Anonymus";
        String faculty1 = "Electrical";


        //3 methods of concatenation
        System.out.println("3 methods of concatenation");
        System.out.println(s1 + " " + s2);
        System.out.println(s1.concat(" ").concat(s2));
        System.out.println(String.format("%s %s", s1, s2));

        //middle letters in String
        System.out.println("Without taking into account odd/even number of letters is string");
        System.out.println(middle(s3));
        System.out.println(middle(s4));
        System.out.println(middle(s5));
        System.out.println("With taking into account odd/even number of letters is string");
        System.out.println(middle2(s3));
        System.out.println(middle2(s4));
        System.out.println(middle2(s5));

        //List of students
        System.out.println("List of students");
        System.out.println(listStudent("Student %s %s is studying at %s faculty", studName1, studSurname1, faculty1 ));
        System.out.println(listStudent("Student %s %s is studying at %s faculty", "Igor", "Cossacov", "Engineering" ));

        //Check for palindrom
        System.out.println("Check for palindrom");
        System.out.println(String.format("The word %s is palindrom = %b", s4, palyndrom(s4)));
        System.out.println(String.format("The word %s is palindrom = %b", s5, palyndrom(s5)));
        System.out.println(String.format("The word %s is palindrom = %b", s6, palyndrom(s6)));
        System.out.println(String.format("The word %s is palindrom = %b", s7, palyndrom(s7)));

        //Check phone number
        System.out.println("Check phone number");
//        System.out.println(mobile("+012345678912"));
//        System.out.println(mobile("012345678912"));
//        System.out.println(mobile("+0123456789123"));
//        System.out.println(mobile("+01234567891"));
//        System.out.println(mobile("+01234567891a"));
        System.out.println(String.format("The phone number %s is %b", m1, mobile(m1)));
        System.out.println(String.format("The phone number %s is %b", m2, mobile(m2)));
        System.out.println(String.format("The phone number %s is %b", m3, mobile(m3)));
        System.out.println(String.format("The phone number %s is %b", m4, mobile(m4)));
        System.out.println(String.format("The phone number %s is %b", m5, mobile(m5)));
    }

    public static String middle(String a) {
        int length = Integer.valueOf(a.length());
        int mid = length / 2;
        char ch1 = a.charAt(mid - 1);
        char ch2 = a.charAt(mid);
        return String.format("Middle of %s is '%c%c'",a, ch1, ch2);

    }
    public static String middle2(String a) {
        int length = Integer.valueOf(a.length());
        if (length % 2 == 0) {
            int mid = length / 2;
            char ch1 = a.charAt(mid - 1);
            char ch2 = a.charAt(mid);
            return String.format("Middle of %s is '%c%c'",a, ch1, ch2);
        }
        else {
            int mid = length / 2;
            char ch2 = a.charAt(mid);
            return String.format("Middle of %s is '%c'",a, ch2);
        }

    }
    public static String f(String target, String aim) {
        return String.format(target, aim);
    }
    public static String listStudent(String target, String name, String surname, String faculty) {
        return String.format(target, name, surname, faculty);
    }
    public static boolean palyndrom(String a) {
        String aLow = a.toLowerCase();
        String revers = "";
        boolean ans = false;
        for (int i = aLow.length()-1; i>=0; i--) {
            revers = revers + aLow.charAt(i);
        }
        if (aLow.equals(revers)){
            ans = true;
        }
        return ans;
    }

    public static boolean mobile(String target) {
        Pattern pattern = Pattern.compile("^\\++\\d{12}");
        Matcher matcher = pattern.matcher(target);
        return matcher.matches();
    }
}

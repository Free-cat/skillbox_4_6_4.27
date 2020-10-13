import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class BirthdayByYear {


    public static void main(String[] args) {
        Locale russianLocale = Locale.forLanguageTag("ru-RU");
        DateFormat dayOfWeekFormatter = new SimpleDateFormat("EEEE", russianLocale);
        Date nowDate = new Date();
        Calendar c = Calendar.getInstance();

        try {
            SimpleDateFormat inputFormat = new SimpleDateFormat("dd.MM.yyyy");
            Date docDate = inputFormat.parse(enterBirthday());
            c.setTime(docDate);
        } catch (ParseException e) {
            System.out.println("Не правильный формат даты");
            return;
        }

        int index = 0;
        while (c.getTime().compareTo(nowDate) < 0){
            System.out.println(String.format("%d - %s", index, dayOfWeekFormatter.format(c.getTime())));
            c.add(Calendar.YEAR, 1);
            index += 1;
        }
    }

    private static String enterBirthday(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите дату вашего рождения в формате dd.MM.yyyy, например, 27.05.1998");

        return scanner.nextLine();
    }
}

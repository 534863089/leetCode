
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class OrderedStream {

    public static void main(String[] args) throws ParseException {
        System.out.println(((60 * 30 * 1000) / (1000 * 60 * 60)));
        System.out.println(new BigDecimal((60 * 30 * 1000) / (1000 * 60 * 60)));
        System.out.println(new BigDecimal(60 * 30 * 1000).divide(new BigDecimal(1000 * 60 * 60)));
    }

    public static int yearDateDiff(String startDate, String endDate) throws ParseException {
        Calendar startCal = Calendar.getInstance();
        Calendar endCal = Calendar.getInstance();

        SimpleDateFormat yyyy = new SimpleDateFormat("yyyy");


        startCal.setTime(yyyy.parse(startDate));
        endCal.setTime(yyyy.parse(endDate));

        return endCal.get(Calendar.YEAR) - startCal.get(Calendar.YEAR);
    }
    public static int yearDateDiff(String startDate, Date endDate) throws ParseException {
        Calendar startCal = Calendar.getInstance();
        Calendar endCal = Calendar.getInstance();

        SimpleDateFormat yyyy = new SimpleDateFormat("yyyy");


        startCal.setTime(yyyy.parse(startDate));
        endCal.setTime(endDate);

        return endCal.get(Calendar.YEAR) - startCal.get(Calendar.YEAR);
    }
}

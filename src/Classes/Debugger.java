package Classes;

/**
 *
 * @author roger
 */
public class Debugger {

    public static void debug(Integer status, String message) {

        if (!message.equals("") && (status.equals(0) || status.equals(1) || status.equals(2))) {

            String str_stat = "";

            switch (status) {
                case 0:
                    str_stat = "INFO";
                    break;
                case 1:
                    str_stat = "WARNING";
                    break;
                case 2:
                    str_stat = "ERROR";
                    break;
            }

            System.out.println(str_stat + " -> " + message);
        }
    }
}

// Trying date formatting
import java.util.Locale;
import java.text.DateFormat;
import java.util.Date;
import static java.util.Locale.*;                                      // Import names of constants
import static java.text.DateFormat.*;                                  // Import names of constants

public class TryDateFormats {
  public enum Style {FULL, LONG, MEDIUM, SHORT}

  public static void main(String[] args) {
    Date today = new Date();
    Locale[] locales = {US, UK, GERMANY, FRANCE};

    // Output the date for each locale in four styles
    DateFormat fmt = null;
    for(Locale locale : locales) {
      System.out.println("\nThe Date for " + locale.getDisplayCountry() + ":");
      for (Style style : Style.values()) {
        fmt = DateFormat.getDateInstance(style.ordinal(), locale);
        System.out.println( "  In " + style + " is " + fmt.format(today));
      }
    }
  }
}
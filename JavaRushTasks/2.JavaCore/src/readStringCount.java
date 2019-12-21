import java.util.concurrent.atomic.AtomicInteger;

public class readStringCount {
    public static volatile AtomicInteger countReadStrings = new AtomicInteger(0);
}

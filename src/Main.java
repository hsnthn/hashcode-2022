import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    private static final String filePrefix = "a";

    public static void main(String[] args) throws IOException {
        final var input = FileUtils.readInts(filePrefix + ".txt");

        //TODO: task

        var res = new ArrayList<>(input.get(0));
        FileUtils.writeInts(filePrefix + ".out", Collections.singletonList(res));
    }

}

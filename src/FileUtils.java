import static java.util.stream.Collectors.toUnmodifiableList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FileUtils {

  public static void writeInts(final String path, final List<List<Integer>> list) throws IOException {
    try(final var writer = new BufferedWriter(new FileWriter(path))) {
      for (List<Integer> l : list) {
        var s = l.stream().map(String::valueOf).collect(Collectors.joining(" "));
//        System.out.println(s);
        writer.write(s + "\n");
      }
    }
  }

  public static List<List<Integer>> readInts(final String path) throws IOException {
    return readSplitted(path, Integer::parseInt);
  }

  public static List<List<Long>> readLongs(final String path) throws IOException {
    return readSplitted(path, Long::parseLong);
  }

  public static <T> List<List<T>> readSplitted(final String path, final Function<String, T> func) throws IOException {
    return read(path, s -> Arrays.stream(s.split("\\s+")).filter(s2 -> !s2.isEmpty()).map(func).collect(toUnmodifiableList()));
  }

  public static <T> List<T> read(final String path, final Function<String, T> func) throws IOException {
    return readLines(path)
        .stream()
        .map(func)
        .collect(toUnmodifiableList());
  }

  public static List<String> readLines(final String path) throws IOException {
    try(final var reader = new BufferedReader(new FileReader(path))) {
      return reader.lines().collect(toUnmodifiableList());
    }
  }

}

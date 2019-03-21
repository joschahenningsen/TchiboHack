package Server;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

/**
 * reads a template file and replaces contents you want to change in your route
 * @author Joscha Henningsen
 */
public class TemplateProcessor {
  private String contents;

  /**
   * Setup template processor by File name
   * @param fileName
   * @throws IOException
   */
  public TemplateProcessor(String fileName) throws IOException {
    InputStream is = new FileInputStream(fileName);
    BufferedReader br = new BufferedReader(new InputStreamReader(is));
    try {
      StringBuilder contentsBuilder = new StringBuilder();
      br.lines().forEach(l -> contentsBuilder.append(l + "\n"));
      this.contents = contentsBuilder.toString();
    } finally {
      is.close();
    }
  }

  /**
   * Replaces all values from the variableAssignments in the template
   * @param variableAssignments
   * @return String body
   */
  public String replace(java.util.Map<String, String> variableAssignments) {
    //sorts variables by length to prevent unwanted replacements
    Map<String, String> sortedAssignments = new TreeMap<>(
            (s1, s2) -> {
              if (s1.length() > s2.length()) {
                return -1;
              } else if (s1.length() < s2.length()) {
                return 1;
              } else {
                return s1.compareTo(s2);
              }
            });
    sortedAssignments.putAll(variableAssignments);
    sortedAssignments.
            keySet().
            stream().
            sorted(((TreeMap<String, String>) sortedAssignments).comparator()).
            forEach(s -> contents = contents.replaceAll(s, sortedAssignments.get(s)));
    return contents;
  }
}

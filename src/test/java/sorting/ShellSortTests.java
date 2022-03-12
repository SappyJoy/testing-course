package sorting;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class ShellSortTests {

  ShellSort sorter = new ShellSort();

  @DisplayName("Test correct work of sort algorithm")
  @Test
  void testSorting() {
    int[] arrayToSort = new int[]{5, 4, 3, 2, 1};
    int[] expectedResult = new int[]{1, 2, 3, 4, 5};

    sorter.sort(arrayToSort);
    assertArrayEquals(arrayToSort, expectedResult);
  }

  @DisplayName("Test correct work of sort algorithm")
  @ParameterizedTest
  @MethodSource("provideArraysForSortTests")
  void sortTests(int[] arrayToSort, int[] expectedResult) {
    System.out.println(
        "Test sorting with arrayToSort: " + Arrays.toString(arrayToSort) + " and expectedResult: "
            + Arrays.toString(expectedResult));

    sorter.sort(arrayToSort);
    assertArrayEquals(arrayToSort, expectedResult);
  }

  private static Stream<Arguments> provideArraysForSortTests() {
    List<Arguments> arguments = new ArrayList<>();
    int[][] arrays = {new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1},
        new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0},
        new int[]{-8, -4, -765, -256, -2, 234525, 26, 6, 2, 2},
        new int[]{2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}};
    for (int[] array : arrays) {
      arguments.add(Arguments.of(array, Arrays.stream(array).sorted().toArray()));
    }
    return arguments.stream();
  }
}

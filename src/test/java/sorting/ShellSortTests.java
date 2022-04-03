package sorting;

import static org.junit.jupiter.api.Assertions.*;

import java.io.DataOutput;
import java.lang.reflect.Array;
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
    @ParameterizedTest
    @MethodSource("provideArraysForSortTests")
    void sortTests(double[] arrayToSort, double[] expectedResult) {
        System.out.println(
                "Test sorting with arrayToSort: " + Arrays.toString(arrayToSort) + " and expectedResult: "
                        + Arrays.toString(expectedResult));

        sorter.sort(arrayToSort);
        System.out.printf(Arrays.toString(arrayToSort));
        assertArrayEquals(arrayToSort, expectedResult);
    }

    private static Stream<Arguments> provideArraysForSortTests() {
        List<Arguments> arguments = new ArrayList<>();
        double[][] arrays = {new double[]{9, 8, 7, 6, 5, 4, 3, 2, 1},
                new double[]{1D, 2D, 3D, 4D, 5D, 6D, 7D, 8D, 9D, 0D},
                new double[]{-8, -4, -765, -256, -2, 234525, 26, 6, 2, 2},
                new double[]{4},
                new double[]{Double.NaN},
                new double[]{Double.NaN,Double.NaN},
                new double[]{Double.NaN,Double.NaN,5},
                new double[]{5,Double.NaN,Double.NaN,5},
                new double[]{5,Double.NaN,Double.NaN,Double.POSITIVE_INFINITY},
                new double[]{5,Double.NaN,Double.NaN,Double.POSITIVE_INFINITY,234,26},
                new double[]{5,Double.POSITIVE_INFINITY,234,26,Double.NEGATIVE_INFINITY},
                new double[]{5, 5,6,7,8,3,3,Double.POSITIVE_INFINITY,4,7,4,2,5,6},
                new double[]{2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}};
        for (double[] array : arrays) {
            arguments.add(Arguments.of(array, Arrays.stream(array).sorted().toArray()));
        }
        return arguments.stream();
    }
}

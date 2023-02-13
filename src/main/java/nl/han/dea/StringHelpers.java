package nl.han.dea;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StringHelpers {

    public List<String> concatenatePairwise(List<String> input) {
        List<String> output = new ArrayList<>();
        IntStream.range(0, input.size() - 1)
                .filter(i -> i % 2 == 0)
                .mapToObj(i -> input.get(i) + " " + input.get(i + 1))
                .collect(Collectors.toCollection(() -> output));
        return output;
    }
}

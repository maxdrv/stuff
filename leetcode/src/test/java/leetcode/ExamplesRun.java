package leetcode;

import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.provider.Arguments;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ExamplesRun {

    private final List<Arguments> args;

    public ExamplesRun(Object... args) {
        this(Arrays.stream(args).toList());
    }

    public ExamplesRun(List<Object> args) {
        this.args = args.stream().map(Arguments::of).toList();
    }

    public Stream<Arguments> implementations() {
        return args.stream();
    }

}

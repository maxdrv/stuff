package util;

import java.util.Iterator;

public class Range implements Iterable<Integer> {

    private final int start;
    private final int end;

    public Range(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public static Range range(int from, int to) {
        return new Range(from, to);
    }

    @Override
    public Iterator<Integer> iterator() {
        return new RangeIterator(start, end);
    }

    private static class RangeIterator implements Iterator<Integer> {

        private final int end;
        private int current;

        public RangeIterator(int start, int end) {
            this.current = start;
            this.end = end;
        }

        @Override
        public boolean hasNext() {
            return current <= end;
        }

        @Override
        public Integer next() {
            return current++;
        }
    }
}

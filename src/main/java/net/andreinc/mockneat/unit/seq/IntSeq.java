package net.andreinc.mockneat.unit.seq;

/**
 * Copyright 2017, Andrei N. Ciobanu

 Permission is hereby granted, free of charge, to any user obtaining a copy of this software and associated
 documentation files (the "Software"), to deal in the Software without restriction, including without limitation the
 rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit
 persons to whom the Software is furnished to do so, subject to the following conditions:

 The above copyright notice and this permission notice shall be included in all copies or substantial portions of the
 Software.

 THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR
 OTHERWISE, ARISING FROM, FREE_TEXT OF OR PARAM CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS PARAM THE SOFTWARE.
 */

import net.andreinc.mockneat.MockNeat;
import net.andreinc.mockneat.abstraction.MockUnitInt;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.MIN_VALUE;
import static net.andreinc.aleph.AlephFormatter.str;
import static net.andreinc.mockneat.utils.ValidationUtils.INT_SEQ_OVERFLOW;
import static net.andreinc.mockneat.utils.ValidationUtils.SEQ_INVALID_RANGE;
import static net.andreinc.mockneat.utils.ValidationUtils.isTrue;

public class IntSeq implements MockUnitInt {

    private int increment = 1;
    private int start; // incremented with 0 by default
    private boolean cycle = true;
    private int max = MAX_VALUE;
    private int min = MIN_VALUE;
    private AtomicInteger internal;

    public static IntSeq intSeq() {
        return MockNeat.threadLocal().intSeq();
    }

    public IntSeq(int start, int increment, int max, int min, boolean cycle) {
        isTrue(min<max, str(SEQ_INVALID_RANGE).args("min", min, "max", max).fmt());
        this.increment = increment;
        this.start = start;
        this.cycle = cycle;
        this.max = max;
        this.min = min;
        this.internal = new AtomicInteger(start);
    }

    public IntSeq(int start, int increment) {
        this(start, increment, MAX_VALUE, MIN_VALUE, true);
    }

    public IntSeq(int increment) {
        this(0, increment, MAX_VALUE, MIN_VALUE, true);
    }

    public IntSeq() {
        this(0, 1, MAX_VALUE, MIN_VALUE, true);
    }

    /**
     * <p>Sets the {@code start} value of the {@code IntSeq}.</p>
     *
     * <p>By default the starting value is 0.</p>
     *
     * @param start The starting value.
     * @return The same {@code IntSeq} object.
     */
    public IntSeq start(int start) {
        isTrue(min<max, str(SEQ_INVALID_RANGE).args("min", min, "max", max).fmt());
        this.start = start;
        this.internal = new AtomicInteger(start);
        return this;
    }

    /**
     * <p>Sets the {@code increment} of the {@code IntSeq}.</p>
     *
     * <p>By default the increment value is 1.</p>
     *
     * @param increment The increment's value.
     * @return The same {@code IntSeq} object.
     */
    public IntSeq increment(int increment) {
        this.increment = increment;
        return this;
    }

    /**
     * <p>Enables or disables the "cycling" in the elements, if the max value was reached.</p>
     *
     * @param cycle The status of "cycling".
     *
     * @return The same {@code IntSeq} object.
     */
    public IntSeq cycle(boolean cycle) {
        this.cycle = cycle;
        return this;
    }

    /**
     * <p>Sets the max value that can be generated by the current {@code IntSeq}.</p>
     *
     * <p>By default, the value is set {@code Integer.MAX_VALUE}.</p>
     *
     * @param max The max value that can be generated by the current {@code IntSeq}.
     *
     * @return The same {@code IntSeq} object.
     */
    public IntSeq max(int max) {
        isTrue(min<max, str(SEQ_INVALID_RANGE).args("min", min, "max", max).fmt());
        this.max = max;
        return this;
    }

    /**
     * <p>Sets the min value that can be generated by the current {@code IntSeq}.</p>
     *
     * <p>By default, the value is set to {@code Integer.MIN_VALUE}</p>
     *
     * @param min The min value that can be generated by the current {@code IntSeq}
     * @return The same {@code IntSeq} object.
     */
    public IntSeq min(int min) {
        isTrue(min<max, str(SEQ_INVALID_RANGE).args("min", min, "max", max).fmt());
        this.min = min;
        return this;
    }

    private boolean nextValueOverflows() {
        return (increment>0) ? internal.get() > max :
                               internal.get() < min;
    }

    private void fail() {
        String fmt = str(INT_SEQ_OVERFLOW)
                        .arg("min", min)
                        .arg("max", max)
                        .fmt();
        throw new IllegalStateException(fmt);
    }

    @Override
    public Supplier<Integer> supplier() {
        return () -> {
            if (nextValueOverflows()) {
                if (cycle) internal.set(start);
                else fail();
            }
            return internal.getAndAdd(increment);
        };
    }
}

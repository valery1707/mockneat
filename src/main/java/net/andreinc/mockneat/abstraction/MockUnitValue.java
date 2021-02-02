package net.andreinc.mockneat.abstraction;

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

public final class MockUnitValue<T> implements MockValue<T> {

    private final MockUnit<T> mockUnit;

    private MockUnitValue(MockUnit<T> mockUnit) {
        this.mockUnit = mockUnit;
    }

    /**
     * Wraps a {@code MockUnit}.
     * @param unit The {@code MockUnit} to be wrapped.
     * @param <T> generic param for the MockUnit
     * @return A new {@code MockUnitValue}
     */
    public static <T> MockUnitValue<T> unit(MockUnit<T> unit) {
        return new MockUnitValue<>(unit);
    }

    /**
     * Retrieves one value generated by the wrapped {@code MockUnit}.
     * @return An Object value generated by the {@code MockUnit}
     */
    @Override
    public T get() {
        return mockUnit.supplier().get();
    }
}

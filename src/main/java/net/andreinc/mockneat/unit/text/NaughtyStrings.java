package net.andreinc.mockneat.unit.text;

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
import net.andreinc.mockneat.abstraction.MockUnitBase;
import net.andreinc.mockneat.abstraction.MockUnitString;
import net.andreinc.mockneat.types.enums.DictType;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;


public class NaughtyStrings extends MockUnitBase implements MockUnitString {

    private final List<MockUnitString> mockUnitStrings =
                    Arrays.asList(
                            cveVulnerabilities(),
                            emoji(),
                            fileInclusions(),
                            inconousStrings(),
                            japaneseEmoji(),
                            msdosSpecialFileNames(),
                            numeric(),
                            quotations(),
                            regionalIndicators(),
                            reservedKeyWords(),
                            rightToLeftStrings(),
                            rubyInjection(),
                            scriptInjection(),
                            serverCodeInjection(),
                            specialChars(),
                            sqlInjection(),
                            trickUnicode(),
                            twoByteChars(),
                            unicodeFont(),
                            unicodeNumbers(),
                            unicodeSubScriptSuperScript(),
                            unicodeSymbols(),
                            unicodeUpsideDown(),
                            unwantedInterpolation(),
                            xmlInjection(),
                            zalgoText()
                    );


    public static NaughtyStrings naughtyStrings() {
        return MockNeat.threadLocal().naughtyStrings();
    }

    protected NaughtyStrings() {
    }

    public NaughtyStrings(MockNeat mockNeat) {
        super(mockNeat);
    }

    @Override
    public Supplier<String> supplier() {
        return mockNeat.from(mockUnitStrings).val().supplier();
    }

    public MockUnitString cveVulnerabilities() {
        return mockNeat.dicts().type(DictType.NS_CVE_VULNERABILITIES);
    }

    public MockUnitString emoji() {
        return mockNeat.dicts().type(DictType.NS_EMOJI);
    }

    public MockUnitString fileInclusions() {
        return mockNeat.dicts().type(DictType.NS_FILE_INCLUSIONS);
    }

    public MockUnitString inconousStrings() {
        return mockNeat.dicts().type(DictType.NS_INCONOUS_STRINGS);
    }

    public MockUnitString japaneseEmoji() {
        return mockNeat.dicts().type(DictType.NS_JAPANESE_EMOJI);
    }

    public MockUnitString msdosSpecialFileNames() {
        return mockNeat.dicts().type(DictType.NS_MSDOS_SPECIAL_FILENAMES);
    }

    public MockUnitString numeric() {
        return mockNeat.dicts().type(DictType.NS_NUMERIC);
    }

    public MockUnitString quotations() {
        return mockNeat.dicts().type(DictType.NS_QUOTATIONS);
    }

    public MockUnitString regionalIndicators() {
        return mockNeat.dicts().type(DictType.NS_REGIONAL_INDICATORS);
    }

    public MockUnitString reservedKeyWords() {
        return mockNeat.dicts().type(DictType.NS_RESERVED_KEYWORDS);
    }

    public MockUnitString rightToLeftStrings() {
        return mockNeat.dicts().type(DictType.NS_RIGHT_TO_LEFT_STRINGS);
    }

    public MockUnitString rubyInjection() {
        return mockNeat.dicts().type(DictType.NS_RUBY_INJECTION);
    }

    public MockUnitString scriptInjection() {
        return mockNeat.dicts().type(DictType.NS_SCRIPT_INJECTION);
    }

    public MockUnitString serverCodeInjection() {
        return mockNeat.dicts().type(DictType.NS_SERVER_CODE_INJECTION);
    }

    public MockUnitString specialChars() {
        return mockNeat.dicts().type(DictType.NS_SPECIAL_CHARS);
    }

    public  MockUnitString sqlInjection() {
        return mockNeat.dicts().type(DictType.NS_SQL_INJECTION);
    }

    public MockUnitString trickUnicode() {
        return mockNeat.dicts().type(DictType.NS_TRICK_UNICODE);
    }

    public MockUnitString twoByteChars() {
        return mockNeat.dicts().type(DictType.NS_TWO_BYTE_CHARS);
    }

    public MockUnitString unicodeFont() {
        return mockNeat.dicts().type(DictType.NS_UNICODE_FONT);
    }

    public MockUnitString unicodeNumbers() {
        return mockNeat.dicts().type(DictType.NS_UNICODE_NUMBERS);
    }

    public MockUnitString unicodeSymbols() {
        return mockNeat.dicts().type(DictType.NS_UNICODE_SYMBOLS);
    }

    public MockUnitString unicodeUpsideDown() {
        return mockNeat.dicts().type(DictType.NS_UNICODE_UPSIDE_DOWN);
    }

    public MockUnitString unicodeSubScriptSuperScript() {
        return mockNeat.dicts().type(DictType.NS_UNICODE_SUBSCRIPT_SUPERSCRIPT);
    }

    public MockUnitString unwantedInterpolation() {
        return mockNeat.dicts().type(DictType.NS_UNWANTED_INTERPOLATION);
    }

    public MockUnitString xmlInjection() {
        return mockNeat.dicts().type(DictType.NS_XML_INJECTION);
    }

    public MockUnitString zalgoText() {
        return mockNeat.dicts().type(DictType.NS_ZALGO_TEXT);
    }
}

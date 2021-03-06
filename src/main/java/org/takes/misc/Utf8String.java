/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2014-2019 Yegor Bugayenko
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included
 * in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NON-INFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package org.takes.misc;

import java.nio.charset.Charset;
import org.cactoos.Bytes;
import org.cactoos.Text;

/**
 * String that uses UTF-8 encoding for all byte operations.
 * @since 0.33
 * @todo #998:30min Please remove this class and use
 *  {@link org.cactoos.io.BytesOf} decorator instead of this class.
 *  Use {@link org.cactoos.text.TextOf} decorator where required with
 *  combination of {@link org.cactoos.io.BytesOf}.
 *  The {@link org.cactoos.io.BytesOf} contains several different constructors
 *  for most of the inputs and supports UTF-8.
 */
public final class Utf8String implements Bytes, Text {

    /**
     * UTF-8 encoding.
     */
    private static final String ENCODING = "UTF-8";

    /**
     * String value.
     */
    private final String value;

    /**
     * Ctor.
     * @param string String value
     */
    public Utf8String(final String string) {
        this.value = string;
    }

    /**
     * Ctor.
     * @param bytes Bytes to construct UTF-8 string value
     */
    public Utf8String(final byte... bytes) {
        this(new String(bytes, Charset.forName(Utf8String.ENCODING)));
    }

    @Override
    public byte[] asBytes() {
        return this.value.getBytes(Charset.forName(Utf8String.ENCODING));
    }

    @Override
    public String asString() {
        return this.value;
    }
}

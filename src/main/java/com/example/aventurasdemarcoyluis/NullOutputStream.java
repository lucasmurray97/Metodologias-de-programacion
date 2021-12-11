package com.example.aventurasdemarcoyluis;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Null outputstream for silent testing.
 */
public class NullOutputStream extends OutputStream {
    @Override
    public void write(int b) throws IOException {
    }
}
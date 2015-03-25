package com.unlu.erkin;

import java.io.IOException;

/**
 * Created by unlue on 24/03/15.
 */
class AirPlane {
    public AirPlane() throws IOException {
        System.out.print("AirPlane");
    }

    public static void tryMe() throws IOException {
        System.out.print("AirPlane TryMe!");
        throw new IOException();
    }
}

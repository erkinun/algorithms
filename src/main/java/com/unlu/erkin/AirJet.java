package com.unlu.erkin;

import java.io.IOException;

/**
 * Created by unlue on 24/03/15.
 */
class AirJet extends AirPlane {

    public static void main(String[] args) {
        try {
            new AirJet();
        } catch (IOException e) {
            System.out.print("IOException is thrown in Tester");
        }

    }

    public AirJet() throws IOException {
        try{
            AirPlane.tryMe();
        }
        catch (IOException exception) {
            System.out.print("IOException is thrown in AirJet");
        }
    }
}


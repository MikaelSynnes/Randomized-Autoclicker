/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autoclicker;

/**
 *
 * @author Mikael
 */
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Random;

/**
 * Simple auto-clicker.
 *
 * @author Mikael
 */
public class Clicker {

    public static int rate;
    public static int rndNr = 0;
    public static int r = 0;
    public static int clicks;
    public static int maxIntervall;
    int k;
    boolean on = false;

    public Clicker() {
    }

    public void setValues(int clicks, int rate, int maxIntervall) {
        this.rate = rate;
        this.clicks = clicks;
        this.maxIntervall = maxIntervall;
    }

    public void go() {
        on=false;
        while (rate == 0) {
            try {
                System.out.println("Speed of the auto-clicker (in miliseconds):");
                BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
                try {
                    rate = Integer.parseInt(in.readLine());
                    if (rate < 1) {
                        rate = 0;
                        System.out.println("Must be at least 500 miliseconds.");
                    }
                } catch (NumberFormatException ex) {
                    System.out.println("Error - please try again.");
                }
            } catch (IOException e) {
            }
        }
        try {
            Robot robot = new Robot();
            for (k = 1; k < clicks + 1; k++) {
                    if (on == true) {
                        break;
                    }

                try {
                    Random rn = new Random();

                    int i = rn.nextInt(maxIntervall);
                    if (200 < i && i < 210) {
                        //     i = (i + r * r) % 20000;
                    }
                    if (i == 0) {
                        i = 200;
                        i = r * r * r % 100000;

                    }

                    Thread.sleep(rate + i + 148);
                    robot.mousePress(InputEvent.BUTTON1_MASK);
                    r = (i * i) % 97;
                    if (r < 0) {
                        r = 125;
                    }
                    System.out.println(r + " click number: " + k);
                    Thread.sleep(r);
                    robot.mouseRelease(InputEvent.BUTTON1_MASK);
                } catch (InterruptedException ex) {
                }
            }
        } catch (AWTException e) {
        }

    }

    public void Stop() {
        on = true;

    }

}

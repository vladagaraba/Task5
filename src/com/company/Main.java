package ru.vsu.cs.garaba;

import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        int width = readWidth();
        drawPicture(width);
    }

    private static void drawPicture(int width) {
        drawPictureBorder(width);
        drawMiddle(width);
        drawPictureBorder(width);
    }


    private static void drawMiddle(int width) {
        int height = calculateHeight(width);
        for (int i = 0; i < height; i++) {
            drawRow(width, i < height / 2 ? i : height - i - 1);
        }
    }

    private static void drawRow(int width, int amountExclamationPoint ) {
        int pos = (1 + amountExclamationPoint) * amountExclamationPoint / 2 + 1;
        System.out.print("|");
        for (int i = 1; i < width - 1; i++) {
            if (pos <= i  && i <= pos + amountExclamationPoint) {
                System.out.print("!");
            } else {
                System.out.print(" ");
            }

        }
        System.out.println("|");
    }

    private static int calculateHeight(int width) {
        return  2 * (int) Math.ceil((-1 + Math.sqrt(1 + 8 * (width - 2))) / 2) - 1;
    }

    private static void drawPictureBorder(int width) {
        System.out.print(" ");
        for (int i = 0; i < width - 2; i++) {
            System.out.print("-");
        }
        System.out.println(" ");

    }

    public static int readWidth() {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter width of shape: ");
        return scn.nextInt();
    }
}




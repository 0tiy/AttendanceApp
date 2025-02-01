package com.example.AttendanceApp.console;

import org.springframework.stereotype.Component;

import static com.example.AttendanceApp.console.ConsoleColors.*;

public class Printer {

    /*
COLOR USAGE GUIDE:
🔴 Red - Errors, critical failures, exceptions
🟢 Green - Success messages, confirmations, "OK" statuses
🟡 Yellow - Warnings, deprecations, cautionary messages
🔵 Blue - Informational messages, system logs, debugging info
🟣 Purple - User input prompts, alternative info, special states
🔵 Cyan - Networking, API calls, connection statuses
⚪ White - Neutral messages, general output, fallback color
*/

    public static void red (String text) {
        System.out.println(ANSI_RED + text + ANSI_RESET);
    }

    public static void green(String text) {
        System.out.println(ANSI_GREEN + text + ANSI_RESET);
    }

    public static void yellow(String text) {
        System.out.println(ANSI_YELLOW + text + ANSI_RESET);
    }

    public static void blue(String text) {
        System.out.println(ANSI_BLUE + text + ANSI_RESET);
    }

    public static void purple(String text) {
        System.out.println(ANSI_PURPLE + text + ANSI_RESET);
    }

    public static void cyan(String text) {
        System.out.println(ANSI_CYAN + text + ANSI_RESET);
    }

    // Background methods with padding
    public static void redBackground(String text) {
        System.out.println(ANSI_RED_BACKGROUND + ANSI_BLACK + " " + text + " " + ANSI_RESET);
    }

    public static void greenBackground(String text) {
        System.out.println(ANSI_GREEN_BACKGROUND + ANSI_BLACK + " " + text + " " + ANSI_RESET);
    }

    public static void yellowBackground(String text) {
        System.out.println(ANSI_YELLOW_BACKGROUND + ANSI_BLACK + " " + text + " " + ANSI_RESET);
    }

    public static void blueBackground(String text) {
        System.out.println(ANSI_BLUE_BACKGROUND + ANSI_BLACK + " " + text + " " + ANSI_RESET);
    }

    public static void purpleBackground(String text) {
        System.out.println(ANSI_PURPLE_BACKGROUND + ANSI_BLACK + " " + text + " " + ANSI_RESET);
    }

    public static void cyanBackground(String text) {
        System.out.println(ANSI_CYAN_BACKGROUND + ANSI_BLACK + " " + text + " " + ANSI_RESET);
    }

    public static void whiteBackground(String text) {
        System.out.println(ANSI_WHITE_BACKGROUND + ANSI_BLACK + " " + text + " " + ANSI_RESET);
    }



}

package ui;

public class AvatarUi {

    private static final String AVATAR_ASCII_ART = 
            "▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▓▓▓████▓▓▓▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒\n" +
            "▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▓█████▓▓▓▓▓▓▓▓███▓▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒\n" +
            "░░░░░░░░░░░░░░░░░░░░░░░░░░░▒▓███████▓▓▓▓▓▓▓▓▓██████▓▒░░░░░░░░░░░░░░░░░░░░░░░░░░░\n" +
            "░░░░░░░░░░░░░░░░░░░░░░░░░░▒██████▓▓▓▒▒▒▓▓▓▓████▓▓▓███▒░░░░░░░░░░░░░░░░░░░░░░░░░░\n" +
            "▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▓████▓▓▓▓▓▓██▓███████▓▓▓▓██▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒\n" +
            "▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▓█████████████████▓▓▓▓▓█▓▓███▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒\n" +
            "░░▒▒░░░░░░░░░░░░░░░░░░░░░▓█████▓▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▓▓▓███▒░░░░░░░░░░░░░░░░░░▒▒░░▒▒▒\n" +
            "░░▒▒░░░░░░░░░░░░░░░░░░░░░▓████▓▓▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▓████▓░░░░░░░░░░░░░░░░░░░▒▒░░▒▒░\n" +
            "░░▒▒░░░░░░░░░░░░░░░░░░░░░░████▓▓▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▓████▒░░░░░░░░░░░░░░░░░░░▒▒░░▒▒░\n" +
            "░░▒▒░░░░░░░░░░░░░░░░░░░░░░████▓▓▓▓▒▒▒▒▒▒▒▒▒▒▒▒▓▓▓▓███░░░░░░░░░░░░░░░░░░░░▒▒░░▒▒░\n" +
            "░░▒▒░░░░░░░░░░░░░░░░░░░░░░▓███▓▓▓▓████▒▒▒▓████▓▓▓▓██▓▒░░░░░░░░░░░░░░░░░░░▒▒░░▒▒░\n" +
            "░░▒▒░░░░░░░░░░░░░░░░░░░░░░▓██▓▒▓█▓▓▓▓▒▓▒▒▓▒▓▓▓▓▓▒▓██▓▒░░░░░░░░░░░░░░░░░░░▒▒░░▒▒░\n" +
            "░░▒▒░░░░░░░░░░░░░░░░░░░░░░▓▓█▓▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▓██▓▒░░░░░░░░░░░░░░░░░░░▒░░░▒▒░\n" +
            "░░▒▒░░░░░░░░░░░░░░░░░░░░░░░▓▓█▓▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▓█▓▒░░░░░░░░░░░░░░░░░░░░▒▒░░▒▒░\n" +
            "░░▒▒░░░░░░░░░░░░░░░░░░░░░░░░▒▓▓▓▒▒▒▒▒▒▓▒▒▓▒▒▒▒▒▓▓▓▓▒░░░░░░░░░░░░░░░░░░░░░▒▒░░▒▒░\n" +
            "░░▒▒░░░░░░░░░░░░░░░░░░░░░░░░░░▓▓▓▒▒▒▒▒▓▓▓▓▒▒▒▒▒▓▓▓░░░░░░░░░░░░░░░░░░░░░░░▒░░░▒▒░\n" +
            "░░▒▒░░░░░░░░░░░░░░░░░░░░░░░░░░▓▓▓▓▒▒▒▒▓▒▒▓▒▒▒▒▓▓▓▓░░░░░░░░░░░░░░░░░░░░░░░▒░░░▒▒░\n" +
            "░░▒▒░░░░░░░░░░░░░░░░░░░░░░░░░░▒▓▓▓▒▒▒▓▓▓▓▓▓▒▒▓▓▓▓░░░░░░░░░░░░░░░░░░░░░░░░▒░░░▒▒░\n" +
            "░░▒▒░░░░░░░░░░░░░░░░░░░░░░░░░░░██▓▓▒▒▒▒▒▒▒▒▒▒▓▓█▓░░░░░░░░░░░░░░░░░░░░░░░░▒░░░▒▒░\n" +
            "░░▒▒░░░░░░░░░░░░░░░░░░░░░░░░░░▒█▓▓█▓▓▒▒▒▒▒▒▓▓█▓▓▓░░░░░░░░░░░░░░░░░░░░░░░░▒▒░░▒▒░\n" +
            "░░▒▒░░░░░░░░░░░░░░░░░░░░░░░░░▓▓▓▓▓▓▓█▓▓▓▓▓██▓▒▒▓▒▓▒░░░░░░░░░░░░░░░░░░░░░░▒▒░░▒▒░\n" +
            "░░▒▒░░░░░░░▒░░░░░░░░░░░░░░░▒██▒▒▒▒▓▓▓▓▓▓▓▓▓▓▒▒▒▒▒▓██▒░░░░░░░░░░░░░░░░░░░░▒▒░░▒▒▒\n" +
            "░░▒▒░░░░▒▒▓▒▒▒▒▒░░░░░░░░▒▓████▒▒▒░░░▒▓▓▓▓▒▒▒░░░▒▒▒████▓▒░░░░░░░░░░░░░░░░░▒▒░░▒▒▒\n" +
            "░░▒▒░░▒▒▓▓▓▓▓▒░░░░░░▒▓▓███████▒▒░░░░░░▒▓▓▒░░░░░▒▒▒███████▓▓▒░░░░░░░░░░░░░▒▒░░▒▒░\n" +
            "▒▒▒▒░░░▒▓▓▓▓▒▒░▒▓▓██████████▓█▒▒░░░░▒██████░░░░░▒▒█▓██████████▓▓▓▒▒▒▒▒▒▒▒▒▒░░▒▒░\n" +
            "▓▓▓▓▒▒▒▒▓▓████████████████▓▓▓█▒▒░░░▒▒██████▒▒░░░▒▒█▓▓▓███████████████▓▓▓▓▓▒▒▒▒▒▒\n" +
            "▓▓▓▓▒▒▓██████████▓▓▓▓▓██▓▓▓▓▓█░░░░▒░░▒████░░░▒░░░▒█▓▓▓▓▓██▓▓▓▓▓▓███████████▓▓▓▒▒\n" +
            "▓▓▓▓█████████▓▓▓▓▓▓█▓▓▓▓▓▓▓▓▓█▒░░░░░░░████░░░░░░░▓█▓▓▓▓▓▓▓▓▓▓█▓▓▓▓▓▓████████▓▓▓▓\n" +
            "███▓███▓█▓▓▓▓▓▓▓▓▓▓█▓▓█▓▓▓▓▓▓█▓░░░░░░▓████▒░░░░░░██▓▓▓▓▓██▓▓█▓▓▓▓▓▓▓▓▓▓▓████▒▒▒▒\n" +
            "▒▒▒▒███▓█▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓██░░░░░░█████▓░░░░░▒██▓▓▓▓▓▓▓▓▓█▓▓▓▓▓▓▓▓▓▓█▓███▓▓▓▓\n" +
            "▓▓▓▓████▓█▓▓▓▓▓▓▓▓▓▓█▓▓▓▓▓▓▓▓██▓░░░░░██████░░░░░▓██▓▓▓▓▓▓▓▓█▓▓▓▓▓▓▓▓▓▓▓██████▓██\n" +
            "████████▓██▓▓▓▓▓▓▓▓▓██▓▓▓▓▓▓▓██▓▒░░░▒██████▒░░░▒▓██▓▓▓▓▓▓▓▓█▓▓▓▓▓▓▓▓▓██▓█████▓▓▓\n" +
            "▓▓▓████████████▓▓▓▓▓▓██▓▓▓▓▓▓██▓▓░░░▓██████▒░░░▓▓██▓▓▓▓▓▓███▓▓▓▓▓▓▓███████████▓▓\n" +
            "░░░█████████████████▓██████████▓▓▓░░▓██████▓░░▓▓▓███████████████████████████████\n" +
            "▒▒▓█████████████████████████████▓▓▒░▓███████░▒█▓▓█████████████████████████████▓▓\n" +
            "█▓█████████████████████████████████▒▓███████░▓▓▓████████████▓▓▓▓▓█████████████▒▒\n" +
            "█▒██████████████████████████████████████████▓████████████▓▓▓▓█████████████████▓▒\n" +
            "█▒████████████████████████████████████████████████████████████████████████████▓▒\n" +
            "▓▓█████████████████████████████████████████████████████████████████████████████▒\n" +
            "▓▓█████████████████████████████████████████████████████████████████████████████▒\n";

    private static final String WELCOME_MESSAGE = "Hello there, I am CLI-nton, your CLI-based " + 
            "personal assistant in event management!";

    public static void printAvatar() {
        String[] lines = AVATAR_ASCII_ART.split("\n");
        int terminalWidth = TerminalSize.getTerminalWidth();
        int avatarWidth = lines[0].length();
        int avatarPadding = Math.max((terminalWidth - avatarWidth) / 2, 0);

        for (String line : lines) {
            System.out.print(" ".repeat(avatarPadding));
            System.out.println(line);
        }
    }

    public static void printWelcomeMessage() {
        int terminalWidth = TerminalSize.getTerminalWidth();
        int messagePadding = Math.max((terminalWidth - WELCOME_MESSAGE.length()) / 2, 0);
        System.out.print(" ".repeat(messagePadding));
        System.out.println("Hello there, I am CLI-nton, your CLI-based personal assistant in event management!");
    }
}
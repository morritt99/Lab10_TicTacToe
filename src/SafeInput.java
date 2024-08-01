import java.util.Scanner;

public class SafeInput {
    /**
     * Use scanner to get an int from the console with no constraints
     *
     * @param pipe   Console input (String)
     * @param prompt String prompt to tell the user what to input
     * @return an Int value
     */
    public static int getInt(Scanner pipe, String prompt) {
        int retVal = 0;
        String trash = "";
        boolean done = false;

        do {
            //prompt num [1-10]
            System.out.print(prompt + ": ");
            if (pipe.hasNextInt()) {
                retVal = pipe.nextInt();
                pipe.nextLine();
                done = true;
            } else {
                trash = pipe.nextLine();
                System.out.println(trash + " Is not a valid number");
            }

        }
        while (!done);

        return retVal;
    }

    /**
     * Get an integer value within a specified range of low-high
     *
     * @param pipe   Scanner to use for console input
     * @param prompt String that asks user what to input
     * @return an int value within the range
     */
    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {
        int retVal = 0;
        String trash = "";
        boolean done = false;

        do {
            //prompt num [1-10]
            System.out.print(prompt + "[ " + low + " - " + high + "]: ");
            if (pipe.hasNextInt()) {
                retVal = pipe.nextInt();
                pipe.nextLine();
                if (retVal >= low && retVal <= high) {
                    System.out.println("\nYou Entered: " + retVal);
                    done = true;
                } else {

                    System.out.println(retVal + " is out of range! [" + low + " - " + high + "]");
                }
            } else {
                trash = pipe.nextLine();
                System.out.println(trash + " Is not a valid number");
            }

        }
        while (!done);

        return retVal;
    }

    /**
     * Use scanner to get a double from the console with no constraints
     *
     * @param pipe   Console input (double)
     * @param prompt String prompt to ask the user what to input
     * @return a double
     */
    public static double getDouble(Scanner pipe, String prompt) {
        double retVal = 0;
        String trash = "";
        boolean done = false;

        do {
            //prompt num [1-10]
            System.out.print(prompt + ": ");
            if (pipe.hasNextDouble()) {
                retVal = pipe.nextDouble();
                pipe.nextLine();
                done = true;
            } else {
                trash = pipe.nextLine();
                System.out.println(trash + "You must enter a double not: " + trash);
            }

        }
        while (!done);

        return retVal;
    }

    /**
     * Get a double value within a specified range
     *
     * @param pipe   Scanner to use for console input
     * @param prompt String that tells user what to input
     * @param low    low value for the range [low to high]
     * @param high   high value if the range
     * @return a double value within the low - high range
     */
    public static int getRangedDouble(Scanner pipe, String prompt, double low, double high) {
        double retVal = low - 1;
        String trash = "";
        boolean done = false;

        do {
            //prompt num [1-10]
            System.out.print(prompt + "[ " + low + " - " + high + "]: ");
            if (pipe.hasNextDouble()) {
                retVal = pipe.nextDouble();
                pipe.nextLine();
                if (retVal >= low && retVal <= high) {
                    //System.out.println("\nYour Fav Num is: " + retVal);
                    done = true;
                } else {
                    System.out.println("You said your fav num is " + retVal + " but that is out of range! [" + low + " - " + high + "]");
                }
            } else {
                trash = pipe.nextLine();
                System.out.println(trash + " Is not a valid number");
            }

        }
        while (!done);

        return (int) retVal;
    }

    /**
     * get an arbitrary String of at least one character in length
     *
     * @param pipe   Scanner to use for input
     * @param prompt Prompt msg for use about what to input
     * @return a String entered with at least 1 character
     */
    public static String getNonZeroLenString(Scanner pipe, String prompt) {

        String retVal = "";
        boolean done = false;

        do {
            //prompt num [1-10]
            System.out.print(prompt + ": ");
            retVal = pipe.nextLine();
            if (retVal.length() > 0) // if the string has at least 1 character in it
            {
                done = true;
            } else {
                System.out.println("You must enter at least 1 character: ");
            }

        }
        while (!done);

        return retVal;

    }


    /**
     * @param pipe    scanner for input
     * @param prompt  string prompt
     * @param pattern a regEx pattern to use for the test
     * @return a String that matches the regEx pattern
     */
    public static String getRegExString(Scanner pipe, String prompt, String pattern) {

        String retVal = "";
        boolean done = false;

        do {
            //prompt num [1-10]
            System.out.print(prompt + ": ");
            retVal = pipe.nextLine();

            if (retVal.matches(pattern)) // if the string has at least 1 character in it
            {
                done = true;
            } else {
                System.out.println("What you entered does not match the pattern: ");
            }

        }
        while (!done);

        return retVal;

    }

    /**
     * @param pipe   scanner to use to get inpput
     * @param prompt String prompt
     * @return a yes or no answer
     */
    public static boolean getYNConfirm(Scanner pipe, String prompt) {
        String respYN = "";
        boolean retVal = false;
        boolean done = false;
        do {
            System.out.println(prompt + "[Y/N]: ");
            respYN = pipe.nextLine();

            if (respYN.equalsIgnoreCase("Y")) {
                retVal = true;
                done = true;
            } else if (respYN.equalsIgnoreCase("N")) {
                retVal = false;
                done = true;
            } else {
                System.out.println("You must enter [Y/N]: ");
            }
        }
        while (!done);

        return retVal;

    }

    public static void prettyHeader(String msg)
    {
        int whiteSpace = (53 - msg.length()) / 2;

        for (int x = 0; x <= 59; x++)
        {
            System.out.print("*");
        }
        System.out.print("\n***");

        for (int x = 0; x <= whiteSpace; x++)
        {
            System.out.print(" ");
        }

        System.out.print(msg);

        for (int x = 0; x <= whiteSpace; x++)
        {
            System.out.print(" ");
        }

        System.out.println("***");

        for (int x = 0; x <= 59; x++)
        {
            System.out.print("*");
        }
    }

}



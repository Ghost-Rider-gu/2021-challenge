package siendev.corp.apps.other;

/**
 * @author Iurii Golubnichenko
 *
 * Just a simple progress line animation in the Console.
 */
public class ProgressAnimation {

    private static final String PROGRESS_TITLE = "Loading the application...  0%";
    private int lengthOfProgress = 100;

    public void setLengthOfProgress(int lengthOfProgress) {
        if (lengthOfProgress < 0 || lengthOfProgress > 100) {
            throw new IllegalArgumentException("The length of a progress line must be between 0 and 100");
        }
        this.lengthOfProgress = lengthOfProgress;
    }

    public void start() throws InterruptedException {
        System.out.print(PROGRESS_TITLE);
        for (int i = 0; i <= this.lengthOfProgress; i++) {
            if (i < 10) {
                System.out.print("\b\b");
            } else {
                System.out.print("\b\b\b");
            }
            System.out.print(i + "%");

            Thread.sleep(250);
        }
    }
}

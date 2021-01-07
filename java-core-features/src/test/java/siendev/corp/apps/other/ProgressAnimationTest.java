package siendev.corp.apps.other;

/**
 * @author Iurii Golubnichenko
 */
public class ProgressAnimationTest {

    public static void main(String[] args) throws InterruptedException {
        ProgressAnimation progressAnimation = new ProgressAnimation();
        progressAnimation.setLengthOfProgress(80);
        progressAnimation.start();
    }
}

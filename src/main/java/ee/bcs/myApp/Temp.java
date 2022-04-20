package ee.bcs.myApp;

public class Temp {
    public static void main(String[] args) {
//        String s = 'Hanno ütles "TERE!" ja astus klassi';
//
//        System.out.println(s);

        if (!isCitizen() && !isNotUnderAge() && doesNotHaveDrivingLicense() && !hasWorkingPermit()) {
        }

    }

    private static boolean isNotUnderAge() {
        return false;
    }

    private static boolean doesNotHaveDrivingLicense() {
        return false;
    }

    private static boolean hasWorkingPermit() {
        return false;
    }

    private static boolean isCitizen() {
        return false;
    }


}

package basic.enums;

public class EnumTest {

    public static void doOp(OpConstant op) {
        switch (op) {
            case TURN_LEFT:
                System.out.println("turn left");
                break;
            case TURN_RIGHT:
                System.out.println("turn right");
                break;
            case SHOOT:
                System.out.println("shoot me");
                break;
        }
    }

    public static void main(String[] args) {
        doOp(OpConstant.SHOOT);
    }
}

enum OpConstant {

    TURN_LEFT, TURN_RIGHT, SHOOT
}
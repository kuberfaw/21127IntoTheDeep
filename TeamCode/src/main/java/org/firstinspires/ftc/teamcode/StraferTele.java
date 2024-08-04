package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

public class StraferTele extends OpMode {

    DcMotor m1, m2, m3, m4;
    @Override
    public void init() {
        m1 = hardwareMap.get(DcMotor.class, "frontLeft");
        m2 = hardwareMap.get(DcMotor.class, "frontRight");
        m3 = hardwareMap.get(DcMotor.class, "backLeft");
        m4 = hardwareMap.get(DcMotor.class, "backRight");
    }

    @Override
    public void loop() {
        double y = gamepad1.left_stick_y, x = gamepad1.left_stick_x, rx = gamepad1.right_stick_x;
        double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);
        double motor1Power = (y + x - rx) / denominator;
        double motor2Power = (y - x + rx) / denominator;
        double motor3Power = (y - x - rx) / denominator;
        double motor4Power = (y + x + rx) / denominator;

        m1.setPower(motor1Power);
        m2.setPower(motor2Power);
        m3.setPower(motor3Power);
        m4.setPower(motor4Power);

        telemetry.addData("left stick y: ", gamepad1.left_stick_y);
        telemetry.addData("left stick x: ", gamepad1.left_stick_x);
        telemetry.addData("right stick x: ", gamepad1.right_stick_x);
    }
}

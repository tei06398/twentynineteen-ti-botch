package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.LegacyModule;
import com.qualcomm.robotcore.hardware.configuration.MotorConfigurationType;

@TeleOp(name="OpMode Test", group="TeleOp OpMode")
public class OpModeTest extends OpMode {
    DcMotor left_drive;
    DcMotor right_drive;
    // Code to run ONCE when the driver hits INIT
    @Override
    public void init() {
        //TODO the big thing
        //App doesn't like something about trying to declare these... Not sure why, but we gotta figure this out to make progress.

        left_drive = hardwareMap.dcMotor.get("left_drive");
        right_drive = hardwareMap.dcMotor.get("right_drive");
        left_drive.setDirection(DcMotorSimple.Direction.FORWARD);
        right_drive.setDirection(DcMotorSimple.Direction.REVERSE);
        left_drive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        right_drive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

    }

    // Code to run REPEATEDLY after the driver hits INIT, but before they hit PLAY
    @Override
    public void init_loop() {}  

    // Code to run ONCE when the driver hits PLAY
    @Override
    public void start() {}

    // Code to run REPEATEDLY after the driver hits PLAY but before they hit STOP
    @Override
    public void loop() {

        if (this.gamepad1.dpad_up) {
            telemetry.addData("UP PRESSED", "YEET");
            left_drive.setPower(1);
            right_drive.setPower(1);
        } else if (this.gamepad1.dpad_down) {
            telemetry.addData("DOWN PRESSED", "YEET");
            left_drive.setPower(-1);
            right_drive.setPower(-1);



        } else if(this.gamepad1.dpad_left){
            telemetry.addData("LEFT PRESSED", "YEET");
            left_drive.setPower(-1);
            right_drive.setPower(1);
        }else if(this.gamepad1.dpad_right){
            telemetry.addData("RIGHT PRESSED", "YEET");
            left_drive.setPower(1);
            right_drive.setPower(-1);

        }else if(this.gamepad1.a){
            telemetry.addData("A PRESSED", "YEEEET");
            // will go in a square

            long millis = System.currentTimeMillis() % 1000;


            for(int i = 0; i<4; i++){
                while(millis < millis+2500){
                    left_drive.setPower(1);
                    right_drive.setPower(1);
                    millis += (System.currentTimeMillis() % 1000 - millis);
                }

                millis = System.currentTimeMillis() % 1000;
                while(millis < millis+1000){
                    left_drive.setPower(-1);
                    right_drive.setPower(1);
                    millis += (System.currentTimeMillis() % 1000 - millis);
                }

            }

        }else{
            telemetry.addData("NOTHING PRESSED", "YEET");
            left_drive.setPower(0);
            right_drive.setPower(0);
        }

        telemetry.update();


    }

    // Code to run ONCE after the driver hits STOP
    @Override
    public void stop() {}

}





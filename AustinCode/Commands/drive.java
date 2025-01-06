// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.StatusSignal;
import com.ctre.phoenix6.hardware.CANcoder;
import com.ctre.phoenix6.hardware.Pigeon2;
import com.revrobotics.CANSparkLowLevel;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class drive extends SubsystemBase {
  /** Creates a new drive. */
  // motors defind turn is the stering motors and drive is the drive motors
  private final CANSparkMax m_turn1 = new CANSparkMax(1, MotorType.kBrushless); // *******front*********
  private final CANSparkMax m_turn2 = new CANSparkMax(17, MotorType.kBrushless); // *********************
  private final CANSparkMax m_turn3 = new CANSparkMax(18, MotorType.kBrushless); // *********************
  private final CANSparkMax m_turn4 = new CANSparkMax(4, MotorType.kBrushless); // *******swerve********
  private final CANSparkMax m_drive1 = new CANSparkMax(3, MotorType.kBrushless); // ********drive********
  private final CANSparkMax m_drive2 = new CANSparkMax(10, MotorType.kBrushless); // *********************
  private final CANSparkMax m_drive3 = new CANSparkMax(7, MotorType.kBrushless); // *********************
  private final CANSparkMax m_drive4 = new CANSparkMax(20, MotorType.kBrushless); // *********************

  // drive control groups
  // private final MotorControllerGroup m_drive1 = new
  // MotorControllerGroup(m_drive1, m_drive4);
  // private final MotorControllerGroup m_drive2 = new
  // MotorControllerGroup(m_drive2, m_drive3);

  private final Pigeon2 Gyro = new Pigeon2(0);

  private final CANcoder number1 = new CANcoder(2);
  private final CANcoder number2 = new CANcoder(1);
  private final CANcoder number3 = new CANcoder(4);
  private final CANcoder number4 = new CANcoder(3);

  private final PIDController pid1 = new PIDController(0.005, 0, 0);
  private final PIDController pid2 = new PIDController(0.005, 0, 0);
  private final PIDController pid3 = new PIDController(0.005, 0, 0);
  private final PIDController pid4 = new PIDController(0.005, 0, 0);

private final RelativeEncoder encode = m_drive4.getEncoder();

  private double predirection = 0;
  private double predirection2 = 0;
  private double speedmod;
  private double rotations;
  private double speedmod2;
  private double rotations2;
  private double directiono;
  private double directiono2;
  private double direction2;
  private double displacement;
  private double displacement2;
  private double steardrect1;
  private double steardrect2;
  private double steardrect3;
  private double steardrect4;
  private double name;
  private double direction;
  private double work;

  private double gyrospin = 0;

  private double gyro360;

  private double mod2 = .35;

  public drive() {

  }

  // returns encoder valuse
public double drivee(){
  return encode.getPosition();
}


  public StatusSignal<Double> number1s() {
    return number1.getPosition();
  }

  public StatusSignal<Double> number2s() {
    return number2.getPosition();
  }

  public StatusSignal<Double> number3s() {
    return number3.getPosition();
  }

  public StatusSignal<Double> number4s() {
    return number4.getPosition();

  }

  public Double number1() {
    return number1s().getValue() * 360;
  }

  public Double number2() {
    return number2s().getValue() * 360;
  }

  public Double number3() {
    return number3s().getValue() * 360;
  }

  public Double number4() {
    return number4s().getValue() * 360;

  }

  // raw gyro value
  public StatusSignal<Double> gyro() {
    return Gyro.getYaw();
  }

  // gyro value from -180 to 180
  public double gyro180() {

    gyro360 = -gyro().getValue();
    if (gyro360 - 360 * gyrospin > 180) {
      gyrospin = gyrospin + 1;
    } else if (gyro360 - 360 * gyrospin < -180) {
      gyrospin = gyrospin - 1;
    }
    return gyro360 - 360 * gyrospin;
  }

  public void zero() {
    Gyro.reset();
  }

  public void mod(double m) {
    mod2 = m;
  }

  public double slow() {
    return mod2;
  }

  public void swerve(double irection, double speed, double turn, double name2) {

    speed = speed * mod2;

    // gyro here
    /*
     * name=irection;
     * if(name!=222){
     * directiono=irection;
     * directiono2=irection+gyro180();
     * direction=irection+gyro180();
     * }
     * //
     */

    // gyro in comand
    /// *
    name = name2;
    if (name != 222) {
      directiono = irection;
      directiono2 = irection;
      direction = irection;
    }
    // */

    turn = 35 * turn;

    if (name == 222 && (turn > 10 || turn < -10)) {
      direction = -45;
      directiono2 = 45;
    }

    // algarithom figers out which dercshon is fastest to get to posishon. motors
    // that are diaganal to echother share an agarithon.
    if ((name == 222 && (turn > 10 || turn < -10)) || name != 222) {
      displacement = Math.abs(direction - predirection);
      if (direction <= 0) {
        direction2 = direction + 180;
      }
      if (direction > 0) {
        direction2 = direction - 180;
      }

      displacement2 = Math.abs(direction2 - predirection);

      if (displacement > 270) {
        if (direction <= 0) {
          direction = direction + 360;
        } else {
          direction = direction - 360;
        }
        displacement = Math.abs(direction - predirection);
      }

      if (displacement <= displacement2) {
        predirection = direction;
        speedmod = 1;
      } else {
        predirection = direction2;
        speedmod = -1;
      }

      if (predirection > 180) {
        predirection = predirection - 360;
        rotations = rotations + 1;
      } else if (predirection < -180) {
        predirection = predirection + 360;
        rotations = rotations - 1;
      }
      // part 2
      direction = directiono2;
      displacement = Math.abs(direction - predirection2);
      if (direction <= 0) {
        direction2 = direction + 180;
      }
      if (direction > 0) {
        direction2 = direction - 180;
      }

      displacement2 = Math.abs(direction2 - predirection2);

      if (displacement > 270) {
        if (direction <= 0) {
          direction = direction + 360;
        } else {
          direction = direction - 360;
        }
        displacement = Math.abs(direction - predirection2);
      }

      if (displacement <= displacement2) {
        predirection2 = direction;
        speedmod2 = 1;
      } else {
        predirection2 = direction2;
        speedmod2 = -1;
      }

      if (predirection2 > 180) {
        predirection2 = predirection2 - 360;
        rotations2 = rotations2 + 1;
      } else if (predirection2 < -180) {
        predirection2 = predirection2 + 360;
        rotations2 = rotations2 - 1;
      }
    }
    work = directiono;// +gyro180();

    if (work > 180) {
      work = work - 360;
    }
    if (work < -180) {
      work = work + 360;
    }

    if (name != 222) {

      if (work <= 45 && work >= -45) {// 0
        steardrect1 = predirection2 + 360 * rotations2 + turn;
        steardrect2 = predirection + 360 * rotations + turn;
        steardrect3 = predirection + 360 * rotations - turn;
        steardrect4 = predirection2 + 360 * rotations2 - turn;
      }
      if (work <= 135 && work > 45) {// 90
        steardrect1 = predirection2 + 360 * rotations2 - turn;
        steardrect2 = predirection + 360 * rotations + turn;
        steardrect3 = predirection + 360 * rotations - turn;
        steardrect4 = predirection2 + 360 * rotations2 + turn;
      }
      if (work < -45 && work >= -135) {// -90
        steardrect1 = predirection2 + 360 * rotations2 + turn;
        steardrect2 = predirection + 360 * rotations - turn;
        steardrect3 = predirection + 360 * rotations + turn;
        steardrect4 = predirection2 + 360 * rotations2 - turn;
      }
      if (work < -135 || work > 135) {// 180
        steardrect1 = predirection2 + 360 * rotations2 - turn;
        steardrect2 = predirection + 360 * rotations - turn;
        steardrect3 = predirection + 360 * rotations + turn;
        steardrect4 = predirection2 + 360 * rotations2 + turn;
      }

    }

    if (name == 222 && (turn > 10 || turn < -10)) {

      speed = -turn / 45;
      steardrect3 = predirection + 360 * rotations;
      steardrect4 = predirection2 + 360 * rotations2;
      steardrect2 = predirection + 360 * rotations;
      steardrect1 = predirection2 + 360 * rotations2;

      m_drive1.set(-speed * speedmod2 * .5);
      m_drive2.set(speed * speedmod * .5);
      m_drive3.set(-speed * speedmod * .5);
      m_drive4.set(speed * speedmod2 * .5);

    }

    if (name == 222 && (turn < 10 && turn > -10)) {
      m_drive2.set(0);
      m_drive1.set(0);
      m_drive3.set(0);
      m_drive4.set(0);
    }

    if (name != 222) {
      m_drive1.set(speed * speedmod2);
      m_drive4.set(speed * speedmod2);
      m_drive3.set(speed * speedmod);
      m_drive2.set(speed * speedmod);
    } // motor speed

    // code for controling posishon of stering motors PID whould be better

    // Calculates the output of the PID algorithm based on the sensor reading
    // and sends it to a motor
    m_turn1.set(pid1.calculate(number1(), steardrect1));
    m_turn2.set(pid2.calculate(number2(), steardrect2));
    m_turn3.set(pid3.calculate(number3(), steardrect3));
    m_turn4.set(pid4.calculate(number4(), steardrect4));

    // outputs data for debuging. add // infront of paragrafe comment to enable
    /*
     * SmartDashboard.putNumber("pred", predirection);
     * SmartDashboard.putNumber("pred2", predirection2);
     * SmartDashboard.putNumber("number1", steardrect1);
     * SmartDashboard.putNumber("number2", steardrect2);
     * SmartDashboard.putNumber("number3", steardrect3);
     * SmartDashboard.putNumber("number4", steardrect4);
     * SmartDashboard.putNumber("mod", speed*speedmod);
     * SmartDashboard.putNumber("tuen", work);
     * //
     */
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

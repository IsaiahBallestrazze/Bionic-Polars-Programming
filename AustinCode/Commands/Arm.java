// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkLowLevel.MotorType;

public class Arm extends SubsystemBase {
  /** Creates a new Arm. */

  private final CANSparkMax m_MotorL1 = new CANSparkMax(2, MotorType.kBrushless);
  private final CANSparkMax m_MotorL2 = new CANSparkMax(12, MotorType.kBrushless);
  private final CANSparkMax m_MotorR1 = new CANSparkMax(9, MotorType.kBrushless);
  private final CANSparkMax m_MotorR2 = new CANSparkMax(16, MotorType.kBrushless);

  private final RelativeEncoder encoder1 = m_MotorL1.getEncoder();
  private final PIDController PIDthing = new PIDController(0.12, 0.1, 0);
private final PIDController PIDthing2 = new PIDController(0.07, 0, 0);

  private double speed;

  public Arm() {
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void ArmAngle(Double angle) {

    // m_MotorR2.follow(m_MotorR1);
    // m_MotorL2.follow(m_MotorL1);

    // m_MotorR1.setInverted(true);
    // m_MotorR2.setInverted(true);
if(angle<=3.5){
    speed = PIDthing.calculate(encoder1.getPosition(), angle);
}
if(angle>3.5){
  speed= PIDthing2.calculate(encoder1.getPosition(), angle);
}

    if (encoder1.getPosition() < 3 && speed < .085) {
      speed = .085;
    }
    if (encoder1.getPosition() < .25 && speed <= .085) {
      speed = 0;
    }
   
    if(angle<1){
if(encoder1.getPosition()>4.5){
  speed=-.06;
}
if(encoder1.getPosition()<=4.5&&encoder1.getPosition()>=3){
  speed=.05;
}

    }


 if (encoder1.getPosition() > 4 && speed > .1) {
      speed = .1;
    }
    m_MotorL1.set(speed);
    m_MotorL2.set(speed);

    m_MotorR1.set(-speed);
    m_MotorR2.set(-speed);
    SmartDashboard.putNumber("speed", speed);

  }

  public double EncoderValue() {
    return encoder1.getPosition();
  }
}

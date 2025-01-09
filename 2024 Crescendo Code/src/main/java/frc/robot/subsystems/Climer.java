// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Climer extends SubsystemBase {
  /** Creates a new Climer. */

private final CANSparkMax c_motorR = new CANSparkMax(13, MotorType.kBrushless);
private final CANSparkMax c_motorL = new CANSparkMax(5, MotorType.kBrushless);
private final RelativeEncoder m_En = c_motorR.getEncoder();
private final RelativeEncoder m_EnL = c_motorL.getEncoder();
private final PIDController Right = new PIDController(0.1,0,0);
private final PIDController Left = new PIDController(0.1,0,0);


  public Climer() {
   // c_motorR.follow(c_motorL);
  }

  public void Climermotor(double angle){
    c_motorR.set(Right.calculate(m_En.getPosition(), angle));
    c_motorL.set(Left.calculate(m_EnL.getPosition(),-angle));
  }
  
  public double EN(){
    return m_En.getPosition();
  }

    public double ENL(){
    return m_EnL.getPosition();
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

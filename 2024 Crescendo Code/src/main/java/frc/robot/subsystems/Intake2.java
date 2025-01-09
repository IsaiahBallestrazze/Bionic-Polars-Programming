// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake2 extends SubsystemBase {


//FLYWHEEL MOTORS
private final CANSparkMax m_Flywheel1 = new CANSparkMax(19, MotorType.kBrushless);
private final CANSparkMax m_Flywheel2 = new CANSparkMax(15, MotorType.kBrushless);

//INTAKE MOTORS
private final CANSparkMax m_Chamber = new CANSparkMax(11, MotorType.kBrushed);
private final CANSparkMax m_Intake = new CANSparkMax(14, MotorType.kBrushed);

//FLYWHEEL ENCODER
private final RelativeEncoder encoder1 = m_Flywheel1.getEncoder();


  public Intake2() {
  }


//FLYWHEELS SPEED
  public void Fly(Double speed) {

    m_Flywheel2.set(speed *1.1);
    m_Flywheel1.set(speed*.8);

}

// INTAKE SPEED
  public void ChamberSpeed(Double speed) {

    m_Chamber.set(speed);

  }

    public void IntakeSpeed(Double speed) {

    m_Intake.set(speed);

  }
  //ENCODER RPM
  public double FlyEncoder(){
    return encoder1.getVelocity() ;
      }





  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

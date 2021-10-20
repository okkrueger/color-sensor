package frc.robot.Color_Wheel;

import edu.wpi.first.wpilibj.util.Color;
import frc.robot.Map;

public class Calibrate{
    
    
    public static class Colors{
        public static Color1 Red = new Color1();
        public static Color1 Blue = new Color1();
        public static Color1 Green = new Color1();
        public static Color1 Yellow = new Color1();
    }

    public static class Color1{
        public double r;
        public double g;
        public double b;
    }

    public static void setColor(String color) {
        final Color detectedColor = Map.ColorWheel.sensor.getColor();

        switch(color){
            case("red"):
                Colors.Red.r = 0.36;
                Colors.Red.g = 0.43;
                Colors.Red.b = 0.19;
                break;
            case("blue"):
                Colors.Blue.r = 0.18;
                Colors.Blue.g = 0.46;
                Colors.Blue.b = 0.33;
                break;
            case("green"):
                Colors.Green.r = 0.22;
                Colors.Green.g = 0.53;
                Colors.Green.b = 0.24;
                break;
            case("yellow"):
                Colors.Yellow.r = 0.30;
                Colors.Yellow.g = 0.53;
                Colors.Yellow.b = 0.15;
                break;
        }



    }
}
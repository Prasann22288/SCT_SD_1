import java.util.*;

public class TemperatureConverter{
    public static double celsiusToFahrenheit(double c){
        return (c*9/5)+32;
    }
    public static double celsiusToKelvin(double c){
        return c+273.15;
    }
    public static double fahrenheitToCelsius(double f){
        return (f-32)*5/9;
    }
    public static double fahrenheitToKelvin(double f){
        return (f-32)*5/9+273.15;
    }
    public static double kelvinToCelsius(double k){
        return k-273.15;
    }
    public static double kelvinToFahrenheit(double k){
        return (k-273.15)*9/5+32;
    }
    public static double convertTemperature(double value, char fromScale, char toScale){
        if (fromScale==toScale){
            return value;
        }
        switch(fromScale){
            case 'C':
                if(toScale=='F'){
                    return celsiusToFahrenheit(value);
                }else if(toScale=='K'){
                    return celsiusToKelvin(value);
                }
                break;
            case 'F':
                if(toScale=='C'){
                    return fahrenheitToCelsius(value);
                }else if(toScale=='K'){
                    return fahrenheitToKelvin(value);
                }
                break;
            case 'K':
                if(toScale=='C'){
                    return kelvinToCelsius(value);
                }else if(toScale=='F'){
                    return kelvinToFahrenheit(value);
                }
                break;
        }
        return Double.NaN;  //Not a valid conversion
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the temperature value: ");
        double temp = sc.nextDouble();
        sc.nextLine();  //Consume the newline character
        System.out.print("Enter the scale of the temperature value (C/F/K): ");
        char fromScale = sc.nextLine().toUpperCase().charAt(0);
        System.out.print("Enter the scale to convert to (C/F/K): ");
        char toScale = sc.nextLine().toUpperCase().charAt(0);
        double convertedTemp = convertTemperature(temp, fromScale, toScale);
        if(Double.isNaN(convertedTemp)){
            System.out.println("Invalid conversion scales provided.");
        }else{
            System.out.printf("%.2f°%c is %.2f°%c\n",temp,fromScale,convertedTemp,toScale);
        }
        sc.close();
    }
}

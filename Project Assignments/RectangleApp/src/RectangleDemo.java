import java.util.Scanner;

/**
 * The Testing Mode of the Rectangle Application.
 * @author Vladimir Efros
 */
public class RectangleDemo 
{
    
    // Create a new Scanner Object.
    public static Scanner keyboard = new Scanner(System.in);
    
    /**
     * The test driver of the Rectangle App.
     */
    public static void main(String[] args)
    {
        // Create a new Rectangle Object.
        Rectangle r1 = getRectangle();
        
        // Create a new Rectangle Object.
        Rectangle r2 = getRectangle();
        
        // Compare the name and area of both rectangles.
        compareRectangles(r1, r2);
        
        // Copy the Objects using the copy() method and confirm we got two objects.
        Rectangle r3 = r1.copy();
        if(r1 == r3)
            System.out.println("The r1 and r3 reference the same object!");
        else
            System.out.println("The r1 and r3 reference different objects!");
        
        //Display Rectangle. [Optional]
        displayRectangle(r1);
    }
    
    /**
     * The getRectangle method creates a new Rectangle Object.
     * @return Rectangle.
     */
    private static Rectangle getRectangle()
    {
        // Enter the name of the student and the sample number of the compound.
        System.out.print("Enter the Name of the Student: ");
        String studentName = keyboard.nextLine();          
        
        System.out.print("Enter the Sample Number of Compound: ");
        int sampleNum = Integer.parseInt(keyboard.nextLine());        
        
        // Enter name, length, width of the Rectangle.
        System.out.print("Enter the Name of the Rectangle: ");
        String name = keyboard.nextLine();        // input: Square
        
        System.out.print("Enter the Length of the Rectangle: ");
        double length = Double.parseDouble(keyboard.nextLine());    // input: 5.0
        
        
        System.out.print("Enter the Width of the Rectangle: ");
        double width = Double.parseDouble(keyboard.nextLine());     // input: 5.0

        // Create Chemical Property Object.
        ChemicalProperty chemProp = getChemicalProperty();
        
        // Create Physical Property Object.
        PhysicalProperty physProp = getPhysicalProperty();
        
        // return the new Rectangle object.
        return new Rectangle(studentName, sampleNum, name, length, width, chemProp, physProp);
    }
    
    /**
     * getChemicalProperty method creates a new ChemicalProperty Object.
     * @return The new created ChemicalProperty Object.
     */
    private static ChemicalProperty getChemicalProperty()
    {
        // Enter Chemical Properties of the Rectangle: Heat of Combustion, reaction with water, pH.
        System.out.print("Enter the Heat Combustion of the Rectangle: ");
        double heatOfCombustion = Double.parseDouble(keyboard.nextLine());     // input: 125
        
        System.out.print("Enter the Reaction of the Rectangle with Water (comments): ");
        String reactWithWater = keyboard.nextLine();     // input: Vigorous Reaction
        
        System.out.print("Enter the pH of the Rectangle when it's dissolved in water: ");
        double pH = Double.parseDouble(keyboard.nextLine());     // input: 12      
        
        // Create Chemical Property Object.
        return new ChemicalProperty(heatOfCombustion, reactWithWater, pH);
    }
    
    /**
     * getPhysicalProperty method creates a new PhysicalProperty Object.
     * @return The new created PhysicalProperty Object.
     */
    private static PhysicalProperty getPhysicalProperty()
    {
        // Enter Physical Properties of the Rectangle: color, smell, freezing point.
        System.out.print("Enter the Color of the Rectangle: ");
        String color = keyboard.nextLine();     // input: white
        
        System.out.print("Enter the Smell of the Rectangle): ");
        String smell = keyboard.nextLine();     // input: no smell
        
        System.out.print("Enter the Freezing Point of the Rectangle: ");
        double fp = Double.parseDouble(keyboard.nextLine());     // input: 12      
        
        // Create Physical Property Object.
        return new PhysicalProperty(color, smell, fp);
    }
    
    /**
     * The displayRectangle method displays the state of the object.
     */
    private static void displayRectangle(Rectangle r)
    {
        System. out.println(r); // System. out.println(r1.toString());
        // System.out.println(r.getName() + " " + r.getLength() + " " + r.getWidth() + " " + r.getArea() + r.getPhysicalProperty() + r.getChemicalProperty());
    }
    
    /**
     * The equals compares two  Rectangles meaningfully.
     * @param r1 the calling rectangle object.
     * @param r2 Rectangle object that is compared to the calling Rectangle object.
     * @return true if Rectangles have the same name and area, otherwise return false.
     */
    private static void compareRectangles(Rectangle r1, Rectangle r2)
    {
        if(r1.equals(r2))
            System.out.println("Rectangles have the identical names and areas!");
        else
            System.out.println("Rectangles do not have the identical names and areas!");
    }
}
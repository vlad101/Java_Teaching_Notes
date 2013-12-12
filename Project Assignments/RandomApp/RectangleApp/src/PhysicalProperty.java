/**
 * The PhysicalProperty Class contains info about physical property of the Rectangle.
 * The physical Properties of the Rectangle: color, smell, freezing point.
 * @author Vladimir Efros
 */

public class PhysicalProperty 
{
    private String color;
    private String smell;
    private double fp;
    
     /**
     * The constructor method creates the default PhysicalProperty Object.
     */
    public PhysicalProperty()
    {
        color = "Unknown";
        smell = "Unknown";
        fp = -1;
    }
    
     /**
     * The constructor method creates the PhysicalProperty Object.
     * @param c The color of Rectangle.
     * @param s The smell of Rectangle.
     * @param f The freezing Point of Rectangle.
     */
    public PhysicalProperty(String c, String s, double f)
    {
        color = c;
        smell = s;
        fp = f;
    }
    
    /**
     * The constructor method creates the copy of the PhysicalProperty object.
     * @param cp the PhysicalProperty object that is to be copied.
     */
    public PhysicalProperty(PhysicalProperty f)
    {
        color = f.color;
        smell = f.smell;
        fp = f.fp;
    }
    
    /**
     * The set method sets a value for each field.
     * @param c The color of Rectangle.
     * @param s The smell of Rectangle.
     * @param f The freezing Point of Rectangle.
     */
    public void setPhysicalProperty(String c, String s, double f)
    {
        color = c;
        smell = s;
        fp = f;
    }
    
    /**
     * toString method
     * @return A string containing physical property info.
     */
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("Color is " + color + "\n");
        builder.append("Smell is " + smell + "\n");
        builder.append("Freezing Point is " + fp);
        return builder.toString();
    }    
}
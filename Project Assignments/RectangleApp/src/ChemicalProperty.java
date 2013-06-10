/**
 * The ChemicalProperty Class contains info about chemical property of a Rectangle/Sphere.
 * Chemical Properties of the Rectangle/Sphere: Heat of Combustion, reaction with water, pH.
 * @author Vladimir Efros
 */
public class ChemicalProperty 
{
    private double heatOfCombustion;
    private String reactWithWater;
    private double pH;
    
    /**
     * The constructor method creates the default ChemicalProperty Object.
     */
    public ChemicalProperty()
    {
        heatOfCombustion = -1;
        reactWithWater = "Unknown";
        pH = -1;
    }
    
     /**
     * The constructor method creates the ChemicalProperty Object.
     * @param h The heat of Combustion.
     * @param r The reaction of Rectangle/Sphere with water.
     * @param p The pH of Rectangle/Sphere.
     */
    public ChemicalProperty(double h, String r, double p)
    {
        heatOfCombustion = h;
        reactWithWater = r;
        pH = p;
    }
    
    /**
     * The constructor method creates the copy of the ChemicalProperty object.
     * @param cp the ChemicalProperty object that is to be copied.
     */
    public ChemicalProperty(ChemicalProperty cp)
    {
        heatOfCombustion = cp.heatOfCombustion;
        reactWithWater = cp.reactWithWater;
        pH = cp.pH;
    }
    
    /**
     * The set method sets a value for each field.
     * @param h The heat of Combustion.
     * @param r The reaction of Rectangle/Sphere with water.
     * @param p The pH of Rectangle/Sphere.
     */
    public void setChemicalProperty(double h, String r, double p)
    {
        heatOfCombustion = h;
        reactWithWater = r;
        pH = p;
    }
    
    /**
     * toString method
     * @return A string containing chemical property info.
     */
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("Heat of Combustion is " + heatOfCombustion + "\n");
        builder.append("Reaction with water is " + reactWithWater + "\n");
        builder.append("ph is " + pH);
        return builder.toString();
    }
}

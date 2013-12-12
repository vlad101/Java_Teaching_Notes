/**
 * 
 * @author Vladimir Efros
 */
public class Sphere extends Shape
{
    // Attributes of the Sphere Object.
    private String name;
    private double radius;
    private ChemicalProperty chemProp;
    private PhysicalProperty physProp;
       
    /**
     * Overloaded Constructor method.
     * @param n The name of the Sphere.
     * @param r The radius of the sphere.
     * @param cp The ChemicalProperty Object.
     * @param fp The PhycailProperty Object.
     */
    public Sphere(String n, double r, ChemicalProperty cp, PhysicalProperty fp)
    {
        name = n;
        radius = r;
        chemProp = new ChemicalProperty(cp); // Deep copy: pass cp as an arg to the copy constructor
        physProp = new PhysicalProperty(fp); // Deep copy: pass fp as an arg to the copy constructor
    }
    
    /**
     * The copy method creates a new Sphere object and initializes 
     * it with the same data held by the calling object.
     * @return a copy of the Sphere Object.
     */
    public Sphere copy()
    {
        Sphere copySphere = new Sphere(name, radius, chemProp, physProp);
        return copySphere;
    }
        
    /**
     * The setName method sets the name of the Sphere.
     * @param n The name of the Sphere.
     */
    public void setName(String n)
    {
        name = n;
    }
    
    /**
     * The setLength method sets the length of the Sphere.
     * @param l The length of the Sphere.
     */
    public void setRadius(double r)
    {
        radius = r;
    }
    
    /**
     * The getName method returns the name of the Sphere.
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * The getLength method returns the length of the Sphere.
     */
    public double getRadius()
    {
        return radius;
    }
    
    /**
     * The getWidth method returns the area of the Sphere.
     */
    public double getArea()
    {
        return 4 * Math.PI * radius * radius;
    }
    
    /**
     * getChemicalProperty method
     * @return A reference to a copy of this Sphere's ChemicalProperty Object.
     */
    public ChemicalProperty getChemicalProperty()
    {
        return new ChemicalProperty(chemProp); // Return a copy of ChemicalProperty Object.
    }
    
    /**
     * getPhysicalProperty method
     * @return A reference to a copy of this Sphere's PhysicalProperty Object.
     */
    public PhysicalProperty getPhysicalProperty()
    {
        return new PhysicalProperty(physProp); // Return a copy of PhysicalProperty Object.
    }
    
    /**
     * The equals compares two  Spheres meaningfully.
     * @param s the Sphere object that is compared with the calling object.
     * @return true if Spheres have the same name and area, otherwise return false.
     */
    public boolean equals(Sphere s)
    {
        if(this.getArea() == s.getArea() && this.getName().equals(s.getName()))
            return true;
        return false;
    }
    
    /**
     * The toString method returns the state of the object.
     */
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("The Name of the Sphere is " + name + "\n");
        builder.append("The Radius of the Sphere is " + radius + "\n");
        builder.append("The Area of the Sphere is " + this.getArea() + "\n");
        builder.append("The Chemical Properties:" + chemProp + "\n");
        builder.append("The Physical Properties:\n" + physProp);
        return builder.toString();
    }
}
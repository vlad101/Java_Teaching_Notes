/**
 * The Rectangle Class describes a chemical substance that has 
 * specific Chemical and Physical Properties.
 * @author Vladimir Efros
 */
public class Rectangle extends Shape
{
    // Attributes of the Rectangle Object.
    private String studentName;
    private int sampleNum;
    private String name;
    private double length;
    private double width;
    private ChemicalProperty chemProp;
    private PhysicalProperty physProp;
       
    /**
     * Overloaded Constructor method.
     * @param studName The name of the student.
     * @param sNum The sample number of the Rectangle.
     * @param n The name of the Rectangle.
     * @param l The length of the Rectangle.
     * @param w The width of the Rectangle.
     * @param cp The ChemicalProperty Object.
     * @param fp The PhycailProperty Object.
     */
    public Rectangle(String studName, int sNum, String n, double l, double w, ChemicalProperty cp, PhysicalProperty fp)
    {
        super(studName, sNum);
        studentName = studName;
        sampleNum = sNum; 
        name = n;
        length = l;
        width = w;
        chemProp = new ChemicalProperty(cp); // Deep copy: pass cp as an arg to the copy constructor
        physProp = new PhysicalProperty(fp); // Deep copy: pass fp as an arg to the copy constructor
    }
    
    /**
     * The copy method creates a new Rectangle object and initializes 
     * it with the same data held by the calling object.
     * @return a copy of the Rectangle Object.
     */
    public Rectangle copy()
    {
        Rectangle copyRectangle = new Rectangle(studentName, sampleNum, name, length, width, chemProp, physProp);
        return copyRectangle;
    }
    
    /**
     * The setStudentName method sets the name of the Rectangle.
     * @param n The name of the student of the Rectangle.
     */
    public void setStudentName(String n)
    {
        studentName = n;
    }
    
    /**
     * The setStudentName method sets the name of the Rectangle.
     * @param n The name of the student of the Rectangle.
     */
    public void setSampleNum(int num)
    {
        sampleNum = num;
    }
    
    /**
     * The setName method sets the name of the Rectangle.
     * @param n The name of the Rectangle.
     */
    public void setName(String n)
    {
        name = n;
    }
    
    /**
     * The setLength method sets the length of the Rectangle.
     * @param l The length of the Rectangle.
     */
    public void setLength(double l)
    {
        length = l;
    }
    
    /**
     * The setWidth method sets the width of the Rectangle.
     * @param w The width of the Rectangle.
     */
    public void setWidth(double w)
    {
        width = w;
    }
    
    /**
     * The getStudentName method returns the name of the Student.
     */
    public String getStudentName()
    {
        return studentName;
    }
    
    /**
     * The getSampleNum method returns the name of the Student.
     */
    public int getSampleNum()
    {
        return sampleNum;
    }
    
    /**
     * The getName method returns the name of the Rectangle.
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * The getLength method returns the length of the Rectangle.
     */
    public double getLength()
    {
        return length;
    }
    
    /**
     * The getWidth method returns the width of the Rectangle.
     */
    public double getWidth()
    {
        return width;
    }
    
    /**
     * The getWidth method returns the area of the Rectangle.
     */
    public double getArea()
    {
        return length * width;
    }
    
    /**
     * getChemicalProperty method
     * @return A reference to a copy of this Rectangle's ChemicalProperty Object.
     */
    public ChemicalProperty getChemicalProperty()
    {
        return new ChemicalProperty(chemProp); // Return a copy of ChemicalProperty Object.
    }
    
    /**
     * getPhysicalProperty method
     * @return A reference to a copy of this Rectangle's PhysicalProperty Object.
     */
    public PhysicalProperty getPhysicalProperty()
    {
        return new PhysicalProperty(physProp); // Return a copy of PhysicalProperty Object.
    }
    
    /**
     * The equals compares two  Rectangles meaningfully.
     * @param r the Rectangle object that is compared with the calling object.
     * @return true if Rectangles have the same name and area, otherwise return false.
     */
    public boolean equals(Rectangle r)
    {
        if(this.getArea() == r.getArea() && this.getName().equals(r.getName()))
            return true;
        return false;
    }
    
    /**
     * The toString method returns the state of the object.
     */
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("The Name of the Student is " + studentName + "\n");
        builder.append("The Sample number of the Sphere is " + sampleNum + "\n");
        builder.append("The Name of the Rectangle is " + name + "\n");
        builder.append("The Length of the Rectangle is " + length + "\n");
        builder.append("The Width of the Rectangle is " + width + "\n");
        builder.append("The Area of the Rectangle is " + this.getArea() + "\n");
        builder.append("The Chemical Properties:" + chemProp + "\n");
        builder.append("The Physical Properties:\n" + physProp);
        return builder.toString();
    }
}
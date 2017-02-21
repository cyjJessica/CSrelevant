
class ComplexNumber {    
    public double x, y;
    public ComplexNumber(double real, double imaginary) {
        this.x = real;
        this.y = imaginary;
    }    
   
    public String toString() { return "{" + x + "," + y + "}"; }    
    
    public void add(ComplexNumber a) {
        this.x=this.x+a.x;
        this.y=this.y+a.y;
    }
   
public void multiply(ComplexNumber a) {
    double tmpx=0;
    tmpx=x;
        x=x*a.x - y*a.y;
        y=y*a.x + tmpx *a.y;
}
}


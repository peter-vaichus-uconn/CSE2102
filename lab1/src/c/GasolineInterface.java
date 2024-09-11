package c;

public interface GasolineInterface {
    
    double calcGasMPG();
    void setMilesfromGas(double miles);
    void setGallonsfromGas(double gallons);
    
    //added
    void setCostPerGallon(double cost);
    double getCostPerGallon();
}





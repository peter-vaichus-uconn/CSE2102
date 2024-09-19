package c;

public interface ElectricInterface {

    double calcMPGe();
    void setElectricMiles(double totalElectricMiles);
    void setTotalkWh(double totalkWh);

    //added

    void setCostPerkWh(double cost);
    double getCostPerkWh();

}



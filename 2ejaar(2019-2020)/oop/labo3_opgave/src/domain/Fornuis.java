package domain;

import domain.Elektrische_apparaat;

public class Fornuis extends Elektrische_apparaat{
    private double prijs;
    private char energielabel;

    public Fornuis(double prijs, char energielabel) {
        super(prijs, energielabel);
    }

    @Override
    public double prijskwaliteitsverhouding() {
        switch (this.getEnergielabel()){
            case 'A':
                return this.getPrijs()/280;
            case 'B':
                return this.getPrijs()/230;
            case 'C':
                return this.getPrijs()/190;
            case 'D':
                return this.getPrijs()/120;
            case 'E':
                return this.getPrijs()/90;
            case 'F':
                return this.getPrijs()/60;
            default:
                throw new IllegalStateException("Unexpected value: " + this.getEnergielabel());
        }

    }
}

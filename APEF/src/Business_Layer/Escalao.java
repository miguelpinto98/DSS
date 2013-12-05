package Business_Layer;

import java.util.ArrayList;

public abstract class Escalao {
    private Plantel plantelA;
    private Plantel plantelB;

    public Escalao() {
    }

    
    //clone, equals e toString
    public abstract Escalao clone();
    
    public abstract String toString();
    
    public abstract boolean equals(Object o);

    /*
	public void adicionaDadosEscalao(int ngMarcados, int ngSofridos) {
		this.dados.addDadosEstatisticos(ngMarcados,ngSofridos);
	}*/
}

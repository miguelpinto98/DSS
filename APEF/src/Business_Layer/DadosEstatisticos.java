package Business_Layer;

public class DadosEstatisticos {
    
    private int vitorias;
    private int derrotas;
    private int empates;
    private int gmarcados;
    private int gsofridos;

    public DadosEstatisticos(){
    	this.vitorias = 0;
    	this.derrotas = 0;
    	this.empates = 0;
    	this.gmarcados = 0;
    	this.gsofridos = 0;
    }

    public DadosEstatisticos(DadosEstatisticos d){
    	this.vitorias = d.getVitorias();
    	this.derrotas = d.getDerrotas();
    	this.empates = d.getEmpates();
    	this.gmarcados = d.getGmarcados();
    	this.gsofridos = d.getGsofridos();
    }

    public int getVitorias(){
    	return this.vitorias;
    }

	public int getDerrotas(){
    	return this.derrotas;
    }

    public int getEmpates(){
    	return this.empates;
    }

    public int getGmarcados(){
    	return this.gmarcados;
    }

    public int getGsofridos(){
    	return this.gsofridos;
    }

    public void setVitorias(int x){
    	this.vitorias = x;
    }

	public void setDerrotas(int x){
    	this.derrotas = x;
    }    

    public void setEmpates(int x){
    	this.empates = x;
    }

    public void setGmarcados(int x){
    	this.gmarcados = x;
    }

    public void setGsofridos(int x){
    	this.gsofridos = x;
    }

    public boolean equals(Object o) {
		if (this == o)
			return true;
		if ((o == null) || (this.getClass() != o.getClass()))
			return false;
		else {
			DadosEstatisticos a = (DadosEstatisticos) o;
			return (this.vitorias == a.getVitorias() && 
				this.derrotas == a.getDerrotas() &&
				this.empates == a.getEmpates() &&
				this.gmarcados == a.getGmarcados() &&
				this.gsofridos == a.getGsofridos());
		}
    }

    public DadosEstatisticos clone(){
    	return new DadosEstatisticos(this);
    }

    public String toString(){
    	StringBuilder s = new StringBuilder();

    	s.append("Dados Estatisticos \n");
    	s.append(this.getVitorias() + "\n");
    	s.append(this.getDerrotas() + "\n");
    	s.append(this.getEmpates() + "\n");
    	s.append(this.getGmarcados() + "\n");
    	s.append(this.getGsofridos() + "\n");

    	return s.toString();
    }
}
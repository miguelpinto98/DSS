package Business_Layer;

public class DadosEstatisticos {
    
    private static final int maxForma = 5;


    private int vitorias;
    private int derrotas;
    private int empates;
    private int gmarcados;
    private int gsofridos;
    private char[] forma;

    public DadosEstatisticos(){
    	this.vitorias = 0;
    	this.derrotas = 0;
    	this.empates = 0;
    	this.gmarcados = 0;
    	this.gsofridos = 0;
        this.forma = new char[maxForma];
        this.forma[0] = '-';
        this.forma[1] = '-';
        this.forma[2] = '-';
        this.forma[3] = '-';
        this.forma[4] = '-';

    } 

    public DadosEstatisticos(DadosEstatisticos d){
    	this.vitorias = d.getVitorias();
    	this.derrotas = d.getDerrotas();
    	this.empates = d.getEmpates();
    	this.gmarcados = d.getGmarcados();
    	this.gsofridos = d.getGsofridos();
        this.forma = d.getForma();
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
    
    public char[] getForma() {
        char[] aux = new char[maxForma];
        int i;
        for(i=0;i<maxForma;i++){
            aux[i] = this.forma[i];
        }
        return aux;
    }
    
    public void setForma(char[] f) {
        this.forma = f;
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
        s.append(this.getForma()[0]+"-"+this.getForma()[1]+"-"+this.getForma()[2]+"-"+this.getForma()[3]+"-"+this.getForma()[4]+"\n");

    	return s.toString();
    }
    
    public void atualizaForma(char c) {
        for(int i=0; i<maxForma-1; i++) {            
            this.forma[i] = getForma()[i+1];
        }
        this.forma[maxForma-1] = c;
        
    }

	public void addDadosEstatisticos(int numGolosMarcados, int numGolosSofridos) {
		this.gmarcados = this.gmarcados + numGolosMarcados;
		this.gsofridos = this.gsofridos + numGolosSofridos;
		
		if(numGolosMarcados > numGolosSofridos) {
			this.vitorias++; 
            this.atualizaForma('V');
        }
		else {
			if(numGolosMarcados < numGolosSofridos) {
				this.derrotas++;
                this.atualizaForma('D');
            }   
            else {
				this.empates++;
                this.atualizaForma('E');
            }
		}
	}
    
    public int pontos() {
        int pts = 3*this.vitorias + this.empates;
        return pts;
    }
    
    public int diferencaGolos() {
        int dif = this.gmarcados - this.gsofridos;
        return dif;
    }
}
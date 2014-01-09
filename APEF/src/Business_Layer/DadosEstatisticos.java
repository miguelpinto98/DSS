package Business_Layer;

public class DadosEstatisticos implements Comparable<DadosEstatisticos> {
    
    private static final int maxForma = 5;

    private int idDados;
    private int idEscalao;
    private int vitorias;
    private int derrotas;
    private int empates;
    private int gmarcados;
    private int gsofridos;
    private char[] forma;

    public DadosEstatisticos(){
        this.idDados = APEF.IDENTIFICADOR;
        this.idEscalao = 0;
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
        APEF.IDENTIFICADOR++;

    } 
    
    public DadosEstatisticos(int id){
        this.idDados = APEF.IDENTIFICADOR;
        this.idEscalao = id;
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
        APEF.IDENTIFICADOR++;
    }

    public DadosEstatisticos(DadosEstatisticos d){
        this.idEscalao = d.getIdEscalao();
    	this.vitorias = d.getVitorias();
    	this.derrotas = d.getDerrotas();
    	this.empates = d.getEmpates();
    	this.gmarcados = d.getGmarcados();
    	this.gsofridos = d.getGsofridos();
        this.forma = d.getForma();
    }
    
    public int getID() {
        return this.idDados;
    }

    public int getIdEscalao() {
        return this.idEscalao;
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
    
    public void setIdEscalao(int id) {
        this.idEscalao = id;
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
			return (this.idEscalao == a.getIdEscalao() && this.vitorias == a.getVitorias() && 
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
        s.append("ID Escalao: " + this.getIdEscalao() + "\n");
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

	public DadosEstatisticos addDadosEstatisticos(int numGolosMarcados, int numGolosSofridos) {
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
        return (this);
	}
    
    public int pontos() {
        int pts = 3*this.vitorias + this.empates;
        return pts;
    }
    
    public int diferencaGolos() {
        int dif = this.gmarcados - this.gsofridos;
        return dif;
    }
    
    public int criterio(DadosEstatisticos d) {
        if( this.pontos() != d.pontos() ) 
            return 0;
        else
            if( (this.pontos() == d.pontos()) && (this.diferencaGolos() != d.diferencaGolos()) ) 
                return 1;
            else
                if( (this.pontos() == d.pontos()) && (this.diferencaGolos() == d.diferencaGolos()) && (this.gmarcados != d.getGmarcados()) )
                    return 2;
                else
                    if( (this.pontos() == d.pontos()) && (this.diferencaGolos() == d.diferencaGolos()) && (this.gmarcados == d.getGmarcados()) && (this.gsofridos != d.getGsofridos()) )
                        return 3;
                    else return -1;
    }
    
      public int ordenaNormal(DadosEstatisticos d) {
        if(d.getIdEscalao() < this.idEscalao) return 1;
        if(d.getIdEscalao()> this.idEscalao) return -1;
        else return 0;
    }
    
    public int ordenaPontos(DadosEstatisticos d) {
        if(d.pontos() < this.pontos()) return 1;
        if(d.pontos() > this.pontos()) return -1;
        else return ordenaNormal(d);
    }
    
    public int ordenaDif(DadosEstatisticos d) {
        if(d.diferencaGolos()< this.diferencaGolos()) return 1;
        if(d.diferencaGolos()> this.diferencaGolos()) return -1;
        else return ordenaNormal(d);
    }
    
    public int ordenaMelhorAtaque(DadosEstatisticos d) {
        if(d.getGmarcados() < this.gmarcados) return 1;
        if(d.getGmarcados() > this.gmarcados) return -1;
        else return ordenaNormal(d);
    }
    
    public int ordenaMelhorDefesa(DadosEstatisticos d) {
        if(d.getGsofridos() < this.gsofridos) return 1;
        if(d.getGsofridos() > this.gsofridos) return -1;
        else return ordenaNormal(d);
    }
    
    public int compareTo(DadosEstatisticos d) {
        int res=0;
        switch(criterio(d)) {
            case 0: res = ordenaPontos(d);
                break;
            case 1: res = ordenaDif(d);
                break;
            case 2: res = ordenaMelhorAtaque(d);
                break;
            case 3: res = ordenaMelhorDefesa(d);
                break;
            case -1: res = ordenaNormal(d);
                break;
        }
        return res;
    }
}
package Business_Layer;

public class Classificacao {
    private EstatisticaCompeticao classificacao;

    public Classificacao(){
    	this.classificacao = new EstatisticaCompeticao();
    }

    public Classificacao(Classificacao c){
    	this.classificacao = c.getClassificacao();
    }

    public EstatisticaCompeticao getClassificacao(){
    	return this.classificacao;
    }

    public void setClassificacao (EstatisticaCompeticao ec){
    	this.classificacao = ec;
    }

    public boolean equals(Object o) {
		if (this == o)
			return true;
		if ((o == null) || (this.getClass() != o.getClass()))
			return false;
		else {
			Classificacao a = (Classificacao) o;
			return (this.classificacao.equals(a.getClassificacao()));
		}
        }
                
        public Classificacao clone() {
		return new Classificacao(this);
	}
        
	public String toString() {
		StringBuilder s = new StringBuilder();
		
		s.append("Classificacao: \n");
		s.append(this.getClassificacao().toString());
		return s.toString();
	}

}

package Business_Layer;

public class Torneio {
    private int id;
    private String nome;

        public Torneio() {
            this.id = 0;
            this.nome = "";
        }
        
	public Torneio(Torneio t) {
            this.id = t.getId();
            this.nome = t.getNome();
	}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
        
        

	public Torneio clone() {
    	return new Torneio(this);
    }


    
}

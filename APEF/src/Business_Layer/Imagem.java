package Business_Layer;

public class Imagem {
	private String nome;
    private String path;
    
    public Imagem() {
    	this.nome = new String();
    	this.path = new String();
    }
    
    public Imagem(String nome, String path) {
    	this.nome = nome;
    	this.path = path;
    }
    
    // Getters e Setters
    public String getNome() {
    	return this.nome;
    }

    public void setNome(String nome) {
    	this.nome = nome;
    }

    public String getPath() {
    	return path;
    }

    public void setPath(String path) {
    	this.path = path;
    }

    // Clone, toString, equals
        public boolean equals(Object obj) {
                if (obj == null) {
                        return false;
                }
                if (getClass() != obj.getClass()) {
                        return false;
                }
                final Imagem other = (Imagem) obj;
                if (!this.nome.equals(other.getNome())) {
                        return false;
                }
                return true;
        }

        @Override
        public String toString() {
                return "Imagem{" + "nome=" + this.nome + ", path=" + this.path + '}';
        }

        public Imagem clone() {
                return new Imagem(this.nome, this.path);
        }
}

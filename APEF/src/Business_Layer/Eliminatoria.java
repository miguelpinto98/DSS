package Business_Layer;

public class Eliminatoria extends Fase {    
    
    //Construtores
    public Eliminatoria() {
        super();
    }

    public Eliminatoria(Eliminatoria g) {
        super(g);
    }

    //Equals,Clone,toString
    public boolean equals(Object o) {

        if(this == o)
            return true;
        if ( (o == null) || (this.getClass() != o.getClass()) )
            return false;
        else {
        Eliminatoria eliminatoria = (Eliminatoria) o;
        return (this.getCalendario().equals(eliminatoria.getCalendario()));
        }
    }
    
    public Eliminatoria clone() {
        return new Eliminatoria(this);
    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("--Eliminatoria--") ;
        str.append(this.getListaEquipas());
        str.append(this.getCalendario()+"  ");
        return str.toString();
    }   
    //Metodos
}

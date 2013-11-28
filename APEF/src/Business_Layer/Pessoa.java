package Business_Layer;

import java.util.GregorianCalendar;

public abstract class Pessoa {
    private int id;
    private String nome;
    private Imagem foto;
    private GregorianCalendar dataNascimento;
    private int sexo; //0 - nao esta definido, 1 - masc , 2 - fem
}

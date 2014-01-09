package Business_Layer;

import java.util.HashSet;
import java.util.GregorianCalendar;

public class ResponsavelEscola extends Utilizador {
	private Escola escola; //???
	
	public ResponsavelEscola() {
		super();
		this.escola = new Escola();
	}

	public ResponsavelEscola(int tipo,String nickname, String password, String email, GregorianCalendar g, APEF a) {
		super(null,tipo,nickname,"",email,password,"","","",g,false,false,false);
		this.escola = new Escola(); 
		APEF.IDENTIFICADOR++;
	}
    
    public ResponsavelEscola(int id, Imagem avatar, int tipo, String nick, String nome, 
            String email, String pw, String morada, String tlmvl, String codPostal, 
            GregorianCalendar dataNasc, boolean ativo, boolean camposP,boolean removido,Escola escola) {
        super(id,avatar,tipo,nick,nome,email,pw,morada,tlmvl,codPostal,dataNasc,ativo,camposP,removido);
        this.escola = escola;
    }

	public ResponsavelEscola(ResponsavelEscola re) {
		super(re);
		this.escola = re.getEscola();
	}
	
	public Escola getEscola() {
		return this.escola;
	}

	public void setEscola(Escola es) {
		this.escola = es;
	}

	public ResponsavelEscola clone() {
		return new ResponsavelEscola(this);
	}
	
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if ((o == null) || (o.getClass() != this.getClass()))
			return false;
		else {
			ResponsavelEscola re = (ResponsavelEscola) o;
			return (this.getID() == re.getID());	
		}
	}
	
	public String toString() {
		StringBuilder str = new StringBuilder("Responsavel Escola\n");
                str.append("ID:" + this.getID() + "\n");
                str.append("Nickname:" + this.getNomeUser()+"\n");
                str.append("Password:" + this.getPass()+"\n");
                str.append("Email:" + this.getEmail()+"\n");
                //str.append("Escola" + this.escola.getNome()+"\n");
		
		return str.toString();
	}
}

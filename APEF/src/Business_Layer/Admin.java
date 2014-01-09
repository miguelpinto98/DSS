package Business_Layer;

import java.util.GregorianCalendar;
import java.util.HashSet;

public class Admin extends Utilizador {
	private APEF gestao;

	public Admin(){
		super();
		this.gestao = new APEF();
	}

	public Admin(int tipo,String nickname, String password, String email, GregorianCalendar g, APEF a){
		super(null,tipo,nickname,"",email,password,"","","",g,false,false,false);
		this.gestao = a;
		APEF.IDENTIFICADOR++;
	}
    
    public Admin(int id, Imagem avatar, int tipo, String nick, String nome, 
            String email, String pw, String morada, String tlmvl, String codPostal, 
            GregorianCalendar dataNasc, boolean ativo, boolean camposP,boolean removido) {
        super(id,avatar,tipo,nick,nome,email,pw,morada,tlmvl,codPostal,dataNasc,ativo,camposP,removido);
    }

	public Admin(Admin a) {
		super(a);
	}
	
	public APEF getGestao() {
		return this.gestao;
	}

	public void setGestao(APEF a){
		this.gestao = a;
	}
    
	public Admin clone() {
		return new Admin(this);
	}
	
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if ((o == null) || (o.getClass() != this.getClass()))
			return false;
		else {
			Admin re = (Admin) o;
			return (this.getID() == re.getID());	
		}
	}
	public String toString() {
		StringBuilder str = new StringBuilder("Admin\n");
		str.append("ID:" + this.getID() + "\n");
		str.append("Nickname:" + this.getNomeUser()+"\n");
        str.append("Password:" + this.getPass()+"\n");
        str.append("Email:" + this.getEmail()+"\n");
        str.append("Nome:" + this.getNome()+"\n");
		str.append("Morada:" + this.getMorada()+"\n");
        str.append("Contacto:" + this.getTelemovel()+"\n");
        str.append("DN:" + this.getDataNasc()+"\n");
        str.append("Ativo:" + this.isAtivo()+"\n");
        str.append("CP:" + this.isCamposPreenchidos()+"\n");
        str.append("Removido:" + this.isRemovido()+"\n");

        return str.toString();
	}
    
	public void criaNovaEpoca(int ano) {
		this.gestao.criaEpoca(ano);
	}
	
	public void atribuiPermissoes(String name) {
		this.gestao.mudarPermissoes(name);
	}
}
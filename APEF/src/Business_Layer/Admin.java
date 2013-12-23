package Business_Layer;

import java.util.GregorianCalendar;
import java.util.HashSet;

public class Admin extends Utilizador {
	private APEF gestao;
	private HashSet<HistoricoAcao> acoes;

	public Admin(){
		super();
		this.gestao = new APEF();
		this.acoes = new HashSet<HistoricoAcao>();
	}

	public Admin(String nickname, String password, String email, GregorianCalendar g, APEF a){
		super(null,nickname,"",email,password,"","","",g,false,false);
		this.gestao = a;
		this.acoes = new HashSet<HistoricoAcao>(); 
		APEF.IDENTIFICADOR++;
	}

	public Admin(Admin a) {
		super(a);
		this.acoes = a.getAcoes();
	}
	
	public APEF getGestao() {
		return this.gestao;
	}

	public void setGestao(APEF a){
		this.gestao = a;
	}
	
	public HashSet<HistoricoAcao> getAcoes() {
		HashSet<HistoricoAcao> hse = new HashSet<HistoricoAcao>();
		
		for(HistoricoAcao s : this.acoes)
			hse.add(s);
		
		return hse;
	}

	public void setAcoes (HashSet<HistoricoAcao> es) {
		this.acoes = es;
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
	
	/**public gdagvdd inserirEu(Utilizador x, Escola)
	{   nomeEquipa = 
		String s = "Inserir equipa "+ nomeEquipa + " da escola "+getNomeEscola();
		this.acoes.add(s)
	}*/

	public String toString() {
		StringBuilder str = new StringBuilder("Admin\n");
		str.append("ID:" + this.getID() + "\n");
		str.append("Nickname:" + this.getNomeUser()+"\n");
        str.append("Password:" + this.getPass()+"\n");
        str.append("Email:" + this.getEmail()+"\n");
        str.append(this.getAcoes());
		return str.toString();
	}
	
	public void criaNovaEpoca(int ano) {
		this.gestao.criaEpoca(ano);
	}
	
	public void atribuiPermissoes(String name) {
		this.gestao.mudarPermissoes(name);
	}

	public void inserirHistorico(HistoricoAcao h) {
		this.acoes.add(h);
	}
}
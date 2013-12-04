package Business_Layer;

import java.util.GregorianCalendar;
import java.util.HashSet;

public class Admin extends Utilizador {
	
	private HashSet<String> historicoAccao;

	public Admin(){
		super();
		this.historicoAccao = new HashSet<String>();
	}

	public Admin(int id, String nickname, String password, String email, GregorianCalendar g){
		super(id,null,nickname,"",email,password,"","","",g,false,false);
		this.historicoAccao = new HashSet<String>(); 
	}

	public Admin(Admin a) {
		super(a);
		this.historicoAccao = a.getHistoricoAccao();
	}
	
	public HashSet<String> getHistoricoAccao() {
		HashSet<String> hse = new HashSet<String>();
		
		for(String s : this.historicoAccao)
			hse.add(s);
		
		return hse;
	}

	public void setHistoricoAccao (HashSet<String> es) {
		this.historicoAccao = es;
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
		this.historicoAccao.add(s)
	}*/

	public String toString() {
		StringBuilder str = new StringBuilder("Admin\n");
		str.append("ID:" + this.getID() + "\n");
                str.append("Nickname:" + this.getNomeUser()+"\n");
                str.append("Password:" + this.getPass()+"\n");
                str.append("Email:" + this.getEmail()+"\n");
		return str.toString();
	}

}
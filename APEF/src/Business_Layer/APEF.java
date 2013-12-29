package Business_Layer;

import DAO.ConexaoBD;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class APEF {
    private HashMap<String, Escola> escolas;
    private HashMap<Integer, Epoca> epocas; //Não será melhor um TreeSet a ordenar por epocas?
    private HashMap<String, Utilizador> users;
    private HashSet<Campo> campos; /*Sao os campos que estao associados a escolas*/
    private Utilizador emSessao;

    public static int IDENTIFICADOR=1;
    
    public APEF() {
    	this.escolas = new HashMap<>();
    	this.epocas = new HashMap<>();
    	this.users = new HashMap<>();
    	this.campos = new HashSet<>();
        //this.iniciarConexao();
        //this.registaUtilizador();
        this.emSessao = null;
    }

    public APEF(APEF a) {
	this.escolas = a.getEscolas();
        this.epocas = a.getEpocas();
	this.users = a.getUsers();
	this.campos = a.getCampos();
        this.emSessao = a.getEmSessao();
    }

	public HashMap<String, Escola> getEscolas() {
		HashMap<String,Escola> aux = new HashMap<>();
		
		for(String s : this.escolas.keySet())
			aux.put(s, this.escolas.get(s));
		
		return aux;
	}
	
	public HashMap<Integer, Epoca> getEpocas() {
		HashMap<Integer,Epoca> aux = new HashMap<>();
		
		for(Integer s : this.epocas.keySet())
			aux.put(s, this.epocas.get(s).clone());
		return aux;
	}

	public HashMap<String, Utilizador> getUsers() {
		HashMap<String,Utilizador> aux = new HashMap<>();
		
		for(String s : this.users.keySet())
			aux.put(s, this.users.get(s).clone());
		
		return aux;
	}

	public HashSet<Campo> getCampos() {
        HashSet<Campo> aux = new HashSet<Campo>();
        for(Campo ca: this.campos) 
            aux.add(ca.clone());
        return aux;
    }

	public Utilizador getEmSessao() {
		return this.emSessao;
	}

	public void setEscolas(HashMap<String, Escola> escolas) {
		this.escolas = escolas;
	}
	
	public void setEpoca(HashMap<Integer, Epoca> epocas) {
		this.epocas = epocas;
	}
	
	public void setCampos(HashSet<Campo> campos) {
		this.campos = campos;
    }

    public void setUsers(HashMap<String, Utilizador> users) {
		this.users = users;
    }

    public void setEmSessao(Utilizador u) {
    	this.emSessao = u;
    }
	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.epocas == null) ? 0 : this.epocas.hashCode());
		result = prime * result + ((this.escolas == null) ? 0 : this.escolas.hashCode());
		result = prime * result + ((this.users == null) ? 0 : this.users.hashCode());
		return result;
	}

	public boolean equals(Object o) {
		if (this == o)
			return true;
		if ((o == null) || (this.getClass() != o.getClass()))
			return false;
		else {
			APEF apef = (APEF) o;
			return this.escolas.equals(apef.getEscolas()) && this.epocas.equals(apef.getEpocas()) && this.users.equals(apef.getUsers());
		}
	}
	
	public APEF clone() {
		return new APEF(this);
	}

	public String toString() {
		StringBuilder str = new StringBuilder(); 
		
		str.append("APEF\n");
		str.append("Utilizador:" + this.getUsers());
        str.append("Escola:" + this.getEscolas());
		
		return str.toString(); 
	}

	/**
	*Metodos Utilizadores
	*/
	public boolean existeEmail(String e) {
		boolean res=false;
		Iterator<String> it = this.users.keySet().iterator(); 
		while (it.hasNext() && !res) {
			String u = it.next();
			if (this.users.get(u).getEmail().equals(e)) {
				res = true;
			}
		}
                return res;
	}

	public boolean existeNickname(String nickname){
		return (this.users.containsKey(nickname));
	}

	public boolean existeUtilizador(String nickname, String email){
		return (existeNickname(nickname) || existeEmail(email));
	}

	

	public static boolean validaPassword(String pw) {
        boolean res = true;
        int i = 0;
        
        if(pw.length() < 6)
                    return false ;
        for (; i < pw.length() && res; i++) {
        	char c = pw.charAt(i);
            if (!(Character.isDigit(c) || Character.isLetter(c) || (c == '_') || (c == '.')))
            	res = false;
        }
        return res;
    }

    public boolean registarUser(String nickname, String password, String email, int tipoUser) {
	GregorianCalendar g = new GregorianCalendar();
        boolean inserido = false;
	
        if(validaPassword(password)) {
            if (tipoUser==0) { 
                Admin user = new Admin(nickname, password, email, g,this);
		String pw = user.encriptarPassword(password);
                user.setPass(pw);
       	    	inserido = inserirUtilizador(user);
            }
            if (tipoUser==1) { 
		ResponsavelEscola user = new ResponsavelEscola(nickname, password, email,g,this);
                String pw = user.encriptarPassword(password);
                user.setPass(pw);
                inserido = inserirUtilizador(user);
            }
            if (tipoUser==2) { 
		Arbitro user = new Arbitro(nickname, password, email, g,this);
                String pw = user.encriptarPassword(password);
                user.setPass(pw);
	        inserido = inserirUtilizador(user);
            }	
	}
        
        return inserido;
    }
    
    public boolean inserirUtilizador(Utilizador user) {
        boolean ins = false;
        
        if ( !(existeUtilizador(user.getNomeUser(),user.getEmail())) ) {
            this.users.put(user.getNomeUser(),user);
            ins = true;
        }
        
        return ins;
    }

    public void removerUtilizador(Utilizador user) {
	this.users.remove(user.getNomeUser());
    }

    public boolean validaLogin(String nickname, String password){
	return (existeNickname(nickname) && this.users.get(nickname).passwordCorresponde(password));
    }
    
    /* Ainda Falta Fazer Uma Verificação */
    public boolean login(String nickname, String password){
        boolean lg = false;
        
        if (validaLogin(nickname,password)) {
            if ((this.users.get(nickname).isAtivo())) { 
		this.emSessao = this.users.get(nickname);
                lg = true;
		if(this.users.get(nickname).isAtivo() && !this.users.get(nickname).isCamposPreenchidos()) {
                    /** metodo prencher campos*/
                    lg = true;
                }
            }
            else { 
                System.out.println("espera validacao");
                lg = true;
            }
        }
	else //System.out.println("LOGIN INVALIDO");
            lg = false;
        
        return lg;
    }
	
	public void logout(){
		this.emSessao = null;
	}

	/**
	*Metodos Escola
	*/
    public boolean inserirEscola(Escola a) {
    	if( !(this.escolas.containsKey(a.getNome())) ){
            this.escolas.put(a.getNome(),a);
            return true;
    	}
        else{
            System.out.println("Escola ja existe");
            return false;
        }
    }

    public void removerEscola(Escola escola) {
		this.escolas.remove(escola.getNome());
	}
	
	/**
	*Metodos Epoca
	*/
	public void criaEpoca(int anoEpoca) {
		GregorianCalendar g = new GregorianCalendar();
		
		if(this.epocas.containsKey(anoEpoca) || (anoEpoca-g.get(GregorianCalendar.YEAR))==0)
			; /*Epoca ja existe || Nao esta no ano corrente*/
		else {
			Epoca e = new Epoca();
			this.epocas.put(anoEpoca, e);
		}	
	}
    
    public void inserirEpoca(Epoca e) {
        if(!this.epocas.containsKey(e.getAno())) {
            this.epocas.put(e.getAno(), e);
        }
    }
	
	public void mudarPermissoes(String name) {
		if(this.users.get(name).isAtivo()) 
			this.users.get(name).setAtivo(false);
		else this.users.get(name).setAtivo(true);		
	}

	/**
	*Metodos Campeonato
	*/
	public boolean verificaJogadores(ArrayList<Jogador> inscritos) {
		return (inscritos.size() >= 12 && inscritos.size() <=25);
	}

	public void inscreveJogadores(int idCompeticao, ArrayList<Jogador> inscritos) {
		for(Jogador j : inscritos) {
			j.addCompeticao(idCompeticao);
		}
	}

	/*Isto e' um boolean para depois no swing dar um erro caso falhe alguma coisa*/
	public boolean inscreverCompeticao(int anoEpoca, int idCompeticao, Escalao x, ArrayList<Jogador> inscritos) {
		if(verificaJogadores(inscritos)) {
			inscreveJogadores(idCompeticao,inscritos);
            Epoca e = this.epocas.get(anoEpoca);
            e.inscreve(x);
			return true;
		}
		else return false;
	}
    
    /*Isto serve para confirmar se a inscricao acabou, e o admin pode agora "IniciarCampeonato"(metodo a ser 
    definido, que ja ira verificar 1�� se tem o nr de equipas pre-definido e de seguida, gerar o calendario, etc.)
    */
    public boolean acabouInscricao(Campeonato c) {
        GregorianCalendar now = new GregorianCalendar();
        if ( c.getDataLimiteInscricoes().before(now) && c.getNrEscaloes()==0) 
            return true;
        else return false;
    }

    public int countArbitros() {
		int res=0;
		for(String s : this.users.keySet())
			if (this.users.get(s) instanceof Arbitro) 
				res++;
		return res;
    }
    
    public ArrayList<Utilizador> daListaArbitros(){
        ArrayList<Utilizador> res = new ArrayList<>();
        
        for(String s : this.users.keySet())
		if (this.users.get(s) instanceof Arbitro) 
				res.add(this.users.get(s));
        return res;
    }
    
    public Campo daCampoEscalao(Escalao e){
    Campo c = this.escolas.get(e.getNomeEscola()).getCampo();
    return c;
    }

    public boolean iniciarCampeonato(Campeonato c){
    	boolean res=false;
        ArrayList<Integer> arrayEquipas = new ArrayList<>();
        ArrayList<Campo> arrayCampos = new ArrayList<>();
        ArrayList<Utilizador> arrayArbitros = new ArrayList<>();
        arrayArbitros = daListaArbitros();
        int nrEscaloes = c.getListaEscaloes().size();

        if (acabouInscricao(c) && countArbitros()>=((nrEscaloes)/2)){
        	for(Escalao e : c.getListaEscaloes()){
        		arrayEquipas.add(e.getID());
                arrayCampos.add(daCampoEscalao(e));
        	}
                
        	c.geraCalendario(arrayEquipas, arrayCampos, arrayArbitros);
            c.setNrEscaloes(nrEscaloes);
            
            for(Escalao e : c.getListaEscaloes()) {
                DadosEstatisticos d = new DadosEstatisticos();
                d.setIdEscalao(e.getID());
                c.getClassificacao().getClassificacao().getEstatistica().add(d);
            }
    	}
        return res;
    }
    
    public Torneio firstFaseTorneioTipo1 (Torneio t){
        ArrayList<Integer> arrayEquipas = new ArrayList<>();
        ArrayList<Integer> arrayEquipasGrupo1 = new ArrayList<>();
        ArrayList<Integer> arrayEquipasGrupo2 = new ArrayList<>();
        HashSet<Escalao> equipasGrupo1 = new HashSet<>();
        HashSet<Escalao> equipasGrupo2 = new HashSet<>();
        ArrayList<Utilizador> arrayArbitros = new ArrayList<>();
        arrayArbitros = daListaArbitros();

        for(Escalao e : t.getListaEscaloes()){
        		arrayEquipas.add(e.getID());
        	}

        int i,nrEquipas;
        nrEquipas = t.getNrEscaloes();
        
        for(i=0;i<(nrEquipas/2);i++){
        	equipasGrupo1.add(t.buscaEscalao(arrayEquipas.get(i)));
        }

        for(i=(nrEquipas/2);i<(nrEquipas);i++){
        	equipasGrupo2.add(t.buscaEscalao(arrayEquipas.get(i)));
        }

        Grupo g1 = new Grupo("Grupo A",equipasGrupo1);
        Grupo g2 = new Grupo("Grupo B",equipasGrupo2);
        
        for (Escalao e : equipasGrupo1){
            DadosEstatisticos d = new DadosEstatisticos();
            d.setIdEscalao(e.getID());
        	g1.getClassificacao().getClassificacao().getEstatistica().add(d);
                arrayEquipasGrupo1.add(e.getID());
        }

        for (Escalao e : equipasGrupo2){
            DadosEstatisticos d = new DadosEstatisticos();
            d.setIdEscalao(e.getID());
        	g2.getClassificacao().getClassificacao().getEstatistica().add(d);
                arrayEquipasGrupo2.add(e.getID());
        }

        Fase f1 = (Fase) g1;
        Fase f2 = (Fase) g2;
        
        HashSet<Utilizador> arbitrosEscolhidos = f1.geraCalendario(t.getID(),t.getDataInicio(),arrayEquipasGrupo1,t.getCampo(),arrayArbitros);
        /**arrayArbitros = funcao que retira os arbitrosEscolhidos do arrayArbitros ,,, 
         * substituindo o arrayArbitros por um LinkedList é permitido retirar elementos e o array ajusta-se não deixando espaços "vazios" (acho eu que funciona assim) */
        f2.geraCalendario(t.getID(),t.getDataInicio(),arrayEquipasGrupo2,t.getCampo(),arrayArbitros);
        
        t.getFases().add(f1);
        t.getFases().add(f2);
        
        return t;
    }

	public void addResultadoCompeticao(Jogo j, int gcasa, int gfora) {
		GregorianCalendar g = new GregorianCalendar();
		int ano = g.get(GregorianCalendar.YEAR);
		
		if(!this.epocas.containsKey(ano));
			ano--;
		
		this.epocas.get(ano).atualizaEpoca(j,gcasa,gfora);	
	}
        
    /* LIGAÇÃO BASE DE DADOS*/    
    public void iniciarConexao() {
    	ConexaoBD.iniciarConexao();
    }

    public void terminarConexao() {
        ConexaoBD.terminarConexao();
    }
    
    /* DEVOLVE LISTA DE JOGOS POR REALIZAR (15)*/
    public ArrayList<Jogo> jogosRealizados(int num) {
    	ArrayList<Jogo> res = new ArrayList<>();
    	Jogo j = null;
    	
    	for(Utilizador arb : this.users.values())
    		if(arb instanceof Arbitro) {
    			Agenda a = ((Arbitro) arb).getAgenda();
    			j = a.getUltimoJogoRealizado();
    			if(j!=null) {
    				res.add(j);
    				if(res.size()==num)
    					return res;
    			}
    		}
    	return res;
    }

    public ArrayList<Jogo> proximosJogos(int i) {
        ArrayList<Jogo> res = new ArrayList<>();
        Jogo j = null;
        
        for(Utilizador arb : this.users.values())
            if(arb instanceof Arbitro) {
                Agenda a = ((Arbitro) arb).getAgenda();
    		j = a.getProximoJogo();
                    if(j!=null) {
    			res.add(j);
    			if(res.size()==i)
                            return res;
                    }
            }
        return res;
    }
    
    public Set<String> listaEscolas() {        
        return this.escolas.keySet();
    }
    
    /* */
    public boolean criarEquipa(String esc, Equipa e) {
        return this.escolas.get(esc).inserirEquipa(e);
    }
}

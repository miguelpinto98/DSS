package Business_Layer;

import Data_Layer.ArbsDAO;
import Data_Layer.ConexaoBD;
import Data_Layer.EpocaDAO;
import Data_Layer.EscolaDAO;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;
import Data_Layer.UtilizadorDAO;
import java.util.Map;

public class APEF {
    private Map<String, Escola> escolas;
    private Map<Integer, Epoca> epocas; //Não será melhor um TreeSet a ordenar por epocas?
    private Map<String, Utilizador> users;
    private HashSet<Campo> campos; /*Sao os campos que nao estao associados a escolas*/
    private Utilizador emSessao;

    public static int IDENTIFICADOR=1;
    
    public APEF() {
    	this.escolas = new EscolaDAO();
    	this.epocas = new EpocaDAO();
    	this.users = new UtilizadorDAO();
    	this.campos = new HashSet<>();
        this.iniciarConexao();
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

    public Map<String, Escola> getEscolas() {
        return this.escolas;
    }
	
	public Map<Integer, Epoca> getEpocas() {
		Map<Integer,Epoca> aux = new EpocaDAO();
		for(Integer s : this.epocas.keySet())
			aux.put(s, this.epocas.get(s).clone());
		return aux;
	}

	public Map<String, Utilizador> getUsers() {
		Map<String,Utilizador> aux = new UtilizadorDAO();
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

	public void setEscolas(Map<String, Escola> escolas) {
		this.escolas = escolas;
	}
	
	public void setEpoca(Map<Integer, Epoca> epocas) {
		this.epocas = epocas;
	}
	
	public void setCampos(HashSet<Campo> campos) {
		this.campos = campos;
    }

    public void setUsers(Map<String, Utilizador> users) {
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

	public boolean validaPassword(String pw) {
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
                Admin user = new Admin(tipoUser,nickname, password, email, g,this);
                String pw = user.encriptarPassword(password);
                user.setPass(pw);
       	    	inserido = inserirUtilizador(user);
            }
            if (tipoUser==1) { 
                ResponsavelEscola user = new ResponsavelEscola(tipoUser,nickname, password, email,g,this);
                String pw = user.encriptarPassword(password);
                user.setPass(pw);
                inserido = inserirUtilizador(user);
            }
            if (tipoUser==2) { 
                Arbitro user = new Arbitro(tipoUser,nickname, password, email, g,this);
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
    	if(!(this.escolas.containsKey(a.getNome()))){
            this.escolas.put(a.getNome(),a);
            System.out.println("Escola inserida "+a.getNome());
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
            System.out.println("ccc");
            this.epocas.put(e.getAno(), e);
        }
    }
	
	public void mudarPermissoes(String name) {
		if(this.users.get(name).isAtivo()) 
			this.users.get(name).setAtivo(false);
		else 
            this.users.get(name).setAtivo(true);		
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
	public boolean inscreverCompeticaoCampeonato(int anoEpoca, int idCompeticao, Escalao x, ArrayList<Jogador> inscritos) {
		if(verificaJogadores(inscritos)) {
			inscreveJogadores(idCompeticao,inscritos);
            Epoca e = this.epocas.get(anoEpoca);
            
            e.inscreveEmCampeonato(x);
			return true;
		}
		else return false;
	}
    
    public boolean inscreverCompeticaoTorneio(int anoEpoca, int idCompeticao, Escalao x, ArrayList<Jogador> inscritos) {
		if(verificaJogadores(inscritos)) {
			inscreveJogadores(idCompeticao,inscritos);
            Epoca e = this.epocas.get(anoEpoca);
            e.inscreveEmTorneio(x,idCompeticao);
			return true;
		}
		else return false;
	}
    
    public boolean acabouInscricaoCampeonato(Campeonato c) {
        GregorianCalendar now = new GregorianCalendar();
        if ( c.getDataLimiteInscricoes().before(now) && c.getDataInicio().after(now) && c.getNrEscaloes()==0) 
            return true;
        else return false;
    }
    
    public boolean acabouInscricaoTorneioTipo1(Torneio t) {
        GregorianCalendar now = new GregorianCalendar();
        if (t.getDataLimiteInscricoes().before(now)) 
            return true;
        else return false;
    }
    
    public boolean acabouInscricaoTorneioTipo2(Torneio t) {
        GregorianCalendar now = new GregorianCalendar();
        if (t.getDataLimiteInscricoes().before(now) && t.getNrEscaloes()<33) 
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

        if (acabouInscricaoCampeonato(c) && countArbitros()>=((nrEscaloes)/2)){
        	for(Escalao e : c.getListaEscaloes().values()){
        		arrayEquipas.add(e.getID());
                arrayCampos.add(daCampoEscalao(e));
        	}
                
        	c.geraCalendario(arrayEquipas, arrayCampos, arrayArbitros);
            c.setNrEscaloes(nrEscaloes);
           
            for(Escalao e : c.getListaEscaloes().values()) {
                DadosEstatisticos x = new DadosEstatisticos(e.getID());
                c.getClassificacao().inserirDados(x);
            }
    	}
        return res;
    }
    
    public static ArrayList<Utilizador> daArbitrosDisponiveis (HashSet<Utilizador> arbitrosEscolhidos, ArrayList<Utilizador> arrayArbitros){
        ArrayList<Utilizador> res = new ArrayList<>();
        
        for(Utilizador u : arrayArbitros){
            if(!(arbitrosEscolhidos.contains(u))){
                res.add(u);
            }
        }
        return res;
    }
    
    public boolean iniciarTorneioTipo1(Torneio t){
    	boolean res=false;
        int nrEscaloes = t.getListaEscaloes().size();
        if (acabouInscricaoTorneioTipo1(t) && countArbitros()>=((nrEscaloes)/2)){
        	firstFaseTorneioTipo1(t);
                res=true;
    	}
        this.avancaData(t);
        return res;
    }
    
    public void avancaData(Torneio t) {
        GregorianCalendar data = t.getDataInicio();
        GregorianCalendar g = new GregorianCalendar();
        int ano = g.get(GregorianCalendar.YEAR);
        if(!this.epocas.containsKey(ano));
			ano--;
        Epoca ep = this.epocas.get(ano);
        ep.avancaDataCampeonto(data, t.getTipoEscalao());
    }
    
    public boolean iniciarTorneioTipo2(Torneio t){
    	boolean res=false;
        int nrEscaloes = t.getListaEscaloes().size();
        ArrayList<Utilizador> arrayArbitros = new ArrayList<>();
        arrayArbitros = daListaArbitros();
        String x= daNomeEliminatoria(nrEscaloes);
        if (acabouInscricaoTorneioTipo2(t) && countArbitros()>=((nrEscaloes)/2)){
        	   t.firstEliminatoriaTorneioTipo2(t,arrayArbitros,x);
                res=true;
    	}
        this.avancaData(t);
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

        for(Escalao e : t.getListaEscaloes().values()){
        		arrayEquipas.add(e.getID());
        	}

        int i,nrEquipas;
        nrEquipas = t.getNrEscaloes();
        
        for(i=0;i<nrEquipas/2;i++){	
                equipasGrupo1.add(t.buscaEscalao(arrayEquipas.get(i)));
            }
        for(i=nrEquipas/2;i<nrEquipas;i++){
            equipasGrupo2.add(t.buscaEscalao(arrayEquipas.get(i)));
        }
        
        Grupo g1 = new Grupo("Grupo A",equipasGrupo1);
        Grupo g2 = new Grupo("Grupo B",equipasGrupo2);
        
        for (Escalao e : equipasGrupo1){
                arrayEquipasGrupo1.add(e.getID());
                DadosEstatisticos x = new DadosEstatisticos(e.getID());
                g1.getClassificacao().inserirDados(x);
                t.getEstatisticaCompeticao().inserirDados(x);
        }

        for (Escalao e : equipasGrupo2){
                arrayEquipasGrupo2.add(e.getID());
                DadosEstatisticos x = new DadosEstatisticos(e.getID());
                g2.getClassificacao().inserirDados(x);
                t.getEstatisticaCompeticao().inserirDados(x);
        }

        
        HashSet<Utilizador> arbitrosEscolhidos = g1.geraCalendario(t.getID(),t.getDataInicio(),arrayEquipasGrupo1,t.getCampo(),arrayArbitros);
        ArrayList<Utilizador> arrayArbitrosDisponiveis = new ArrayList<>();
        arrayArbitrosDisponiveis = daArbitrosDisponiveis(arbitrosEscolhidos, arrayArbitros);
        Map<Integer,Utilizador> aux = new ArbsDAO();
        for(Utilizador j : arrayArbitrosDisponiveis) {
            aux.put(j.getID(), j);
        }
        g2.geraCalendario(t.getID(),t.getDataInicio(),arrayEquipasGrupo2,t.getCampo(),arrayArbitrosDisponiveis);
        
        Fase f1 = (Grupo) g1;
        Fase f2 = (Grupo) g2;

        t.inserirGrupo(t.getNFase(),f1);
        t.inserirGrupo(t.getNFase(),f2);
        
        t.setArbs(aux);
        
        return t;
    }
    
    public String daNomeEliminatoria(int x){
        String res = "";
        switch (x){
            case 32: res="1/16 DE FINAL";
                break;
            case 16: res="OITAVOS-DE-FINAL";
                break;
            case 8: res="QUARTOS-DE-FINAL";
                break;
            case 4: res="MEIA-FINAL";
                break;
        }
        return res;
    }
    
	public void addResultadoCompeticao(Jogo j) {
		GregorianCalendar g = new GregorianCalendar();
		int ano = g.get(GregorianCalendar.YEAR);
		if(!this.epocas.containsKey(ano));
			ano--;
		this.epocas.get(ano).atualizaEpoca(j,this);	
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
    
    public boolean emprestarJogador(Jogador j, String nomeEquipa, int escalao) {
        boolean flag = false, res = false;
        Equipa equipa = new Equipa();
        Iterator<Escola> it = this.escolas.values().iterator(); 
		while (it.hasNext() && !flag) {
            Escola e = it.next();
            Iterator<String> it2 = e.getEquipas().keySet().iterator(); 
            while (it2.hasNext() && !flag) {
                String eq = it2.next();
                if(eq==nomeEquipa) {
                    equipa = e.getEquipas().get(nomeEquipa);
                    flag = true;
                    res = equipa.getEscaloes().get(escalao).inserirJogador(j);
                }
            }
        }
        if(res) {
            j.setEmprestado(true);
            j.setNomeEquipaEmprestimo(nomeEquipa);
        }
        return res;
    }
    
    public boolean cancelarEmprestimo(Jogador j, int tipoEscalao) {
        boolean flag = false, res = false;
        Equipa equipa = new Equipa();
        Iterator<Escola> it = this.escolas.values().iterator(); 
		while (it.hasNext() && !flag) {
            Escola e = it.next();
            Iterator<String> it2 = e.getEquipas().keySet().iterator(); 
            while (it2.hasNext() && !flag) {
                String eq = it2.next();
                if(eq==j.getNomeEquipaEmprestimo()) {
                    equipa = e.getEquipas().get(j.getNomeEquipaEmprestimo());
                    flag = true;
                    res = equipa.getEscaloes().get(tipoEscalao).removerJogador(j);
                }
            }
        }
        if(res) {
            j.setEmprestado(false);
            j.setNomeEquipaEmprestimo("");
        }
        return res;
    }

    public boolean criarEquipa(String esc, Equipa e) {
        return this.escolas.get(esc).inserirEquipa(e);
    }
    
    public void atualizaPalmaresEquipa(String nomeCompeticao,String escola, String equipa) {
      this.escolas.get(escola).getEquipas().get(equipa).atualizaPalmares(nomeCompeticao);
    }
}

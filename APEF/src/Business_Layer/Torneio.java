package Business_Layer;

import Data_Layer.ArbsDAO;
import Data_Layer.EscalaoDAO;
import Data_Layer.FaseDAO;
import Data_Layer.GoleadoresDAO;
import Data_Layer.UtilizadorDAO;
import java.util.ArrayList;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

public class Torneio implements Competicao{
    
    //Variaveis de Instancia
    private int id;
    private int tipoEscalao;
    private int tipoTorneio;
    private String nome;
    private int nrEscaloes;
    private Map<Integer,Integer> goleadores;
    private Map<Integer,Escalao> listaEscaloes;
    private EstatisticaCompeticao estatisticaCompeticao;
    private GregorianCalendar dataInicio;
    private GregorianCalendar dataLimiteInscricoes;
    private int nFase;
    private Map<Integer,Fase> fases;
    private Campo campo;
    private Map<Integer,Utilizador> arbs;

    public Torneio() {
        this.id = 0;
        this.tipoEscalao = -1;
        this.tipoTorneio = -1;
        this.nome = "";
        this.nrEscaloes = 0;
        this.goleadores = new GoleadoresDAO();
        this.listaEscaloes = new EscalaoDAO();
        this.estatisticaCompeticao = new EstatisticaCompeticao();
        this.fases = new FaseDAO(this.id);
        this.nFase = 0;
        this.dataInicio = new GregorianCalendar();
        this.dataLimiteInscricoes = new GregorianCalendar();
        this.campo = new Campo();
        this.arbs = new ArbsDAO();
    }
    
    public Torneio(String nome, GregorianCalendar inicio, GregorianCalendar limite, int tipoEscalao, int tipoTorneio, int nrEquipas, Campo campo){
        this.id = APEF.IDENTIFICADOR;
        this.tipoEscalao = tipoEscalao;
        this.tipoTorneio = tipoTorneio;
        this.nome = nome;
        this.nrEscaloes = nrEquipas;
        this.goleadores = new GoleadoresDAO();
        this.listaEscaloes = new EscalaoDAO();
        this.estatisticaCompeticao = new EstatisticaCompeticao();
        this.fases = new FaseDAO(this.id);
        this.nFase = 0;
        this.dataInicio = inicio;
        this.dataLimiteInscricoes = limite;
        this.campo = campo;
        this.arbs = new ArbsDAO() ;
    }
    
    public Torneio(String nome, GregorianCalendar inicio, GregorianCalendar limite, int tipoEscalao, int nrEquipas, Campo campo){
        this.id = APEF.IDENTIFICADOR;
        this.tipoEscalao = tipoEscalao;
        this.nome = nome;
        this.nrEscaloes = nrEquipas;
        this.goleadores = new GoleadoresDAO();
        this.listaEscaloes = new EscalaoDAO();
        this.estatisticaCompeticao = new EstatisticaCompeticao();
        this.fases = new FaseDAO(this.id);
        this.nFase = 0;
        this.dataInicio = inicio;
        this.dataLimiteInscricoes = limite;
        this.campo = campo;
        this.arbs = new ArbsDAO();
    }  

	public Torneio(Torneio t) {
        this.id = t.getID();
        this.tipoEscalao = t.getTipoEscalao();
        this.tipoTorneio = t.getTipoTorneio();
        this.nome = t.getNome();
        this.nrEscaloes = t.getNrEscaloes();
        this.goleadores = t.getGoleadores();
        this.listaEscaloes = t.getListaEscaloes();
        this.estatisticaCompeticao = t.getEstatisticaCompeticao();
        this.fases = t.getFases();
        this.nFase = t.getNFase();
        this.dataInicio = t.getDataInicio();
        this.dataLimiteInscricoes = t.getDataLimiteInscricoes();
        this.campo = t.getCampo();
        this.arbs = t.getArbs();
	}

    public int getID() {
        return this.id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public int getTipoEscalao() {
        return this.tipoEscalao;
    }
    
    public int getTipoTorneio() {
        return this.tipoTorneio;
    }
    
    public void setTipoTorneio(int t) {
        this.tipoTorneio = t;
    }

    public void setTipoEscalao(int t) {
        this.tipoEscalao = t;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNrEscaloes() {
        return this.nrEscaloes;
    }

    public void setNrEscaloes(int nrEscaloes) {
        this.nrEscaloes = nrEscaloes;
    }

    public Map<Integer, Integer> getGoleadores() {
        Map<Integer,Integer> hsg = new GoleadoresDAO();
        for(Integer n : this.goleadores.keySet())
            hsg.put(n, this.goleadores.get(n));
        
        return hsg;
    }

    public void setGoleadores(HashMap<Integer, Integer> goleadores) {
        this.goleadores = goleadores;
    }
    
    public Map<Integer,Escalao> getListaEscaloes() {
        Map<Integer,Escalao> aux = new EscalaoDAO();
        for(Escalao e: this.listaEscaloes.values()) 
            aux.put(e.getID(),e);
        return aux;
    }

    public void setListaEscaloes (Map<Integer,Escalao> le){
        this.listaEscaloes = le;
    }

    public EstatisticaCompeticao getEstatisticaCompeticao(){
        return this.estatisticaCompeticao;
    }

    public void setEstatisticaCompeticao(EstatisticaCompeticao ec){
        this.estatisticaCompeticao = ec;
    }
    public Map<Integer,Fase> getFases(){
        Map<Integer,Fase> aux = new FaseDAO(this.id);

        for(Fase f : this.fases.values()){
            aux.put(f.getNFase(),f);
        }
        return aux;
    }
    
    public Map<Integer,Utilizador> getArbs(){
        Map<Integer,Utilizador> aux = new ArbsDAO();

        for(Utilizador f : this.arbs.values()){
            aux.put(f.getID(),f);
        }
        return aux;
    }
    
    public void setArbs(Map<Integer,Utilizador> a) {
        this.arbs = a;
    }
    
    public int getNFase() {
        return this.nFase;
    }

    public void setNFase(int n) {
        this.nFase = n;
    }
    public void setFases (Map<Integer,Fase> al){
        this.fases = al;
    }
    
    public GregorianCalendar getDataInicio(){
        return this.dataInicio;
    }

    public void setDataInicio (GregorianCalendar data) {
        this.dataInicio = data;
    }

    public GregorianCalendar getDataLimiteInscricoes(){
        return this.dataLimiteInscricoes;
    }

    public void setDataLimiteInscricoes (GregorianCalendar data){
        this.dataLimiteInscricoes = data;
    }

    public Campo getCampo(){
        return this.campo;
    }

    public void setCampo(Campo c){
        this.campo = c;
    }

    //Equals,hashCode,Clone,toString
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.goleadores);
        return hash;
    }
    
    public boolean equals(Object o) {
        if (this == null)
            return true;
        if ((o == null) || (this.getClass() != o.getClass()))
            return false;
        else {
            Torneio c = (Torneio) o;
            return (this.getID() == c.getID());
        }
    }

    public Torneio clone() {
        return new Torneio(this);
    }   

    public String toString() {
        StringBuilder str = new StringBuilder(); 
        
        str.append("--Torneio--\n");
        str.append("\nID: "+this.getID());
        str.append("\nNome: "+this.getNome());
        str.append("\nNrEquipas: "+this.getNrEscaloes());
        str.append("\nParticipantes: "+this.getListaEscaloes());
        str.append("\nClassificacao:"+this.estatisticaCompeticao);
        for(Fase x : this.fases.values())
            str.append(x.toString());
        return str.toString(); 
    }
    
    /** Metodos */
    public void inserirEscalao(Escalao e) {
        if(!this.listaEscaloes.containsKey(e.getID()))
            this.listaEscaloes.put(e.getID(),e);
    }

    public void removerEscalao(Escalao e) {
        this.listaEscaloes.remove(e);
    }

    public void inscreverEscalao(Escalao e) {
        inserirEscalao(e);
        this.nrEscaloes++;//no caso dos torneios temos de ver melhor isto ,,, 
                          // nao se sabe quantas equipas vai ter logo nao podes inicia-lo com um valor ,,,
                          // mais vale fazer o inverso, começar a 0 e incrementar
    }
    
    public Escalao buscaEscalao(int id) {
        Escalao res = new Escalao();
        boolean flag = false;
        Iterator<Escalao> it = this.listaEscaloes.values().iterator(); 
        while (it.hasNext() && !flag) {
            Escalao e = it.next();
            if (e.getID()==id) {
                res = e;
                flag = true;
            }
        }
        return res;
    }
    
    public void atualizaGoleadores(Jogo j) {
        int contador;
        for(Integer id: j.getGoleadoresJogo().keySet()) {
            if(this.goleadores.containsKey(id)) {
                contador = this.goleadores.get(id);
                this.goleadores.put(id, contador+1);
            }
            else
                this.goleadores.put(id, 1); 
        }
    }
    
    public ArrayList<Integer> melhoresMarcadoresAux() {
        Map<Integer,Integer> aux = this.goleadores;
        ArrayList<Integer> res = new ArrayList<>();
        int maxGolos = Collections.max(aux.values());

		Iterator<Integer> it = this.goleadores.keySet().iterator();
        while (it.hasNext()) {
            Integer id = it.next();
            if (maxGolos == this.goleadores.get(id)) {
                res.add(id);
                aux.remove(id);
            }
        }
        return res; 
    }
    
    public Jogador buscaJogador(int id) {
        Jogador res = new Jogador();
        boolean flag = false;
        
        Iterator<Escalao> it = this.listaEscaloes.values().iterator(); 
        while (it.hasNext() && !flag) {
            Escalao e = it.next();
            Iterator<Integer> it2 = e.getJogadores().keySet().iterator(); 
            while (it2.hasNext() && !flag) {
                Integer i = it2.next();
                if (i==id) {
                    res = e.getJogadores().get(id);
                    flag = true;
                }
            }
        }
        return res;
    }
        
    public ArrayList<Jogador> melhoresMarcardores() {
        ArrayList<Jogador> res = new ArrayList<>();
        ArrayList<Integer> aux = melhoresMarcadoresAux();
        Jogador j = new Jogador();
        for (int i = 0; i < aux.size(); i++) {
            j = buscaJogador(aux.get(i));
            res.add(i,j);
        }
        return res;
    }
    
     public Torneio secondFaseTorneioTipo1 (ArrayList<Integer> grupoA, ArrayList<Integer> grupoB) {
        HashSet<Escalao> equipas = new HashSet<>();
        ArrayList<Utilizador> arbs = new ArrayList<>();
        for(Utilizador j : this.getArbs().values()) {
            arbs.add(j);
        }                
        for (int i = 0; i < grupoA.size(); i++) {
            equipas.add(this.buscaEscalao(grupoA.get(i)));
        }
        for (int i = 0; i < grupoB.size(); i++) {
            equipas.add(this.buscaEscalao(grupoB.get(i)));
        }
        Eliminatoria meiaFinal = new Eliminatoria("Meia-Final",1,nFase);
        Map<Integer,Escalao> aux = new EscalaoDAO(meiaFinal.getID());
        for(Escalao e : equipas) {
            aux.put(e.getID(), e);
        }
        meiaFinal.setListaEquipas(aux);
        meiaFinal.geraCalendarioTipo1(this.getID(), this.getDataInicio(), arbs, grupoA, grupoB, this.getCampo());
        Fase f = (Fase) meiaFinal;
        this.getFases().put(this.nFase,f);
        this.nFase = 2;
        
    return this;
    }
    
    public Torneio thirdFaseTorneioTipo1(HashSet<Escalao> finalistas) {
        ArrayList<Utilizador> arbs = new ArrayList<>();
        for(Utilizador j : this.getArbs().values()) {
            arbs.add(j);
        }          
        Eliminatoria finale = new Eliminatoria("Final",1,this.nFase);
        Map<Integer,Escalao> aux = new EscalaoDAO(finale.getID());
        for(Escalao e : finalistas) {
            aux.put(e.getID(), e);
        }
        finale.setListaEquipas(aux);
        finale.geraFinal(this.getID(),this.getDataInicio(),arbs,finalistas,this.getCampo());
        Fase f = (Fase) finale;
        this.getFases().put(this.nFase,f);
        this.nFase++;
        
        return this;
    }

    public boolean atualizaTorneioTipo1(Jogo j, APEF ap) {
        int i = this.getNFase();
        ArrayList<Integer> equipas1 = new ArrayList<>();
        ArrayList<Integer> equipas2 = new ArrayList<>();
        boolean res = false;
        boolean res2 = false;
        boolean res3 = false;
        Grupo a = (Grupo) this.fases.get(i);
        Eliminatoria e = (Eliminatoria) this.fases.get(i);
        if(i == 0) {
            res = a.atualizaGrupoTipo1(j,ap);
            if(!res) {
                Grupo b = (Grupo) this.fases.get(1);
                res = b.atualizaGrupoTipo1(j,ap);
                res2 = b.ultimoJogoGrupo();
                if(res2) 
                    equipas2 = b.doisMelhores();
                    equipas1 = a.doisMelhores();
            }
         }
        else {
            res=e.atualizaEliminatoriaTipo1(j,ap);
            res3 = e.ultimoJogoEliminatoria();
            }
            
        if(res) {
            this.atualizaGoleadores(j);
            this.estatisticaCompeticao.actualizaClassificacao(j);
        }
        
        if (res2) 
            this.secondFaseTorneioTipo1(equipas1,equipas2);
        if (res3)
            if(e.vencedores().size() == 2)
                this.thirdFaseTorneioTipo1(e.vencedores());
            else
                this.atualizaPalmaresVencedor(ap,e.vencedores());
        return res;
    }

    public void atualizaPalmaresVencedor(APEF a, HashSet<Escalao> vencedor) {
        for(Escalao e : vencedor) {
            a.atualizaPalmaresEquipa(this.nome,e.getNomeEscola(),e.getNomeEquipa());
        }  
    }
    
    public Torneio firstEliminatoriaTorneioTipo2 (Torneio t, ArrayList<Utilizador> arrayArbitros,String nomeElim) {
        HashSet<Escalao> equipas = new HashSet<>();
        ArrayList<Integer> arrayEquipas = new ArrayList<>();
        for(Escalao eq : t.getListaEscaloes().values()) {
            equipas.add(eq);
        }
        int nrEquipas = equipas.size();
        for(Escalao e: equipas){
            arrayEquipas.add(e.getID());
            DadosEstatisticos x = new DadosEstatisticos(e.getID());
            t.getEstatisticaCompeticao().inserirDados(x);
        }
        
        ArrayList<Utilizador> arbs = new ArrayList<>();
        arbs = arrayArbitros;
        String nomeEliminatoria = nomeElim;
        Eliminatoria elimi = new Eliminatoria(nomeEliminatoria,1,this.nFase);
        Map<Integer,Escalao> aux = new EscalaoDAO(elimi.getID());
        for(Escalao e : equipas) {
            aux.put(e.getID(), e);
        }
        elimi.setListaEquipas(aux);
        elimi.geraCalendarioTipo2(t.getID(), t.getDataInicio(), arbs, arrayEquipas, t.getCampo());
        //System.out.println(elimi);
        Fase f = (Fase) elimi;
        t.inserirEliminatoria(t.getNFase(),f);  
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
    
    public Torneio secondEliminatoriaTorneioTipo2 (HashSet<Escalao> escaloes) {
        ArrayList<Utilizador> arbs = new ArrayList<>();
        for(Utilizador j : this.getArbs().values()) {
            arbs.add(j);
        }          
        int nrEquipas = escaloes.size();
        ArrayList<Integer> equipas = new ArrayList<>();
        for(Escalao e : escaloes){
            equipas.add(e.getID());
        }
        String nm = daNomeEliminatoria(nrEquipas);
        Eliminatoria elim = new Eliminatoria(nm,1,this.nFase);
        Map<Integer,Escalao> aux = new EscalaoDAO(elim.getID());
        for(Escalao e : escaloes) {
            aux.put(e.getID(), e);
        }
        elim.setListaEquipas(aux);
        elim.geraCalendarioTipo2(this.getID(), this.getDataInicio(), arbs, equipas, this.getCampo());
        Fase f = (Fase) elim;
        this.inserirEliminatoria(this.nFase,f);
        
    return this;
    }
    
    public boolean atualizaTorneioTipo2(Jogo j, APEF ap) {
        boolean res = false, res2=false;
        int i = this.nFase;
        Eliminatoria e = (Eliminatoria) this.fases.get(i);
        res=e.atualizaEliminatoriaTipo1(j,ap);
        res2=e.ultimoJogoEliminatoria();
        ArrayList<Integer> arrayVencedoras = new ArrayList<>();
        if(res) {
            this.atualizaGoleadores(j);
            this.estatisticaCompeticao.actualizaClassificacao(j);
        }
        
        if(res2){
            this.secondEliminatoriaTorneioTipo2(e.vencedores());
            this.nFase++;
        }
            
        return res;
        }    
    
    public void inserirGrupo (int i,Fase f){
        this.fases.put(i,f);
    }
    
    public void inserirEliminatoria (int i,Fase f){
        this.fases.put(i,f);
    }
    
}
        

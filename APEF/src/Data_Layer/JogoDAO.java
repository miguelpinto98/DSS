package Data_Layer;

import Business_Layer.Agenda;
import Business_Layer.Arbitro;
import Business_Layer.Campo;
import Business_Layer.Escalao;
import Business_Layer.Imagem;
import Business_Layer.Jogo;
import Business_Layer.Treinador;
import Business_Layer.Utilizador;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author serafim
 */
public class JogoDAO implements Map<Integer,Jogo> {
    private int id;
    private int idJornada;
    
    private HashMap<Integer,Jogo> jogos;
    
    public static final String JOGO_O = "Jogo o";
    public static final int IDJOGO = 1;
    public static final int IDCOMPETICAO = 2;
    public static final int REALIZADO = 3;
    public static final int DIA = 4;
    public static final int IDCAMPO = 5;
    public static final int IDAGENDA = 6;
    public static final int IDESCALAOCASA = 7;
    public static final int IDESCALAOFORA = 8;
    public static final int NRGOLOSCASA = 9;
    public static final int NRGOLOSFORA = 10;
    public static final int IDJORNADA = 11;
    
    public static final int ID_CAMPO = 1;
    public static final int NOME_CAMPO = 2;
    
    public static final int IDUTILIZADOR=1;
    public static final int AVATAR = 2;
    public static final int NICKNAME = 3;
    public static final int EMAIL = 4;
    public static final int PASSWORD = 5;
    public static final int MORADA = 6;
    public static final int TELEMOVEL = 7;
    public static final int CODPOSTAL = 8;
    public static final int DATANASC = 9;
    public static final int ATIVO = 10;
    public static final int CAMPOSPREENCHIDOS = 11;
    public static final int TIPO = 12;
    public static final int REMOVIDO = 13;
    public static final int NOME = 14;
    
    private static final int ID_ESCALAO = 1;
    private static final int TIPOESCALAO = 2;
    private static final int ESCOLANOME = 3;
    private static final int ID_EQUIPA = 4;
    private static final int ID_TREINADOR = 5;
    private static final int ID_AGENDA = 6;
    private static final int ID_DADOSEST = 7;
    private static final int ID_CAMPEONATO = 8;
    private static final int ID_TORNEIO = 9;
    private static final int ID_FASE = 10;
    private static final int REMOVIDO2 = 11;
    
    private static final int IDPESSOA = 1;
    private static final int NOMEPESSOA = 2;
    private static final int FOTO = 3;
    private static final int DATANASC2 = 4;
    private static final int SEXO = 5;
    
    public JogoDAO() {
        this.jogos = new HashMap<Integer,Jogo>(); 
    }

    public JogoDAO(int id) {
        this.id = id;
        this.idJornada = id; 
    }
    
    public boolean converte(int a) {
        if(a==0)
            return false;
        else return true;
    }
    
    public int converte2(boolean a) {
        if(a==true)
            return 1;
        else return 0;
    }
    
    @Override
    public int size() {
        int res = 0;
        try {
            Statement stm = ConexaoBD.getConexao().createStatement();          
            String sql = "SELECT * FROM AGENDA";
            ResultSet rs = stm.executeQuery(sql);
            
            while(rs.next())
                res++;
            
            ConexaoBD.fecharCursor(rs, stm);
        } catch (SQLException e) {
        }  
        return res;
    }

    @Override
    public boolean isEmpty() {
        return this.jogos.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        try {
        int id = (Integer) key;
        Statement stm = ConexaoBD.getConexao().createStatement();
        String sql = "SELECT IDJOGO FROM JOGO j WHERE j.IDJOGO = "+id;
            ResultSet rs = stm.executeQuery(sql);
            boolean res = rs.next();
            ConexaoBD.fecharCursor(rs, stm);
            return res;
        } catch (SQLException e) {
            throw new NullPointerException(e.getMessage());
        }    
    }

    @Override
    public boolean containsValue(Object value) {
        return this.jogos.containsValue(value);
    }

    @Override
    public Jogo get(Object key) {
        Jogo res = null;
        
        try {
            int idJogo = (Integer) key;
            //String chave = c.toUpperCase();
            Statement stm = ConexaoBD.getConexao().createStatement();
            String sql = "SELECT * FROM JOGO j WHERE j.IDJOGO = "+idJogo;
            ResultSet rs = stm.executeQuery(sql);
            
            Arbitro arb = null;
            Campo campo = null;
            Escalao escCasa = null;
            Escalao escFora = null;
            Treinador t1 = null;
            Treinador t2 = null;
            
            if(rs.next()) {
                int idJ = rs.getInt(IDJOGO);
                int idComp = rs.getInt(IDCOMPETICAO);
                int aux = rs.getInt(REALIZADO);
                boolean realizado = converte(aux);
                if(aux==1) { realizado = true; }
                else realizado = false;
                GregorianCalendar data = new GregorianCalendar();
                GregorianCalendar data2 = data;
                rs.getTimestamp(DIA, data);
                int idCampo = rs.getInt(IDCAMPO);
                int idArbitro = rs.getInt(IDUTILIZADOR);
                int idEscalaoCasa = rs.getInt(IDESCALAOCASA);
                int idEscalaoFora = rs.getInt(IDESCALAOFORA);
                int nGolosCasa = rs.getInt(NRGOLOSCASA);
                int nGolosFora = rs.getInt(NRGOLOSFORA);
                int idJornada = rs.getInt(IDJORNADA);
                
                stm = ConexaoBD.getConexao().createStatement();
                sql = "SELECT * FROM CAMPO c where c.IDCAMPO = "+idCampo;
                rs = stm.executeQuery(sql);
                if(rs.next()) {
                    String sCampo = rs.getString(NOME_CAMPO);
                    campo = new Campo(idCampo, sCampo);
                }
                
                stm = ConexaoBD.getConexao().createStatement();
                sql = "SELECT * FROM ARBITRO a where a.IDUTILIZADOR = "+idArbitro;
                rs = stm.executeQuery(sql);
                if(rs.next()) {
                int idAgenda = rs.getInt(IDAGENDA);
                int id = rs.getInt(IDUTILIZADOR);
                Imagem avatar = null;
                if(rs.getBlob(AVATAR) == null)
                avatar = new Imagem();
                int tipo = rs.getInt(TIPO);
                String nick = rs.getString(NICKNAME);
                String nome = rs.getString(NOME);
                String email = rs.getString(EMAIL);
                String pw = rs.getString(PASSWORD);
                String morada = rs.getString(MORADA);
                String tlmvl = rs.getString(TELEMOVEL);
                String codPostal = rs.getString(CODPOSTAL);
                GregorianCalendar dataNasc = new GregorianCalendar();
                rs.getTimestamp(DATANASC, dataNasc);
                int ativo = rs.getInt(ATIVO); 
                int camposPreenchidos = rs.getInt(CAMPOSPREENCHIDOS);  
                int removido = rs.getInt(REMOVIDO);
                                        
                JogoDAO ag = new JogoDAO(idAgenda);
                Agenda agenda = new Agenda(idAgenda,ag);
                arb = new Arbitro(id,avatar,tipo,nick,nome,email,pw,morada,tlmvl,
                                        codPostal,dataNasc,converte(ativo),converte(camposPreenchidos),
                                        agenda,converte(removido));
                }    
                
                stm = ConexaoBD.getConexao().createStatement();
                sql = "SELECT * FROM ESCALAO e where e.IDESCALAO = "+idEscalaoCasa;
                rs = stm.executeQuery(sql);
                if(rs.next()) {
                int idEscalao1 = rs.getInt(ID_ESCALAO);
                int tipoEscalao = rs.getInt(TIPOESCALAO);
                String nomeEsc = rs.getString(ESCOLANOME);
                int idEquipa = rs.getInt(ID_EQUIPA);
                int idTreinador1 = rs.getInt(ID_TREINADOR);
                int idAgendaEscalao1 = rs.getInt(ID_AGENDA);
                int idDados = rs.getInt(ID_DADOSEST);
                int idCamp = rs.getInt(ID_CAMPEONATO);
                int idTorneio = rs.getInt(ID_TORNEIO);
                int idFase = rs.getInt(ID_FASE);
                int removido = rs.getInt(REMOVIDO2);
                
                stm = ConexaoBD.getConexao().createStatement();
                sql = "SELECT * FROM EQUIPA e where e.IDEQUIPA = "+idEquipa;
                rs = stm.executeQuery(sql);
                String nomeEquipa1 = new String();
                if(rs.next()) {
                nomeEquipa1 = rs.getString(NOME);
                }
                
                stm = ConexaoBD.getConexao().createStatement();
                sql = "SELECT * FROM PESSOA t where t.IDPESSOA = "+idTreinador1;
                rs = stm.executeQuery(sql);
                if(rs.next()) {
                int idTrei1 = rs.getInt(IDPESSOA);
                String nomeTreinador1 = rs.getString(NOMEPESSOA);
                Imagem foto1 = null;
                if(rs.getBlob(FOTO) == null)
                foto1 = new Imagem();
                GregorianCalendar dN1 = new GregorianCalendar();
                rs.getTimestamp(DATANASC2, dN1);
                int sexo1 = rs.getInt(SEXO);
                
                t1 = new Treinador(idTrei1,nomeTreinador1,foto1,dN1,sexo1);
                }
                
                escCasa = new Escalao(idEscalao1, nomeEquipa1, nomeEsc, t1);
                }
                
                stm = ConexaoBD.getConexao().createStatement();
                sql = "SELECT * FROM ESCALAO e where e.IDESCALAO = "+idEscalaoFora;
                rs = stm.executeQuery(sql);
                if(rs.next()) {
                int idEscalao2 = rs.getInt(ID_ESCALAO);
                int tipoEscalao2 = rs.getInt(TIPOESCALAO);
                String nomeEsc2 = rs.getString(ESCOLANOME);
                int idEquipa2 = rs.getInt(ID_EQUIPA);
                int idTreinador2 = rs.getInt(ID_TREINADOR);
                int idAgendaEscalao1 = rs.getInt(ID_AGENDA);
                int idDados2 = rs.getInt(ID_DADOSEST);
                int idCamp2 = rs.getInt(ID_CAMPEONATO);
                int idTorneio2 = rs.getInt(ID_TORNEIO);
                int idFase2 = rs.getInt(ID_FASE);
                int removido2 = rs.getInt(REMOVIDO2);
                
                stm = ConexaoBD.getConexao().createStatement();
                sql = "SELECT * FROM EQUIPA e where e.IDEQUIPA = "+idEquipa2;
                rs = stm.executeQuery(sql);
                String nomeEquipa2 = new String();
                if(rs.next()) {
                nomeEquipa2 = rs.getString(NOME);
                }
                
                stm = ConexaoBD.getConexao().createStatement();
                sql = "SELECT * FROM PESSOA t where t.IDPESSOA = "+idTreinador2;
                rs = stm.executeQuery(sql);
                if(rs.next()) {
                int idTrei2 = rs.getInt(IDPESSOA);
                String nomeTreinador2 = rs.getString(NOMEPESSOA);
                Imagem foto = null;
                if(rs.getBlob(FOTO) == null)
                foto = new Imagem();
                GregorianCalendar dN = new GregorianCalendar();
                rs.getTimestamp(DATANASC2, dN);
                int sexo2 = rs.getInt(SEXO);
                
                t2 = new Treinador(idTrei2,nomeTreinador2,foto,dN,sexo2);
                }
                
                escFora = new Escalao(idEscalao2, nomeEquipa2, nomeEsc2, t2);
                }
                
                res = new Jogo(idJogo,idComp,data2,campo,arb,escCasa,escFora);
            }
                
        ConexaoBD.fecharCursor(rs, stm);
        } catch (Exception e) {
        }        
        return res;
    }

    @Override
    public Jogo put(Integer key, Jogo value) {
        Jogo res = null;
        try {
            Integer c = (Integer) key;
            boolean existe = this.containsKey(key);
            PreparedStatement stm = null;
            
            if(!existe) {
                String sql = "";
                
                sql = "INSERT INTO Jogo(idJogo,idComp,realizado,dia,idCampo,idAgenda,idEscalaoCasa,idEscalaoFora,nrGolosCasa,nrGolosFora,idJornada) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                
                stm.setInt(IDJOGO, value.getID());
                stm.setInt(IDCOMPETICAO,value.getIdCompeticao());
                stm.setInt(REALIZADO,converte2(value.isJogoRealizado()));
                Timestamp dataNasc = new Timestamp(value.getDiaJogo().getTimeInMillis());
                stm.setTimestamp(DIA, dataNasc);
                stm.setInt(IDCAMPO,value.getCampoJogo().getID());
                stm.setInt(IDAGENDA, this.id);
                stm.setInt(IDESCALAOCASA, value.getEscalaoCasa().getID());
                stm.setInt(IDESCALAOFORA, value.getEscalaoFora().getID());
                stm.setInt(NRGOLOSCASA, value.getNumGolosJogoCasa());
                stm.setInt(NRGOLOSFORA, value.getNumGolosJogoFora());
                stm.setInt(IDJORNADA, this.idJornada);
                
                stm.execute();
                stm.close();
                
            }
            res = value;
        } catch (SQLException e) {
        }
        return res;
    }

    @Override
    public Jogo remove(Object key) {
        try {
			Jogo res = null;
			int chave = (Integer) key;
			String sql = "DELETE FROM JOGO j WHERE j.IDJOGO = ?";
			PreparedStatement stm = ConexaoBD.getConexao()
					.prepareStatement(sql);
			stm.setInt(1, chave);
			stm.execute();
                        ConexaoBD.fecharCursor(null, stm);
			return res;
		} catch (Exception e) {
			throw new NullPointerException(e.getMessage());
		}
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Jogo> m) {
        this.jogos.putAll(m);
    }

    @Override
    public void clear() {
        this.jogos.clear();
    }

    @Override
    public Set<Integer> keySet() {
        Set<Integer> res = new HashSet<>();
        try {
            Statement stm = ConexaoBD.getConexao().createStatement();
            String sql = "SELECT IDJOGO FROM JOGO j WHERE j.IDAGENDA = "+this.id;
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next())
                res.add(rs.getInt(IDJOGO));
          
            ConexaoBD.fecharCursor(rs, stm);
        } catch (SQLException e) {
            throw new NullPointerException(e.getMessage());
        }
        return res;
    }

    @Override
    public Collection<Jogo> values() {
        Statement stm;
        try {
            Collection<Jogo> jgs = new ArrayList<Jogo>();
            stm = ConexaoBD.getConexao().createStatement();
            String sql = "SELECT * FROM JOGO j where j.IDAGENDA = "+this.id;
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next()) {
                
                Jogo jg = new Jogo();
                jgs.add(jg);
            }
            ConexaoBD.fecharCursor(rs, stm);
            return jgs;
        } catch (SQLException e) {  
            throw new NullPointerException(e.getMessage());
        }
}

    @Override
    public Set<Map.Entry<Integer, Jogo>> entrySet() {
        return this.jogos.entrySet();
    }
    
    public int hashCode() {
        return ConexaoBD.getConexao().hashCode();
    }
}

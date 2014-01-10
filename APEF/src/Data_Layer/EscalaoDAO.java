package Data_Layer;

import Business_Layer.Escalao;
import Business_Layer.Imagem;
import Business_Layer.Treinador;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author serafim
 */
public class EscalaoDAO implements Map<Integer,Escalao> {
    private int idEquipa;
    private int idFase;
    
    private static final int ID_PESSOA = 1;
    private static final int TREINADOR_NOME = 2;
    private static final int FOTO = 3;
    private static final int TREINADOR_DATANASC = 4;
    private static final int TREINADOR_SEXO = 5;
    
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
    private static final int REMOVIDO = 11;
    
    public EscalaoDAO() {
    }
    
    public EscalaoDAO(int id) {
        this.idEquipa = id;
        this.idFase = id;
    }
    
    @Override
    public int size() {
        int res = 0;
        try {
            Statement stm = ConexaoBD.getConexao().createStatement();          
            String sql = "SELECT * FROM ESCALAO";
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
        throw new NullPointerException("Não Definido");
    }

    @Override
    public boolean containsKey(Object key) {
        boolean res = false;
        try {
            int chave = (Integer) key;
            //String chave = c.toUpperCase();
            
            Statement stm = ConexaoBD.getConexao().createStatement();          
            String sql = "SELECT * FROM ESCALAO e WHERE e.IDESCALAO = "+chave;
            ResultSet rs = stm.executeQuery(sql);
            res = rs.next();
            
            ConexaoBD.fecharCursor(rs, stm);   
        } catch (SQLException e) {
        }
        return res;
    }

    @Override
    public boolean containsValue(Object value) {
        throw new NullPointerException("Não Definido");
    }

    @Override
    public Escalao get(Object key) {
        Escalao escalao = null;
        try {
            Integer chave = (Integer) key;
            if(chave < 4) {
                Statement stm = ConexaoBD.getConexao().createStatement();
                String sql = "SELECT * FROM ESCALAO e WHERE e.TIPOESCALAO = "+chave+" and e.IDEQUIPA = "+this.idEquipa;
                ResultSet rs = stm.executeQuery(sql);         
                if(rs.next()) {
                    int nIdEsc = rs.getInt(ID_ESCALAO);
                    int nTipoEsc = rs.getInt(TIPOESCALAO);
                    String nNomeEsco = rs.getString(ESCOLANOME);
                    int nIdEqui = rs.getInt(ID_EQUIPA);
                    int nIdTrei = rs.getInt(ID_TREINADOR);
                    int nIdAg = rs.getInt(ID_AGENDA);
                    int nIdDadEst = rs.getInt(ID_DADOSEST);
                    int nIdCamp = rs.getInt(ID_CAMPEONATO);
                    int nIdTor = rs.getInt(ID_TORNEIO);
                    int nIdFase = rs.getInt(ID_FASE);
                    int nrem = rs.getInt(REMOVIDO);
                    
                    stm = ConexaoBD.getConexao().createStatement();
                    sql = "SELECT * FROM PESSOA p, TREINADOR t WHERE t.IDPESSOA = "+nIdTrei+" and p.IDPESSOA = "+nIdTrei;
                    rs = stm.executeQuery(sql);
                    Treinador t = null;
                    if(rs.next()) {
                        int nIdPess = rs.getInt(ID_PESSOA);
                        String nomePess = rs.getString(TREINADOR_NOME);
                        Blob avatar = rs.getBlob(FOTO);
                        GregorianCalendar dataNascT = new GregorianCalendar();
                        rs.getTimestamp(TREINADOR_DATANASC, dataNascT);
                        int sexoTrei = rs.getInt(TREINADOR_SEXO);
                        
                        t = new Treinador(nIdPess,nomePess,new Imagem(),dataNascT,sexoTrei);
                        
                        stm = ConexaoBD.getConexao().createStatement();
                        sql = "SELECT NOME FROM Equipa e WHERE e.IDEQUIPA = "+nIdEqui;
                        rs = stm.executeQuery(sql);
                        String nomeEquipa = null;
                        if(rs.next())
                            nomeEquipa = rs.getString(1);
                        
                        escalao = new Escalao(nIdEsc, nTipoEsc, nNomeEsco, nomeEquipa, t, nIdAg,nIdDadEst);
                    }
                }
            
            }
        } catch (SQLException e) {
        }
        return escalao;
    }

    @Override
    public Escalao put(Integer key, Escalao value) {
        Escalao res = null;
        try {
            Integer c = (Integer) key;
            boolean existe = this.containsKey(key);
            PreparedStatement stm = null;
            
            if(!existe && c < 4) {
                String sql = "";
                
                Treinador tre = value.getTreinador();
                if(tre != null) {
                    sql = "INSERT INTO Pessoa(idPessoa, nome, foto, dataNasc, sexo) VALUES (?, ?, ?, ?, ?)";
                    stm = ConexaoBD.getConexao().prepareStatement(sql);
                    stm.setInt(ID_PESSOA, tre.getID());
                    stm.setString(TREINADOR_NOME, tre.getNome());
                    stm.setString(FOTO, null);
                    Timestamp dataNasc = new Timestamp(tre.getDataNasc().getTimeInMillis());
                    stm.setTimestamp(TREINADOR_DATANASC, dataNasc);
                    stm.setInt(TREINADOR_SEXO, tre.getSexo());
                    stm.execute();
                    stm.close();
                    
                    sql = "INSERT INTO Treinador(idPessoa) VALUES (?)";
                    stm = ConexaoBD.getConexao().prepareStatement(sql);
                    stm.setInt(ID_PESSOA, tre.getID());
                    stm.execute();
                    stm.close();
                    
                    System.out.println(value.getNomeEquipa());
                    System.out.println(value.getTipoEscalao());
                    
                    
                    sql = "INSERT INTO Escalao VALUES ("+value.getID()+", "+value.getTipoEscalao()+", '"+value.getNomeEscola()+"', "+this.idEquipa+", "+tre.getID()+", null, null, null, null, null, 0)";
                    stm = ConexaoBD.getConexao().prepareStatement(sql);
                    //stm.setInt(ID_ESCALAO, value.getID());
                    //stm.setInt(TIPOESCALAO, c);
                    //stm.setString(ESCOLANOME, value.getNomeEscola());
                    //stm.setInt(ID_EQUIPA, this.idEquipa);
                    //stm.setInt(ID_TREINADOR, tre.getID());
                    //stm.setInt(REMOVIDO, 0);
                    ResultSet rs = stm.executeQuery();
                    if(rs.rowInserted())
                        System.out.println("INSERIDA");
                    stm.close();
                }
            }
            res = value;
        } catch (SQLException e) {
        }
        return res;
    }

    @Override
    public Escalao remove(Object key) {
        throw new NullPointerException("Não Definido");
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Escalao> m) {
        throw new NullPointerException("Não Definido");
    }

    @Override
    public void clear() {
        throw new NullPointerException("Não Definido");
    }

    @Override
    public Set<Integer> keySet() {
        Set<Integer> res = new HashSet<>();
        try {
            Statement stm = ConexaoBD.getConexao().createStatement();
            String sql = "SELECT IDESCALAO FROM ESCALAO e WHERE e.IDEQUIPA = "+this.idEquipa;
            ResultSet rs = stm.executeQuery(sql);
            
            while(rs.next())
                res.add(rs.getInt(1));
           
            ConexaoBD.fecharCursor(rs, stm);
        } catch (SQLException e) {
        }
        return res;
    }

    @Override
    public Collection<Escalao> values() {
        throw new NullPointerException("Não Definido");
    }

    @Override
    public Set<Map.Entry<Integer, Escalao>> entrySet() {
        throw new NullPointerException("Não Definido");
    }
    
    public int hashCode() {
        return ConexaoBD.getConexao().hashCode();
    }
}


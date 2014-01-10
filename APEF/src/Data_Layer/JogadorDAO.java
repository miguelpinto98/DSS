package Data_Layer;

import Business_Layer.Imagem;
import Business_Layer.Jogador;
import static Data_Layer.EscolaDAO.NOME;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author serafim
 */
public class JogadorDAO implements Map<Integer,Jogador> {
    private static final int ID_PESSOA = 1;
    private static final int NOME_PESSOA = 2;
    private static final int FOTO_PESSOA = 3;
    private static final int DATANASC_PESSOA = 4;
    private static final int SEXO_PESSOA = 5;
    
    private static final int GOLOS_JOGADOR = 2;
    private static final int IDESCALAO_JOGADOR = 3;
    private static final int EMPRESTADO_JOGADOR = 4;
    private static final int IDEQUIPA_JOGADOR = 5;
    private static final int IDEQUIPAEMPR = 6;
    private static final int REMOVIDO = 7;
    
    private int idEscalao;
    private String nomeEquipa;
    
    public JogadorDAO(int idEscalao, String NomeEquipa) {
        this.idEscalao = idEscalao;
        this.nomeEquipa = NomeEquipa;
    }
    
    @Override
    public int size() {
        int res = 0;
        try {
            Statement stm = ConexaoBD.getConexao().createStatement();          
            String sql = "SELECT * FROM JOGADOR j WHERE j.IDESCALAO = "+this.idEscalao;
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
        try {
            Integer chave = (Integer) key;            
            Statement stm = ConexaoBD.getConexao().createStatement();          
            String sql = "SELECT * FROM JOGADOR j WHERE j.IDPESSOA = "+chave;
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
        throw new NullPointerException("Não Definido");
    }

    @Override
    public Jogador get(Object key) {
        Jogador jog = null;
        try {
            int chave = (Integer) key;
            Statement stm = ConexaoBD.getConexao().createStatement();
            String sql = "SELECT * FROM JOGADOR j, PESSOA p WHERE j.IDPESSOA = "+chave+" and p.IDPESSOA = "+chave;
            ResultSet rs = stm.executeQuery(sql);
            
            if(rs.next()) {
                int idPessoa = rs.getInt(ID_PESSOA);
                int ngolos = rs.getInt(GOLOS_JOGADOR);
                int idEsc = rs.getInt(IDESCALAO_JOGADOR);
                int emprestado = rs.getInt(EMPRESTADO_JOGADOR);
                int idEquipa = rs.getInt(IDEQUIPA_JOGADOR);
                int idEquipaEmpr = rs.getInt(IDEQUIPAEMPR);
                int removido = rs.getInt(REMOVIDO);
                String nome = rs.getString(9);
                int foto = rs.getInt(10);
                Calendar dataNascT = GregorianCalendar.getInstance();
                dataNascT.setTime(rs.getTimestamp(11));
                int sexo = rs.getInt(12);
                
                jog = new Jogador(idPessoa, nome, new Imagem(), (GregorianCalendar) dataNascT, sexo, ngolos, this.nomeEquipa, emprestado, idEquipaEmpr);
            }
            
        } catch (SQLException e) {
        }
        
        return jog;
    }

    @Override
    public Jogador put(Integer key, Jogador value) {
        Jogador jog = null;
        try {
            int chave = (Integer) key;
            boolean existe = this.containsKey(key);
            
            if(!existe) {
                String sql = "INSERT INTO Pessoa(idPessoa, nome, foto, dataNasc, sexo) VALUES (?, ?, ?, ?, ?)";
                PreparedStatement pstm = ConexaoBD.getConexao().prepareStatement(sql);
                pstm.setInt(ID_PESSOA, value.getID());
                pstm.setString(NOME_PESSOA, value.getNome());
                pstm.setString(FOTO_PESSOA, null);
                Timestamp data = new Timestamp(value.getDataNasc().getTimeInMillis());
                pstm.setTimestamp(DATANASC_PESSOA, data);
                pstm.setInt(SEXO_PESSOA, value.getSexo());
                pstm.execute();
                pstm.close();
                
                sql = "SELECT IDEQUIPA FROM EQUIPA e WHERE e.NOME = '"+this.nomeEquipa+"'";
                Statement stm = ConexaoBD.getConexao().createStatement();
                ResultSet rs = stm.executeQuery(sql);
                int idEquipa = 0;
                if(rs.next())
                    idEquipa = rs.getInt(1);
                rs.close();
                
                sql = "INSERT INTO Jogador VALUES("+value.getID()+", "+value.getNrGolos()+", "+this.idEscalao+", 0, "+idEquipa+", null, 0)";
                pstm = ConexaoBD.getConexao().prepareStatement(sql);
                //pstm.setInt(ID_PESSOA, value.getID());
                //pstm.setInt(GOLOS_JOGADOR, value.getNrGolos());
                //pstm.setInt(IDESCALAO_JOGADOR, this.idEscalao);
                //pstm.setInt(EMPRESTADO_JOGADOR, 0);
                //pstm.setInt(IDEQUIPA_JOGADOR, idEquipa);
                //pstm.setInt(IDEQUIPAEMPR, 0);
                //pstm.setInt(REMOVIDO, 0);
                pstm.executeQuery();
                pstm.close();

            }
        
        } catch (SQLException e) {
        }
        
        return jog;
    }

    @Override
    public Jogador remove(Object key) {
        throw new NullPointerException("Não Definido");
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Jogador> m) {
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
            String sql = "SELECT IDPESSOA FROM JOGADOR j WHERE j.IDESCALAO = "+this.idEscalao;
            ResultSet rs = stm.executeQuery(sql);
            
            while(rs.next())
                res.add(rs.getInt(1));
           
            ConexaoBD.fecharCursor(rs, stm);
        } catch (SQLException e) {
        }
        return res;
    }

    @Override
    public Collection<Jogador> values() {
        Collection<Jogador> res = new HashSet<Jogador>();
        try {
            Statement stm = ConexaoBD.getConexao().createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM JOGADOR j, PESSOA p WHERE j.IDESCALAO = "+this.idEscalao+" and p.IDPESSOA = j.IDPESSOA");
            
            while(rs.next()) {
                int id = rs.getInt(1);
                int golos = rs.getInt(2);
                int idesc = rs.getInt(3);
                int emprestado = rs.getInt(4);
                int idequi = rs.getInt(5);
                int idequiempr = rs.getInt(6);
                
                String nome = rs.getString(9);
                GregorianCalendar g = new GregorianCalendar();
                rs.getTimestamp(11, g);
                int sexo = rs.getInt(12);
                
                Jogador j = new Jogador(id, nome, new Imagem(), g, sexo, golos, this.nomeEquipa, emprestado, idequiempr);
                
                res.add(j);
            }
        } catch (Exception e) {
        }
        return res;
    }

    @Override
    public Set<Map.Entry<Integer, Jogador>> entrySet() {
        throw new NullPointerException("Não Definido");
    }
    
     public int hashCode() {
         return ConexaoBD.getConexao().hashCode();
    }
}


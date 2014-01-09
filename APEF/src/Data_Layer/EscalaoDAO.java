package Data_Layer;

import Business_Layer.Escalao;
import Business_Layer.Treinador;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author serafim
 */
public class EscalaoDAO implements Map<Integer,Escalao> {
    private HashMap<Integer,Escalao> escaloes = new HashMap<Integer, Escalao>();
    private int idEquipa;
    
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
    
    public EscalaoDAO(int idEquipa) {
        this.idEquipa = idEquipa;
    }
    
    @Override
    public int size() {
        return this.escaloes.size();
    }

    @Override
    public boolean isEmpty() {
        return this.escaloes.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return this.escaloes.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return this.escaloes.containsValue(value);
    }

    @Override
    public Escalao get(Object key) {
        Escalao escalao = null;
        try {
            
        } catch (Exception e) {
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
                    
                    sql = "INSERT INTO Escalao(idEscalao, tipoEscalao, Escolanome, idEquipa, idTreinador, idAgenda, idDadosEstatisticos, idCampeonato, idTorneio, idFase, removido) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                    stm = ConexaoBD.getConexao().prepareStatement(sql);
                    stm.setInt(ID_ESCALAO, value.getID());
                    stm.setInt(TIPOESCALAO, value.getTipoEscalao());
                    stm.setString(ESCOLANOME, value.getNomeEscola());
                    stm.setInt(ID_EQUIPA, this.idEquipa);
                    stm.setInt(ID_TREINADOR, tre.getID());
                    stm.setInt(REMOVIDO, 0);
                    stm.execute();
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
        return this.escaloes.remove(key);
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Escalao> m) {
        this.escaloes.putAll(m);
    }

    @Override
    public void clear() {
        this.escaloes.clear();
    }

    @Override
    public Set<Integer> keySet() {
        return this.escaloes.keySet();
    }

    @Override
    public Collection<Escalao> values() {
        return this.escaloes.values();
    }

    @Override
    public Set<Map.Entry<Integer, Escalao>> entrySet() {
        return this.escaloes.entrySet();
    }
    
    public int hashCode() {
        return ConexaoBD.getConexao().hashCode();
    }
}


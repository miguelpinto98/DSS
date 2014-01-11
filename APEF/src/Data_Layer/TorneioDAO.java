/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Data_Layer;

import Business_Layer.Campo;
import Business_Layer.EstatisticaCompeticao;
import Business_Layer.Torneio;
import static Data_Layer.JogoDAO.NOME_CAMPO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author serafim
 */
public class TorneioDAO implements Map<Integer,Torneio> {
    private int tipoEscalao;
    
    public TorneioDAO(int id) {
        this.tipoEscalao = id;
    }
    @Override
    public int size() {
        int i=0;
         try {
            Statement stm = ConexaoBD.getConexao().createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM TORNEIO t WHERE t.TIPOESCALAO = '"+this.tipoEscalao+"'");
                 while (rs.next()) i++;
                 ConexaoBD.fecharCursor(rs, stm);}
         catch(SQLException e) {}
         return i;
    }

    @Override
    public boolean isEmpty() {
       try {
        Statement stm = ConexaoBD.getConexao().createStatement();
        ResultSet rs = stm.executeQuery("SELECT IDTORNEIO FROM Torneio t");
        boolean res = !rs.next();
        ConexaoBD.fecharCursor(rs, stm);        
        return res;
        } catch (SQLException e) {
            throw new NullPointerException(e.getMessage());
        }  
    }

    public boolean containsKey(Object key){
        boolean res = false;
        try {
            int chave = (Integer) key;
            Statement stm = ConexaoBD.getConexao().createStatement();          
            String sql = "SELECT * FROM TORNEIO t WHERE t.TIPOESCALAO = '"+this.tipoEscalao+"' and t.IDTORNEIO= '"+chave+"'";
            ResultSet rs = stm.executeQuery(sql);
            res = rs.next();
            ConexaoBD.fecharCursor(rs, stm);}
        catch (SQLException e) {}
        return res;
    }

    @Override
    public boolean containsValue(Object value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Torneio get(Object key) {
        Torneio t = null;
        try {
            Integer chave = (Integer) key;
            Statement stm = ConexaoBD.getConexao().createStatement();
            String sql = "SELECT * FROM TORNEIO t WHERE t.TIPOESCALAO = '"+this.tipoEscalao+"' and t.IDTORNEIO = '"+chave+"'";
            ResultSet rs = stm.executeQuery(sql);         
            if(rs.next()) {
                int id = rs.getInt("IDTORNEIO");
                int tipoEscalao = rs.getInt("TIPOESCALAO");
                int tipoTorneio = rs.getInt("TIPOTORNEIO");
                String nome  = rs.getString("NOME");
                int nrEscaloes = rs.getInt("NRESCALOES");
                GoleadoresDAO gs = new GoleadoresDAO(id);
                EscalaoDAO es = new EscalaoDAO(id); 
                EstatisticaCompeticao ec = new EstatisticaCompeticao(id);
                FaseDAO f = new FaseDAO(id);
                GregorianCalendar g = new GregorianCalendar();
                rs.getTimestamp("DATAINICIO",g);
                GregorianCalendar g1 = new GregorianCalendar();
                rs.getTimestamp("DATALIMINSCICAO",g1);
                int nfase = rs.getInt("NFASE");
                ArbsDAO arbs = new ArbsDAO(id);
                int idCampo = rs.getInt("IDCAMPO");

                stm = ConexaoBD.getConexao().createStatement();
                sql = "SELECT * FROM CAMPO c where c.IDCAMPO = ";
                rs = stm.executeQuery(sql);
                if(rs.next()) {
                    String sCampo = rs.getString(NOME_CAMPO);
                    Campo campo = new Campo(idCampo, sCampo);
                    t = new Torneio(id,tipoEscalao,tipoTorneio,nome,nrEscaloes,gs,es,ec,f,g,g1,nfase,arbs,campo);
                }
            }
                           
           } catch (SQLException e) {}
        return t;
    }

    @Override
    public Torneio put(Integer key, Torneio value) {
        Torneio res = null;
        Integer id = (Integer) key;
        try{            
            boolean existe = this.containsKey(key);
            String sql;
                      
            if(!existe) {
                sql = "INSERT INTO Torneio(idTorneio,tipoEscalao,tipoTorneio,nome,nrEscaloes,"
                        + "dataInicio,dataLimInscicao,nFase,idEstatisticaComp, Epocaano,idCampo) "
                        + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement stm = ConexaoBD.getConexao().prepareStatement(sql);
                stm.setInt(1, value.getID());
                stm.setInt(2, value.getTipoEscalao());
                stm.setInt(3, value.getTipoTorneio());
                stm.setString(4, value.getNome());
                stm.setInt(5, value.getNrEscaloes());
                Timestamp di = new Timestamp(value.getDataInicio().getTimeInMillis());
                stm.setTimestamp(6, di);
                Timestamp dfi = new Timestamp(value.getDataLimiteInscricoes().getTimeInMillis());
                stm.setTimestamp(7, dfi);
                stm.setInt(8, value.getNFase());
                stm.setInt(9, value.getEstatisticaCompeticao().getID());
                stm.setInt(10, value.getID());
                stm.setInt(11, value.getCampo().getID());
                stm.executeQuery();
                stm.close();
                res = value;
            }        
        } catch (SQLException e) {
        }
    return res;
    }

    @Override
    public Torneio remove(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Torneio> m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<Integer> keySet() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Torneio> values() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<Entry<Integer, Torneio>> entrySet() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

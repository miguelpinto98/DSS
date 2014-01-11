package Data_Layer;

import Business_Layer.Campeonato;
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


public class CampeonatoDAO implements Map<Integer,Campeonato>/*IDCAMPEONATO->CAMPEONATO*/{
    private int idEpoca;
    
    
    private static final int ID_CAMPEONATO = 1;
    private static final int TIPO_ESCALAO = 2;
    private static final int NOME = 3;
    private static final int NR_ESCALOES = 4;
    private static final int DATA_INICIO = 5;
    private static final int DATA_LIMITE = 6;
    private static final int ID_DADOSEST = 7;
    private static final int ID_CALENDARIO = 8;
    private static final int ID_EPOCA = 9;
    
    public CampeonatoDAO(int id) {
        this.idEpoca=id;
    }
   
    @Override
    public int size(){
        int i=0;
         try {
            Statement stm = ConexaoBD.getConexao().createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM CAMPEONATO c WHERE c.EPOCAANO="+this.idEpoca);
                 while (rs.next()) i++;
                 ConexaoBD.fecharCursor(rs, stm);}
         catch(SQLException e) {}
         return i;}
    
    @Override
    public boolean isEmpty() {throw new NullPointerException("Não Definido");}

    @Override
    public boolean containsKey(Object key){
        boolean res = false;
        try {
            int chave = (Integer) key;
            Statement stm = ConexaoBD.getConexao().createStatement();          
            String sql = "SELECT * FROM CAMPEONATO camp WHERE camp.EPOCAANO = "+this.idEpoca+" and camp.TIPOESCALAO= '"+chave+"'";
            ResultSet rs = stm.executeQuery(sql);
            res = rs.next();
            ConexaoBD.fecharCursor(rs, stm);}
        catch (SQLException e) {}
        return res;}
    
  
    @Override
    public boolean containsValue(Object value) {throw new NullPointerException("Não Definido");}

    
    @Override
    public Campeonato get(Object key) {
        Campeonato camp = null;
        try {
            Integer chave = (Integer) key;
            Statement stm = ConexaoBD.getConexao().createStatement();
            String sql = "SELECT * FROM CAMPEONATO camp WHERE camp.EPOCAANO = "+this.idEpoca+" and camp.IDCAMPEONATO="+chave;
            ResultSet rs = stm.executeQuery(sql);         
            if(rs.next()) {
                int tipoEsc = rs.getInt(TIPO_ESCALAO);
                String nome = rs.getString(NOME);
                int nrEscaloes = rs.getInt(NR_ESCALOES);                   
                GregorianCalendar g = new GregorianCalendar();
                rs.getTimestamp(DATA_INICIO,g);
                GregorianCalendar g1 = new GregorianCalendar();
                rs.getTimestamp(DATA_LIMITE,g1);
                           
            camp = new Campeonato (nome,g, g1, tipoEsc, nrEscaloes);}
            
           } catch (SQLException e) {}
        return camp;}
    

    @Override
    public Campeonato put(Integer key, Campeonato value){
        Campeonato res = null;
        Integer idC = (Integer) key;
        try{            
            boolean existe = this.containsKey(key);
            String sql;
                      
            if(!existe) {
                sql = "INSERT INTO Campeonato(idCampeonato, tipoEscalao, nome, nrEscaloes, dataInicio, dataLimInscricoes, Epocaano) VALUES (?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement stm = ConexaoBD.getConexao().prepareStatement(sql);
                stm.setInt(1, value.getID());
                stm.setInt(2, value.getTipoEscalao());
                stm.setString(3, value.getNome());
                stm.setInt(4, value.getNrEscaloes());
                Timestamp di = new Timestamp(value.getDataInicio().getTimeInMillis());
                stm.setTimestamp(5, di);
                Timestamp dfi = new Timestamp(value.getDataLimiteInscricoes().getTimeInMillis());
                stm.setTimestamp(6, dfi);
                stm.setInt(7, this.idEpoca);
                
                stm.executeQuery();
                stm.close();
                System.out.println("CAMPEONATO INSERIDO");
                res = value;
            }        
        } catch (SQLException e) {
        }
    return res;
    }
    
       
    @Override
    public Campeonato remove(Object key) {
        Campeonato res = null;
        try {            
            Integer chave = (Integer) key;
            String sql = "DELETE FROM CAMPEONATO WHERE CAMPEONATO.IDCAMPEONATO = "+chave;
            PreparedStatement stm = ConexaoBD.getConexao().prepareStatement(sql);
            stm.execute();
            ConexaoBD.fecharCursor(null, stm);
            return res;
        } catch (Exception e) {
            throw new NullPointerException(e.getMessage());
        }
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Campeonato> m) {throw new NullPointerException("Não Definido");}

    @Override
    public void clear() {throw new NullPointerException("Não Definido");}

    @Override
    public Set<Integer> keySet() {
        Set<Integer> res = new HashSet<Integer>();
        try {                
                Statement stm = ConexaoBD.getConexao().createStatement();
                ResultSet rs = stm.executeQuery("SELECT * FROM CAMPEONATO");
                while (rs.next())
                res.add(rs.getInt(ID_CAMPEONATO));
                ConexaoBD.fecharCursor(rs, stm);}
        catch (SQLException e) {}
        return res;
   }
    
    

    @Override
    public Collection<Campeonato> values() {throw new NullPointerException("Não Definido");}

    @Override
    public Set<Map.Entry<Integer, Campeonato>> entrySet() {throw new NullPointerException("Não Definido");}
    
    @Override
    public int hashCode() {return ConexaoBD.getConexao().hashCode();}
}



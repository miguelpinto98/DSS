package Data_Layer;

import Business_Layer.Campeonato;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;


public class CampeonatoDAO implements Map<Integer,Campeonato>/*IDCAMPEONATO->CAMPEONATO*/ {
    private int idEpoca;
    
    private static final int ID_CAMPEONATO = 1;
    private static final int TIPO_ESCALAO = 2;
    private static final String NOME = null;
    private static final int NR_ESCALOES = 4;
    private static final int DATA_INICIO = 5;
    private static final int DATA_LIMITE = 6;
    private static final int ID_DADOSEST = 7;
    private static final int ID_CALENDARIO = 8;
    private static final int ID_EPOCA = 9;
    
    public CampeonatoDAO(int id) {this.idEpoca=id;}
    
    public CampeonatoDAO(){}
    
   
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
            String sql = "SELECT * FROM CAMPEONATO camp WHERE camp.EPOCAANO = "+this.idEpoca+" and camp.IDCAMPEONATO="+chave;
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
                int idCamp = rs.getInt(ID_CAMPEONATO);
                int tipoEsc = rs.getInt(TIPO_ESCALAO);
                String nome = rs.getString(NOME);
                int nrEscaloes = rs.getInt(NR_ESCALOES);                   
                GregorianCalendar g = new GregorianCalendar();
                rs.getTimestamp(DATA_INICIO,g);
                GregorianCalendar g1 = new GregorianCalendar();
                rs.getTimestamp(DATA_LIMITE,g1);
                int idDadEst = rs.getInt(ID_DADOSEST);
                int idCal = rs.getInt(ID_CALENDARIO);
                int idEpocaa = rs.getInt(ID_EPOCA);
            
            camp = new Campeonato (nome,g, g1, tipoEsc, nrEscaloes);}
            
           } catch (SQLException e) {}
        return camp;}
    
 
    
   

    @Override
    public Campeonato put(Integer key, Campeonato value){
        Campeonato res = null;
        Integer c = (Integer) key;
        try{            
            boolean existe = this.containsKey(key);
            PreparedStatement stm = null;            
            if(!existe) {
                String sql = "INSERT INTO Campeonato(nome, dataI, dataF, tipo, nrEquipas) VALUES (?, ?, ?, ?, ?)";
                    stm = ConexaoBD.getConexao().prepareStatement(sql);
                    stm.setString(3, value.getNome());
                    Timestamp dataIn = new Timestamp(value.getDataInicio().getTimeInMillis());
                    stm.setTimestamp(DATA_INICIO, dataIn);
                    Timestamp dataFim = new Timestamp(value.getDataLimiteInscricoes().getTimeInMillis());
                    stm.setTimestamp(DATA_LIMITE, dataFim);
                    stm.setInt(TIPO_ESCALAO, value.getTipoEscalao());
                    stm.setInt(NR_ESCALOES, value.getNrEscaloes());
                    stm.execute();
                    stm.close();}
             res = value;}            
        catch (SQLException e) {}
    return res;}
    
       
    @Override
    public Campeonato remove(Object key) {
        Campeonato res = null;
        try {            
            Integer chave = (Integer) key;
            String sql = "DELETE FROM CAMPEONATO WHERE CAMPEONATO.IDCAMPEONATO = ?";
            PreparedStatement stm = ConexaoBD.getConexao().prepareStatement(sql);
            stm.setInt(ID_CAMPEONATO, chave);
            stm.execute();
            ConexaoBD.fecharCursor(null, stm);
            return res;}
        catch (Exception e){throw new NullPointerException(e.getMessage());}
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Campeonato> m) {throw new NullPointerException("Não Definido");}

    @Override
    public void clear() {throw new NullPointerException("Não Definido");}

    @Override
    public Set<Integer> keySet() {
        Set<Integer> res = new TreeSet<Integer>();
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



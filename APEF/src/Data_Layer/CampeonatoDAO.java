package Data_Layer;

import Business_Layer.Campeonato;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;


public class CampeonatoDAO implements Map<Integer,Campeonato> {
    private static final int ID_CAMPEONATO = 1;
    private static final int TIPO_ESCALAO = 2;
    private static final String NOME = null;
    private static final int NR_ESCALOES = 4;
    private static final Date DATA_INICIO = null;
    private static final Date DATA_LIMITE = null;
    private static final int ID_DADOSEST = 7;
    private static final int ID_CALENDARIO = 8;
    private static final int ID_EPOCA = 9;
    
    public CampeonatoDAO() {}
    
    @Override
    public int size() {
        int i=0;
         try {
            Statement stm = ConexaoBD.getConexao().createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM CAMPEONATO");
                 while (rs.next()) i++;
                 ConexaoBD.fecharCursor(rs, stm);}
         catch(Exception e) {throw new NullPointerException(e.getMessage());}
         return i;}

    @Override
    public boolean isEmpty() {throw new NullPointerException("Não Definido");}

    @Override
    public boolean containsKey(Object key){
        boolean res = false;
        try {
            int chave = (Integer) key;
            Statement stm = ConexaoBD.getConexao().createStatement();          
            String sql = "SELECT * FROM CAMPEONATO camp WHERE camp.IDCAMPEONATO = "+chave;
            ResultSet rs = stm.executeQuery(sql);
            res = rs.next();
            ConexaoBD.fecharCursor(rs, stm);}
        catch (SQLException e) {}
        return res;}

    @Override
    public boolean containsValue(Object value) {throw new NullPointerException("Não Definido");}

    public static Calendar DateToCalendar(Date date){ 
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal;
      }
    
    @Override
    public Campeonato get(Object key) {
        Campeonato camp = null;
        try {
            Integer chave = (Integer) key;
            if(chave < 4) {
                Statement stm = ConexaoBD.getConexao().createStatement();
                String sql = "SELECT * FROM CAMPEONATO c WHERE c.IDCAMPEONATO = "+chave;
                ResultSet rs = stm.executeQuery(sql);         
                if(rs.next()) {
                    int idCamp = rs.getInt(ID_CAMPEONATO);
                    int tipoEsc = rs.getInt(TIPO_ESCALAO);
                    String nome = rs.getString(NOME);
                    int nrEscaloes = rs.getInt(NR_ESCALOES);
                    Date aux = rs.getDate(5);
                    Date aux2 = rs.getDate(6);                   
                    GregorianCalendar dataI = (GregorianCalendar) DateToCalendar(aux);
                    GregorianCalendar dataF = (GregorianCalendar) DateToCalendar(aux2);
                    int idDadEst = rs.getInt(ID_DADOSEST);
                    int idCal = rs.getInt(ID_CALENDARIO);
                    int idEpoca = rs.getInt(ID_EPOCA);}            
            }
        } catch (SQLException e) { }
        return camp;
    }

    @Override
    public Campeonato put(Integer key, Campeonato value){
        Campeonato res = null;
        Integer c = (Integer) key;
        try{            
            boolean existe = this.containsKey(key);
            PreparedStatement stm = null;            
            if(!existe && c < 4) {
                String sql = "INSERT INTO Campeonato(nome, dataI, dataF, tipo, nrEquipas) VALUES (?, ?, ?, ?, ?)";
                    stm = ConexaoBD.getConexao().prepareStatement(sql);
                    stm.setString(3, value.getNome());
                    stm.setDate(5, (java.sql.Date) DATA_INICIO);
                    stm.setDate(6, (java.sql.Date) DATA_LIMITE);
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
        try {
                Set<Integer> res = new TreeSet<Integer>();
                Statement stm = ConexaoBD.getConexao().createStatement();
                ResultSet rs = stm.executeQuery("SELECT * FROM CAMPEONATO");
                while (rs.next())
                res.add(rs.getInt(ID_CAMPEONATO));
                ConexaoBD.fecharCursor(rs, stm);
                return res;
        } catch (Exception e) {throw new NullPointerException(e.getMessage());}
   }

    @Override
    public Collection<Campeonato> values() {throw new NullPointerException("Não Definido");}

    @Override
    public Set<Map.Entry<Integer, Campeonato>> entrySet() {throw new NullPointerException("Não Definido");}
    
    @Override
    public int hashCode() {return ConexaoBD.getConexao().hashCode();}
}



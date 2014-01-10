package Data_Layer;

import Business_Layer.Epoca;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;


public class EpocaDAO implements Map<Integer,Epoca> {
    private static final int ANO = 1;
    
    public EpocaDAO() { }
    
    @Override
    public int size() {
        int i=0;
         try {
            Statement stm = ConexaoBD.getConexao().createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM EPOCA");
                 while (rs.next()) i++;
                 ConexaoBD.fecharCursor(rs, stm);}
         catch(Exception e) {throw new NullPointerException(e.getMessage());}
         return i;} 
    
    @Override
    public boolean isEmpty() {throw new NullPointerException("Não Definido");}

    @Override
    public boolean containsKey(Object key) {
        boolean res = false;
        try {
            int chave = (Integer) key;
            Statement stm = ConexaoBD.getConexao().createStatement();          
            String sql = "SELECT * FROM EPOCA e WHERE e.ANO = "+chave;
            ResultSet rs = stm.executeQuery(sql);
            res = rs.next();
            ConexaoBD.fecharCursor(rs, stm);}
        catch (SQLException e) {}
        return res;}
    
    @Override
    public boolean containsValue(Object value) {throw new NullPointerException("Não Definido");}

    @Override
    public void putAll(Map<? extends Integer, ? extends Epoca> m) {throw new NullPointerException("Não Definido");}
    
    @Override
    public Epoca remove(Object key) {
        Epoca res = null;
        try {            
            Integer chave = (Integer) key;
            String sql = "DELETE FROM EPOCA WHERE EPOCA.ANO = ?";
            PreparedStatement stm = ConexaoBD.getConexao().prepareStatement(sql);
            stm.setInt(ANO, chave);
            stm.execute();
            ConexaoBD.fecharCursor(null, stm);
            return res;}
        catch (Exception e){throw new NullPointerException(e.getMessage());}
    }

    @Override
    public void clear() {throw new NullPointerException("Não Definido");}
    
    @Override
    public Set<Map.Entry<Integer, Epoca>> entrySet() {throw new NullPointerException("Não Definido");}

    @Override
    public Epoca get(Object key){
        Epoca ep = null;
        
        try {
            String chave = (String) key;
            Statement stm = ConexaoBD.getConexao().createStatement();
            String sql = "SELECT * FROM EPOCA WHERE EPOCA.ANO = "+chave+"";
            ResultSet rs = stm.executeQuery(sql);
            
            if(rs.next()) { int ano = rs.getInt(ANO); ep= new Epoca(ano);}
            
            rs.close();
            stm.close();}
        catch (Exception e) {}        
     return ep;}

    @Override
    public Epoca put(Integer key, Epoca value){        
        Epoca res = null;
        Integer c = (Integer) key;
        try {
            boolean existe = this.containsKey(key);
            if(!existe){
            String sql = "INSERT INTO Epoca(ano) VALUES (?)";            
            PreparedStatement stm = ConexaoBD.getConexao().prepareStatement(sql);
            stm.setInt(ANO, c);
            stm.execute();
            stm.close();}
        res=value;}
        catch (Exception e){throw new NullPointerException(e.getMessage());}
        return res;}
    
        
   @Override
    public Set<Integer> keySet() {
        try {
                Set<Integer> res = new TreeSet<Integer>();
                Statement stm = ConexaoBD.getConexao().createStatement();
                ResultSet rs = stm.executeQuery("SELECT ANO FROM EPOCA ORDER BY ANO DESC");
                while (rs.next())
                res.add(rs.getInt(ANO));
                ConexaoBD.fecharCursor(rs, stm);
                return res;
        } catch (Exception e) {throw new NullPointerException(e.getMessage());}
   }

    @Override
    public Collection<Epoca> values() {throw new NullPointerException("Não Definido");}

    @Override
    public int hashCode() {return ConexaoBD.getConexao().hashCode();}
}

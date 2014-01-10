package Data_Layer;

import Business_Layer.Agenda;
import Business_Layer.Arbitro;
import Business_Layer.Imagem;
import Business_Layer.Utilizador;
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
public class ArbsDAO implements Map<Integer,Utilizador> {
    private int idTorneio;
    
    public static final int ID = 1;
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
    
    public ArbsDAO(int id) {
        this.idTorneio = id;
    }

    @Override
    public int size() {
        int res = 0;
        try {
            String sql = "SELECT * FROM ARBITRO a WHERE a.IDTORNEIO ="+this.idTorneio;
            Statement stm = ConexaoBD.getConexao().createStatement();
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean containsKey(Object key) {
        boolean res = false;
        try {
            String chave = (String) key;
            String sql = "SELECT * FROM ARBITRO a WHERE a.IDTORNEIO = "+this.idTorneio;
            Statement stm = ConexaoBD.getConexao().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            res = rs.next();
            
            ConexaoBD.fecharCursor(rs, stm);
        } catch (SQLException e) {
        }
        return res;
    }

    @Override
    public boolean containsValue(Object value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Utilizador get(Object key) {
        Utilizador u = null;
        try {
            int chave = (Integer) key;
            Statement stm = ConexaoBD.getConexao().createStatement();
            String sql = "SELECT * FROM ARBITRO ar, Utilizador u WHERE ar.IDUTILIZADOR = u.IDUTILIZADOR and ar.IDTORNEIO = "+this.idTorneio;
            ResultSet rs = stm.executeQuery(sql);
            
            if(rs.next()) {
                int idUser = rs.getInt(1);
                int idTor = rs.getInt(2);
                int idAg = rs.getInt(3);
                Blob b = rs.getBlob(5);
                String nick = rs.getString(6);
                String email = rs.getString(7);
                String pass = rs.getString(8);
                String morada = rs.getString(9);
                String tel = rs.getString(10);
                String codp = rs.getString(11);
                GregorianCalendar g = new GregorianCalendar();
                rs.getTimestamp(12, g);
                int atv = rs.getInt(13);
                int campreenc = rs.getInt(14);
                int tipo = rs.getInt(15);
                int remv = rs.getInt(16);
                String nome = rs.getString(17);
                boolean ativo = false;
                if(atv != 0)
                    ativo = true;
                boolean cpreenc = false;
                if(campreenc != 0)
                    cpreenc = true;
                boolean removido = false;
                if(remv != 0)
                    removido = true;
                
                JogoDAO ag = new JogoDAO(idAg);
                Agenda agenda = new Agenda(idAg,ag);
                u = new Arbitro(idUser, new Imagem(), tipo, nick, nome, email, pass, morada, tel, codp, g, ativo, cpreenc, agenda, removido);
            }
            
        } catch (SQLException e) {
        }
        return u;
    }

    @Override
    public Utilizador put(Integer key, Utilizador value) {
        Utilizador u = null;
        try {
            boolean existe = this.containsKey(key);
            String sql;
            if(existe)
                sql = "UPDATE UTILIZADOR u SET u.idUtilizador = ?, u.avatar = ?"+
                        ", u.nickname = ?, u.email = ?, u.password = ?, u.morada = ?"+
                        ", u.telemovel = ?, u.codPostal = ?, u.dataNasc = ?, u.ativo = ?"+
                        ", u.camposPreenchidos = ?, u.tipoUser = ?, u.removido = ?, u.nome = ?"+
                        " WHERE u.nickname = "+key;
            else
                sql = "INSERT INTO Utilizador(idUtilizador,avatar,nickname,email,password,morada,telemovel,codPostal,dataNasc,ativo,camposPreenchidos,tipoUser,removido,nome) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement stm = ConexaoBD.getConexao().prepareStatement(sql);
            stm.setInt(ID, value.getID());
            stm.setString(NICKNAME,value.getNomeUser());
            stm.setString(EMAIL,value.getEmail());
            if(existe)
                stm.setString(PASSWORD, value.getPass());
            else
                stm.setString(PASSWORD, Utilizador.encriptarPassword(value.getPass()));
            stm.setString(AVATAR,null);
            stm.setString(MORADA,value.getMorada());
            stm.setString(TELEMOVEL, value.getTelemovel());
            stm.setString(CODPOSTAL, value.getCodPostal());
            Timestamp dataNasc = new Timestamp(value.getDataNasc().getTimeInMillis());
            stm.setTimestamp(DATANASC, dataNasc);
            stm.setInt(ATIVO, converte2(value.isAtivo()));
            stm.setInt(CAMPOSPREENCHIDOS, converte2(value.isCamposPreenchidos()));
            stm.setInt(REMOVIDO, converte2(value.isRemovido()));
            stm.setInt(TIPO, value.getTipo());
            stm.setString(NOME, value.getNome());
            stm.executeQuery();
            stm.close();
            
            Arbitro a = (Arbitro) value;
            int idAgenda = a.getAgenda().getIDAgenda();
            String sql4 = "INSERT INTO Arbitro(idUtilizador,idTorneio,idAgenda) VALUES ("+value.getID()+","+this.idTorneio+","+idAgenda+")";
            PreparedStatement stm4 = ConexaoBD.getConexao().prepareStatement(sql4);
            stm4.execute();
            stm4.close();    
        } catch (SQLException e) {
        }
        return u;
    }

    @Override
    public Utilizador remove(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Utilizador> m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<Integer> keySet() {
        Set<Integer> res = new HashSet<>();
        try {
            String sql = "SELECT IDUTILIZADOR FROM ARBITRO a WHERE a.IDTORNEIO = "+this.idTorneio;
            Statement stm = ConexaoBD.getConexao().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            
            while(rs.next())
                res.add(rs.getInt(1));
            
            ConexaoBD.fecharCursor(rs, stm);
        } catch (SQLException e) {
        }
        return res;
    }

    @Override
    public Collection<Utilizador> values() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<Entry<Integer, Utilizador>> entrySet() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public int hashCode() {
        return ConexaoBD.getConexao().hashCode();
    }
    
    public int converte2(boolean a) {
        int res = 0;
        if(a)
            res = 1;
        return res;
    }
}
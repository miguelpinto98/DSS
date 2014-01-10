package Data_Layer;

import Business_Layer.Admin;
import Business_Layer.Agenda;
import Business_Layer.Arbitro;
import Business_Layer.Escola;
import Business_Layer.Utilizador;
import Business_Layer.Imagem;
import Business_Layer.Jogo;
import Business_Layer.ResponsavelEscola;
import java.io.File;
import java.sql.Blob;
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
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
        
public class UtilizadorDAO implements Map<String,Utilizador>{

    public static final String USER = "Utilizador u";
    public static final String ADMIN = "Admin u";
    public static final String RESCOLA = "ResponsavelEscola u";
    public static final String ARBITRO = "Arbitro u";

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
    //arbitro
    public static int IDUTILIZADOR = 1;
    
    public static int IDTORNEIO = 2;
    public static int IDAGENDA = 3;

    //r.escola
    public static int ESCOLANOME = 2;    
            
    public UtilizadorDAO() {
    }
    
    @Override
    public int size() {
        int i=0;
        try {
        Statement stm = ConexaoBD.getConexao().createStatement();
        ResultSet rs = stm.executeQuery("SELECT NICKNAME FROM " + USER);
            for (; rs.next(); i++)
                              ;
            ConexaoBD.fecharCursor(rs, stm);            
             return i;
        } catch (SQLException e) {
            throw new NullPointerException(e.getMessage());
        }
       
    }

    @Override
    public boolean isEmpty() {
    try {
        Statement stm = ConexaoBD.getConexao().createStatement();
        ResultSet rs = stm.executeQuery("SELECT NICKNAME FROM " +USER);
        boolean res = !rs.next();
        ConexaoBD.fecharCursor(rs, stm);        
        return res;
        } catch (SQLException e) {
            throw new NullPointerException(e.getMessage());
        }    
    }

    @Override
    public boolean containsKey(Object key) {
    try {
        String chave = (String) key;
        Statement stm = ConexaoBD.getConexao().createStatement();
        String sql = "SELECT NICKNAME FROM "+USER+" WHERE u.NICKNAME = '"+chave+"'";
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
        throw new NullPointerException("não está implementado!");
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
    public Utilizador get(Object key) {
        try {
            Utilizador res = null;
            String chave = (String) key;
            Statement stm = ConexaoBD.getConexao().createStatement();
            String sql = "SELECT * FROM UTILIZADOR u WHERE u.NICKNAME = '"+chave+"'";
            ResultSet rs = stm.executeQuery(sql);
            if(rs.next()) {
                int id = rs.getInt(ID);
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
                if(tipo == 2) {
                    stm = ConexaoBD.getConexao().createStatement();
                    sql = "SELECT * FROM ARBITRO u where u.IDUTILIZADOR = '"+id+"'";
                    rs = stm.executeQuery(sql);
                    if(rs.next()) {
                    int idAgenda = rs.getInt(IDAGENDA);
                                        
                    JogoDAO ag = new JogoDAO(idAgenda);
                    Agenda agenda = new Agenda(idAgenda,ag);
                    res = new Arbitro(id,avatar,tipo,nick,nome,email,pw,morada,tlmvl,
                            codPostal,dataNasc,converte(ativo),converte(camposPreenchidos),
                            agenda,converte(removido));
                    }
                }
                if(tipo == 1) {
                    stm = ConexaoBD.getConexao().createStatement();
                    sql = "SELECT * FROM RESPONSAVELESCOLA a where a.IDUTILIZADOR = '"+id+"'";
                    rs = stm.executeQuery(sql);
                    if(rs.next()) {
                    String nomeEscola = rs.getString(ESCOLANOME);
                    EscolaDAO x = new EscolaDAO();
                    Escola y = x.get(nomeEscola);
                    res = new ResponsavelEscola(id,avatar,tipo,nick,nome,email,pw,morada,tlmvl,
                            codPostal,dataNasc,converte(ativo),converte(camposPreenchidos),converte(removido),y);
                    }
                }
                if(tipo == 0) {
                    stm = ConexaoBD.getConexao().createStatement();
                    sql = "SELECT * FROM ADMIN a where a.IDUTILIZADOR = '"+id+"'";
                    rs = stm.executeQuery(sql);
                    if(rs.next()) {
                    res = new Admin(id,avatar,tipo,nick,nome,email,pw,morada,tlmvl,
                            codPostal,dataNasc,converte(ativo),converte(camposPreenchidos),converte(removido));
                    }
                } 
            }
            return res;
        }
        catch (SQLException e) {
            throw new NullPointerException(e.getMessage());
        }
    }

    @Override
    public Utilizador put(String key, Utilizador value) {
        Utilizador res = null;
        try {
            boolean existe = this.containsKey(key);
            String sql;
            if (existe) {
                sql = "UPDATE "
                        + USER
                        + " SET u.idUtilizador = ?, u.avatar = ?, u.nickname = ?, u.email = ?, u.password = ?, u.morada = ?, u.telemovel = ?, u.codPostal = ?, u.dataNasc = ?, u.ativo = ?, u.camposPreenchidos = ?, u.tipoUser = ?, u.removido = ?, u.nome = ? WHERE u.nickname = '"+key+"'";
            }
            else {
                sql = "INSERT INTO Utilizador(idUtilizador,avatar,nickname,email,password,morada,telemovel,codPostal,dataNasc,ativo,camposPreenchidos,tipoUser,removido,nome) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            }
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
             if (value.getTipo() == 0) {
                  String sql2 = "INSERT INTO Admin(idUtilizador) VALUES ("+value.getID()+")";
                  PreparedStatement stm2 = ConexaoBD.getConexao().prepareStatement(sql2);
                  stm2.execute();
                  stm2.close();
             }
             if(value.getTipo() == 1)  {
                ResponsavelEscola r = (ResponsavelEscola) value; 
                String s = r.getEscola().getNome();
                String sql3 = "INSERT INTO ResponsavelEscola(idUtilizador,escolaNome) VALUES ("+value.getID()+",'"+s+"')";
                PreparedStatement stm3 = ConexaoBD.getConexao().prepareStatement(sql3);
                stm3.execute();
                stm3.close();
             }
             if(value.getTipo() == 2) {
                Arbitro a = (Arbitro) value;
                int idAgenda = a.getAgenda().getIDAgenda();
                String sql4 = "INSERT INTO Arbitro(idUtilizador,idTorneio,idAgenda) VALUES ("+value.getID()+",null,null)";
                PreparedStatement stm4 = ConexaoBD.getConexao().prepareStatement(sql4);
                stm4.execute();
                stm4.close();
            }

         }
       
        catch (SQLException e) {
            throw new NullPointerException(e.getMessage());
        }
        return res;
    }
        
    @Override
    public Utilizador remove(Object key) {
        try {
            
            String chave = (String) key;
            Utilizador res = null;
            String sql = "SELECT * FROM Utilizador u WHERE u.NICKNAME = '"+chave+"'";
            PreparedStatement stm = ConexaoBD.getConexao().prepareStatement(sql);
            ResultSet rs = stm.executeQuery(sql);
            if(rs.next()) {
            int tipo = rs.getInt(TIPO);
            int id = rs.getInt(ID);
            stm.executeQuery();
            stm.close();
            if(tipo == 0) {
                String sql1 = "DELETE FROM Admin u WHERE u.IDUTILIZADOR = '"+id+"'";
                PreparedStatement stm1 = ConexaoBD.getConexao().prepareStatement(sql1);
                stm1.execute();
                stm1.close();
            }
            if(tipo == 1) {
                String sql2 = "DELETE FROM ResponsavelEscola u WHERE u.IDUTILIZADOR = '"+id+"'";
                PreparedStatement stm2 = ConexaoBD.getConexao().prepareStatement(sql2);
                stm2.execute();
                stm2.close();
                
            }
            if(tipo == 2) {
                String sql4 = "DELETE FROM Arbitro u WHERE u.IDUTILIZADOR = '"+id+"'";
                PreparedStatement stm4 = ConexaoBD.getConexao().prepareStatement(sql4);
                stm4.execute();
                stm4.close();
            }
            String sql3 = "DELETE FROM Utilizador u WHERE u.NICKNAME = '"+chave+"'";
            PreparedStatement stm3 = ConexaoBD.getConexao().prepareStatement(sql3);
            stm3.execute();
            stm3.close();
            }
            return res;
        } catch (Exception e) {
            throw new NullPointerException(e.getMessage());
        }
    }
    

    @Override
    public void putAll(Map<? extends String, ? extends Utilizador> m) {
        throw new NullPointerException("não está implementado!");
    }

    @Override
    public void clear() {
        throw new NullPointerException("não está implementado!");
    }

    @Override
    public Set<String> keySet() {
        Set<String> res = new TreeSet<>();
        try {
            Statement stm = ConexaoBD.getConexao().createStatement();
            String sql = "SELECT NOME FROM ESCOLA";
            ResultSet rs = stm.executeQuery(sql);
            
            while(rs.next())
                res.add(rs.getString(NICKNAME));
           
            ConexaoBD.fecharCursor(rs, stm);
        } catch (SQLException e) {
        }
        return res;
    }

    @Override
    public Collection<Utilizador> values() {
        try {
            Collection<Utilizador> res = new ArrayList<Utilizador>();;
            Statement stm = ConexaoBD.getConexao().createStatement();
            String sql = "SELECT * FROM UTILIZADOR u";
            ResultSet rsCiclo = stm.executeQuery(sql);
            while(rsCiclo.next()) {
                int id = rsCiclo.getInt(ID);
                Imagem avatar = null;
                if(rsCiclo.getBlob(AVATAR) == null)
                    avatar = new Imagem();
                int tipo = rsCiclo.getInt(TIPO);
                String nick = rsCiclo.getString(NICKNAME);
                String nome = rsCiclo.getString(NOME);
                String email = rsCiclo.getString(EMAIL);
                String pw = rsCiclo.getString(PASSWORD);
                String morada = rsCiclo.getString(MORADA);
                String tlmvl = rsCiclo.getString(TELEMOVEL);
                String codPostal = rsCiclo.getString(CODPOSTAL);
                GregorianCalendar dataNasc = new GregorianCalendar();
                rsCiclo.getTimestamp(DATANASC, dataNasc);
                int ativo = rsCiclo.getInt(ATIVO); 
                int camposPreenchidos = rsCiclo.getInt(CAMPOSPREENCHIDOS);  
                int removido = rsCiclo.getInt(REMOVIDO);                
                if(tipo == 2) {
                    Arbitro a = null;
                    stm = ConexaoBD.getConexao().createStatement();
                    sql = "SELECT * FROM ARBITRO u where u.IDUTILIZADOR = '"+id+"'";
                    ResultSet rs = stm.executeQuery(sql);
                    if(rs.next()) {
                    int idAgenda = rs.getInt(IDAGENDA);
                                        
                    JogoDAO ag = new JogoDAO(idAgenda);
                    Agenda agenda = new Agenda(idAgenda,ag);
                    a = new Arbitro(id,avatar,tipo,nick,nome,email,pw,morada,tlmvl,
                            codPostal,dataNasc,converte(ativo),converte(camposPreenchidos),
                            agenda,converte(removido));
                    res.add(a);
                    }
                }
                if(tipo == 1) {
                    ResponsavelEscola r = null;
                    stm = ConexaoBD.getConexao().createStatement();
                    sql = "SELECT * FROM RESPONSAVELESCOLA a where a.IDUTILIZADOR = '"+id+"'";
                    ResultSet rs = stm.executeQuery(sql);
                    if(rs.next()) {
                    String nomeEscola = rs.getString(ESCOLANOME);
                    EscolaDAO x = new EscolaDAO();
                    Escola y = x.get(nomeEscola);
                    r = new ResponsavelEscola(id,avatar,tipo,nick,nome,email,pw,morada,tlmvl,
                            codPostal,dataNasc,converte(ativo),converte(camposPreenchidos),converte(removido),y);
                    res.add(r);
                    }
                }
                if(tipo == 0) {
                    Admin a = null;
                    stm = ConexaoBD.getConexao().createStatement();
                    sql = "SELECT * FROM ADMIN a where a.IDUTILIZADOR = '"+id+"'";
                    ResultSet rs = stm.executeQuery(sql);
                    if(rs.next()) {
                    a = new Admin(id,avatar,tipo,nick,nome,email,pw,morada,tlmvl,
                            codPostal,dataNasc,converte(ativo),converte(camposPreenchidos),converte(removido));
                    res.add(a);
                    }
                } 
            }
            ConexaoBD.fecharCursor(rsCiclo, stm);
            return res;
        }
        catch (SQLException e) {
            throw new NullPointerException(e.getMessage());
        }
    }

    @Override
    public Set<Entry<String, Utilizador>> entrySet() {
        throw new NullPointerException("não está implementado!");
    }
    
    public int hashCode() {
        return ConexaoBD.getConexao().hashCode();
    }
}

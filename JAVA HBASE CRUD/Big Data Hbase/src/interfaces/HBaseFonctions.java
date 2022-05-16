package interfaces;
import org.apache.hadoop.conf.Configuration;
//import org.apache.commons.configuration.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;

public class HBaseFonctions {
	
  // Pour creation table
  public boolean createHbaseTable(String tableName,String family1,String family2) throws IOException {
      Configuration config = HBaseConfiguration.create();
      Connection connection = ConnectionFactory.createConnection(config);
      Admin admin = connection.getAdmin();

      HTableDescriptor ht = new HTableDescriptor(TableName.valueOf(tableName));
      ht.addFamily(new HColumnDescriptor(family1));
      ht.addFamily(new HColumnDescriptor(family2));
      System.out.println("connecting");

      
      if(!admin.tableExists(TableName.valueOf(tableName))){
      	System.out.println("Creating Table");
          admin.createTable(ht);
          System.out.println("Done.");
          return true;
      }else{
      	System.out.println("La table existe deja");
      	return false;
      }
      
  }
  
  //Pour ajouter une linge
  public boolean addUser(String tableName,String id,String family1,String col,String valeur) throws IOException{
  	
  	  Configuration config = HBaseConfiguration.create();
      Connection connection = ConnectionFactory.createConnection(config);
 	 Admin admin = connection.getAdmin();
      Table table = connection.getTable(TableName.valueOf(tableName));
      if(admin.tableExists(TableName.valueOf(tableName))){
      byte[] row1 = Bytes.toBytes(id);
      Put p = new Put(row1);
      p.addColumn(family1.getBytes(), col.getBytes(), Bytes.toBytes(valeur));
      table.put(p);
      return true;
  }else
	  return false;
      }
//Pour afficher une table
  public ResultScanner afficherUser(String tableName) throws IOException{
  	
  	 Configuration config = HBaseConfiguration.create();

  	    Connection connection = ConnectionFactory.createConnection(config);
  	    Table table = connection.getTable(TableName.valueOf(tableName));
  	    Scan s = new Scan();
  	    
  	 // Scanning the required columns
          s.addColumn(Bytes.toBytes("info_maj"), Bytes.toBytes("ename"));
          s.addColumn(Bytes.toBytes("info_sup"), Bytes.toBytes("manager"));
          
	        ResultScanner scanner = table.getScanner(s);
	        return scanner;
	        //scanner.close();
  	   
  	
  }
  //Supprimer Une table
  
  public boolean supprimerUser(String tableName) throws IOException{
  	Configuration conf = HBaseConfiguration.create();
      HBaseAdmin admin = new HBaseAdmin(conf);
      if(admin.tableExists(tableName)){
      	admin.disableTable(tableName);
          admin.deleteTable(tableName);
          return true;
      }else{
      	System.out.println("Table n'existe pas");
      	return false;
      }
      
  	
  }
  
  //Pour afficher une ligne
  public String recuperer(String tableName,String id,String fam1,String col) throws IOException{
  
      Configuration config = HBaseConfiguration.create();
      HTable table = new HTable(config, tableName);//mettre tablename
      Get g = new Get(Bytes.toBytes(id));//mettre id

      Result result = table.get(g);

      byte [] value = result.getValue(Bytes.toBytes(fam1),Bytes.toBytes(col));//mettre famille et colonne

      // afficher les valeurs 
      String valeur = Bytes.toString(value);
      System.out.println("valeur: " + valeur );
      return valeur;
     
  }
  
  public static void createOrOverwrite(Admin admin, HTableDescriptor table) throws IOException {
      if (admin.tableExists(table.getTableName())) {
          admin.disableTable(table.getTableName());
          admin.deleteTable(table.getTableName());
      }
      admin.createTable(table);
  }
  
 

	public static void main(String[] args) throws IOException {
  	
  }

}
package tk.mattrick.openblock.entity;
    
      import java.util.Lists;
      
      public interface Metadatable {
      
       public  void setMetadata(String MetadataKey, MetadataValue newMetadataValue);
       
       
       public List<MetadataValue> getMetadata(String metadataKey);
      
          public boolean hasMetadata(String metadataKey);
     
      }

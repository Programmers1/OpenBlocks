package tk.mattrick.openblocks.entity;

    import java.util.Lists;
    
    public interface MetadataStore {
    
       public void setMetadata (T subject, String metadataKey, MetadataValue newMetadataValue);
       
       public void removeMetadata(T subject, String metadataKey);
       
       public void setMetadata(T subject, String metadataKey, MetadataValue newMetadataValue); 
 
       public List<MetadataValue> getMetadata(T subject, String metadataKey); 

        public boolean hasMetadata(T subject, String metadataKey); 

       
       
 }

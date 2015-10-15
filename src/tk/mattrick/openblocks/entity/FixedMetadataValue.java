package tk.mattrick.openblocks.entity;

public class FixedMetadataValue extends LazyMetadataValue{

    public final Object internalValue;
    
    
    @Override
    public void invalidate (){
    
      
    }
  @Override 
  public Object value(){
  
  return internalValue;
  }
} 

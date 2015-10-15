package tk.mattrick.openblock.enttiy;

import java.lang.ref.SoftReference; 
import java.util.concurrent.Callable; 

public class LazyMetadataValue extends MetadataValueAdapter implements MetadataValue { 
private Callable<Object> lazyValue; 
   private CacheStrategy cacheStrategy; 
   private SoftReference<Object> internalValue; 
   private static final Object ACTUALLY_NULL = new Object(); 

public Object value() { 
       eval(); 
       Object value = internalValue.get(); 
         if (value == ACTUALLY_NULL) { 
            return null; 
        } 
        return value; 
    } 

 
   
         if (cacheStrategy == CacheStrategy.NEVER_CACHE || internalValue.get() == null) { 
         try { 
                 Object value = lazyValue.call(); 
                if (value == null) { 
                    value = ACTUALLY_NULL; 
               } 
               internalValue = new SoftReference<Object>(value); 
            } catch (Exception e) { 
                throw new MetadataEvaluationException(e); 
            } 
        } 
    } 

 
    public synchronized void invalidate() { 
        if (cacheStrategy != CacheStrategy.CACHE_ETERNALLY) { 
            internalValue.clear(); 
        } 
     } 
 
 
  
    public enum CacheStrategy { 
       
        CACHE_AFTER_FIRST_EVAL, 

 
      
        NEVER_CACHE, 
 
 
         
         CACHE_ETERNALLY 

}

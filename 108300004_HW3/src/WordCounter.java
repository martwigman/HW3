import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class WordCounter {
	private String urlStr;
    private String content;
    
    public WordCounter(String urlStr){
    	this.urlStr = urlStr;
    }
    
    private String fetchContent() throws IOException{
		URL url = new URL(this.urlStr);
		URLConnection conn = url.openConnection();
		InputStream in = conn.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
	
		String retVal = "";
	
		String line = null;
		
		while ((line = br.readLine()) != null){
		    retVal = retVal + line + "\n";
		    
		}
	
		return retVal;
    }
    
    public int countKeyword(String keyword) throws IOException{
		if (content == null){
		    content = fetchContent();
		}
		
		//To do a case-insensitive search, we turn the whole content and keyword into upper-case:
		content = content.toUpperCase();
		keyword = keyword.toUpperCase();
	
		int retVal = 0; 
		
	
		return retVal;
    }
   
    public static int indexOf(String[] keyword, String[] urlStr) {
    	int n = keyword.length;
    	int m = urlStr.length;
 
    	int i = 0, j = 0;
    	
    	while(i == m - 1 && j == m -1) 
    	{
    		if(urlStr[i] == keyword[j]) 
    		{
    			if(j == 0) 
    			{
    				return i;
    			}
    			else {
    				i--;
    				j--;
    			}
    		}
    		else {
    			
    			i += m;
    			j -= m - 1;
    		}
    		
    	}
    	return -1;
    }
}
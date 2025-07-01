class CheckRotation
{
    static public int[] calculateLps(String pat)
    {
        int n=pat.length();
        int LPS[]=new int[n];
        int i=1;
        int len=0;
        LPS[0]=0;
        while(i<n)
        {
            if(pat.charAt(i)==pat.charAt(len))
            {
                len++;
                LPS[i]=len;
                i++;
            }
            else
            {
                if(len!=0)
                {
                   len=LPS[len-1]; 
                }
                else
                {
                    LPS[i]=0;   
                    i++;
                }
            }
        }
        return LPS;
    }
    public static boolean areRotations(String s1, String s2) {
        
        // Your code here
        
        if(s1.length()!=s2.length())
        {
            return false;
        }
        String txt=s1+s1;
        String pat=s2;
        int n=txt.length();
        int m=pat.length();
        int []lps=calculateLps(pat);
        int i=0;
        int j=0;
        while(i<n)
        {
            if(pat.charAt(j)==txt.charAt(i))
            {
                i++;
                j++;
                
                if(j==m)
                {
                    return true;
                }
            }
            else if(i<n&&pat.charAt(j)!=txt.charAt(i))
            {
                if(j!=0)
                {
                    j=lps[j-1];
                }
                else
                {
                    i++;
                }
            }
        }
        return false;
    }
    public static void main(String[] args)
    {
       System.out.println(areRotations("abcd", "cdab")); // Output: true
    }
}
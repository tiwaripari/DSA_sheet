import java.util.Arrays;
//TC: O(m+n)+O(nlon)+O(mlogm) SC: O(1)
public class Solution {
    public static void mergeTwoSortedArraysWithoutExtraSpace(long []a, long []b){
        // Write your code here.
        int left = a.length-1;
        int right = 0;
        while(left>=0 && right<b.length)
        {
            if(a[left]<b[right])
            {
                break;
            }
            else{
                long temp=a[left];
                a[left] = b[right];
                b[right] = temp;
                left--;
                right++;
            }
        }
        Arrays.sort(a);
        Arrays.sort(b);

    }
   //gap emthod
     public static void swap(long[] a,long[] b,int ind1, int ind2)
    {
        long temp;
        temp=a[ind1];
        a[ind1]=b[ind2];
        b[ind2]=temp;
    }
    public static void merge(long arr1[], long arr2[], int n, int m) 
    {
        // code here 
        //tc: O(log(m+n)(m+n))
        int len=m+n;
        int left=0;
        int gap = (n+m)/2 + (n+m)%2;
        int right=left+gap;
        
        while(gap>0)
        {
            //left in a right in b
            
            while(right<len)
            {
                if(left<n && right>=n)
                {
                    if(arr1[left]>=arr2[right-n])
                    {
                        swap(arr1,arr2,left,right-n);
                    }
                }
                //left in b right in b if left in b implies right will be in b
                else if(left>=n)
                {
                    if(arr2[left-n]>=arr2[right-n])
                    {
                        swap(arr2,arr2,left-n,right-n);
                    }
                }
                //left in a right in a 
                else
                {
                    if(arr1[left]>=arr1[right])
                    {
                        swap(arr1,arr1,left,right);
                    }
                }
                left++;
                right++;
            }
            if(gap==1)
            {
                break;
            }
            
            gap = gap/2 + gap%2;
            left=0;
            right=left+gap;
        }
        
  
}

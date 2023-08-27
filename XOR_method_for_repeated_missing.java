public ArrayList<Integer> repeatedNumber(final List<Integer> A) {
        int xr=0;
        for(int i=0;i<A.size();i++)
        {
            xr = xr ^ A.get(i);
            xr = xr ^ (i+1);
        }
        int bitNo=0;
        while(true)
        {
            if((xr & (1<<bitNo))!=0)
            {
                break;
            }
            bitNo++;
        }
        int zero=0;
        int one=0;
        
        for(int i=0;i<A.size();i++)
        {
            if((A.get(i) & (1<<bitNo)) != 0)
            {
                one = one ^ A.get(i);
            }
            else
            {
                zero = zero ^ A.get(i);
            }
        }
        
        for(int i=0;i<A.size();i++)
        {
            if(((i+1) & (1<<bitNo)) != 0)
            {
                one = one ^ (i+1);
            }
            else
            {
                zero = zero ^ (i+1);
            }
        }
        
        int flag=0;
        for(int i=0;i<A.size();i++)
        {
            if(A.get(i)==zero)
            {
                flag=1;
                break;
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        if(flag==1)
        {
            res.add(zero);
            res.add(one);
        }
        else
        {
            res.add(one);
            res.add(zero);
        }
        return res;
        
    }

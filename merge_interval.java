public static List< List< Integer > > mergeOverlappingIntervals(int [][]arr){
        // Write your code here.
        // Arrays.sort(arr, new Comparator<int[]>(){
        //     @Override
        //     public int compare(int[] o1,int[] o2)
        //     {
        //         return Integer.compare(o1[0],o2[0]);
        //     }
        // });

        int best_start=arr[0][0];
        int best_end = arr[0][1];
        List<List<Integer>> res = new ArrayList<>();
        for(int i=1;i<arr.length;i++)
        {
            if(arr[i][0]<=best_end)
            {
                best_start = Math.min(best_start,arr[i][0]);
                best_end = Math.max(best_end,arr[i][1]);


            }
            else{
                List<Integer> l1 = new ArrayList<>();
                l1.add(best_start);
                l1.add(best_end);
                res.add(l1);
                best_start = arr[i][0];
                best_end = arr[i][1];
            }
        }
        List<Integer> l1 = new ArrayList<>();
        l1.add(best_start);
        l1.add(best_end);
        res.add(l1);

        return res;

    }

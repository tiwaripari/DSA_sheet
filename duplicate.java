   
    public int findDuplicate(int[] nums) {

        while(nums[0]!=nums[nums[0]])
        {
            int n;
            n=nums[nums[0]];
            nums[nums[0]]=nums[0];
            nums[0]=n;
            
        }
        return nums[0];

        
        
    }

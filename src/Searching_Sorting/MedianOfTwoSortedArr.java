package Searching_Sorting;
//https://leetcode.com/problems/median-of-two-sorted-arrays/
public class MedianOfTwoSortedArr {
    //Approach 1
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int a=0;
        int b=0;
        int k=0;
        int[] finalArr=new int[nums1.length+ nums2.length];
        while (a<nums1.length && b< nums2.length){
            if (nums1[a]<nums2[b]){
                finalArr[k]=nums1[a];
                k++;a++;
            }else{
                finalArr[k]=nums2[b];
                k++;b++;
            }
        }
        if (a< nums1.length){
            while (a< nums1.length){
                finalArr[k]=nums1[a];
                k++; a++;
            }
        }
        if (b< nums2.length){
            while (b< nums2.length){
                finalArr[k]=nums1[b];
                k++; b++;
            }
        }
        int len= nums1.length+ nums2.length;
        if (len%2==1) return finalArr[((len+1)/2)-1];
        else return ((double) finalArr[(len/2)-1]+ (double) finalArr[(len/2)])/2.0;
    }

    //Optimized
    public double findMedianSortedArrays2(int[] nums1, int[] nums2){
        if (nums1.length> nums2.length){
            return findMedianSortedArrays2(nums2,nums1);
        }
        int low=0, high= nums1.length;
        int medianPos= ((nums1.length+ nums2.length)+1)/2;
        while (low<=high){
            int cut1=(low+high)/2;
            int cut2= medianPos-cut1;

            int l1= (cut1==0)? Integer.MIN_VALUE : nums1[cut1-1];
            int l2= (cut2==0)? Integer.MIN_VALUE : nums2[cut2-1];
            int r1= (cut1== nums1.length)? Integer.MAX_VALUE : nums1[cut1];
            int r2= (cut2== nums2.length)? Integer.MAX_VALUE : nums2[cut2];

            if (l1<= r2 && l2<= r1){
                if ((nums1.length+ nums2.length)%2 !=0){
                    return Math.max(l1,l2);
                }else{
                    return (Math.max(l1,l2) + Math.min(r1,r2))/2.0;
                }
            }
            else if (l1>r2) high=cut1-1;
            else low=cut1+1;
        }
        return 0.0;
    }
}

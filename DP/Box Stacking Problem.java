import java.util.*;


public class BoxStackingProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int maxHeight(int[] height, int[] width, int[] length, int n)
    {
        Box[] arr = new Box[n];
        for(int i = 0; i < n; i++) {
        	arr[i] = new Box(height[i], width[i], length[i]); 
        }
        
        Box[] rot = new Box[3 * n];
        for(int i = 0; i < n; i++) {
        	rot[3 * i] = new Box(arr[i].h, Math.max(arr[i].w, arr[i].l), Math.min(arr[i].w, arr[i].l));
        	rot[3 * i + 1] = new Box(arr[i].w, Math.max(arr[i].l, arr[i].h), Math.min(arr[i].l, arr[i].h));
        	rot[3 * i + 2]  = new Box(arr[i].l, Math.max(arr[i].h, arr[i].w), Math.min(arr[i].h, arr[i].w));
        }
        
        for(int i = 0; i < rot.length; i++) {
        	rot[i].area = rot[i].w * rot[i].l;
        }
        Arrays.sort(rot);
        
        int[] msh = new int[3 * n];
        for(int i = 0; i < msh.length; i++) {
        	msh[i] = rot[i].h;
        }
        
        for(int i = 0; i < msh.length; i++) {
        	msh[i] = 0;
        	Box box = rot[i];
        	int val = 0;
        	for(int j = 0; j < i; j++) {
        		if(box.w < rot[j].w && box.l < rot[j].l) {
        			val = Math.max(val, msh[j]);
        		}
        	}
        	msh[i] = val + box.h;
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < msh.length; i++) {
        	max = Math.max(max, msh[i]);
        }
        return max;
    }
	
	
	public static class Box implements Comparable<Box>{
		int h;
		int w;
		int l;
		int area;
		
		Box(int h, int w, int l){
			this.h = h;
			this.w = w;
			this.l = l;
		}
		
		public int compareTo(Box o) {
			return o.area - this.area;
		}
	}

}

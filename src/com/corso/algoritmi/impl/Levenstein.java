package com.corso.algoritmi.impl;

import com.corso.algoritmi.CheckStringImpl;

public class Levenstein extends CheckStringImpl {
	
	 private int soglia;
	
	 public Levenstein(int soglia) {
	        this.soglia = soglia;
	    }
	 
	 public int getSoglia() {
	        return soglia;
	 }
	 
    @Override
    public boolean check(String input, String standard) {
    	        int[][] dp = new int[input.length() + 1][standard.length() + 1];

    	        for (int i = 0; i <= input.length(); i++) {
    	            for (int j = 0; j <= standard.length(); j++) {
    	                if (i == 0) {
    	                    dp[i][j] = j;
    	                } else if (j == 0) {
    	                    dp[i][j] = i;
    	                } else {
    	                    int cost = (input.charAt(i - 1) == standard.charAt(j - 1)) ? 0 : 1;
    	                    dp[i][j] = min(dp[i - 1][j - 1] + cost, 
    	                            dp[i - 1][j] + 1, 
    	                            dp[i][j - 1] + 1); 
    	                }
    	            }
    	        }

    	        int distanza = dp[input.length()][standard.length()];
    	        if (distanza <= getSoglia()) {
    	            return true;
    	        } else {
    	            return false;
    	        }
   }


    @Override
    public String getName() {
        return super.getName()+" "+getSoglia();
    }
    

    private int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}




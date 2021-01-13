package com.emergingit.bot.stringmatcher;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Component
public class EditDistanceStringMatcher implements StringMatcher{

    private final int MAX_LENGTH_OF_STRING=70;
    private int [][] dp;

    public EditDistanceStringMatcher() {
        this.dp=new int[MAX_LENGTH_OF_STRING][MAX_LENGTH_OF_STRING];
    }


    private int editDistance(int m,int n,String str1,String str2)
    {
        if(m==0) return  n;
        if(n==0) return  m;

        if(dp[m][n]!=-1) return dp[m][n];
        int ret=Integer.MAX_VALUE;
        if(str1.charAt(m)==str2.charAt(n))
            ret=editDistance(m-1,n-1,str1,str2);
        else
            ret=1+Math.min(
                    editDistance(m,n-1,str1,str2),
                    editDistance(m-1,n,str1,str2)
            );

        return  dp[m][n]=ret;
    }

    @Override
    public boolean matchString(String str1, String str2,int tolerance) {
        int m=str1.length();
        int n=str2.length();
        for(int i=0;i<m;i++)
            Arrays.fill(dp[i],-1);
        return (editDistance(m-1,n-1,str1,str2)<=tolerance);
    }
}

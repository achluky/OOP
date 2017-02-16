/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jayuk
 */
public class Jj {

char[] canUse = {
'0','1','2','3','4','5','6','7','8','9',
'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'
};

int maxlen = 8;

	public static void main (String[] args) {

		Jj b = new Jj();
	}
	

	public Jj() {
	int k = 0;

	while (k < canUse.length) {
		nextString(new Character(canUse[k]).toString());
		k++;
	}

	}


	private void nextString(String s) {

	int i = 0;

	System.out.println(s);

	while (i< canUse.length) {
		System.out.println(s + new Character(canUse[i]).toString());
		
		if (new String(s + new Character(canUse[i]).toString()).length() <= maxlen) {nextString(s + new Character(canUse[i]).toString());}
		i++;
	}

	}
}

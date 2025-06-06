/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package disjointSetUnion;

import disjointSetUnion.UnionFind;

/**
 *
 * @author FPT
 */
public class LexicographicallySmallestEquivalentString {

    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        int len = s1.length();
        UnionFind uf = new UnionFind(26);
        for (int i = 0; i < len; i++) {
            uf.union(s1.charAt(i) - 97, s2.charAt(i) - 97);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < baseStr.length(); i++) {
            sb.append((char) (uf.find(baseStr.charAt(i) - 97) + 97));
        }

        return sb.toString();
    }
}
